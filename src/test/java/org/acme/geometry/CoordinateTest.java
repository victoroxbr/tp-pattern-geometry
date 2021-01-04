package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
	}
	
	@Test
	public void testConstructor() {
		Coordinate c = new Coordinate(5, 10.2);
		Assert.assertEquals(5, c.getX(), EPSILON);
		Assert.assertEquals(10.2, c.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty() {
		Coordinate c_empty = new Coordinate();
		Coordinate c = new Coordinate(5, 10.2);
		Assert.assertTrue(c_empty.isEmpty());
		Assert.assertFalse(c.isEmpty());
	}
}
