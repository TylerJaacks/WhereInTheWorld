package springhackisu.locationdata;
import java.util.ArrayList;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) throws Exception
	{
		WebScraper ws = new WebScraper("http://www.reuters.com/article/us-mideast-crisis-syria-un-russia-idUSKBN16324L");
		String[] html = ws.getHTML();
		int count = 0;
		for(int i = 0; i < html.length;i++)
		{
			count++;
			System.out.println(html[i]);
		}
		System.out.println(count + "!!!");
//		LocationFinder loc = new LocationFinder(ws.getHTML());
//		String[] temparr = loc.getLocations();
//		for(int i = 0; i < temparr.length;i++)
//		{
//			System.out.println(temparr[i]);
//		}
//		                                Geocode g = new Geocode();
//		                                String[] s = {"Paris", "Berlin", "klajsfdlkasdhflkajdshflkasjdhfklasjdfhlkasdjfnsdmv sdklanfksjadfsaklmdfnsakldfnsalkdjfhlskafusaluflksadhfjkdsfnsdkfnsalfdh"};
//		                                g.getCoordinates(s);
	}
}
