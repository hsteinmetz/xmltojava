package de.hsteinmetz.xmltojava.codegen.models;

public class Interface {

	String name;
	
	boolean publicc = true;

	public Interface(String name, boolean publicc) {
		super();
		this.name = name;
		this.publicc = publicc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPublicc() {
		return publicc;
	}

	public void setPublicc(boolean publicc) {
		this.publicc = publicc;
	}
	
	
	
}
