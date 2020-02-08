package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {
	static Socket socket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			try {
				String serverIp = "127.0.0.1";
				System.out.println("서버에 연결중입니다. 서버IP :" + serverIp);
				socket = new Socket(serverIp, 7777); //서버와 연결된 소켓 획득 
				
				InputStream in = socket.getInputStream(); // 소켓의 스트림 핸들러 객체 획득 
				OutputStream out = socket.getOutputStream();
				DataInputStream dis = new DataInputStream(in);
				DataOutputStream dos = new DataOutputStream(out);
				
				
				String message = dis.readUTF();
				if(message != null) {
					System.out.println("서버로부터 받은 메시지 :"+message);
				}
			} catch(ConnectException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
