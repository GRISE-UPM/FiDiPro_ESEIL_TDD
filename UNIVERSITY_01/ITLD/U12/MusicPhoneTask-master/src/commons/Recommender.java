package commons;

import java.util.ArrayList;
import java.util.List;

import player.Player;
import commons.dataClasses.ConcertInfo;
import commons.dataClasses.Destination;
import commons.dataClasses.FreqCounter;
import commons.dataClasses.GeoPoint;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IGps;
import commons.interfaces.IPlayer;
import commons.interfaces.IRecommender;
import dataConnectors.LastFmConnectionException;




public class Recommender implements IRecommender 
{
	static final double RADIUS_KM = 6371.01;
	static final double RADIUS_MI = 3958.76;
	
	static final String KM = "km";
	static final String MILES = "mi";
	
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
	public List<Recommendation> getRecommendations() throws ToBeImplementedException, LastFmConnectionException {
		List<Recommendation> recommendations = new ArrayList<Recommendation>();
		
		IPlayer player = DeviceManager.getInstance().Player;
		List<String> fans = connector.getTopFansForArtist(player.getCurrentArtist());
		FreqCounter counter = new FreqCounter();
		
		for (String fan : fans) {
			List<String> topArtists = getConnector().getTopArtistsByFan(fan);
			String topArtist;
			int fanCount;
			//FIXME Recommendation r  = new Recommendation(topArtist, fanCount);
			//recommendations.add(r);
		}
		
		return recommendations;
	}

	@Override
	public List<Destination> getDestinationsForArtists(String artist) {
		IGps gps = getGps();
		GeoPoint currentPosition = gps.getCurrentPosition();

		List<Destination> dests = new ArrayList<Destination>();
		
		try {
			List<ConcertInfo> concerts = getConnector().getConcertsForArtist(artist);
			for (ConcertInfo c : concerts) {
				Double distance = computeDistance(currentPosition, c.getPosition(), gps.getDistanceUnits());
				Destination d  = new Destination(c);
				d.setDistance(distance);
				d.setDistanceUnits(gps.getDistanceUnits());
				dests.add(d);
			}
			
		} catch (LastFmConnectionException e) {
		}
		
		
		return dests;

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

	public Double computeDistance(GeoPoint p1, GeoPoint p2, String dimension) {
		double radius = 0.0;
		if (KM.equalsIgnoreCase(dimension)) {
			radius = RADIUS_KM;
		}else if (MILES.equalsIgnoreCase(dimension)) {
			radius = RADIUS_MI;
		}else {
			return null;
		}
		
		if (p1.validLatitude() && p1.validLongitude() && 
			p2.validLatitude() && p2.validLongitude() )
		{
			double la1= p1.getLatitudeNumberRadians(),lo1=p1.getLongitudeNumberRadians();
			double la2= p2.getLatitudeNumberRadians(),lo2=p2.getLongitudeNumberRadians();
			
			double a = Math.sqrt(
					Math.pow(Math.sin((la1-la2)/2),2)+
					Math.cos(la1)*Math.cos(la2)*
					Math.pow(Math.sin((lo1-lo2)/2),2));
			return 2*Math.asin(Math.min(1.0, a))*radius;
		}
		else {
			return null;
		}

	}
}