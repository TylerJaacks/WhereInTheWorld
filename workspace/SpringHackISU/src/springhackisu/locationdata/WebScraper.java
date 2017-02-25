package springhackisu.locationdata;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
	
	String url;
	
	public WebScraper(String url)
	{
		this.url = url;
	}
	
	public String getHTML() throws IOException
	{
		String html = null;
		 URL oracle = new URL(url);
		 BufferedReader br = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));
	        
	        String inputLine = "";
	        while ((inputLine = br.readLine()) != null)
	        {
	        	html += inputLine;
	        }
	        br.close();
		return html;
	
	}
}
	

