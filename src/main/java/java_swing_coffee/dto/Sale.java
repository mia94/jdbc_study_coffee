package java_swing_coffee.dto;

public class Sale {
	public int no;//번호
	public String code;//코드
	public int price;//가격
	public int saleCnt;//판매수량
	public int marginRate;//마진율
	private SaleDetail detail;//SaleDetail에 만들어진 변수를 여기서 이용
	
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	//코드만 받기
	public Sale(String code) {
		this.code = code;
	}
	//전부받기
	public Sale(int no, String code, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}
	//get, set
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	//코드로 비교
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Sale [%s, %s, %s, %s, %s]", no, code, price, saleCnt, marginRate);
	}
	
	
	
}
