import java.io.IOException;

public class tester {

	public static void main(String[] args) throws Exception
	{
//		WebScraper ws = new WebScraper("http://www.cnn.com/2017/02/23/europe/sweden-trump-refugees-integration/index.html");
//		LocationFinder loc = new LocationFinder(ws.getHTML());
//		String[] temparr = loc.getLocations();
//		for(int i = 0; i < temparr.length;i++)
//		{
//			System.out.println(temparr[i]);
//		}
		                                Geocode g = new Geocode();
		                                String[] s = {"Paris", "Berlin", "klajsfdlkasdhflkajdshflkasjdhfklasjdfhlkasdjfnsdmv sdklanfksjadfsaklmdfnsakldfnsalkdjfhlskafusaluflksadhfjkdsfnsdkfnsalfdh"};
		                                g.getCoordinates(s);
	}
}
