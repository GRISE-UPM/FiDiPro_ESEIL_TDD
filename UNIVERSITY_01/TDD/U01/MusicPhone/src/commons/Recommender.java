package commons;

import java.util.List;



import commons.dataClasses.Destination;

import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IGps;
import commons.interfaces.IPlayer;
import commons.interfaces.IRecommender;
import commons.dataClasses.GeoPoint;




public class Recommender implements IRecommender {
	public Recommender(IConnector connector) {

		this.connector = connector;
	}
	
	public static  double computeDistance (GeoPoint x,GeoPoint y, String s){
		double retorno=-1;
		double alfa,distanceKm,distanceMi;
		double deltaLat,deltaLon;
		double latx=Double.parseDouble(x.getLatitude());
		double laty=Double.parseDouble(y.getLatitude());
		double longx=Double.parseDouble(x.getLongitude());
		double longy=Double.parseDouble(y.getLongitude());
		double LatRx=latx*Math.PI/180;
		double LonRx=longx*Math.PI/180;
		double LatRy=laty*Math.PI/180;
		double LonRy=longy*Math.PI/180;
		
		if(latx>90||latx<-90)
			retorno=-1;
		else if(longx>180||longx<-180)
			retorno=-1;
		else{
			deltaLat=Math.abs(LatRx-LatRy);
			deltaLon=Math.abs(LonRy-LonRx);
			alfa=Math.sqrt(Math.pow(Math.sin(deltaLat/2),2)+Math.cos(LatRx)*Math.cos(LatRy)*Math.pow(Math.sin(deltaLon/2),2));
			distanceKm=2*Math.asin(Math.min(1.0, alfa))*6371.01;
			distanceMi=2*Math.asin(Math.min(1.0, alfa))*3958.76;
			if(s=="km")
				retorno=distanceKm;
			else
				retorno=distanceMi;
			}
		
		return retorno;
		
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

}
