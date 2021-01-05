package org.acme.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EnveloppeBuilder {
	private List<Coordinate> coordinates;

	public EnveloppeBuilder() {
		this.coordinates = new ArrayList<Coordinate>();
	}
	
	public void insert(Coordinate coordinate) {
		this.coordinates.add(coordinate);
	}
	
	public Enveloppe build() {
		List<Double> enveloppe = Arrays.asList(new Double[4]);
		enveloppe.set(0, this.coordinates.get(0).getX());
		enveloppe.set(1, this.coordinates.get(0).getY());
		enveloppe.set(2, this.coordinates.get(0).getX());
		enveloppe.set(3, this.coordinates.get(0).getY());
		for(Iterator<Coordinate> iterator = this.coordinates.iterator(); iterator.hasNext();) {
			Coordinate c = (Coordinate) iterator.next();
			enveloppe.set(0, Math.min(enveloppe.get(0), c.getX()));
			enveloppe.set(1, Math.min(enveloppe.get(1), c.getY()));
			enveloppe.set(2, Math.max(enveloppe.get(2), c.getX()));
			enveloppe.set(3, Math.max(enveloppe.get(3), c.getY()));
		}
		
		return new Enveloppe(new Coordinate(enveloppe.get(0), enveloppe.get(1)), new Coordinate(enveloppe.get(2), enveloppe.get(3)));
	}
	
	public List<Coordinate> getCoordinates() {
		return coordinates;
	}
}
