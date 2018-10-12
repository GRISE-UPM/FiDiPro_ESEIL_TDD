package commons;

import java.util.List;

import commons.dataClasses.Destination;
import commons.dataClasses.GeoPoint;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IGps;
import commons.interfaces.IPlayer;
import commons.interfaces.IRecommender;




public class Recommender implements IRecommender {
	public Recommender(IConnector connector) {

		this.connector = connector;
	}

	public Recommender(){
		this.connector = null;
	}

	private IConnector connector;
	@Override
	public IConnector getConnector() {

		return this.connector;
	}

	@Override
	public void setConnector(IConnector connector) {
		this.connector = connector;

	}

	@Override
	public List<Recommendation> getRecommendations() throws ToBeImplementedException {
		try {
			throw new ToBeImplementedException("You need to implement this!");
		} catch (ToBeImplementedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Destination> getDestinationsForArtists(String artist) {
		try {
			throw new ToBeImplementedException("You need to implement this!");
		} catch (ToBeImplementedException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Destination> buildItineraryForArtists(List<String> artists) throws ToBeImplementedException  {
		try {
			throw new ToBeImplementedException("You need to implement this!");
		} catch (ToBeImplementedException e) {
			e.printStackTrace();
		}
		return null;
	}


	public  IPlayer getPlayer(){
		return DeviceManager.getInstance().getPlayer();
	}

	public  IGps getGps(){
		return DeviceManager.getInstance().getGps();
	}
	
	public static Object computeDistance(GeoPoint x ,GeoPoint y ,String unit){
		double radius=0;
		if(unit=="km"){
			radius = 6371.01;
		}else if (unit=="mi"){
			radius = 3958.76;
		}
		double lat1 = Double.parseDouble(x.getLatitude());
		double lat2 = Double.parseDouble(y.getLatitude());
		double lon1 = Double.parseDouble(x.getLongitude());
		double lon2 = Double.parseDouble(y.getLongitude());
		if((lat1 < -90 || lat1 > 90)||(lat2 < -90 || lat2 > 90)||(lon1 < -180 || lon1 > 180)||(lon2 < -180 || lon2 > 180)){
			
			return null;
		}
		
		return 2*Math.asin(Math.min(1.0, a(x,y)))*radius;
	}
	
	public static double a(GeoPoint x ,GeoPoint y){
		return Math.sqrt(Math.pow(((Math.sin(degreesToRadians(y.getLatitude())-degreesToRadians(x.getLatitude())/2))), 2)+
				Math.cos(degreesToRadians(x.getLatitude()))*Math.cos(degreesToRadians(y.getLatitude()))*
				Math.pow(((Math.sin(degreesToRadians(y.getLongitude())-degreesToRadians(x.getLongitude())/2))), 2));
	}
	
	public static double degreesToRadians(String x){
		double y = Double.parseDouble(x);
		return (y*Math.PI)/180;
	}

}
