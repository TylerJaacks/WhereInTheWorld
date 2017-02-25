import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
 
/**
* This class will get the lat long values.
*/
public class Geocode
{
	
	
	public Geocode()
	{
		
	}
	
                /**
  @throws Exception
                 **/
public static void getCoordinates(String[] locations) throws Exception
{
                File file = new File("C:\\Users\\Jeff Yokup\\Desktop\\DesktopHere\\something.txt");
                PrintWriter n = new PrintWriter(file);
                String output = "";
                for(int i = 0; i < locations.length; i++)
                {
                                output = "";
                                String temp[] = getLatLongPositions(locations[i]);
                                if(temp != null)
                                {
                                                //System.out.println(temp[0]);
                                                output += temp[0];
                                                output += " ";
                                                output += temp[1];
                                }
                                n.write(output);
                                n.println("");
                }
               
                n.close();
}
 
  private static String[] getLatLongPositions(String address) throws Exception
  {
    int responseCode = 0;
    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
    //System.out.println("URL : "+api);
    URL url = new URL(api);
    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
    httpConnection.connect();
    responseCode = httpConnection.getResponseCode();
    if(responseCode == 200)
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
      Document document = builder.parse(httpConnection.getInputStream());
      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();
      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
      String status = (String)expr.evaluate(document, XPathConstants.STRING);
      if(status.equals("OK"))
      {
         expr = xpath.compile("//geometry/location/lat");
         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
         expr = xpath.compile("//geometry/location/lng");
         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
         return new String[] {latitude, longitude};
      }
      else
      {
         return null;
      }
    }
    return null;
  }
}