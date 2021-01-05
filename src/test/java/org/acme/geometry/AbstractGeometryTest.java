package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {
	
	@Test
	public void testAsText() {
		AbstractGeometry geometry = new Point(new Coordinate(3.0,4.0));
		
		Assert.assertEquals("POINT(3.0 4.0)", geometry.asText());
	}
}
