package org.acme.geometry;

public class GeometryWithCachedEnveloppe{
	
	private Geometry original;
	
	private Enveloppe CachedEnveloppe;
	
	public GeometryWithCachedEnveloppe(Geometry  original) {
		this.original = original;
	}

	public Geometry getOriginal() {
		return original;
	}

}
