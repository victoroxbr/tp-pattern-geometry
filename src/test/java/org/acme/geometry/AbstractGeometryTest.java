package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testAsText() {
		AbstractGeometry geometry = new Point(new Coordinate(3.0,4.0));
		
		Assert.assertEquals("POINT(3.0 4.0)", geometry.asText());
	}
}
