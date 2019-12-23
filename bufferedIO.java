package coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bufferedIO {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(bf.readLine());
		List result = new ArrayList();
		String[] split_data = new String[2];
		
		for(int i=0; i<count; i++) { 
			String data = bf.readLine();
			split_data = data.split(" ");
			result.add(Integer.parseInt(split_data[0])+Integer.parseInt(split_data[1]));
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<count; i++) { 
			bw.write(result.get(i)+"\n");
		}
		
		bf.close();
		bw.close();

		
	}

}
