package network;

import java.net.Socket;

public class CharClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String serverIP = "127.0.0.1";
			Socket socket = new Socket(serverIP, 7777);
			
			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
