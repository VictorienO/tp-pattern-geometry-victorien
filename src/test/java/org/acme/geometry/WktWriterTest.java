package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWktPoint() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		WktWriter wkt = new WktWriter();
		String chaine = wkt.write(p);
		Assert.assertEquals("POINT(3.0 4.0)", chaine);
	}
	
	@Test
	public void testWktLineString() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		
		Coordinate b = new Coordinate(4.0,4.0);
		Point q = new Point(b);
		
		Coordinate d = new Coordinate(4.0,5.0);
		Point r = new Point(d);
		
		List<Point> listeTest = new ArrayList<Point>();
		listeTest.add(p);
		listeTest.add(q);
		listeTest.add(r);
		
		LineString l = new LineString(listeTest);
		
		WktWriter wkt = new WktWriter();
		String chaine = wkt.write(l);
		Assert.assertEquals("LINESTRING(3.0 4.0,4.0 4.0,4.0 5.0)", chaine);
	}
}
