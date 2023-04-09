package dto;

public class HouseInfoDto {
	private double aptCode;
	private String dong;
	private String jibun;
	private String lat; // 위도
	private String lng; // 경도
	private String dongCode;
	private String apartmentName;
	
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public double getAptCode() {
		return aptCode;
	}
	public void setAptCode(double aptCode) {
		this.aptCode = aptCode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "{\"aptCode\":" + aptCode 
				+ ", \"dong\": \"" + dong 
				+ "\", \"jibun\": \"" + jibun 
				+ "\", \"lat\": \"" + lat 
				+ "\", \"lng\": \"" + lng 
				+ "\", \"dongCode\": \"" + dongCode 
				+ "\", \"apartmentName\": \"" + apartmentName + "\"";
	}
}
