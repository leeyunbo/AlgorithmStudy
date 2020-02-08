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
				System.out.println("������ �������Դϴ�. ����IP :" + serverIp);
				socket = new Socket(serverIp, 7777); //������ ����� ���� ȹ�� 
				
				InputStream in = socket.getInputStream(); // ������ ��Ʈ�� �ڵ鷯 ��ü ȹ�� 
				OutputStream out = socket.getOutputStream();
				DataInputStream dis = new DataInputStream(in);
				DataOutputStream dos = new DataOutputStream(out);
				
				
				String message = dis.readUTF();
				if(message != null) {
					System.out.println("�����κ��� ���� �޽��� :"+message);
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
