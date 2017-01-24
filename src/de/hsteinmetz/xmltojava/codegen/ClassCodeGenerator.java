package de.hsteinmetz.xmltojava.codegen;

import de.hsteinmetz.xmltojava.codegen.models.Field;
import de.hsteinmetz.xmltojava.codegen.models.Method;
import de.hsteinmetz.xmltojava.codegen.models.MethodParam;

public class ClassCodeGenerator {

	/**
	 * 
	 * @param name
	 *            Field name
	 * @param accessModif
	 *            Field Access Modifier
	 * @param type
	 *            Field type
	 * @param stat
	 *            Static field or not
	 * @param constant
	 *            Final field or not
	 * @return Java code line for a field
	 */
	public String generateField(String name, String accessModif, String type,
			boolean stat, String initialValue, boolean constant) {
		StringBuffer buf = new StringBuffer();

		buf.append(accessModif + " ");

		if (stat) {
			buf.append("static ");
		}

		if (constant)
			buf.append("final ");

		buf.append(type + " ");
		buf.append(name);
		buf.append(" = ");
		buf.append(initialValue);
		buf.append(";");

		return buf.toString();
	}

	/**
	 * Creates a field and sets its initial value to <code>null</code>
	 * 
	 * @param name
	 *            Field name
	 * @param accessModif
	 *            Field Access Modifier
	 * @param type
	 *            Field type
	 * @param stat
	 *            Static field or not
	 * @param constant
	 *            Final field or not
	 * @return Java field code line
	 */
	public String generateField(String name, String accessModif, String type,
			boolean stat, boolean constant) {
		return generateField(name, accessModif, type, stat, "null", constant);
	}

	public String generateField(Field f) {
		return generateField(f.getName(), f.getAccessModif(), f.getType(),
				f.isStat(), f.getInitialValue(), f.isFinaL());
	}

	/**
	 * 
	 * @param name
	 *            Method name
	 * @param accessModif
	 *            Method access Modifier
	 * @param returnType
	 *            Method return type
	 * @param abstr
	 *            defines, if the method is abstract or not
	 * @param stat
	 *            defines, if the method is static or not
	 * @param params
	 *            Method params
	 * @return Java method code line
	 */
	public String generateMethod(String name, String accessModif,
			String returnType, boolean abstr, boolean stat,
			MethodParam[] params) {
		StringBuffer buf = new StringBuffer();

		buf.append(accessModif + " ");

		if (stat)
			buf.append("static ");

		if (abstr)
			buf.append("abstract ");

		buf.append(returnType + " ");
		buf.append(name + "(");

		if (params.length > 0)
			for (int i = 0; i < params.length; i++) {
				buf.append(params[i].getType() + " " + params[i].getName());
				if (i < params.length - 1)
					buf.append(", ");
			}

		buf.append(") { }");

		return buf.toString();
	}

	public String generateMethod(Method m) {
		return generateMethod(m.getName(), m.getAccessModif(), m.getType(),
				m.isAbstr(), m.isStat(), m.getParams());
	}

}
