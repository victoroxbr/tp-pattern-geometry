package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
	
	@Test
	public void testVisitPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		
		Assert.assertEquals("POINT(3.0 4.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitPointEmpty() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point();
		geometry.accept(visitor);
		
		Assert.assertEquals("POINT EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitLineString() {
		WktVisitor visitor = new WktVisitor();
		LineString l = SampleFactory.createLineString();
		l.accept(visitor);
		
		Assert.assertEquals("LINESTRING(5.0 10.2,10.0 3.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitLineStringEmpty() {
		WktVisitor visitor = new WktVisitor();
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
		WktVisitor visitor = new WktVisitor();
		collection.accept(visitor);
		
		Assert.assertEquals("GEOMETRYCOLLECTION(POINT(5.0 10.2),LINESTRING(5.0 10.2,10.0 3.0))", visitor.getResult());
	}
	
	@Test
	public void testVisitCollectionEmpty() {
		List<Geometry> geometries = new ArrayList<Geometry>();
		Point p = new Point();
		LineString l = SampleFactory.createLineString();
		geometries.add(p);
		geometries.add(l);
		GeometryCollection collection = new GeometryCollection(geometries);
		WktVisitor visitor = new WktVisitor();
		collection.accept(visitor);
		
		Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", visitor.getResult());
	}
}
