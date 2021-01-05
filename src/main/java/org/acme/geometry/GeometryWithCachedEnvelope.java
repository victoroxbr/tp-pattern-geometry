package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {
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
			this.addListener(this);
		}
		return this.cachedEnvelope;
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.original.accept(visitor);
	}

	@Override
	public void onChange(Geometry geometry) {
		this.cachedEnvelope = geometry.getEnveloppe();
	}

	@Override
	public void addListener(GeometryListener listener) {
		this.original.addListener(listener);
	}
}
