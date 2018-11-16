package jdbc_study_coffee.dto;

public class Product {
	private String code;//제품코드
	private String name;//제품이름


	//생성자
	public Product() {
	}
	//코드만 받기
	public Product(String code) {
		this.code = code;
	}
	//코드,이름 모두 받기
	public Product(String code, String name) {
		this.code = code;
		this.name = name; 
	}
	//get, set
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Product [%s, %s]", code, name);
	}

	
	
}
