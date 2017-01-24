package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ClassParser {

	static boolean defStatic = false;
	static boolean defAbstr = false;
	static boolean defFinal = false;
	static String defAccess = "public";
	
	public static de.hsteinmetz.xmltojava.codegen.models.Class parseClass(
			Node classNode) {

		Element elem = (Element) classNode;

		String className = elem.getAttribute("name");

		String classAcMod = elem.hasAttribute("access") ? elem.getAttribute("access") : defAccess;

		boolean stat = elem.hasAttribute("static") ? Boolean.parseBoolean(elem.getAttribute("static")) : defStatic;
		boolean abstr = elem.hasAttribute("abstract") ? Boolean.parseBoolean(elem.getAttribute("abstract")): defAbstr;
		boolean finaL = elem.hasAttribute("final") ? Boolean.parseBoolean(elem.getAttribute("final")) : defFinal;

		return new de.hsteinmetz.xmltojava.codegen.models.Class(className,
				classAcMod, finaL, stat, abstr);
	}

}
