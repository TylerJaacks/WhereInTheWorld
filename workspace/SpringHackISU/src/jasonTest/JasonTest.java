package jasonTest;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;

import javax.swing.text.html.parser.Parser;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class JasonTest
{

	public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException {
		
		String[] coordinates = {"12.322132", "66.909090", "90.000000", "123.456789"};
		JasonWriter n = new JasonWriter();
		n.JSWriter(coordinates, "C:\\Users\\Owner\\Desktop\\Here\\JasonTest.json");
	}
}


