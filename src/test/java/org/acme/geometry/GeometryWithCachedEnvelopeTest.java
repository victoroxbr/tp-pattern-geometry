package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
	
	@Test
	public void testCachedEnvelope() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		g = new GeometryWithCachedEnvelope(g);
		Enveloppe a = g.getEnveloppe();
		Enveloppe b = g.getEnveloppe();
		Assert.assertSame(a,b);
	}
}
