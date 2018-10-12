package commons;

public class GeoPoint2 {
	double latitude;
	double longitude;
	
	public GeoPoint2(){
		
	}
	
	public void setLatitude(double latitude){
		if (latitude >= -90 && latitude <= 90)
			this.latitude = latitude;
		else 
			this.latitude = 100;
	}
	
	public void setLongitude(double longitude){
		if (longitude >= -180 && longitude <= 180)
			this.longitude = longitude;
		else 
			this.longitude = 200;
	}
	
	public double getLongitude(){
		return	this.longitude;
	}
	
	public double getLatitude(){
		return	this.latitude;
	}
	
}
