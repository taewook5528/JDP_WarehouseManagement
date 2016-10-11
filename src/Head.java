import java.util.ArrayList;///////

public class Head {
	//내부 주문 접수 클래스
	private class Request {
		private String storeName;
		private String stockName;
		private int amount;
		private boolean confirmed; //주문 접수 여부
		
		public Request(String storeName, String stockName, int amount) {
			this.storeName = storeName;
			this.stockName = stockName;
			this.amount = amount;
			this.confirmed = false;
		}
	}
	
	String id, password;
	private ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>(); //창고 어레이리스트
	private ArrayList<Store> stores = new ArrayList<Store>(); //가게 어레이리스트
	
	public void showDetail(Warehouse obj) {
		
	}
	
	public void showDetail(Store obj) {
		
	}
	
	public void calculate(Request r) {
		
		/* calculating ... */
		
		r.confirmed = true;
	}
}
