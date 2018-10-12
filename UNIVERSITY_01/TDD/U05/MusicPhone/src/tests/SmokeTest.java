package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import gps.Gps;

import org.junit.Test;

import player.Player;
import commons.Recommender;
import commons.dataClasses.*;
import commons.interfaces.*;
import dataConnectors.LastFmConnectionException;
import dataConnectors.LastFmXmlConnector;

public class SmokeTest {

	 @Test
	 public void HowToUsePlayerGpsAndRecommenderInUnitTests()
	 {
	     // Creating and initializing Player and Gps objects
		 double distance=0;
		 List listOfArtists=null;
	     IPlayer player = new Player(); // Player auto-registers itself with DeviceManager
	     IGps gps = new Gps();  // Gps auto-registers itself with DeviceManager
	     //GeoPoint position = new GeoPoint("-14.2", "60.4");//degrees 
	     GeoPoint position = new GeoPoint("36.12", "-86.67");//degrees 
	     gps.setCurrentPosition(position); 
	     gps.setDistanceUnits("KM");
	     player.setCurrentArtist("Cher");
	     player.setCurrentTitle("Moonstruck"); 
	     // Creating and initializing Recommender to access XML data for testing
	     Recommender recommender = new Recommender(new LastFmXmlConnector());

	     // Recommender knows how to access the new Player and Gps objects
	     assertNotNull(recommender.getGps());
	     assertNotNull(recommender.getPlayer());
	     assertEquals(position.getLatitude(), recommender.getGps().getCurrentPosition().getLatitude());
	     assertEquals(position.getLongitude(), recommender.getGps().getCurrentPosition().getLongitude());
	     assertEquals("Cher", recommender.getPlayer().getCurrentArtist());
	     assertEquals("KM", recommender.getGps().getDistanceUnits());
	     
	     //Creating the GeoPoint of concert in km
	     GeoPoint positionConcert = new GeoPoint("33.94", "-118.4");
	     distance=Recommender.computeDistance(position,positionConcert,"km");
	     assertEquals(1793.55, distance,1794);
	     
	     //Creating the GeoPoint of concert in mi
	     GeoPoint positionConcert2 = new GeoPoint("33.94", "-118.4");
	     distance=Recommender.computeDistance(position,positionConcert2,"MI");
	     assertEquals(1793.55, distance,1794);
	     
	     //Creating the GeoPoint of concert invalid
	     GeoPoint positionConcert3 = new GeoPoint("120.4", "200.5");
	     distance=Recommender.computeDistance(position,positionConcert3,"MI");
	     assertEquals(0, distance,0);
	     
	     try {
			listOfArtists=recommender.getConnector().getConcertsForArtist("Metallica");
		} catch (LastFmConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	 }
}

