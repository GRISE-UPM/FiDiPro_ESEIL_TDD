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
	 public  void testValidGeoPoints() {
		 GeoPoint geoPoint= new GeoPoint("-1000", "100");
		 assertTrue(geoPoint.validLongitude());
		 assertFalse(geoPoint.validLatitude());
		 
	}

	 @Test
	 public void testComputeDistanceWithEmptyValues() throws Exception {
		 Recommender recommender = new Recommender(new LastFmXmlConnector());
		 GeoPoint p1 = new GeoPoint("",null);
		 GeoPoint p2 = new GeoPoint("", "");
		 assertNull(recommender.computeDistance(p1, p2, "km"));
	 }
	 
	 @Test
	 public void testComputeDistanceValidInput() throws Exception {
		 Recommender recommender = new Recommender(new LastFmXmlConnector());
		 GeoPoint p1 = new GeoPoint("36.12", "-86.67");
		 GeoPoint p2 = new GeoPoint("33.94", "-118.40");
		 assertEquals(1793.55 ,recommender.computeDistance(p1, p2, "mi"), 0.01);
	 }
	 
	 @Test
	 public void testGetDestinationsForArtistsWithoutConcerts() throws Exception {
		  // Creating and initializing Player and Gps objects
	     IPlayer player = new Player(); // Player auto-registers itself with DeviceManager
	     IGps gps = new Gps();  // Gps auto-registers itself with DeviceManager
	     GeoPoint p1 = new GeoPoint("36.12", "-86.67"); 
	     gps.setCurrentPosition(p1); 
	     gps.setDistanceUnits("KM");
	     player.setCurrentArtist("Cher");
	     player.setCurrentTitle("Moonstruck");
	     
	     // Creating and initializing Recommender to access XML data for testing
		 Recommender recommender = new Recommender(new LastFmXmlConnector());
		 assertEquals(0, recommender.getDestinationsForArtists(player.getCurrentArtist()).size());
	 }
	 
	 @Test
	 public void testGetDestinationsForArtistsWithConcerts() throws Exception {
		  // Creating and initializing Player and Gps objects
	     IPlayer player = new Player(); // Player auto-registers itself with DeviceManager
	     IGps gps = new Gps();  // Gps auto-registers itself with DeviceManager
	     GeoPoint p1 = new GeoPoint("36.12", "-86.67"); 
	     gps.setCurrentPosition(p1); 
	     gps.setDistanceUnits("KM");
	     player.setCurrentArtist("Coldplay");
	     player.setCurrentTitle("Anything");
	     
	     // Creating and initializing Recommender to access XML data for testing
		 Recommender recommender = new Recommender(new LastFmXmlConnector());
		 assertNotEquals(109, recommender.getDestinationsForArtists(player.getCurrentArtist()).size());
	 }
	 
	 @Test
	 public void testCounter() throws Exception {
		 FreqCounter c = new FreqCounter();
		 String item = "artist1";
		 c.add(item);
		 c.add(item);
		 assertEquals(2, c.getCount(item));
	 }
	 
	 @Test
	 public void testCounterNoEntries() throws Exception {
		 FreqCounter c = new FreqCounter();
		 String item = "artist1";
		 assertEquals(0, c.getCount(item));
	 }
	 
	 @Test
	public void testCounterSorting() throws Exception {
		 FreqCounter c = new FreqCounter();
		 String item = "artist1";
		 String item2 = "artist2";
		 c.add(item);
		 c.add(item);
		 c.add(item2);
		 
		 System.out.println(c.getSortedData());
		 fail();
		 //assertEquals(2, .)		
	}
}

