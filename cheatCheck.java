package line;

public class cheatCheck {
		private static String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"}; 
		private static String answer_sheet = "4132315142";
	public static void main(String[] args) {
		System.out.println(solution(answer_sheet,sheets));
	}
	
	private static boolean[] checkSame(boolean[][] isCorrect, int tempSheet, int otherSheet) {
		boolean[] isSame = new boolean[answer_sheet.length()];
		//2. 틀린 애들에 대해서, 같은 답을 선택한 애들을 찾는다. 
		for(int problem=0; problem<answer_sheet.length(); problem++) {
				String tempSelect = sheets[tempSheet].substring(problem,problem+1);
				if(isCorrect[tempSheet][problem]) {
					continue;
				}
				if(isCorrect[otherSheet][problem] || isSame[problem]) {
					continue;
				}
				
				if(tempSelect.equals(sheets[otherSheet].substring(problem,problem+1))) {
					isSame[problem] = true; 
				}
		}
		return isSame;
	}
	
	private static int checkContinuous(boolean[] isSame, int tempSheet) {
		//3. 각 학생에 대해서 연속되게 틀렸는데, 같은 답을 선택한 수를 구한다.
		int Cnt = 0;
		int continuous = 1; 
		int cont = 0;
		
		for(int j=0; j<answer_sheet.length(); j++) {
			if(isSame[j] == true) Cnt++;
		}

		if(Cnt == 0) {
			continuous = 0;
			return continuous;
		}
		
		for(int j=0; j<answer_sheet.length()-1; j++) {
			if(isSame[j] == true && isSame[j+1] == true) {
				cont++;
			}
			else {
				continuous = Math.max(continuous,cont);
				cont = 0;
			}
		}
			
		continuous = Math.max(continuous,cont);
		return continuous;
	}
	
	private static int solution(String answer_sheet, String[] sheets) {
		int answer = -1; 
		boolean[][] isCorrect = new boolean[sheets.length][answer_sheet.length()];
		
		//1. 채점을 한다. 
		for(int i=0; i<sheets.length; i++) {
			String sheet = sheets[i];
			int correctCnt = 0;
			// 답 수만큼 맞은것을 체크한다.
			for(int j=0; j<answer_sheet.length(); j++) {
				String correct = answer_sheet.substring(j,j+1);
				String select = sheet.substring(j,j+1); 
				if(correct.equals(select)) {
					isCorrect[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<sheets.length-1; i++) {
			for(int j=i; j<sheets.length; j++) {
				int sameCnt = 0;
				boolean[] isSame = checkSame(isCorrect,i,j);
				int continuous = checkContinuous(isSame,i);
				for(int k=0; k<isSame.length; i++) {
					if(isSame[k] == true) 
						sameCnt++;
				}
				answer = (int) Math.max(answer,sameCnt+Math.pow(continuous,2));
			}
		}
		
		
		
		return answer; 
	}
	

}
