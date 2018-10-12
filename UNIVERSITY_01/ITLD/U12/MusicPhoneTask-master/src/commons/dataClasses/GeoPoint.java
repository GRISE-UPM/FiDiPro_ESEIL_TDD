package commons.dataClasses;

public class GeoPoint {
	//Dimensions are in Degrees
	private String latitude;
	private String longitude;
	
	public GeoPoint(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public boolean validLatitude() {
		try {
			double dlatitude = Double.parseDouble(latitude); 
			return dlatitude >= -90 && dlatitude <= 90 ;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validLongitude() {
		try {
			double dlongitude = Double.parseDouble(longitude);
			return dlongitude >= -180 && dlongitude <= 180;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public double getLatitudeNumber() {
		return Double.parseDouble(latitude);
	}
	
	public double getLongitudeNumber() {
		return Double.parseDouble(longitude);
	}
	
	public double getLatitudeNumberRadians() {
		return Math.toRadians(Double.parseDouble(latitude));
	}
	
	public double getLongitudeNumberRadians() {
		return Math.toRadians(Double.parseDouble(longitude));
	}
}
