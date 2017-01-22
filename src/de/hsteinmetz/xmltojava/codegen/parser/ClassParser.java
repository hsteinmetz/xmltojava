package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ClassParser {

	public static de.hsteinmetz.xmltojava.codegen.models.Class parseClass(
			Node classNode) {

		Element elem = (Element) classNode;

		String className = elem.getAttribute("name");

		String classAcMod = elem.getAttribute("access");

		boolean stat = Boolean.parseBoolean(elem.getAttribute("static"));
		boolean abstr = Boolean.parseBoolean(elem.getAttribute("abstract"));
		boolean finaL = Boolean.parseBoolean(elem.getAttribute("final"));

		return new de.hsteinmetz.xmltojava.codegen.models.Class(className,
				classAcMod, finaL, stat, abstr);
	}

}
