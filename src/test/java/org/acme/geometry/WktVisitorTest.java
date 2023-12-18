package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WktVisitorTest {
	
	@Test
	public void testVisitorWktPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		assertEquals("POINT(3.0 4.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitorWktLineString() {
		WktVisitor visitor = new WktVisitor();
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		
		Coordinate d = new Coordinate(3.0,5.0);
		Point q = new Point(d);
		
		Coordinate e = new Coordinate(3.0,6.0);
		Point r = new Point(e);
		
		List<Point> listeTest  = new ArrayList<Point>();
		listeTest.add(p);
		listeTest.add(q);
		listeTest.add(r);
		
		Geometry geometry = new LineString(listeTest);
		geometry.accept(visitor);
		assertEquals("LINESTRING(3.0 4.0,3.0 5.0,3.0 6.0)", visitor.getResult());
	}
}
