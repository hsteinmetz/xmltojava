package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.hsteinmetz.xmltojava.codegen.models.Field;

public class FieldParser {

	static boolean defStatic = false;
	static boolean defFinal = false;
	static String defAccess = "private";
	
	public static Field parseField(Node fieldNode) {
		Element field = (Element) fieldNode;
		
		String name = field.getAttribute("name");
		String type = field.getAttribute("type");
		boolean stat = field.hasAttribute("static") ? Boolean.parseBoolean(field.getAttribute("static")) : defStatic;
		boolean fin = field.hasAttribute("final") ? Boolean.parseBoolean(field.getAttribute("final")) : defFinal;
		String access = field.hasAttribute("access") ? field.getAttribute("access") : defAccess;
		String initialValue = field.hasAttribute("value") ? field.getAttribute("value") : null;
		
		
		return new Field(name, access, type, initialValue, stat, fin);
	}
	
}
