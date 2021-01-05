package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {
	
	private List<GeometryListener> listeners = new ArrayList<GeometryListener>();
	
	public String asText() {
		WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
		return visitor.getResult();
	}
	
	protected void triggerChange() {
		for(int i = 0; i < this.listeners.size(); i++) {
			this.listeners.get(i).onChange(this);
		}
	}
	
	@Override
	public Geometry clone() {
		return this.clone();
	}

	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder visitor = new EnveloppeBuilder();
		this.accept(visitor);
		return visitor.build();
	}
	
	@Override
	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}

}
