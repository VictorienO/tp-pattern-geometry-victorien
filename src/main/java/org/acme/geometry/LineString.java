package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {

	private List<Point> points;

	public LineString() {
	}

	public LineString(List<Point> points) {
		this.points = points != null ? points : new ArrayList<>();
	}

	public int getNumPoints() {
		return points.size();
	}

	public Point getPointN(int n) {
		return points.get(n);
	}

	public boolean isEmpty() {
		return this.points.isEmpty();
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public void translate(double dx, double dy) {
		for (Point point : points) {
			point.translate(dx, dy);
		}
	}
	
	@Override
	public LineString clone() {
		List<Point> pointsCopied = new ArrayList<>();
		for(Point point : points) {
			Point tempPoint = (Point) point.clone();
			pointsCopied.add(tempPoint);
		}
		return new LineString(pointsCopied);	
	}
	
	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder eBuild = new EnveloppeBuilder();
		for(Point point : points) {
			eBuild.insert(point.getCoordinate());
		}
		return eBuild.build();
	}
	
	@Override
	public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }

	@Override
	public void accept(WktVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String asText() {
		WktVisitor wktVisitor = new WktVisitor();
		accept(wktVisitor);
		return wktVisitor.getResult();
	}
}
