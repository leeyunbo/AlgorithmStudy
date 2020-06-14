
public class Distance {
	static double answer = 654321;
	static int boardN = 3;
	static int boardM = 4;
	static int[][] boardMap = {{1,0,0,0},{0,0,0,0},{0,0,0,1}};
	public static void main(String[] args) {
		for(int i=0; i<boardN; i++) {
			for(int j=0; j<boardM; j++) {
				if(boardMap[i][j] == 1) {
					for(int k=0; k<boardN; k++) {
						for(int x=0; x<boardM; x++) {
							if(k == i && x == j) continue;
							if(boardMap[k][x] == 1) answer = Math.min(answer, getDistance(i,j,k,x));
						}
					}
				}
				else {
					continue;
				}
			}
		}
		
		
		System.out.println(answer);

	}
	
	
	// 두 점 사이의 거리를 구하는 메소드  
	private static double getDistance(int leftIdx, int rightIdx, int otherLeftIdx, int otherRightIdx) {
		double result = Math.sqrt(Math.pow((otherLeftIdx - leftIdx),2) 
				+ Math.pow((otherRightIdx - rightIdx), 2));
		return Math.round(result*100d)/100d;
	}

}
