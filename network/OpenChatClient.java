package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OpenChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String serverIp="127.0.0.1";
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new Thread(new ClientReceiver(socket));
			Thread receiver = new Thread(new ClientSender(socket,"축하합니다, 최종합격하셨습니다."));
			sender.start();
			receiver.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static class ClientSender extends Thread {
		Socket socket; 
		DataOutputStream dos;
		String name; 
		ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			Scanner scanner = new Scanner(System.in);
			try {
				if(dos != null) {
					dos.writeUTF(name);
				}
				while(dos!=null) {
					dos.writeUTF("["+name+"]"+scanner.nextLine());
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ClientReceiver extends Thread {
		Socket socket; 
		DataInputStream dis;
		String name; 
		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(dis!=null) {
				try {
					System.out.println(dis.readUTF());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
