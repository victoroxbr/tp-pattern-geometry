package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
	private StringBuilder buffer;
	
	public WktVisitor() {

	}
	
	public String getResult() {
		return this.buffer.toString();
	}

	@Override
	public void visit(Point point) {
		WktWriter writer = new WktWriter();
		this.buffer = new StringBuilder(writer.write(point));
		System.out.print(this.buffer);
	}

	@Override
	public void visit(LineString lineString) {
		WktWriter writer = new WktWriter();
		this.buffer = new StringBuilder(writer.write(lineString));
		System.out.print(this.buffer);
	}
}
