package it.polito.tdp.extflightdelays.model;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Tratta {
	
	private int originAirportId;
	private int destinationAirportId;
	private double media;
	
	public Tratta(int originAirportId, int destinationAirportId, double media) {
		super();
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.media=media;
	}

	public int getOriginAirportId() {
		return originAirportId;
	}

	public void setOriginAirportId(int originAirportId) {
		this.originAirportId = originAirportId;
	}

	public int getDestinationAirportId() {
		return destinationAirportId;
	}

	public void setDestinationAirportId(int destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	
	

}
