package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = null;
		BufferedReader input = null;
		String address = "https://mail.naver.com/";
		String line = "";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
