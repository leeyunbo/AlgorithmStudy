package programmers;
import java.util.*;
/*
���� ����
�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.

����	�̸�
��	���׶� �Ȱ�, ���� ���۶�
����	�Ķ��� Ƽ����
����	û����
�ѿ�	�� ��Ʈ
�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
�����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
�����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.
*/


public class ClothHash {
	public int solution(String[][] clothes) {
        int answer = 0;
        int count = 0;
        int Cnum = 1;
        HashMap<String, Integer> count_map = new HashMap<String, Integer>();
        
        for(int i=0; i<clothes.length; i++) {
            if(count_map.containsKey(clothes[i][1])) {
                count = count_map.get(clothes[i][1]); 
                count_map.put(clothes[i][1], count + 1);
            } else {
                count_map.put(clothes[i][1], 1);
            }       
        } 
                
        if(count_map.size() > 1) {
            for(Map.Entry<String, Integer> entry : count_map.entrySet()) {
                count = entry.getValue();
                if(count > 1) {
                    Cnum *= count + 1; 
                }
                else {
                    Cnum *= 2;
                }
            }
            answer = Cnum - 1;
        } else {
            answer = clothes.length;
        }
        
      
        
        return answer;
    }

}
