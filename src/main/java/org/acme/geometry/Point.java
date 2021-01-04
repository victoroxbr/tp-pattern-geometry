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
		return "Point";
	}

	@Override
	public Boolean isEmpty() {
		if(coordinate.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
	}
	
	@Override
	public Point clone() {
		return new Point(this.coordinate);
	}

}
