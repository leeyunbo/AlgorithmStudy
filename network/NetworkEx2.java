package network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		
		try {
			url = new URL(address);
			URLConnection conn = url.openConnection();
			System.out.println(conn.toString());
			System.out.println(conn.getAllowUserInteraction()); 
			System.out.println(conn.getConnectTimeout());
			System.out.println(conn.getContentType());
			System.out.println(conn.getContentEncoding());
			System.out.println(conn.getDate());
			System.out.println(conn.getDefaultAllowUserInteraction());
			System.out.println(conn.getDefaultUseCaches());
			System.out.println(conn.getDoInput());
			System.out.println(conn.getDoOutput());
			System.out.println(conn.getConnectTimeout());
			System.out.println(conn.getHeaderFields());
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
