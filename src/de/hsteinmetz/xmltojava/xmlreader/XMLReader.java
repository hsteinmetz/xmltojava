package de.hsteinmetz.xmltojava.xmlreader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	NodeList classes;

	public XMLReader(File input) {
		factory = DocumentBuilderFactory.newInstance();

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			doc = builder.parse(input);

			doc.getDocumentElement().normalize();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public NodeList getClasses() {
		classes = doc.getElementsByTagName("class");
		return classes;
	}

}
