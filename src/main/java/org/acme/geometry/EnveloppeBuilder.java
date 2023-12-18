package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnveloppeBuilder {
	public List<Double> xVals = new ArrayList<>();
	public List<Double> yVals = new ArrayList<>();
	
	public void insert(Coordinate coordinate) {
		xVals.add(coordinate.getX());
		yVals.add(coordinate.getY());
	}
	
	public Enveloppe build() {
		double xmin = Collections.min(xVals);
		double xmax = Collections.max(xVals);
		double ymin = Collections.min(yVals);
		double ymax = Collections.max(yVals);
		Coordinate bl = new Coordinate(xmin, ymin);
		Coordinate tr = new Coordinate(xmax, ymax);
		return new Enveloppe(bl, tr);
	}
}