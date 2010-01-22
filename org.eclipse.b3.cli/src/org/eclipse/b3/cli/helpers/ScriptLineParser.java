/*******************************************************************************
 * Copyright (c) 2004, 2006
 * Thomas Hallgren, Kenneth Olwing, Mitch Sonies
 * Pontus Rydin, Nils Unden, Peer Torngren
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the individual
 * copyright holders listed above, as Initial Contributors under such license.
 * The text of such license is available at www.eclipse.org.
 *******************************************************************************/
package org.eclipse.b3.cli.helpers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple command line parser that implements a subset of the parsing that is performed by a normal bourne shell.
 * Environment substitution is performed only if the Java runtime is of version 1.5 or higher.
 * 
 * @author Thomas Hallgren
 * @see java.util.Iterator
 */
public class ScriptLineParser implements Iterator<String> {
	@Deprecated
	private static String getenv(String varName) {
		try {
			return System.getenv(varName);
		}
		catch(Error e) {
			return "CommandLineParser ENV variables are supported in Java 1.5 or higher only";
		}
	}

	private static char getEscapedChar(char escaped) {
		switch(escaped) {
		case 't':
			return '\t';
		case 'n':
			return '\n';
		case 'r':
			return '\r';
		default:
			return escaped;
		}
	}

	private final StringBuffer m_innerBld = new StringBuffer();

	private final StringBuffer m_outerBld = new StringBuffer();

	private final String m_line;

	private String m_nextToken;

	private int m_pos;

	public ScriptLineParser(String line) {
		m_line = line;
		int top = m_line.length();
		while(m_pos < top) {
			char c = m_line.charAt(m_pos);
			if(Character.isWhitespace(c)) {
				++m_pos;
				continue;
			}

			// Lines where first non-space character is a '#' are considered
			// to be comments
			//
			if(c == '#')
				m_pos = top;
			break;
		}
	}

	public boolean hasNext() {
		if(m_nextToken == null)
			m_nextToken = this.nextToken();
		return m_nextToken != null;
	}

	public String next() {
		if(!this.hasNext())
			throw new NoSuchElementException();
		String nxt = m_nextToken;
		m_nextToken = null;
		return nxt;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	private void getExpanded(StringBuffer bld, String string) {
		int top = string.length();
		int idx = 0;
		while(idx < top) {
			char c = string.charAt(idx++);
			if(c != '$') {
				bld.append(c);
				continue;
			}
			if(idx == top)
				break;

			int start;
			int end;
			c = string.charAt(idx);
			if(c == '{') {
				start = ++idx;
				while(idx < top && string.charAt(idx) != '}')
					++idx;
				end = idx++; // Skip trailing '}'
			}
			else {
				start = idx;
				while(idx < top && Character.isJavaIdentifierPart(string.charAt(idx)))
					++idx;
				end = idx;
			}
			if(end > start) {
				String key = string.substring(start, end);
				String value = (key.length() > 4 && "env:".equalsIgnoreCase(string.substring(0, 4))) //$NON-NLS-1$
						? getenv(key.substring(4))
						: System.getProperty(key);
				if(value != null)
					bld.append(value);
			}
		}
	}

	private String getQuoted(char quote) {
		m_innerBld.setLength(0);
		int top = m_line.length();
		while(m_pos < top) {
			char c = m_line.charAt(m_pos++);
			if(c == quote)
				break;

			if(c == '\\') {
				if(m_pos == top)
					break;
				c = getEscapedChar(m_line.charAt(m_pos++));
			}
			m_innerBld.append(c);
		}
		return m_innerBld.toString();
	}

	private String getSpaceDelimited() {
		m_innerBld.setLength(0);
		int top = m_line.length();
		while(m_pos < top) {
			char c = m_line.charAt(m_pos);
			if(Character.isWhitespace(c) || c == '\'' || c == '"')
				break;

			++m_pos;
			if(c == '\\') {
				if(m_pos == top)
					break;

				// The sequence '\ ' should not cause a break since that
				// is an escaped space. The sequence '\t' however, should
				// since that is an unescaped tab
				//
				c = m_line.charAt(m_pos++);
				if(!Character.isWhitespace(c)) {
					c = getEscapedChar(c);
					if(Character.isWhitespace(c))
						break;
				}
			}
			m_innerBld.append(c);
		}
		return m_innerBld.toString();
	}

	private String nextToken() {
		m_outerBld.setLength(0);
		int top = m_line.length();
		if(m_pos == top)
			return null;

		while(m_pos < top) {
			char c = m_line.charAt(m_pos);
			switch(c) {
			case '\'':
				// Find matching end quote. No expansion is performed
				//
				++m_pos;
				m_outerBld.append(getQuoted('\''));
				continue;
			case '"':
				// Find matching end quote and perform expansion
				//
				++m_pos;
				getExpanded(m_outerBld, getQuoted('"'));
				continue;

			default:
				if(Character.isWhitespace(c)) {
					++m_pos;
					while(m_pos < top && Character.isWhitespace(m_line.charAt(m_pos)))
						++m_pos;
					break;
				}
				getExpanded(m_outerBld, getSpaceDelimited());
				continue;
			}
			break;
		}
		return m_outerBld.toString();
	}
}
