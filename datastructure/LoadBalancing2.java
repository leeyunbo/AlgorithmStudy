import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
class Server {
	int num; 
	Long total_consume_time; 
	LinkedList<Long> request_time_queue = new LinkedList<>();
	LinkedList<Long> consume_time_queue = new LinkedList<>();
	LinkedList<Long> finishTime = new LinkedList<>();
	public Server(int num) {
		this.num = num;
	}
	public void timeRR() {
		while(!request_time_queue.isEmpty()) {
			long start_time = request_time_queue.poll().longValue();
			if(start_time > total_consume_time) 
				total_consume_time = start_time + consume_time_queue.poll();
			else
				total_consume_time = total_consume_time + consume_time_queue.poll();
			
			finishTime.add(total_consume_time);
		}
	}
	public int countQueue(long currentTime) {
		int count = 0;
		for(int i=0; i<finishTime.size(); i++) {
			if(finishTime.get(i) > currentTime) {
				count++;
			}
		}
		
		return count;
	}
	
}
public class LoadBalancing2 {
	public static final int INF = 654321;
	public static LinkedList<Long> request_time_queue = new LinkedList<>();
	public static LinkedList<Long> consume_time_queue = new LinkedList<>();
	public static String[] request_time = {"12:00:00.100 0.400","12:00:00.200 0.500","12:00:00.300 0.100","12:00:00.400 0.600","12:00:00.500 0.200", "12:00:00.600 0.400"};
	public static String[] consume_time = {"0.400","0.500","0.100","0.600","0.200","0.400"};
	public static HashMap<Integer,Server> serverMap = new HashMap<>();
	static SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss.SSS");
	static SimpleDateFormat format2 = new SimpleDateFormat("s.SSS");

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int numServer = scanner.nextInt();
		
		addRequest();
		startServer(numServer);
		System.out.println("Round Robin의 총 걸린 시간 :" + RoundRobin());
		addRequest();
		startServer(numServer);
		System.out.println("Least Connection의 총 걸린 시간 :" + LeastConnection());
	}
	
	static public void addRequest() throws ParseException { // 요청 채우기
		int numRequest = request_time.length;
		
		for(int i=0; i<numRequest; i++) {
			Date n = format.parse(request_time[0]);
			Date n2 = format2.parse(consume_time[0]);
			request_time_queue.add(n.getTime());
			consume_time_queue.add(n2.getTime());
		}		
	}
	
	static public void startServer(int numServer) { // 서버 시작 
		for(int i=0; i<numServer; i++) {
			Server server = new Server(i+1);
			serverMap.put(i+1, server);
		}
	}
	
	static public long RoundRobin() {
		long max = 0;
		int i = 0;
		while(!request_time_queue.isEmpty()) {
			i = i%(serverMap.size());
			serverMap.get(i+1).request_time_queue.add(request_time_queue.poll().longValue());
			serverMap.get(i+1).consume_time_queue.add(consume_time_queue.poll().longValue());
			serverMap.get(i+1).timeRR();
			if(max < serverMap.get(i+1).total_consume_time) 
				max = serverMap.get(i+1).total_consume_time;
			i++;
		}
		return max;
	}
	
	static public long LeastConnection() {
		int min = INF;
		int min_idx = 0;
		while(!request_time_queue.isEmpty()) {
			min = INF;
			for(int i=0; i<serverMap.size(); i++) {
				int count = serverMap.get(i+1).countQueue(request_time_queue.peek());
				if(min > count) {
					min = count;
					min_idx = i;
				}
			}
			serverMap.get(min_idx+1).request_time_queue.add(request_time_queue.poll().longValue());
			serverMap.get(min_idx+1).consume_time_queue.add(consume_time_queue.poll().longValue());
			serverMap.get(min_idx+1).timeRR();
		}
		long max = 0;
		for(int i=0; i<serverMap.size(); i++) {
			if(max < serverMap.get(i+1).total_consume_time)
				max = serverMap.get(i+1).total_consume_time;
		}
		
		return max;
	}

}
