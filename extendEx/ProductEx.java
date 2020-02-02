package extendEx;

class Product {
	int price; 
	int bonusPoint;
	Product(int price) {
		this.price = price;
		this.bonusPoint = (int)(price/20.0);
	}
	Product() {}
	
}

class Tv extends Product {
	Tv() {
		super(200);
	}
	public String toString() {return "Tv";}
}

class Audio extends Product {
	Audio() {
		super(150);
	}
	public String toString() {return "Audio";}
}

class Computer extends Product {
	Computer() {
		super(160);
	}
	public String toString() {return "Computer";}
}

class buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i =0;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("돈이 부족해요.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void summary() {
		int sum = 0;
		String itemList="";
		
		for(int i=0; i<item.length; i++) {
			if(item[i] == null) break;
			sum += item[i].price;
			itemList += item[i] + ", ";
		}
		System.out.println("구입하신 물품의 총금액은 " +sum+"만원입니다." );
		System.out.println("구입하신 제품은 " +itemList+"입니다.");
	}
}


public class ProductEx {

	public static void main(String[] args) {
		buyer man = new buyer();
		man.buy(new Tv());
		man.buy(new Computer());
		man.buy(new Audio());
		
		man.summary();

	}

}
