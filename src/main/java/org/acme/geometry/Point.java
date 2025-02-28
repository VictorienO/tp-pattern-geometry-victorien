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
	
	@Override
	public Point clone() {
		Coordinate coordinateCopied = new Coordinate(this.coordinate.getX(),this.coordinate.getY());
		return new Point(coordinateCopied);
	}
	
	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder eBuild = new EnveloppeBuilder();
		eBuild.insert(this.coordinate);
		Enveloppe evlPoint = new Enveloppe();
		evlPoint = eBuild.build();
		return evlPoint;
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
