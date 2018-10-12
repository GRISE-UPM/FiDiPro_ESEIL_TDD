package commons;

import gps.Gps;

import java.util.Date;
import java.util.List;

import commons.dataClasses.ConcertInfo;
import commons.dataClasses.Destination;
import commons.dataClasses.GeoPoint;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IGps;
import commons.interfaces.IPlayer;
import commons.interfaces.IRecommender;
import dataConnectors.LastFmXmlConnector;




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
	public static double computeDistance(GeoPoint gp1,GeoPoint gp2, String name){
		double lat1,lon1,lat2,lon2,a,deltalat,deltalon,gcd,earthradius;
		earthradius=6371.01;
		lat1=Double.parseDouble(gp1.getLatitude());
		lon1=Double.parseDouble(gp1.getLongitude());
		lat2=Double.parseDouble(gp2.getLatitude());
		lon2=Double.parseDouble(gp2.getLongitude());
		deltalat=lat1-lat2;
		deltalon=lon1-lon2;
		a=Math.sqrt(Math.abs((Math.sin(deltalat/2)*Math.sin(lat1/2))+Math.cos(lat1)*Math.cos(lat2)*(Math.sin(deltalon/2)*Math.sin(deltalon/2))));
		gcd=2*Math.atan(Math.min(1.0,a))*earthradius;
		return gcd;
	}
	
	public static String checkValidity(){
		IGps gps = new Gps();
		GeoPoint position1 = new GeoPoint("-14.2", "60.4");
		gps.setCurrentPosition(position1);
	    gps.setDistanceUnits("KM");
	    if(((Double.parseDouble(gps.getCurrentPosition().getLatitude())<-90)&&(Double.parseDouble(gps.getCurrentPosition().getLatitude())>90))||((Double.parseDouble(gps.getCurrentPosition().getLongitude())<-180)&&(Double.parseDouble(gps.getCurrentPosition().getLongitude())>180))) 
	    	return "Not Valid Distance";
		else
			return "Valid Distance";
	}
	public static String getDestinationsForArtist(){
		
		
		return null;
		
	}

}
