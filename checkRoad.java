package line;

public class checkRoad {
	static String myRoad ="111011110011111011111100011111";
	static int myN = 3;
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckRoadFunc(0, myRoad, 0);
		System.out.println(answer);
	}
	
	private static void CheckRoadFunc(int cnt, String road, int idx) {
		if(cnt >= 3 || idx >= road.length()) {
			int result = 0;
			int temp = 1;
			System.out.println(road);
			for(int i=0; i<road.length()-1; i++) {
				if(road.substring(i,i+1).equals("1") && road.substring(i+1,i+2).equals("1")) {
					temp++;
				}
				else {
					result = Math.max(temp,result);
					temp = 1;
				}
			}
			result = Math.max(temp,result);
			answer= Math.max(result, answer);
		}
		
		for(int i = idx; i<road.length(); i++) {
			String nextRoad = road;
			if(myRoad.substring(i,i+1).equals("0")) {
				nextRoad = road.substring(0,i) + "1" + road.substring(i+1,road.length());
				for(int j = i+1; j<road.length(); j++) {
					if(myRoad.substring(j,j+1).equals("0")) {
						nextRoad = nextRoad.substring(0,j) + "1" + nextRoad.substring(j+1,nextRoad.length());
						i = j;
					}
					else {
						CheckRoadFunc(cnt+1, nextRoad, j+1);
						i = j + 1;
						break;
					}
				}
			}
		}
	}

}
