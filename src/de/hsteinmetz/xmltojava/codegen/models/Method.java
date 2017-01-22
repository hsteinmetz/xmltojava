package de.hsteinmetz.xmltojava.codegen.models;

public class Method {

	String name, type, accessModif;
	boolean abstr, stat;
	MethodParam[] params;

	public Method(String name, String type, String accessModif, boolean abstr,
			boolean stat, MethodParam[] params) {
		super();
		this.params = params;
		this.name = name;
		this.type = type;
		this.accessModif = accessModif;
		this.abstr = abstr;
		this.stat = stat;
	}

	public MethodParam[] getParams() {
		return params;
	}

	public void setParams(MethodParam[] params) {
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccessModif() {
		return accessModif;
	}

	public void setAccessModif(String accessModif) {
		this.accessModif = accessModif;
	}

	public boolean isAbstr() {
		return abstr;
	}

	public void setAbstr(boolean abstr) {
		this.abstr = abstr;
	}

	public boolean isStat() {
		return stat;
	}

	public void setStat(boolean stat) {
		this.stat = stat;
	}

}
