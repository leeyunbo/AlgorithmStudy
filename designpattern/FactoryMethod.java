package designpattern;
/*
 * FactoryMethod ����, Ŭ�������� Ŭ������ ��ü�� �����ϸ� ���յ��� �ö� �� �ۿ� ����.
 * ���� Factory��� ��ü ���� Ŭ������ ���� �����Ͽ�, ��ü ������ �ñ��. 
 * �������� �������� ���յ��� ��������. 
 */
public class FactoryMethod {
	public static void main(String args[]) {
		human runner = ObjectFactory.getInstance("Runner");
		human flyer = ObjectFactory.getInstance("Flyer");
		runner.moving();
		flyer.moving();
	}
}

interface human {
	public void moving(); 
}

class ObjectFactory {
	static public human getInstance(String select) {
		if(select.equals("Runner")) {
			return new Runner();
		}
		else if(select.equals("Flyer")) {
			return new Flyer();
		}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		return null;
	}
}

class Runner implements human {
	@Override
	public void moving() {
		// TODO Auto-generated method stub
		System.out.println("�޸���");
	}
}

class Flyer implements human{
	@Override
	public void moving() {
		// TODO Auto-generated method stub
		System.out.println("����");		
	}
}

