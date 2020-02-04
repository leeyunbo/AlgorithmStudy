package designpattern;
/*
 * strategy ����, ������ ������ ���� �������� ���� Ŭ������ �����Ͽ�
 * ���� ��ȭ�� ������ ���� �������� �ʰ�, ������ �����Ͽ� ��� Ŭ������ �����ų �� ���� 
 * ���յ��� ���߰� �������� ������! 
 */
public class Strategy {
	public static void main(String args[]) {
		Moving train = new Moving(new groundMoveStrategy());
		Moving plane = new Moving(new skyMoveStrategy());
		Moving car = new Moving(new groundMoveStrategy());
		plane.move();
		train.move();
		car.move();
	}
}
interface MoveStrategy {
	void move();
}

class skyMoveStrategy implements MoveStrategy{
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("�ϴ��� ����");
	}
}

class groundMoveStrategy implements MoveStrategy{
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("���� �޸���.");
	}
}
class Moving {
	private MoveStrategy strategy;
	
	public Moving(MoveStrategy strategy) {
		this.strategy = strategy;
	}
	public void move() {
		strategy.move();
	}
}
class bus extends Moving{
	bus(MoveStrategy strategy) {
		super(strategy);
	}
}


class plane  extends Moving{
	plane(MoveStrategy strategy) {
		super(strategy);
	}
}


class car  extends Moving{
	car(MoveStrategy strategy) {
		super(strategy);
	}
	
}
