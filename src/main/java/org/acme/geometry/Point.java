package org.acme.geometry;

public class Point implements Geometry {
	
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Point";
	}

}
