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
	public void methodA(I i) { // B를 직접 선언하지 않고, I를 통해 B를 사용. 직접적인 관계가 아닌 간접적인 관계가 되었음
		i.methodB();
	}
}
