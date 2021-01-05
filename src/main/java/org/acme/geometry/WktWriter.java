package org.acme.geometry;

import java.util.Iterator;

public class WktWriter {
	public WktWriter() {

	}
	
	public String write(Geometry geometry) {
		if(geometry instanceof Point) {
			Point p = (Point) geometry;
			String wkt = "POINT(" + p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ")";
			return wkt;
		} else if(geometry instanceof LineString) {
			LineString l = (LineString) geometry;
			String wkt = "LINESTRING(";
			for(Iterator<Point> iterator = l.getPoints().iterator(); iterator.hasNext();) {
				Point p = (Point) iterator.next();
				wkt += p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ",";
			}
			wkt = wkt.substring(0, wkt.length() - 1);
			wkt += ")";
			return wkt;
		} else {
			throw new RuntimeException("geometry type is not supported");
		}
	}
}
