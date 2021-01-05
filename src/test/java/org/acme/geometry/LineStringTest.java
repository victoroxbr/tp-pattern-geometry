package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		LineString line = new LineString();
		
		Assert.assertEquals(0, line.getPoints().size(), EPSILON);
	}
	
	@Test
	public void testConstructor() {	
		LineString line = SampleFactory.createLineString();
		
		Assert.assertEquals(5, line.getPoints().get(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(3, line.getPoints().get(1).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testConstructorNullList() {
		Boolean thrown = false;
		try {
			LineString l = new LineString(null);
		} catch(AssertionError e) {
			thrown = true;
		}
		
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void testConstructorUnderTwoElements() {
		Boolean thrown = false;
		Point p1 = SampleFactory.createPointA();
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(p1);
		try {
			LineString l = new LineString(listPoint);
		} catch(AssertionError e) {
			thrown = true;
		}
		
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void testGetNumPoints() {
		LineString line = SampleFactory.createLineString();
		
		Assert.assertEquals(2, line.getNumPoints(), EPSILON);
	}
	
	@Test
	public void testGetPointN() {
		LineString line = SampleFactory.createLineString();
		
		Assert.assertEquals(10, line.getPointN(1).getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testType() {
		LineString line = new LineString();
		Assert.assertEquals("LineString", line.getType());
	}
	
	@Test
	public void testIsEmpty() {
		Point p1 = new Point();
		Point p2 = SampleFactory.createPointA();
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(p1);
		listPoint.add(p2);
		LineString line_empty = new LineString(listPoint);
		LineString line = SampleFactory.createLineString();;
		
		Assert.assertTrue(line_empty.isEmpty());
		Assert.assertFalse(line.isEmpty());
	}
	
	@Test
	public void testTranslate() {
		LineString line = SampleFactory.createLineString();	
		line.translate(5, 5);
		
		Assert.assertEquals(10, line.getPoints().get(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(15, line.getPoints().get(1).getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testClone() {
		LineString line = SampleFactory.createLineString();
		Geometry copy = line.clone();
		copy.translate(1, 1);
		
		Assert.assertEquals(5, line.getPoints().get(0).getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testGetEnveloppe() {
		LineString line = SampleFactory.createLineString();
		Enveloppe e = line.getEnveloppe();
		
		Assert.assertEquals(5, e.getXmin(), EPSILON);
		Assert.assertEquals(10, e.getXmax(), EPSILON);
		Assert.assertEquals(3, e.getYmin(), EPSILON);
		Assert.assertEquals(10.2, e.getYmax(), EPSILON);
	}
}
