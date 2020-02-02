package interfaceabstract;

public class interfaceEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv tv = new Tv();
		tv.On();
		tv.Connect();
		tv.Off();
	}
}

interface controlable {
	public static final String category = "appliance"; 
	void On(); // 전원 키기
	void Off(); // 전원 끄기 
	void Connect(); //통신
	public static void Connect2() { //jdk1.8 버전부터, interface에 default 메소드와 static 메소드를 추가하는 것이 가능해짐.
		System.out.println("hello");
	}
}

class Tv implements controlable {
	@Override
	public void On() {
		// TODO Auto-generated method stub
		System.out.println(category + " 키다");
	}

	@Override
	public void Off() {
		// TODO Auto-generated method stub
		System.out.println(category + " 끄다");
	}

	@Override
	public void Connect() {
		// TODO Auto-generated method stub
		System.out.println(category + " 통신하다");
	}
	
}
