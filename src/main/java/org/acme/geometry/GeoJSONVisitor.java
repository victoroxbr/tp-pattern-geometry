package org.acme.geometry;

import java.util.Iterator;

public class GeoJSONVisitor implements GeometryVisitor {
	private StringBuilder buffer;
	
	public GeoJSONVisitor() {
		this.buffer = new StringBuilder();
	}
	
	public String getResult() {
		return this.buffer.toString();
	}

	@Override
	public void visit(Point point) {
		GeoJSONWriter writer = new GeoJSONWriter();
		if(point.isEmpty()) {
			this.buffer = new StringBuilder("POINT EMPTY");
		} else {
			this.buffer = new StringBuilder(writer.write(point));
		}
	}

	@Override
	public void visit(LineString lineString) {
		GeoJSONWriter writer = new GeoJSONWriter();
		if(lineString.isEmpty()) {
			this.buffer = new StringBuilder("LINESTRING EMPTY");
		} else {
			this.buffer = new StringBuilder(writer.write(lineString));
		}
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
		GeoJSONWriter writer = new GeoJSONWriter();
		if(geometryCollection.isEmpty()) {
			this.buffer = new StringBuilder("GEOMETRYCOLLECTION EMPTY");
		} else {
			this.buffer.append("{'type': 'COLLECTION', 'geometry': [");
			for(Iterator<Geometry> iterator = geometryCollection.getGeometries().iterator(); iterator.hasNext();) {
				Geometry g = (Geometry) iterator.next();
				this.buffer.append(writer.write(g) + ",");
			}
			this.buffer = this.buffer.deleteCharAt(this.buffer.length() - 1);
			this.buffer.append("]}");
		}
	}

}
