package extendEx;

public class ExtendEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Parent {
	private int x;
	private int y;
	private int z;
	
	Parent(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	};
}

class Child extends Parent {
	private int w; 
	Child(int x, int y, int z, int w) {
		super(x, y, z);
		this.w = w;
	}
}
