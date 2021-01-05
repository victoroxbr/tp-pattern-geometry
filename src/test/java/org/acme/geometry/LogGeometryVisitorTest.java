package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {
	@Test
	public void testVisitPoint() throws UnsupportedEncodingException {
		LogGeometryVisitor visitor = new LogGeometryVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		PrintStream old = System.out;
		System.setOut(out);
		geometry.accept(visitor);
		System.out.flush();
		System.setOut(old);
		
		Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0", os.toString());
	}
	
	@Test
	public void testVisitLineString() throws UnsupportedEncodingException {
		LogGeometryVisitor visitor = new LogGeometryVisitor();
		LineString l = SampleFactory.createLineString();
		Geometry geometry = (Geometry) l;
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		PrintStream old = System.out;
		System.setOut(out);
		geometry.accept(visitor);
		System.out.flush();
		System.setOut(old);
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s)", os.toString());
	}
}
