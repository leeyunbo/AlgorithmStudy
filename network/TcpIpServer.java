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
			System.out.println(getTime()+ "서버가 준비되었습니다.");
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
				System.out.println(getTime()+"연결 요청을 기다립니다.");
				Socket socket = serverSocket.accept(); //연결 요청 대기후, 연결 완료되면 소켓과 연결 
				System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				OutputStream out = socket.getOutputStream(); //socket의 stream 객체 얻기
				DataOutputStream dos = new DataOutputStream(out); //DataOutputStream 확장
				
				dos.writeUTF("[Notice] Test Message1 form Server."); //데이터 전송 
				System.out.println(getTime()+"데이터를 전송했습니다.");
				
				dos.close();
				socket.close();
			} catch(SocketTimeoutException e) {
				System.out.println(getTime() + "연결 요청 시간이 초과되었습니다.");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
