package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorXY(){
		Coordinate c = new Coordinate(3.0,4.0);
		Assert.assertEquals(3.0, c.getX(), EPSILON);
		Assert.assertEquals(4.0, c.getY(), EPSILON);
		Assert.assertFalse(c.isEmpty());
		Assert.assertEquals("[3.0,4.0]", c.toString());
	}
	
	@Test
	public void testConstructorEmpty() {
		Coordinate e = new Coordinate();
		Assert.assertTrue(e.isEmpty());
		Assert.assertEquals(Double.NaN, e.getX(), EPSILON);
		Assert.assertEquals(Double.NaN,  e.getY(), EPSILON);
		Assert.assertEquals("[NaN,NaN]",e.toString());
	}

}
