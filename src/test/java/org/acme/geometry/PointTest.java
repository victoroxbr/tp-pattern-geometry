package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Point p = new Point();
		Assert.assertEquals(0,  p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(0,  p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testConstructor() {
		Coordinate c = new Coordinate(5, 10.2);
		Point p = new Point(c);
		Assert.assertEquals(5, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(10.2, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testType() {
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
	}
}
