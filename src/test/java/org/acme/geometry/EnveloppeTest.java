package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnveloppeTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorEnveloppeEmpty(){
		Enveloppe e = new Enveloppe();
	}
	
	@Test
	public void testFilledFilled() {
		Enveloppe e = new Enveloppe();
		Assert.assertTrue(e.isEmpty());
	}
	
	@Test
	public void testConstructorFilled() {
		Coordinate bl = new Coordinate(1.0,1.0);
		Coordinate tr = new Coordinate(2.0,2.0);
		Enveloppe e = new Enveloppe(bl,tr);
	}
	
	@Test
	public void testGetters(){
		Coordinate bl = new Coordinate(1.0,1.0);
		Coordinate tr = new Coordinate(2.0,2.0);
		Enveloppe e = new Enveloppe(bl,tr);
		Assert.assertEquals(1.0,e.getXmin() ,EPSILON);
		Assert.assertEquals(1.0,e.getYmin() ,EPSILON);
		Assert.assertEquals(2.0,e.getXmax() ,EPSILON);
		Assert.assertEquals(2.0,e.getYmax() ,EPSILON);
		Assert.assertEquals("1.0,1.0,2.0,2.0", e.toString());
	}
	
	@Test
	public void testFilledEmpty() {
		Coordinate bl = new Coordinate(1.0,1.0);
		Coordinate tr = new Coordinate(2.0,2.0);
		Enveloppe e = new Enveloppe(bl,tr);
		Assert.assertFalse(e.isEmpty());
	}
	
	@Test
	public void buildingEnveloppe() {
		EnveloppeBuilder eb = new EnveloppeBuilder();
		Coordinate c1 = new Coordinate(1.0,1.0);
		eb.insert(c1);
		Coordinate c2 = new Coordinate(2.0,2.0);
		eb.insert(c2);
		Coordinate c3 = new Coordinate(3.0,3.0);
		eb.insert(c3);
		Coordinate c4 = new Coordinate(4.0,4.0);
		eb.insert(c4);
		Coordinate c5 = new Coordinate(5.0,5.0);
		eb.insert(c5);
		Enveloppe eBuilt = eb.build();
		Assert.assertEquals(eBuilt.getXmin(),1.0, EPSILON);
		Assert.assertEquals(eBuilt.getXmax(),5.0, EPSILON);
		Assert.assertEquals(eBuilt.getYmin(),1.0, EPSILON);
		Assert.assertEquals(eBuilt.getYmax(),5.0, EPSILON);
	}
}
