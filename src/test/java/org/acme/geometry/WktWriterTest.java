package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {
	
	@Test
	public void testGetName() {
		WktWriter writer = new WktWriter();
		
		Assert.assertEquals("WKT", writer.getName());
	}
	
	@Test
	public void testWritePoint() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		WktWriter writer = new WktWriter();
		
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
	@Test
	public void testWriteLineString() {
		LineString l = SampleFactory.createLineString();
		Geometry g = (Geometry) l;
		WktWriter writer = new WktWriter();
		
		Assert.assertEquals("LINESTRING(5.0 10.2,10.0 3.0)", writer.write(l));
	}
}
