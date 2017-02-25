package springhackisu.locationdata;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) throws Exception
	{
		File file = new File("C:\\Users\\Jeff Yokup\\Desktop\\WhereInTheWorld\\URLs.txt");
		Scanner scan = new Scanner(file);
		int count = 1;
		String[] cordArray;
		ArrayList<String> temp = new ArrayList<String>();
		while(count < 5)
		{
			System.out.println("Started New URL");
			String url = scan.next();
			System.out.println("Scanned URL");
			WebScraper jeff = new WebScraper(url);
			System.out.println("Created WebScraper");
			String html = jeff.getHTML();
			System.out.println("Retrieved HTML");
			LocationFinder Tyler = new LocationFinder(html);
			System.out.println("Created Location Finder");
			String[] arr = Tyler.getLocations();
			Tyler.cleanLocations(arr);
			System.out.println("Received Locations");
			Geocode Paul = new Geocode();
			String[] Steve = Paul.getCoordinates(arr);
			System.out.println(Arrays.toString(Steve));
			System.out.println("Got coordinates");
			System.out.println("Finished URL #" + count);
			System.out.println();
			count++;
		}
		scan.close();
		System.out.println("Finished Execution");
	}
}
