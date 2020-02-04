package designpattern;
/*
 * FactoryMethod 패턴, 클래스에서 클래스의 객체를 생성하면 결합도가 올라갈 수 밖에 없다.
 * 따라서 Factory라는 객체 생성 클래스를 따로 생성하여, 객체 생성을 맡긴다. 
 * 의존도가 내려가서 결합도가 떨어진다. 
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
			System.out.println("잘못 입력하셨습니다.");
		}
		return null;
	}
}

class Runner implements human {
	@Override
	public void moving() {
		// TODO Auto-generated method stub
		System.out.println("달리다");
	}
}

class Flyer implements human{
	@Override
	public void moving() {
		// TODO Auto-generated method stub
		System.out.println("날다");		
	}
}

