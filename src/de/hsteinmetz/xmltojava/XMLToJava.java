package de.hsteinmetz.xmltojava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.hsteinmetz.xmltojava.codegen.ClassGenerator;
import de.hsteinmetz.xmltojava.codegen.CodeGenerator;
import de.hsteinmetz.xmltojava.codegen.models.Class;
import de.hsteinmetz.xmltojava.codegen.parser.ClassParser;
import de.hsteinmetz.xmltojava.codegen.parser.FieldParser;
import de.hsteinmetz.xmltojava.codegen.parser.MethodParser;
import de.hsteinmetz.xmltojava.xmlreader.XMLReader;

public class XMLToJava {

	public static void main(String[] args) {
		File input = new File(args[0]);

		System.out.println("Input file: " + input.getAbsolutePath());

		XMLReader read = new XMLReader(input);
		BufferedWriter out;

		NodeList classes = read.getClasses();

		String outputFile = "";
		ClassParser cp = new ClassParser();
		CodeGenerator codeGen = new CodeGenerator();
		ClassGenerator classGen = new ClassGenerator();
		
		String tabs = "";

		for (int i = 0; i < classes.getLength(); i++) {
			Class c = cp.parseClass(classes.item(i));

			outputFile = c.getName() + ".java";
			System.out.println("Output file: " + outputFile);

			System.out.println("Found class: " + c.getName());
			try {
				out = new BufferedWriter(new FileWriter(new File(outputFile)));
				out.write(classGen.generateClass(c));
				out.newLine();
				out.newLine();

				Node clazz = classes.item(i);

				NodeList subList = clazz.getChildNodes();

				System.out.println("Class elements: " + subList.getLength());

				for (int j = 0; j < subList.getLength(); j++) {
					Node current = subList.item(j);
					tabs += "\t";
					
					if (current.getNodeName().equals("method")) {
						out.write(tabs + codeGen.generateMethod(
								MethodParser.parseMethod(subList.item(j))));
						out.newLine();
						out.newLine();
						tabs = "";
					} else if(current.getNodeName().equals("field")) {
						out.write(tabs + codeGen.generateField(FieldParser.parseField(current)));
						
						out.newLine();
						out.newLine();
						tabs = "";
					}
				}

				out.write(classGen.getClosingBracket());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
