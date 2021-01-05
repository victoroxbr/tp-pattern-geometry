package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnveloppeBuilderTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testInsert() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		builder.insert(new Coordinate(5, 10.2));
		
		Assert.assertEquals(1, builder.getCoordinates().size(), EPSILON);
	}
	
	@Test
	public void testBuild() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		builder.insert(new Coordinate(5, 10.2));
		builder.insert(new Coordinate(10, 3));
		builder.insert(new Coordinate(2, 20));
		Enveloppe enveloppe = builder.build();
		
		Assert.assertEquals(2, enveloppe.getBottomLeft().getX(),EPSILON);
		Assert.assertEquals(3, enveloppe.getBottomLeft().getY(),EPSILON);
		Assert.assertEquals(10, enveloppe.getTopRight().getX(),EPSILON);
		Assert.assertEquals(20, enveloppe.getTopRight().getY(),EPSILON);
	}
}
