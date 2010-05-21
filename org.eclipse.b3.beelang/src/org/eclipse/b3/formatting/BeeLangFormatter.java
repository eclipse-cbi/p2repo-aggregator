/*
 * generated by Xtext
 */
package org.eclipse.b3.formatting;

import org.eclipse.b3.services.BeeLangGrammarAccess;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class BeeLangFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		BeeLangGrammarAccess f = (BeeLangGrammarAccess) getGrammarAccess();

		c.setAutoLinewrap(120);

		// SWITCH
		c.setIndentation(
			f.getSwitchExpressionAccess().getSwitchKeyword_1(), f.getSwitchExpressionAccess().getEndswitchKeyword_4());
		c.setLinewrap().before(f.getCaseAccess().getCaseKeyword_1_0_0());
		c.setLinewrap().before(f.getCaseAccess().getDefaultKeyword_1_1());
		c.setLinewrap().before(f.getSwitchExpressionAccess().getEndswitchKeyword_4());

		// Blocks
		c.setIndentation(
			f.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1(),
			f.getBlockExpressionAccess().getRightCurlyBracketKeyword_3());
		c.setLinewrap().after(f.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
		c.setLinewrap().after(f.getBlockExpressionAccess().getSemicolonKeyword_2_1());
		c.setNoSpace().before(f.getBlockExpressionAccess().getSemicolonKeyword_2_1());
		c.setLinewrap().after(f.getBlockExpressionAccess().getRightCurlyBracketKeyword_3());
		c.setLinewrap().before(f.getBlockExpressionAccess().getRightCurlyBracketKeyword_3());
	}
}
