package org.acme.geometry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {
	
	private List<Geometry> geometries;
	
	public GeometryCollection() {
		this.geometries = new ArrayList<Geometry>();
	}
	
	public GeometryCollection(List<Geometry> geometries) {
		this.geometries = geometries;
	}
	
	public int getNumGeometries() {
		return this.geometries.size();
	}
	
	public Geometry getGeometryN(int n) {
		return this.geometries.get(n);
	}

	@Override
	public String getType() {
		return "Collection";
	}

	@Override
	public Boolean isEmpty() {
		for(Iterator<Geometry> iterator = this.geometries.iterator(); iterator.hasNext();) {
			Geometry g = (Geometry) iterator.next();
			if(g.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void translate(double dx, double dy) {
		for(Iterator<Geometry> iterator = this.geometries.iterator(); iterator.hasNext();) {
			Geometry g = (Geometry) iterator.next();
			g.translate(dx, dy);
		}
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public List<Geometry> getGeometries() {
		return geometries;
	}

}
