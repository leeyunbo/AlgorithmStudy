/*
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 * ���α׷��ӽ� ��ųƮ��
 */
public class SkillTree {

	public static void main(String[] args) {
		String skill = "CBD"; 
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"}; 
		int answer = 0; 
		
		for(int i=0; i<skill_trees.length; i++) {
			String tempString = skill_trees[i];
			boolean isOk = true; 
			int depth = 0;
			// ���� ����� �ϴ� ��ų 
			
			for(int j=0; j<tempString.length(); j++) {
				char tempSkill = skill.charAt(depth); 
				char tempUserSkill = tempString.charAt(j); 
				// ���� ��ų Ʈ���� ���ԵǴ� ��ų�̸�
				// ������ �´��� Ȯ�� �ؾ���
				// ���࿡ ���� ������ �Ұ����� ��ų Ʈ��  
				if(isContain(skill ,tempUserSkill)) {
					if(tempUserSkill == tempSkill) {
						System.out.println(tempUserSkill+","+tempSkill);
						if(depth < skill.length()-1) depth++;
					}
					else {
						isOk = false; 
						break; 
					}
				}
			}
			
			if(isOk) answer++; 
			
		}
		
		System.out.println(answer);
	}
	
	private static boolean isContain(String skill, char tempUserSkill) {
		boolean isContain = false; 
		
		for(int i=0; i<skill.length(); i++) {
			if(skill.charAt(i) == tempUserSkill) {
				isContain = true; 
			}
		}
		
		return isContain; 
	}

}
