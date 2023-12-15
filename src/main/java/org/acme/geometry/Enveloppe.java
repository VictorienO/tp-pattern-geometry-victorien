package org.acme.geometry;

public class Enveloppe {

	private Coordinate bottomLeft;
	private Coordinate topRight;
	
	public Enveloppe() {
		this(new Coordinate(), new Coordinate());
	}
	
	public Enveloppe(Coordinate bottomLeft, Coordinate topRight){
		if (bottomLeft.getX() < topRight.getX() && bottomLeft.getY()<topRight.getY()){
			this.bottomLeft = bottomLeft;
			this.topRight = topRight;
		} else {
			this.bottomLeft = topRight;
			this.topRight = bottomLeft;
		}
		
	}
	
	public double getXmin() {
		return bottomLeft.getX();
	}
	
	public double getXmax() {
		return topRight.getX();
	}
	
	public double getYmin() {
		return bottomLeft.getY();
	}
	
	public double getYmax() {
		return topRight.getY();
	}
	
	public String toString() {
		return this.getXmin()+","+this.getYmin()+","+this.getXmax()+","+this.getYmax();
	}
	
	public boolean isEmpty() {
		return bottomLeft.isEmpty() || topRight.isEmpty();
	}
	
}