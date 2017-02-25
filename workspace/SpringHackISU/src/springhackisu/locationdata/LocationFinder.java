package springhackisu.locationdata;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

public class LocationFinder {
//	String[] example = {"Fox River Grove","This is a sample sentence about Obama nuking Syria", "Cary", "Minsk", "Chicago"," Timbuktu"," Normandy"," Paris"," Warsaw","Europe","U.S."," London Bern Churchill Lexington Pittsburgh "};
//    for (String str : example) {
//      System.out.println(classifier.classifyToString(str));
//    }
	String serializedClassifier = "english.all.3class.distsim.crf.ser.gz";
	 static AbstractSequenceClassifier<CoreLabel> classifier;
	 static String article; //String  that contains the article
	 static ArrayList<String> tempLocations;
	static int duplicates = 0;
	 
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
	    tempLocations = new ArrayList<String>();
		String articlePlusTokens = classifier.classifyToString(article); //creates string article with tokens
		Scanner scan = new Scanner(articlePlusTokens);
		
		while(scan.hasNext())
		{
			String word = scan.next();
			if(word.length() > 9)
			{
				if(word.substring(word.length()-8,word.length()).equals("LOCATION"))
				{
					if(!contains(word))
					tempLocations.add(word.substring(0,word.length()-9));
					else
					{
						duplicates++;
					}
					
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
	
	public static boolean contains(String s)
	{
		for(int i = 0; i < tempLocations.size();i++)
		{
			String temp = tempLocations.get(i);
			if(temp.equals(s.substring(0,s.length()-9)))
				return true;
		}
		return false;
	}
	
	public int getDuplicates()
	{
		return duplicates;
	}
	
	public void cleanLocations(String[] point)
	{
		ArrayList<String> temparray = new ArrayList<String>();
		for(int i = 0; i < point.length; i++)
		{
			temparray.add(point[i]);
		}

		for(int i = 0; i < tempLocations.size();i++)
		{
			String temp = tempLocations.get(i); //String to be tested
			String tempSwitch = temp; //New String to be replaced

			for(int x = 0; x < 40; x++)
			{
				try
				{
					if(!(Character.isUpperCase(temp.charAt(x)) || Character.isLowerCase(temp.charAt(x))))
					{
						tempSwitch = tempSwitch.replace(temp.substring(x, x+1), "");
					}
				}
				catch(Exception e)
				{
					break;
				}
			}
			temparray.set(i, tempSwitch);
		}
		for(int i = 0; i < temparray.size(); i++)
		{
			point[i] = temparray.get(i);
		}
	}
	

}
