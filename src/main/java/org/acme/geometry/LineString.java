package org.acme.geometry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> points;
	
	public LineString() {
		this.points = new ArrayList<Point>();
	}
	
	public LineString(List<Point> points) {
		assert(points != null);
		assert(points.size() > 1);
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}
	
	public List<Point> getPoints() {
		return points;
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public Boolean isEmpty() {
		for (Iterator<Point> iterator = this.points.iterator(); iterator.hasNext();) {
			Point point = (Point) iterator.next();
			if(point.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void translate(double dx, double dy) {
		for (Iterator<Point> iterator = this.points.iterator(); iterator.hasNext();) {
			Point point = (Point) iterator.next();
			point.translate(dx, dy);
		}
	}
	
	@Override
	public LineString clone() {
		List<Point> points_clone = new ArrayList<Point>();
		for (Iterator<Point> iterator = this.points.iterator(); iterator.hasNext();) {
			Point point = (Point) iterator.next();
			points_clone.add(point.clone());
		}
		return new LineString(points_clone);
	}

	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		for(Iterator<Point> iterator = this.points.iterator(); iterator.hasNext();) {
			Point p = (Point) iterator.next();
			builder.insert(p.getCoordinate());
		}
		return builder.build();
	}

}
