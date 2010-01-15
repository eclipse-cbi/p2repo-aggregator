package org.eclipse.b3.commands;

import java.io.PrintStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.b3.backend.core.B3Engine;
import org.eclipse.b3.backend.evaluator.b3backend.B3JavaImport;
import org.eclipse.b3.backend.evaluator.b3backend.BFunction;
import org.eclipse.b3.backend.evaluator.typesystem.TypeUtils;
import org.eclipse.b3.beeLang.BeeModel;
import org.eclipse.b3.beelang.ui.BeeLangConsoleUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class ExecuteHandler extends AbstractHandler {

	@SuppressWarnings("unchecked")
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final MessageConsole b3Console = BeeLangConsoleUtils.getBeeLangConsole();
		PrintStream b3ConsoleOutputStream = BeeLangConsoleUtils.getConsoleOutputStream(b3Console);
		try {
			b3ConsoleOutputStream.println("Running the main function...");
			EvaluationContext ctx = (EvaluationContext) event.getApplicationContext();
			List<ContentOutlineNode> nodes = (List<ContentOutlineNode>) ctx.getDefaultVariable();
			ContentOutlineNode node = nodes.get(0);
			Object result = node.getEObjectHandle().readOnly(new IUnitOfWork<Object, EObject>(){
				public Object exec(EObject state) throws Exception {
					B3Engine engine = new B3Engine();
					// Define all functions, and
					// find a function called main (use the first found) and call it with a List<Object> argv
					BFunction main = null;
					for(BFunction f : ((BeeModel) state).getFunctions()) {
						engine.getContext().defineFunction(f);
						if("main".equals(f.getName())) {
							main = f;
						}
					}
					// Define all imports as constants
					for(Type t : ((BeeModel) state).getImports()) {
						if(t instanceof B3JavaImport) {
							Class<?> x = TypeUtils.getRaw(t);
							engine.getContext().defineValue(((B3JavaImport) t).getName(), x, x);
						}
					}
					if(main == null)
						return null;
					final List<Object> argv = new ArrayList<Object>();
					try {
						return engine.getContext().callFunction("main", new Object[] { argv },
								new Type[] { List.class });
					} catch(Throwable e) {
						// Just print some errors
						e.printStackTrace();
						PrintStream b3ConsoleErrorStream = BeeLangConsoleUtils.getConsoleErrorStream(b3Console);
						try {
							b3ConsoleErrorStream.println(e.getMessage());
						} finally {
							b3ConsoleErrorStream.close();
						}
					}

					return null;
				}
			});
			b3ConsoleOutputStream.println("Result = " + (result == null ? "null" : result.toString()));
			return null;
		}  finally {
			b3ConsoleOutputStream.close();
		}
	}
}
