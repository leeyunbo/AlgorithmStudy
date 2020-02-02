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
	void On(); // ���� Ű��
	void Off(); // ���� ���� 
	void Connect(); //���
	public static void Connect2() { //jdk1.8 ��������, interface�� default �޼ҵ�� static �޼ҵ带 �߰��ϴ� ���� ��������.
		System.out.println("hello");
	}
}

class Tv implements controlable {
	@Override
	public void On() {
		// TODO Auto-generated method stub
		System.out.println(category + " Ű��");
	}

	@Override
	public void Off() {
		// TODO Auto-generated method stub
		System.out.println(category + " ����");
	}

	@Override
	public void Connect() {
		// TODO Auto-generated method stub
		System.out.println(category + " ����ϴ�");
	}
	
}
