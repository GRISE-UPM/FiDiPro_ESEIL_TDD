package commons;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import commons.dataClasses.ConcertInfo;
import commons.dataClasses.Destination;
import commons.dataClasses.GeoPoint;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IGps;
import commons.interfaces.IPlayer;
import commons.interfaces.IRecommender;
import dataConnectors.LastFmConnectionException;




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

	public List<Recommendation> getRecommendations(String currentArtistName) throws LastFmConnectionException{
		IConnector connector = null;
		List<String> topFans = null;
		List<String> topArtistsPerFan = null;
		
		
		topFans = connector.getTopFansForArtist(currentArtistName);
		Object[] arrTopFans = topFans.toArray();
		for (int i = 0; i<arrTopFans.length; i++){
			String fanName = (String)arrTopFans[i];
			topArtistsPerFan = connector.getTopArtistsByFan(fanName);
			
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
	
	public static double convertToRadians (double degrees){
		double radians = (degrees*Math.PI)/180;
		return radians;
		
	}
	
	public static double computeDistance (GeoPoint g1, GeoPoint g2, String unit){
		double radius = 0;
		double a = 0;
		int band = 1;
		double greatDistance;
		
		if ( unit.equals("mi"))
			radius = 3958.76;
		else if (unit.equals("km"))
				radius = 6371.01;
		
		if (Double.parseDouble(g1.getLatitude()) < -90 || Double.parseDouble(g2.getLatitude()) > 90)
			band = 0;
		else if (Double.parseDouble(g1.getLongitude()) < -180 || Double.parseDouble(g2.getLongitude()) > 180)
				band = 0;
		
		
		
		if (band == 1){
			double LatRG1 = convertToRadians(Double.parseDouble(g1.getLatitude())); 
			double LatRG2 = convertToRadians(Double.parseDouble(g2.getLatitude()));
			double LonRG1 = convertToRadians(Double.parseDouble(g1.getLongitude())); 
			double LonRG2 = convertToRadians(Double.parseDouble(g2.getLongitude()));
			
			double DeltaLatR = LatRG1 - LatRG2;
			double DeltaLonR = LonRG1 - LonRG2;
		
			a = Math.sqrt(Math.sin(DeltaLatR/2)+Math.cos(LatRG1)* Math.cos(LatRG2)*Math.pow(Math.sin(DeltaLonR), 2));
		
			greatDistance = 2*Math.asin(Math.min(1.0, a))*radius;
		} else 
			
			greatDistance =  0; 
		
		return greatDistance;
		
	}
	
	@SuppressWarnings("null")
	public static List<Destination> getDestinationsForArtist(String artist){
		IConnector artistList = null;
		IGps position = null;
		List<Destination> resultList = new ArrayList<Destination>();
		int i;
		
		
		Object[] arrArtistList = null;
		try {
			arrArtistList = artistList.getConcertsForArtist(artist).toArray();
		} catch (LastFmConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (i = 0; i<arrArtistList.length; i++){
			ConcertInfo currentConcertArtist = (ConcertInfo)arrArtistList[i];
			GeoPoint currentConcertPosition = currentConcertArtist.getPosition();
			if (( Double.parseDouble(currentConcertPosition.getLatitude()) < -90 &&  Double.parseDouble(currentConcertPosition.getLatitude()) > 90 ) || ( Double.parseDouble(currentConcertPosition.getLongitude()) < -180 &&  Double.parseDouble(currentConcertPosition.getLongitude()) > 180) )
				return null;
			else {
				Destination currentDestination = new Destination(currentConcertArtist);
				currentDestination.setPosition(position.getCurrentPosition());
				currentDestination.setDistanceUnits( Double.toString(computeDistance( position.getCurrentPosition(),currentConcertArtist.getPosition(),"mi")));
				resultList.add(currentDestination);
			}
		}
		return resultList;
		
	}

	@Override
	public List<Recommendation> getRecommendations() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	

}
