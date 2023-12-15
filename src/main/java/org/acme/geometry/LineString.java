package org.acme.geometry;

import java.util.List;

public class LineString implements Geometry{
	
	private List<Point> points;
	
	public LineString() {
		
	}
	
	public LineString(List<Point> points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return points.size();
	}
	
	public Point getPointN(int n) {
		Point ptIndexed = points.get(n);
		return ptIndexed;
	}

	@Override
	public String getType() {
		return "LineString";
	}
}
