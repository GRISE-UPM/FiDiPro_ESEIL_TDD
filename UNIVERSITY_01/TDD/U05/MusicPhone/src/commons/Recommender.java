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

	public static double computeDistance(GeoPoint position, GeoPoint positionConcert, String unit) {
		double radius=0,latD1,latD2,lonD1,lonD2,latR1,lonR1,latR2,lonR2,a,greatCircleDistance=0;
		latD1=Double.parseDouble(position.getLatitude());
		lonD1=Double.parseDouble(position.getLongitude());
		latD2=Double.parseDouble(positionConcert.getLatitude());
		lonD2=Double.parseDouble(positionConcert.getLongitude());
		if((latD1>=-90&&latD1<=90&&latD2>=-90&&latD2<=90)&&(lonD1>=-180&&lonD1<=180&&lonD2>=-180&&lonD2<=180)){
			latR1=(latD1*Math.PI)/180;
			lonR1=(lonD1*Math.PI)/180;
			latR2=(latD2*Math.PI)/180;
			lonR2=(lonD2*Math.PI)/180;
			a=Math.sqrt(Math.pow(Math.sin(Math.abs((latR1-latR2))/2),2)+Math.cos(latR1)*Math.cos(latR2)*Math.pow(Math.sin(Math.abs((lonR1-lonR2))/2),2));
			if(unit.equalsIgnoreCase("km"))
				radius=6371.01;
			else if(unit.equalsIgnoreCase("mi"))
				radius=3958.76;

			greatCircleDistance=2*Math.asin(Math.min(1.0, a))*radius;
		}
		return greatCircleDistance;
	}

}
