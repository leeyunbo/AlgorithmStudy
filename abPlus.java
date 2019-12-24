package coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class abPlus {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] split_data = new String[2];
		
		while(true) { 
			String data = bf.readLine();
			split_data = data.split(" ");
			System.out.println(Integer.parseInt(split_data[0])+Integer.parseInt(split_data[1]));
		}
	}
}
