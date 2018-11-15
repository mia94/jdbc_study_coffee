package jdbc_study_coffee.dto;

public class SaleDetail{
	private int salesPrice;//판매금액
	private int supply;//공급가액
	private double addPrice;//부가세액
	private double marginPrice;//마진액
	
	
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}
	
	//get set
	public int getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}
	public int getSupply() {
		return supply;
	}
	public void setSupply(int supply) {
		this.supply = supply;
	}
	public double getAddPrice() {
		return addPrice;
	}
	public void setAddPrice(double addPrice) {
		this.addPrice = addPrice;
	}
	public double getMarginPrice() {
		return marginPrice;
	}
	public void setMarginPrice(double marginPrice) {
		this.marginPrice = marginPrice;
	}


}
