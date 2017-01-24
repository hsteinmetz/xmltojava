package de.hsteinmetz.xmltojava.codegen;

import de.hsteinmetz.xmltojava.codegen.models.Interface;

public class InterfaceGenerator {

	public String generateInterface(String name, boolean publicc) {
		StringBuffer sb = new StringBuffer();
		
		if(publicc) {
			sb.append("public ");
		}
		
		sb.append("interface " + name + " {\n");
		
		return sb.toString();
	}
	
	public String generateInterface(Interface i) {
		return this.generateInterface(i.getName(), i.isPublicc());
	}
	
	public String getClosingBracket() {
		return "}";
	}
	
}
