/**
 * Copyright (c) 2016-2020, Red Hat Inc. and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.tycho;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.util.AggregatorResourceImpl;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class GenerateTychoBuildApplication implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		Aggregation agg = findAggragation(Arrays.asList((String[])context.getArguments().get("application.args")));
		if (agg == null) {
			System.out.println("No aggregation model file");
			return 1;
		}
		File outputDirectory = new File("tycho-ified");
		outputDirectory.mkdir();
		for (Entry<IPath, String> content : new AggregatorToTycho(agg).createTychoFiles().entrySet()) {
			Files.write(new File(outputDirectory, content.getKey().toString()).toPath(), content.getValue().getBytes());
		}
		return 0;
	}

	private Aggregation findAggragation(List<String> args) throws IOException {
		String fileName = null;
		int index = args.indexOf("-aggregation");
		if (index >= 0 && index + 1 < args.size()) {
			fileName = args.get(index + 1);
		}
		if (fileName == null) {
			fileName = Arrays.stream(new File(".").listFiles(file -> file.getName().endsWith(".aggr"))).map(File::getAbsolutePath).findAny().orElse(null);
			System.out.println("No -aggregation specified, using " + fileName);
		}
		if (fileName != null) {
			AggregatorResourceImpl aggregatorResourceImpl = new AggregatorResourceImpl(URI.createFileURI(new File(fileName).getAbsolutePath()));
			aggregatorResourceImpl.load(Collections.emptyMap());
			return aggregatorResourceImpl.getAggregation();
		}
		return null;
	}

	@Override
	public void stop() {

	}

}
