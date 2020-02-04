package interfaceabstract;

public class interfaceUseEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SCV scv = new SCV();
		Tank tank = new Tank();
		Overload overload = new Overload();
		
		scv.repairUnit(tank);
		scv.repairUnit(overload);
		
		tank.modeChange();
		overload.getUnit();
	}
}

interface Repairable {}

class GroundUnit {
	int hitPoint;
	final boolean repairable;
	final int MAX_HP;
	int x, y; 
	GroundUnit (int hp,boolean repairable) {
		this.MAX_HP = hp;
		this.repairable = repairable;
		this.x = 0;
		this.y = 0;
	}
	public void move(int x, int y) {
		System.out.println("�̵� ������ġ : " + x + ", " + y);
		x += x;
		y += y;
	}
}

class SkyUnit {
	int hitPoint;
	final boolean repairable;
	final int MAX_HP;
	int x, y; 
	SkyUnit (int hp, boolean repairable) {
		this.MAX_HP = hp;
		this.repairable = repairable;
		this.x = 0;
		this.y = 0;
	}
	
	public void move(int x, int y) {
		System.out.println("�̵� ������ġ : " + x + ", " + y);
		x += x;
		y += y;
	}
}

class Tank extends GroundUnit implements Repairable {
	boolean mod = false;
	Tank() {
		super(200,true);
	}
	public void modeChange() {
		System.out.println("������");
		mod = !mod;
	}
	public String toString() {
		return "Tank";
	}
}

class Overload extends SkyUnit implements Repairable {
	int unitCount = 0;
	Overload() {
		super(100,false);
	}
	public void getUnit() {
		System.out.println("���� ž��");
		unitCount++;
	}
	public String toString() {
		return "Overload";
	}
}

class SCV extends GroundUnit implements Repairable{
	final boolean repairable = true;;
	SCV() {
		super(50,true);
	}
	public void repairUnit(Repairable unit) {
		if(unit instanceof SkyUnit) {
			SkyUnit skyUnit = (SkyUnit)unit; 
			if(skyUnit.repairable==false) {
				System.out.println("��ĥ �� �����ϴ�.");
				return;
			}
		}
		else {
			GroundUnit groundUnit = (GroundUnit)unit;
			if(groundUnit.repairable==false) {
				System.out.println("��ĥ �� �����ϴ�.");
				return;
			}
		}
		System.out.println(unit.toString()+" ���ƽ��ϴ�.");
	}
	public String toString() {
		return "Scv";
	}
}
