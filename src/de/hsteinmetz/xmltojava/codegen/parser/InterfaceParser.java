package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.hsteinmetz.xmltojava.codegen.models.Interface;

public class InterfaceParser {

	static boolean defPublicc = true;
	
	public static Interface parseInterface(Node interfaceNode) {
		Element elem = (Element) interfaceNode;
		
		String name = elem.getAttribute("name");
		boolean publicc = elem.hasAttribute("public") ? Boolean.parseBoolean(elem.getAttribute("public")) : defPublicc;
		
		return new Interface(name, publicc);
	}
	
}
