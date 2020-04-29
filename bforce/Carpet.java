package bforce;
// https://programmers.co.kr/learn/courses/30/lessons/42842
// 프로그래머스 레벨2 카펫

public class Carpet {
	static int mBrown = 24; 
	static int mRed = 24;
	static int[] mAnswer = new int[2]; 
	public static void main(String[] args) {
		for(int vertical = 3; vertical < mBrown + mRed; vertical++) {
			for(int horizontal = 3; horizontal < mBrown + mRed; horizontal++) {
				int sideCnt = horizontal * 2 + (vertical - 2) * 2; 
				if(sideCnt == mBrown && (vertical - 2) * (horizontal -2) == mRed) {
					System.out.println(horizontal + " " + vertical);
					System.out.println(sideCnt);
					return;
				}
			}
		}
		
	}
}
