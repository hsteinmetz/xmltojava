package de.hsteinmetz.xmltojava.codegen.test;

import org.junit.Assert;
import org.junit.Test;

import de.hsteinmetz.xmltojava.codegen.ClassCodeGenerator;
import de.hsteinmetz.xmltojava.codegen.models.MethodParam;

public class CodeGeneratorTest {

	@Test
	public void test() {
		ClassCodeGenerator gen = new ClassCodeGenerator();

		String field = gen.generateField("test", "public", "String", false,
				"\"test\"", false);

		Assert.assertEquals(field, "public String test = \"test\";");

		Assert.assertEquals(gen.generateMethod("test", "public", "String",
				false, false, new MethodParam[0]), "public String test() { }");
	}

}
