package interfaceabstract;


abstract class abs_appliance {
	public int price = 200;
	abstract public void powerUp();
	abstract public void powerDown();
	abstract public void destory();
	abstract public void upgrade();
	public void add_function() {
		System.out.println("추가기능");
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
		System.out.println("Computer 추가기능");
	}
	
	
}


public class abstractEx {
	public static void main(String[] args) {
		abs_appliance app = new Computer(); //멤버변수는 참조변수의 타입에 따라 정해지고, 오버라이딩된 메소드는 인스턴스 타입에 따라 정해진다.
		app.add_function();
		System.out.println(app.price);
		

	}
}
