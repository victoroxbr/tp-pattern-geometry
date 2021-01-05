package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Point p = new Point();
		Assert.assertEquals(Double.NaN,  p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN,  p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testConstructor() {
		Point p = SampleFactory.createPointA();
		Assert.assertEquals(5, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(10.2, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testType() {
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
	}
	
	@Test
	public void testIsEmpty() {
		Point p_empty = new Point();
		Point p = SampleFactory.createPointA();
		Assert.assertTrue(p_empty.isEmpty());
		Assert.assertFalse(p.isEmpty());
	}
	
	@Test
	public void testTranslate() {
		Point p = SampleFactory.createPointA();
		p.translate(5, 2);
		Assert.assertEquals(10, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(12.2, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testClone() {
		Point p = SampleFactory.createPointA();
		Geometry copy = p.clone();
		copy.translate(5, 5);
		
		Assert.assertEquals(5, p.getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testGetEnveloppe() {
		Point p = SampleFactory.createPointA();
		Enveloppe e = p.getEnveloppe();
		
		Assert.assertEquals(5, e.getXmin(), EPSILON);
		Assert.assertEquals(5, e.getXmax(), EPSILON);
		Assert.assertEquals(10.2, e.getYmin(), EPSILON);
		Assert.assertEquals(10.2, e.getYmax(), EPSILON);
	}
}
