package interfaceabstract;


abstract class abs_appliance {
	public int price = 200;
	abstract public void powerUp();
	abstract public void powerDown();
	abstract public void destory();
	abstract public void upgrade();
	public void add_function() {
		System.out.println("�߰����");
	}
}

class Computer extends abs_appliance{
	public int price = 400;
	@Override
	public void powerDown() {
		// TODO Auto-generated method stub
	}
	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add_function() {
		System.out.println("Computer �߰����");
	}
	
	
}


public class abstractEx {
	public static void main(String[] args) {
		abs_appliance app = new Computer(); //��������� ���������� Ÿ�Կ� ���� ��������, �������̵��� �޼ҵ�� �ν��Ͻ� Ÿ�Կ� ���� ��������.
		app.add_function();
		System.out.println(app.price);
		

	}
}
