package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnveloppeTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Enveloppe e = new Enveloppe();
		
		Assert.assertEquals(Double.NaN, e.getBottomLeft().getX(),EPSILON);
		Assert.assertEquals(Double.NaN, e.getTopRight().getY(),EPSILON);
	}
	
	@Test
	public void testConstructor() {
		Enveloppe e = new Enveloppe(new Coordinate(0, 1), new Coordinate(2, 3));
		
		Assert.assertEquals(0, e.getBottomLeft().getX(), EPSILON);
		Assert.assertEquals(3, e.getTopRight().getY(), EPSILON);
	}
	
	@Test
	public void testIsEmpty() {
		Enveloppe e_empty = new Enveloppe();
		Enveloppe e = SampleFactory.createEnveloppe();
		
		Assert.assertTrue(e_empty.isEmpty());
		Assert.assertFalse(e.isEmpty());
	}
}
