package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeoJSONVisitorTest {
	
	@Test
	public void testVisitPoint() {
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		
		Assert.assertEquals("{'type': 'Point', 'coordinates': [3.0, 4.0]}", visitor.getResult());
	}
	
	@Test
	public void testVisitPointEmpty() {
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		Geometry geometry = new Point();
		geometry.accept(visitor);
		
		Assert.assertEquals("POINT EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitLineString() {
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		LineString l = SampleFactory.createLineString();
		l.accept(visitor);
		
		Assert.assertEquals("{'type': 'LineString', 'coordinates': [[5.0, 10.2], [10.0, 3.0]]}", visitor.getResult());
	}
	
	@Test
	public void testVisitLineStringEmpty() {
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(SampleFactory.createPointA());
		listPoint.add(new Point());
		LineString l = new LineString(listPoint);
		l.accept(visitor);
		
		Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitCollection() {
		GeometryCollection collection = SampleFactory.createCollection();
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		collection.accept(visitor);
		
		Assert.assertEquals("{'type': 'COLLECTION', 'geometry': [{'type': 'Point', 'coordinates': [5.0, 10.2]},{'type': 'LineString', 'coordinates': [[5.0, 10.2], [10.0, 3.0]]}]}", visitor.getResult());
	}
	
	@Test
	public void testVisitCollectionEmpty() {
		List<Geometry> geometries = new ArrayList<Geometry>();
		Point p = new Point();
		LineString l = SampleFactory.createLineString();
		geometries.add(p);
		geometries.add(l);
		GeometryCollection collection = new GeometryCollection(geometries);
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		collection.accept(visitor);
		
		Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", visitor.getResult());
	}
}
