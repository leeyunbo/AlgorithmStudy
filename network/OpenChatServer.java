package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class OpenChatServer {
	HashMap clients;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OpenChatServer().start();
	}
	OpenChatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {
		ServerSocket serverSocket; 
		Socket socket = null; 
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getLocalPort()+"]"+"에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class ServerReceiver extends Thread {
		Socket socket; 
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		ServerReceiver(Socket socket) {
			this.socket = socket; 
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String name="";
			try {
				name = dis.readUTF();
				sendToAll("#"+name+"님이 들어오셨습니다.");
				clients.put(name, dos);
				System.out.println("현재 서버접속자 수는" + clients.size() +"입니다.");
				while(dis != null) {
					sendToAll(dis.readUTF());
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress()+":"+socket.getLocalPort()+"]"+"에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는" + clients.size() + "입니다.");
			}
		}
	}
	
}


