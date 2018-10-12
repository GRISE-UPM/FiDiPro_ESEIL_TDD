package app;

import static org.junit.Assert.*;

import java.util.List;

import gps.Gps;

import org.junit.Test;

import player.Player;
import commons.Recommender;
import commons.dataClasses.*;
import commons.interfaces.*;
import dataConnectors.LastFmXmlConnector;

public class SmokeTest {
	 @Test
	 public void HowToUsePlayerGpsAndRecommenderInUnitTests()
	 {
	     // Creating and initializing Player and Gps objects
	     IPlayer player = new Player(); // Player auto-registers itself with DeviceManager
	     IGps gps = new Gps();  // Gps auto-registers itself with DeviceManager
	     GeoPoint position = new GeoPoint("-14.2", "60.4"); 
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
	 }
	 
	 @Test
	 public void HowIsTheDistanceWhenGeoPointsAreNotValid(){
		 GeoPoint G1 = new GeoPoint("-100","-200");
		 GeoPoint G2 = new GeoPoint("100", "200");
		
		 double result = Recommender.computeDistance(G1, G2, "mi");
		 assertEquals( 0, result, 0);
	 }
	 
	 @Test
	 public void HowIsTheDistanceWhenUsingExampleOneValues(){
		 GeoPoint G1 = new GeoPoint("0","0");
		 GeoPoint G2 = new GeoPoint("360", "360");
		
		 double result = Recommender.computeDistance(G1, G2, "km");
		 assertEquals(0, result, 0);
	 }
	 
	 @Test
	 public void HowIsTheDistanceWhenUsingExampleTwoValues(){
		 GeoPoint G1 = new GeoPoint("0","0");
		 GeoPoint G2 = new GeoPoint("60", "0");
		
		 double result = Recommender.computeDistance(G1, G2, "km");
		 assertEquals(6671.70, result, 0);
	 }
	 
	 @Test
	 public void HowIsTheDistanceWhenUsingExampleThreeValues(){
		 GeoPoint G1 = new GeoPoint("0","0");
		 GeoPoint G2 = new GeoPoint("360", "360");
		
		 double result = Recommender.computeDistance(G1, G2, "mi");
		 assertEquals(0, result, 0);
	 }
	 
	 @Test
	 public void HowIsTheDistanceWhenUsingExampleFourValues(){
		 GeoPoint G1 = new GeoPoint("0","0");
		 GeoPoint G2 = new GeoPoint("60", "0");
		
		 double result = Recommender.computeDistance(G1, G2, "mi");
		 assertEquals(1793.55, result, 0);
	 }
	 
	 @Test
	 public void HowIsTheDistanceWhenUsingExampleFiveValues(){
		 GeoPoint G1 = new GeoPoint("36.12","-86.67");
		 GeoPoint G2 = new GeoPoint("33.94", "-118.40");
		
		 double result = Recommender.computeDistance(G1, G2, "mi");
		 assertEquals(1793.55, result, 0);
	 }
	 
	 @Test
	 public void IsConcertLocationAnInvalidPoint(){
		 		
		 List<Destination> result = Recommender.getDestinationsForArtist("cher");
		 assertEquals(null, result, 0);
	 }
	 
}

