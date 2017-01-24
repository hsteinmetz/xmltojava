package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.hsteinmetz.xmltojava.codegen.models.Method;
import de.hsteinmetz.xmltojava.codegen.models.MethodParam;

public class MethodParser {

	static String defAccess = "private";
	static boolean defStatic = false;
	static boolean defAbstr = false;
	
	public static Method parseMethod(Node method) {

		Element elem = (Element) method;

		String name = elem.getAttribute("name");
		String type = elem.getAttribute("return");
		String acmod = elem.hasAttribute("access") ? elem.getAttribute("access") : defAccess;
		boolean abstr = elem.hasAttribute("abstr") ? Boolean.parseBoolean(elem.getAttribute("abstract")) : defAbstr;
		boolean stat = elem.hasAttribute("static") ? Boolean.parseBoolean(elem.getAttribute("static")) : defStatic;

		MethodParam[] params = new MethodParam[0];

		if (method.getChildNodes().getLength() > 0)
			params = ParamParser.parseParams(elem.getElementsByTagName("param"));
		
		return new Method(name, type, acmod, abstr, stat, params);
	}

}
