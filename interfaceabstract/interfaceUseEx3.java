package interfaceabstract;
/*
 * DB ���� ���� 
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
		System.out.println("����");
		
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println("�б�");
		
	}

	@Override
	public void Write() {
		// TODO Auto-generated method stub
		System.out.println("����");
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("����");
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("������Ʈ");
	}
	
}
