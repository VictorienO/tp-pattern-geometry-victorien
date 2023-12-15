package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	public static final double EPSILON = 1.0e-15;

	@Test
	public void PointConstructorXY(){
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		Assert.assertEquals(c, p.getCoordinate());
		Assert.assertEquals("Point",p.getType());
		
	}
	@Test
	public void PointConstructorEmpty() {
		Point p = new Point();
		Assert.assertTrue(p.getCoordinate().isEmpty());
		Assert.assertEquals("Point",p.getType());
	}
	
	@Test
	public void PointTranslate() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		p.translate(1.0, 1.0);
		Assert.assertEquals(p.getCoordinate().getX(), 4.0,EPSILON);
	}

}
