import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

//This/O is/O a/O sample/O sentence/O about/O Obama/PERSON nuking/O Syria/LOCATION
//Cary/PERSON
//Minsk/LOCATION
//Chicago/LOCATION
public class LocationFinder {
//	String[] example = {"Fox River Grove","This is a sample sentence about Obama nuking Syria", "Cary", "Minsk", "Chicago"," Timbuktu"," Normandy"," Paris"," Warsaw","Europe","U.S."," London Bern Churchill Lexington Pittsburgh "};
//    for (String str : example) {
//      System.out.println(classifier.classifyToString(str));
//    }
	String serializedClassifier = "english.all.3class.distsim.crf.ser.gz";
	 static AbstractSequenceClassifier<CoreLabel> classifier;
	 static String article; //String  that contains the article
	 
	 /**
	  * LocationFinder constructor. Initializes some 2 objects that help use the NER api. 
	  * @param article
	  * @throws ClassCastException
	  * @throws ClassNotFoundException
	  * @throws IOException
	  */
	public LocationFinder(String article) throws ClassCastException, ClassNotFoundException, IOException
	{
		this.article = article;
	    classifier = CRFClassifier.getClassifier(serializedClassifier);
	}
	
	/**
	 * Returns string array of locations
	 * @return
	 */
	public static String[] getLocations()
	{
		String[] locations; //return this
		ArrayList<String> tempLocations = new ArrayList<String>();
		String articlePlusTokens = classifier.classifyToString(article); //creates string article with tokens
		Scanner scan = new Scanner(articlePlusTokens);
		while(scan.hasNext())
		{
			String word = scan.next();
			if(word.length() > 9)
			{
				if(word.substring(word.length()-8,word.length()).equals("LOCATION"))
				{
					tempLocations.add(word.substring(0,word.length()-9));
				}
			}
		}
		locations = new String[tempLocations.size()];
		for(int i = 0; i < tempLocations.size();i++)
		{
			locations[i] = tempLocations.get(i);
		}
		return locations;
	}
	

}