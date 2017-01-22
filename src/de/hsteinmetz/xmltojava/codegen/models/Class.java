package de.hsteinmetz.xmltojava.codegen.models;

public class Class {

	private String name, accessModif;

	private boolean finaL, stat, abstr;

	public Class(String name, String accessModif, boolean finaL, boolean stat,
			boolean abstr) {
		super();
		this.accessModif = accessModif;
		this.name = name;
		this.finaL = finaL;
		this.stat = stat;
		this.abstr = abstr;
	}

	public String getAccessModif() {
		return accessModif;
	}

	public void setAccessModif(String accessModif) {
		this.accessModif = accessModif;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFinal() {
		return finaL;
	}
	public void setFinal(boolean finaL) {
		this.finaL = finaL;
	}
	public boolean isStatic() {
		return stat;
	}
	public void setStatic(boolean stat) {
		this.stat = stat;
	}
	public boolean isAbstract() {
		return abstr;
	}
	public void setAbstract(boolean abstr) {
		this.abstr = abstr;
	}

}
