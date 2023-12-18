package org.acme.geometry;

public class WktVisitor {
	
	private StringBuilder buffer;
	
	public WktVisitor() {
		this.buffer =new StringBuilder();
	}

	public String getResult() {
		return(buffer.toString());
	}
	
	public void visit(Point point) {
		WktWriter wkt = new WktWriter();
		String chaine = wkt.write(point);
		buffer.append(chaine);
	}
	
	public void visit(LineString linestring) {
		WktWriter wkt = new WktWriter();
		String chaine = wkt.write(linestring);
		buffer.append(chaine);
	}
}
