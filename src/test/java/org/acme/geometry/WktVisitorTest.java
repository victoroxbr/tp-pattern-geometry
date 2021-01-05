package org.acme.geometry;

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
	public void testVisitLineString() {
		WktVisitor visitor = new WktVisitor();
		LineString l = SampleFactory.createLineString();
		Geometry geometry = (Geometry) l;
		geometry.accept(visitor);
		
		Assert.assertEquals("LINESTRING(5.0 10.2,10.0 3.0)", visitor.getResult());
	}
}
