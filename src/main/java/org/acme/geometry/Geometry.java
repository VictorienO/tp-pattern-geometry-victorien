package org.acme.geometry;

public interface Geometry {
	abstract String getType();
	abstract void translate (double dx, double dy);
	abstract Geometry clone();
	abstract Enveloppe getEnveloppe();
	abstract void accept(GeometryVisitor visitor);
	abstract void accept(WktVisitor visitor);
	abstract String asText();
}
