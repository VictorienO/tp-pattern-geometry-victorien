package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testLineStringFilled(){
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
		Assert.assertEquals(3, l.getNumPoints());
		int idx = 0;
		Assert.assertEquals(p, l.getPointN(idx));
		Assert.assertEquals("LineString", l.getType());
	}
	
	@Test
	public void testLineEmpty() {
		List<Point> listeTest = new ArrayList<Point>();
		LineString l = new LineString();
	}
	
	@Test
	public void testLineTranslation() {
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
		l.translate(1.0, 1.0);
		Assert.assertEquals(l.getPointN(0).getCoordinate().getX(), 4.0,EPSILON);
	}
}
