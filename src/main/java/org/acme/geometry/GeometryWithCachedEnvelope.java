package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {
	private Geometry original;
	private Enveloppe cachedEnvelope;
	
	public GeometryWithCachedEnvelope() {
		
	}
	
	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
	}

	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public Boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.original.translate(dx, dy);
	}

	@Override
	public Geometry clone() {
		return this.original.clone();
	}

	@Override
	public Enveloppe getEnveloppe() {
		if(this.cachedEnvelope == null) {
			this.cachedEnvelope = this.original.getEnveloppe();
		}
		return this.cachedEnvelope;
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.original.accept(visitor);
	}
}
