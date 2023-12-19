package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{

	@Override
	public abstract String getType();

	@Override
	public abstract void translate(double dx, double dy);

	@Override
	public abstract Geometry clone();
	
	@Override
	public abstract Enveloppe getEnveloppe();

	@Override
	public abstract void accept(GeometryVisitor visitor);
	
	@Override
	public abstract  void accept(WktVisitor visitor);
	
	@Override
	public abstract String asText();
	
}
