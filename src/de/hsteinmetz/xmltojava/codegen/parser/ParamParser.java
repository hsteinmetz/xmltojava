package de.hsteinmetz.xmltojava.codegen.parser;

import org.apache.commons.lang3.ArrayUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import de.hsteinmetz.xmltojava.codegen.models.MethodParam;

public class ParamParser {

	public static MethodParam[] parseParams(NodeList childNodes) {
		MethodParam[] params = new MethodParam[0];

		for (int i = 0; i < childNodes.getLength(); i++) {
			if(childNodes.item(i) instanceof Element) {
				Element elem = (Element) childNodes.item(i);
				MethodParam p = new MethodParam(elem.getAttribute("name"),
						elem.getAttribute("type"));
				
				params = ArrayUtils.add(params, p);
			}
		}

		return params;
	}

}
