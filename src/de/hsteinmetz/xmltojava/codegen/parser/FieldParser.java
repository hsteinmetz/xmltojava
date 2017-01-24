package de.hsteinmetz.xmltojava.codegen.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.hsteinmetz.xmltojava.codegen.models.Field;

public class FieldParser {

	public Field parseField(Node fieldNode) {
		Element field = (Element) fieldNode;
		
		String name = field.getAttribute("name");
		String type = field.getAttribute("type");
		boolean stat = Boolean.parseBoolean(field.getAttribute("static"));
		boolean fin = Boolean.parseBoolean(field.getAttribute("final"));
		String access = field.getAttribute("access");
		String initialValue = field.getAttribute("value");
		
		
		return new Field(name, access, type, initialValue, stat, fin);
	}
	
}
