package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.hsteinmetz.xmltojava.codegen.models.Method;
import de.hsteinmetz.xmltojava.codegen.models.MethodParam;

public class MethodParser {

	public static Method parseMethod(Node method) {

		Element elem = (Element) method;

		String name = elem.getAttribute("name");
		String type = elem.getAttribute("return");
		String acmod = elem.getAttribute("access");
		boolean abstr = Boolean.parseBoolean(elem.getAttribute("abstract"));
		boolean stat = Boolean.parseBoolean(elem.getAttribute("static"));

		MethodParam[] params = new MethodParam[0];

		if (method.getChildNodes().getLength() > 0)
			params = ParamParser.parseParams(elem.getElementsByTagName("param"));
		
		return new Method(name, type, acmod, abstr, stat, params);
	}

}
