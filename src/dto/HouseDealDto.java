package dto;

public class HouseDealDto {
	private int no;
	private String dealAmount; // 거래금액
	private String area; // 면적
	private String floor; // 층수
	private double aptCode;
	
	public HouseDealDto() {

	}
	
	public HouseDealDto(String dealAmount, String area, String floor, String apartmentName, String dong, String jibun,
			String lat, String lng) {
		this.dealAmount = dealAmount;
		this.area = area;
		this.floor = floor;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public double getAptCode() {
		return aptCode;
	}
	public void setAptCode(double aptCode) {
		this.aptCode = aptCode;
	}

	@Override
	public String toString() {
		return ", \"dealAmount\": \"" + dealAmount 
				+ "\", \"area\": \"" + area
				+ "\", \"floor\": \"" + floor + "\"}";
	}
	

}
