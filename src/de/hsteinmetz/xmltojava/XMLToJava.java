package de.hsteinmetz.xmltojava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.hsteinmetz.xmltojava.codegen.ClassGenerator;
import de.hsteinmetz.xmltojava.codegen.InterfaceCodeGenerator;
import de.hsteinmetz.xmltojava.codegen.ClassCodeGenerator;
import de.hsteinmetz.xmltojava.codegen.InterfaceGenerator;
import de.hsteinmetz.xmltojava.codegen.models.Class;
import de.hsteinmetz.xmltojava.codegen.models.Interface;
import de.hsteinmetz.xmltojava.codegen.parser.ClassParser;
import de.hsteinmetz.xmltojava.codegen.parser.FieldParser;
import de.hsteinmetz.xmltojava.codegen.parser.InterfaceParser;
import de.hsteinmetz.xmltojava.codegen.parser.MethodParser;
import de.hsteinmetz.xmltojava.xmlreader.XMLReader;

public class XMLToJava {

	public static void main(String[] args) {
		File input = new File(args[0]);

		System.out.println("Input file: " + input.getAbsolutePath());

		XMLReader read = new XMLReader(input);
		BufferedWriter out;

		NodeList classes = read.getClasses();
		NodeList interfaces = read.getInterfaces();

		String outputFile = "";
		
		ClassParser cp = new ClassParser();
		InterfaceParser ip = new InterfaceParser();
		
		ClassCodeGenerator codeGen = new ClassCodeGenerator();
		ClassGenerator classGen = new ClassGenerator();
		InterfaceGenerator interGen = new InterfaceGenerator();
		InterfaceCodeGenerator interCodeGen = new InterfaceCodeGenerator();
		
		String tabs = "";

		// Classes loop
		for (int i = 0; i < classes.getLength(); i++) {
			Class c = cp.parseClass(classes.item(i));

			outputFile = c.getName() + ".java";

			System.out.println("Found class: " + c.getName());
			
			System.out.println("Output file: " + outputFile);

			try {
				out = new BufferedWriter(new FileWriter(new File(outputFile)));
				out.write(classGen.generateClass(c));
				out.newLine();
				out.newLine();

				Node clazz = classes.item(i);

				NodeList subList = clazz.getChildNodes();
				
				for (int j = 0; j < subList.getLength(); j++) {
					Node current = subList.item(j);
					tabs = tabs + "\t";
					
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

			System.out.println("------------------------");
			
		} // End Classes loop
				
		// Interface loop
		for(int i = 0; i < interfaces.getLength(); i++) {
			Interface in = ip.parseInterface(interfaces.item(i));
			
			outputFile = in.getName() + ".java";
			
			System.out.println("Found Interface: " + in.getName());
			
			System.out.println("Output file: " + outputFile);
			
			try {
				out = new BufferedWriter(new FileWriter(new File(outputFile)));
				out.write(interGen.generateInterface(in));
				out.newLine();
				out.newLine();
				
				Node inter = interfaces.item(i);
				
				NodeList subList = inter.getChildNodes();
				
				for (int j = 0; j < subList.getLength(); j++) {
					Node current = subList.item(j);
					tabs = tabs + "\t";
					
					if (current.getNodeName().equals("method")) {
						out.write(tabs + interCodeGen.generateMethod(
								MethodParser.parseMethod(subList.item(j))));
						out.newLine();
						out.newLine();
						tabs = "";
					} else if(current.getNodeName().equals("field")) {
						out.write(tabs + interCodeGen.generateField(FieldParser.parseField(current)));
						
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
			
			System.out.println("------------------------");
		} // end interface loop

	}

}
