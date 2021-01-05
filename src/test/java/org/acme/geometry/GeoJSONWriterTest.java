package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeoJSONWriterTest {

	@Test
	public void testGetName() {
		GeoJSONWriter writer = new GeoJSONWriter();
		
		Assert.assertEquals("GeoJSON", writer.getName());
	}
	
	@Test
	public void testWritePoint() {
		GeoJSONWriter writer = new GeoJSONWriter();
		Point p = SampleFactory.createPointA();
		
		Assert.assertEquals("{'type': 'Point', 'coordinates': [5.0, 10.2]}", writer.write(p));
	}
	
	@Test
	public void testWriteLineString() {
		GeoJSONWriter writer = new GeoJSONWriter();
		LineString l = SampleFactory.createLineString();
		
		Assert.assertEquals("{'type': 'LineString', 'coordinates': [[5.0, 10.2], [10.0, 3.0]]}", writer.write(l));
	}
}
