package designpattern;

import java.util.ArrayList;
import java.util.List;

public class Singleton{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonTest s = SingletonTest.getInstance();
		s.printClassName();
	}
}

final class SingletonTest { //final class는 오버라이딩이 불가능하다. 왜냐하면 상속이 불가능하기 때문이다.
	private static SingletonTest s = new SingletonTest();
	private SingletonTest() {}
	
	public static SingletonTest getInstance() {
		if(s==null) s = new SingletonTest();
		return s;
	}
	
	public void printClassName() {
		System.out.println(s.getClass().getName());
	}
}
