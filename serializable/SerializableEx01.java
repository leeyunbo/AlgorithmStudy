package serializable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableEx01 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ObjectInputStream in = new ObjectInputStream(bis);
	
			UserInfo u1 = (UserInfo) in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			System.out.println(u1.toString());
			System.out.println(list.toString());
			System.out.println("직렬화 끝");
			in.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
