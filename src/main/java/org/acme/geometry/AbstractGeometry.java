package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
	
	public String asText() {
		WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
		return visitor.getResult();
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public Boolean isEmpty() {
		return null;
	}

	@Override
	public void translate(double dx, double dy) {

	}

	@Override
	public Geometry clone() {
		return null;
	}

	@Override
	public Enveloppe getEnveloppe() {
		return null;
	}

	@Override
	public void accept(GeometryVisitor visitor) {

	}

}
