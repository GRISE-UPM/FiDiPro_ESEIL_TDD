package commons;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Track;

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

	@Override
	public List<Recommendation> getRecommendations() throws ToBeImplementedException {
		try {
			
			List<String> artistas= connector.getTopFansForArtist();
			for (int i=0;i<artistas.size();i++)
			  connector.getTopArtistsByFan(artistas.get(i));
			
			
			
			
		} catch (LastFmConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Destination> getDestinationsForArtists(String artist) {
		try {
			
			 double distancia=0; 
			 GeoPoint current= getGps().getCurrentPosition();
			 List<ConcertInfo> destinos=connector.getConcertsForArtist(artist);
			 List<Destination> destinationArtist = new ArrayList<>();
			 
			 for (int i = 0; i < destinos.size(); i++) {
				 
				Destination obj=new Destination(destinos.get(i));					
				destinationArtist.add(obj);
			}
			  return destinationArtist;   
	} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Destination> buildItineraryForArtists(List<String> artists) throws ToBeImplementedException  {
		try {
				
			
			
			
			
			
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
	
	public static double computeDistance(GeoPoint gp1,GeoPoint gp2, String mesure){
		double gp1Latitude=Double.parseDouble(gp1.getLatitude())*Math.PI/180;
		double gp2Latitude=Double.parseDouble(gp2.getLatitude());
		double gp1Long=Double.parseDouble(gp1.getLongitude())*Math.PI/180;
		double gp2Long=Double.parseDouble(gp2.getLongitude());
		double a;
		double radius,gdistance=0;
		
		if(mesure.equals("km"))
			radius=6371.01;
		else
			radius=3958.76;
		
		if(gp1Latitude>=-90 && gp1Latitude<=90 && gp2Latitude>=-90 && gp2Latitude<=90 &&
				gp1Long>-180 && gp1Long<=180 && gp1Long>-180 && gp1Long<=180){
				
			double sin=Math.sin((gp2Latitude-gp1Latitude)/2);
			sin*=2;
			double sinLongR=Math.sin((gp2Long-gp1Long)/2);
			sinLongR*=2;
		    a=Math.sqrt(sin +Math.cos(gp1Latitude) * Math.cos(gp2Latitude)* sinLongR);			
			gdistance=2*Math.asin(Math.min(1,a))*radius;	
		
		}
		return gdistance;
		
	}

}
