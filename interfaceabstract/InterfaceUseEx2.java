package interfaceabstract;

public class InterfaceUseEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}

interface I {
	public abstract void methodB();
}

class B implements I {
	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("methodB() in B Class");
	}
}

class A {
	public void methodA(I i) { // B�� ���� �������� �ʰ�, I�� ���� B�� ���. �������� ���谡 �ƴ� �������� ���谡 �Ǿ���
		i.methodB();
	}
}
