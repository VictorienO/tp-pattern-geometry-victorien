package org.acme.geometry;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import org.junit.Assert;

public class GeometryVisitorTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testVisitPointFilled() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		String result;
		/*
		try {
			result = os.toString("UTF8");
			Assert.assertEquals("Je suis une LineString vide :(", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@Test
	public void testVisitLineStringFilled() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
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
		Geometry geometry = new LineString(listeTest);
		geometry.accept(visitor);
	}
	
	@Test
	public void testVisitPointEmpty() {
		Point geometry = new Point(new Coordinate());
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		String result;
		try {
			result = os.toString("UTF8");
			Assert.assertEquals("Je suis un point Vide :( ", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testVisitLineStringEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		List<Point> listeTest = new ArrayList<Point>();
		Geometry geometry = new LineString(listeTest);
		geometry.accept(visitor);
		String result;
		try {
			result = os.toString("UTF8");
			Assert.assertEquals("Je suis une LineString vide :(", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
