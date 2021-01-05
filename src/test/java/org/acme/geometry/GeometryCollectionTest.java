package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryCollectionTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		GeometryCollection collection = new GeometryCollection();
		
		Assert.assertEquals(0, collection.getGeometries().size(), EPSILON);
	}
	
	@Test
	public void testGetNumGeometries() {
		GeometryCollection collection = SampleFactory.createCollection();
		
		Assert.assertEquals(2, collection.getNumGeometries(), EPSILON);
	}

	@Test
	public void testGetGeometryN() {
		GeometryCollection collection = SampleFactory.createCollection();
		
		Assert.assertTrue(collection.getGeometryN(0) instanceof Point);
	}
	
	@Test
	public void testGetType() {
		GeometryCollection collection = SampleFactory.createCollection();
		
		Assert.assertEquals("Collection", collection.getType());
	}
	
	@Test
	public void testIsEmpty() {
		GeometryCollection collection = SampleFactory.createCollection();
		
		List<Geometry> geometries = new ArrayList<Geometry>();
		Point p = new Point();
		LineString l = SampleFactory.createLineString();
		geometries.add(p);
		geometries.add(l);
		GeometryCollection collection_empty = new GeometryCollection(geometries);
		
		Assert.assertTrue(collection_empty.isEmpty());
		Assert.assertFalse(collection.isEmpty());
	}
	
	@Test
	public void testTranslate() {
		GeometryCollection collection = SampleFactory.createCollection();
		collection.translate(1, 2);
		Point p = (Point) collection.getGeometries().get(0);
		Assert.assertEquals(6, p.getCoordinate().getX(),EPSILON);
	}
}
