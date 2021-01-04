package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestLineString {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testConstructor() {
		Coordinate c = new Coordinate(5, 10.2);
		Point p1 = new Point();
		Point p2 = new Point(c);
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(p1);
		listPoint.add(p2);		
		LineString line = new LineString(listPoint);
		
		Assert.assertEquals(p1, line.getPoints().get(0));
		Assert.assertEquals(p2, line.getPoints().get(1));
	}
	
	@Test
	public void testGetNumPoints() {
		Coordinate c = new Coordinate(5, 10.2);
		Point p1 = new Point();
		Point p2 = new Point(c);
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(p1);
		listPoint.add(p2);		
		LineString line = new LineString(listPoint);
		
		Assert.assertEquals(2, line.getNumPoints(), EPSILON);
	}
	
	@Test
	public void testGetPointN() {
		Coordinate c = new Coordinate(5, 10.2);
		Point p1 = new Point();
		Point p2 = new Point(c);
		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(p1);
		listPoint.add(p2);		
		LineString line = new LineString(listPoint);
		
		Assert.assertEquals(p2, line.getPointN(1));
	}
	
	@Test
	public void testType() {
		LineString line = new LineString();
		Assert.assertEquals("LineString", line.getType());
	}
}
