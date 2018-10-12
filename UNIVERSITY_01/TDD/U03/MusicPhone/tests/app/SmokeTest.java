package app;

import static org.junit.Assert.*;
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
	 public void ComputeDistanceKm()
	 {
	     GeoPoint position1 = new GeoPoint("0", "0"); 
	     GeoPoint position2 = new GeoPoint("360", "360");
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     Object result = recommender.computeDistance(position1, position2, "mi");
	     double ans = (double)result;
	     assertEquals(0,ans,0.01);
	 }
	
	@Test
	 public void ComputeDistanceKm1()
	 {
	     GeoPoint position1 = new GeoPoint("0", "0"); 
	     GeoPoint position2 = new GeoPoint("60", "0");
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     Object result = recommender.computeDistance(position1, position2, "mi");
	     double ans = (double)result;
	     assertEquals(6671.70,ans,0.01);
	 }
	
	@Test
	 public void ComputeDistanceMi()
	 {
	     GeoPoint position1 = new GeoPoint("36.12", "-86.67"); 
	     GeoPoint position2 = new GeoPoint("33.94", "-118.40");
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     Object result = recommender.computeDistance(position1, position2, "mi");
	     double ans = (double)result;
	     assertEquals(1793.55,ans,0.01);
	 }
	
	@Test
	 public void UnvalidLongitude()
	 {
	     GeoPoint position1 = new GeoPoint("36.12", "-86.67"); 
	     GeoPoint position2 = new GeoPoint("33.94", "200");
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     Object result = recommender.computeDistance(position1, position2, "mi");
	     assertEquals(null,result);
	 }
	
	@Test
	 public void UnvalidLatitude()
	 {
	     GeoPoint position1 = new GeoPoint("36.12", "-86.67"); 
	     GeoPoint position2 = new GeoPoint("33.94", "200");
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     Object result = recommender.computeDistance(position1, position2, "mi");
	     assertEquals(null,result);
	 }
	
	@Test
	 public void DegreesToRadians()
	 {
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     assertEquals(0,recommender.degreesToRadians("0"),0.01);
	 }
	
	@Test
	 public void DegreesToRadians1()
	 {
	     Recommender recommender = new Recommender(new LastFmXmlConnector());
	     assertEquals(0.592,recommender.degreesToRadians("33.94"),0.01);
	 }
}

