package org.acme.geometry;

import java.util.Iterator;

public class GeoJSONWriter implements GeometryWriter {
	
	public GeoJSONWriter() {

	}

	@Override
	public String getName() {
		return "GeoJSON";
	}

	@Override
	public String write(Geometry geometry) {
		if(geometry instanceof Point) {
			Point p = (Point) geometry;
			String geoJSON = "{'type': 'Point', 'coordinates': [" + p.getCoordinate().getX() + ", " + p.getCoordinate().getY() + "]}";
			return geoJSON;
		} else if(geometry instanceof LineString) {
			LineString l = (LineString) geometry;
			String geoJSON = "{'type': 'LineString', 'coordinates': [";
			for(Iterator<Point> iterator = l.getPoints().iterator(); iterator.hasNext();) {
				Point p = (Point) iterator.next();
				geoJSON += "[" + p.getCoordinate().getX() + ", "+ p.getCoordinate().getY() + "], ";
			}
			geoJSON = geoJSON.substring(0, geoJSON.length() - 2);
			geoJSON += "]}";
			return geoJSON;
		} else {
			throw new RuntimeException("geometry type is not supported");
		}
	}

}
