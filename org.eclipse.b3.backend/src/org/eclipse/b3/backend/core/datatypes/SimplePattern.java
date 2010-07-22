/*******************************************************************************
 * Copyright (c) 2009 Cloudsmith Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cloudsmith Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.b3.backend.core.datatypes;

public class SimplePattern {
	private static class AnyCharacterNode extends Node {
		AnyCharacterNode(Node next) {
			super(next);
		}

		@Override
		boolean match(CharSequence value, int pos) {
			int top = value.length();
			return next == null
					? pos + 1 == top
					: next.match(value, pos + 1);
		}
	}

	private static class ConstantNode extends Node {
		final String constant;

		ConstantNode(Node next, String constant) {
			super(next);
			this.constant = constant;
		}

		@Override
		boolean match(CharSequence value, int pos) {
			int vtop = value.length();
			int ctop = constant.length();
			if(ctop + pos > vtop)
				return false;

			for(int idx = 0; idx < ctop; ++idx, ++pos)
				if(constant.charAt(idx) != value.charAt(pos))
					return false;

			return next == null
					? true
					: next.match(value, pos);
		}
	}

	private static abstract class Node {
		final Node next;

		Node(Node next) {
			this.next = next;
		}

		abstract boolean match(CharSequence value, int pos);
	}

	private static class RubberBandNode extends Node {
		RubberBandNode(Node next) {
			super(next);
		}

		@Override
		boolean match(CharSequence value, int pos) {
			if(next == null)
				return true;

			int top = value.length();
			while(pos < top) {
				if(next.match(value, pos++))
					return true;
			}
			return false;
		}
	}

	public static SimplePattern compile(CharSequence pattern) {
		if(pattern == null)
			throw new IllegalArgumentException("Pattern can not be null"); //$NON-NLS-1$

		return new SimplePattern(parse(pattern, 0));
	}

	private static Node parse(CharSequence pattern, int pos) {
		int top = pattern.length();
		StringBuffer bld = null;
		Node parsedNode = null;
		while(pos < top) {
			char c = pattern.charAt(pos);
			switch(c) {
				case '*':
					parsedNode = new RubberBandNode(parse(pattern, pos + 1));
					break;
				case '?':
					parsedNode = new AnyCharacterNode(parse(pattern, pos + 1));
					break;
				case '\\':
					if(++pos == top)
						throw new IllegalArgumentException("Pattern ends with escape"); //$NON-NLS-1$
					c = pattern.charAt(pos);
					// fall through
				default:
					if(bld == null)
						bld = new StringBuffer();
					bld.append(c);
					++pos;
					continue;
			}
			break;
		}

		if(bld != null)
			parsedNode = new ConstantNode(parsedNode, bld.toString());
		return parsedNode;
	}

	private final Node node;

	private SimplePattern(Node node) {
		this.node = node;
	}

	public boolean isMatch(CharSequence value) {
		return node.match(value, 0);
	}
}
