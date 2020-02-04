package designpattern;
/*
 * strategy 패턴, 동일한 행위에 대해 전략으로 따로 클래스를 생성하여
 * 만약 변화가 있으면 직접 변경하지 않고, 전략만 변경하여 모든 클래스를 변경시킬 수 있음 
 * 결합도를 낮추고 응집도를 높이자! 
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
		System.out.println("하늘을 날다");
	}
}

class groundMoveStrategy implements MoveStrategy{
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("땅을 달리다.");
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
