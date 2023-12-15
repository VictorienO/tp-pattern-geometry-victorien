package org.acme.geometry;

public class Point implements Geometry {
	private Coordinate coordinate;

	public Point() {
		this.coordinate = new Coordinate();
	}

	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	@Override
	public String getType() {
		return "Point";
	}

	@Override
	public void translate(double dx, double dy) {
		if (!this.isEmpty()) {
			double x = this.coordinate.getX() + dx;
			double y = this.coordinate.getY() + dy;
			this.coordinate = new Coordinate(x, y);
		}
	}
}
