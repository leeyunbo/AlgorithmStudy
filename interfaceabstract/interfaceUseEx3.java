package interfaceabstract;
/*
 * DB 접근 로직 
 */
public class interfaceUseEx3 {
	static class StaticInner{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DBConnection db = InterfaceMananger.getInstance();
			db.Connect();
			db.Read();
			db.Delete();
			db.Write();
	}

}

class InterfaceMananger {
	public static DBConnection getInstance() {
		return new DBClass();
	}
}

interface DBConnection {
	void Connect(); 
	void Read();
	void Write();
	void Delete();
	void Update(); 
}

class DBClass implements DBConnection {
	@Override
	public void Connect() {
		// TODO Auto-generated method stub
		System.out.println("연결");
		
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println("읽기");
		
	}

	@Override
	public void Write() {
		// TODO Auto-generated method stub
		System.out.println("쓰기");
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("삭제");
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("업데이트");
	}
	
}
