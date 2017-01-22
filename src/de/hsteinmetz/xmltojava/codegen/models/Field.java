package de.hsteinmetz.xmltojava.codegen.models;

public class Field {

	String name, accessModif, type, initialValue;
	boolean stat, finaL;

	public Field(String name, String accessModif, String type,
			String initialValue, boolean stat, boolean finaL) {
		super();
		this.name = name;
		this.accessModif = accessModif;
		this.type = type;
		this.initialValue = initialValue;
		this.stat = stat;
		this.finaL = finaL;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccessModif() {
		return accessModif;
	}
	public void setAccessModif(String accessModif) {
		this.accessModif = accessModif;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInitialValue() {
		return initialValue;
	}
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	public boolean isStat() {
		return stat;
	}
	public void setStat(boolean stat) {
		this.stat = stat;
	}
	public boolean isFinaL() {
		return finaL;
	}
	public void setFinaL(boolean finaL) {
		this.finaL = finaL;
	}

}
