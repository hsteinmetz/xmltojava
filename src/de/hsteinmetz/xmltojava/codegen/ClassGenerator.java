package de.hsteinmetz.xmltojava.codegen;

import de.hsteinmetz.xmltojava.codegen.models.Class;

public class ClassGenerator {

	public String generateClass(String name, String accessModif, boolean abstr,
			boolean stat, boolean finaL) {
		StringBuffer buf = new StringBuffer();

		buf.append(accessModif + " ");

		if (stat)
			buf.append("static ");

		if (abstr)
			buf.append("abstract ");

		if (finaL)
			buf.append("final ");

		buf.append("class " + name + " ");
		buf.append("{");

		return buf.toString();
	}

	public String generateClass(Class c) {
		return generateClass(c.getName(), c.getAccessModif(), c.isAbstract(),
				c.isStatic(), c.isFinal());
	}

	public String getClosingBracket() {
		return "}";
	}

}
