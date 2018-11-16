package jdbc_study_coffee.dto;

public class SaleDetail {
	private int salPrice;// 판매금액
	private int supplyPrice;// 공급가액
	private double addtax;// 부가세액
	private double marginPrice;// 마진액
	private int ranking;//랭킹

	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}

	public SaleDetail(int salPrice, int supplyPrice, double addtax, double marginPrice) {
		this.salPrice = salPrice;
		this.supplyPrice = supplyPrice;
		this.addtax = addtax;
		this.marginPrice = marginPrice;
	}

	public SaleDetail(int salPrice, int supplyPrice, double addtax, double marginPrice, int ranking) {
		this.salPrice = salPrice;
		this.supplyPrice = supplyPrice;
		this.addtax = addtax;
		this.marginPrice = marginPrice;
		this.ranking = ranking;
	}

	// get set
	
	public int getSalesPrice() {
		return salPrice;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public void setSalesPrice(int salesPrice) {
		this.salPrice = salesPrice;
	}

	public int getSupply() {
		return supplyPrice;
	}

	public void setSupply(int supply) {
		this.supplyPrice = supply;
	}

	public double getAddPrice() {
		return addtax;
	}

	public void setAddPrice(double addPrice) {
		this.addtax = addPrice;
	}

	public double getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(double marginPrice) {
		this.marginPrice = marginPrice;
	}

}
