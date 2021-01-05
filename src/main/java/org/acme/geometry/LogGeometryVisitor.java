package org.acme.geometry;

public class LogGeometryVisitor implements GeometryVisitor {
	
	public LogGeometryVisitor() {

	}

	@Override
	public void visit(Point point) {
		System.out.print("Je suis un point avec x=" + point.getCoordinate().getX() + " et y=" + point.getCoordinate().getY());
	}

	@Override
	public void visit(LineString lineString) {
		System.out.print("Je suis une polyligne définie par " + lineString.getNumPoints() + " point(s)");
	}
	
	@Override
	public void visit(GeometryCollection geometryCollection) {
		System.out.print("Je suis une géométrie collection définie par " + geometryCollection.getNumGeometries() + " géométrie(s)");
	}
}
