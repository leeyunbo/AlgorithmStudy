package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer implements Runnable {
	static ServerSocket serverSocket = null;
	Thread[] threadArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TcpIpServer server = new TcpIpServer(5);
		server.start();
	}
	
	public TcpIpServer(int num) {
		try {
			serverSocket = new ServerSocket(7777); 
			System.out.println(getTime()+ "������ �غ�Ǿ����ϴ�.");
			threadArr = new Thread[num];
		} catch(IOException e) {e.printStackTrace();}
	}
	
	public void start() {
		for(int i=0; i<threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date()) + name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				System.out.println(getTime()+"���� ��û�� ��ٸ��ϴ�.");
				Socket socket = serverSocket.accept(); //���� ��û �����, ���� �Ϸ�Ǹ� ���ϰ� ���� 
				System.out.println(getTime()+socket.getInetAddress()+"�κ��� �����û�� ���Խ��ϴ�.");
				
				OutputStream out = socket.getOutputStream(); //socket�� stream ��ü ���
				DataOutputStream dos = new DataOutputStream(out); //DataOutputStream Ȯ��
				
				dos.writeUTF("[Notice] Test Message1 form Server."); //������ ���� 
				System.out.println(getTime()+"�����͸� �����߽��ϴ�.");
				
				dos.close();
				socket.close();
			} catch(SocketTimeoutException e) {
				System.out.println(getTime() + "���� ��û �ð��� �ʰ��Ǿ����ϴ�.");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
