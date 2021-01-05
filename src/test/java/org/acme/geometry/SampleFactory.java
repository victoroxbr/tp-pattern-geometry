package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class SampleFactory {
	public static Point createPointA() {
		return new Point(new Coordinate(5, 10.2));
	}
	
	public static Point createPointB() {
		return new Point(new Coordinate(10, 3));
	}
	
	public static LineString createLineString() {
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(createPointA());
		listPoint.add(createPointB());
		return new LineString(listPoint);
	}
	
	public static Enveloppe createEnveloppe() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		builder.insert(new Coordinate(5, 10.2));
		builder.insert(new Coordinate(10, 3));
		builder.insert(new Coordinate(2, 20));
		return builder.build();
	}
}
