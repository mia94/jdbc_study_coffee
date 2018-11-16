package jdbc_study_coffee.dto;

public class Sale {
	private int no;//번호
//	private String code;//코드
	private int price;//가격
	private int saleCnt;//판매수량
	private int marginRate;//마진율
	private Product product;
	private SaleDetail detail;
	
	public Sale() { 
		// TODO Auto-generated constructor stub
	}

	public Sale( Product product,int price, int saleCnt, int marginRate, SaleDetail detail) {
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.product = product;
		this.detail = detail;
	}

	public Sale(int no, Product product, int price, int saleCnt, int marginRate, SaleDetail detail) {
		this.no = no;
		this.price = price; 
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.product = product;
		this.detail = detail;
	}

	public Sale(int no,Product product, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public Sale(int no, int price, int saleCnt, int marginRate, SaleDetail detail) {
		this.no = no;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.detail = detail;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SaleDetail getDetail() {
		return detail;
	}

	public void setDetail(SaleDetail detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return String.format("Sale [%s, %s, %s, %s, %s, %s]", no, price, saleCnt, marginRate, product, detail);
	}

	
	
	

	
	
	
}
