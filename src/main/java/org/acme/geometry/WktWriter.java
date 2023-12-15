package org.acme.geometry;

public class WktWriter {
	
	public String write(Geometry geometry) {
		String chaine;
		if ( geometry instanceof Point ){
		    Point point = (Point)geometry;
		    chaine = "POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")";
		}else if ( geometry instanceof LineString ){
		    LineString lineString = (LineString)geometry;
		    String begin = "LINESTRING(";
		    String end = ")";
		    String inter = "";
		    for (int i = 0; i< lineString.getNumPoints(); i++) {
		    	Point point = lineString.getPointN(i);
		    	double x = point.getCoordinate().getX();
		    	double y = point.getCoordinate().getY();
		    	inter += x+" "+y+",";
		    }
		    inter =inter.substring(0, inter.length() - 1);
		    chaine = begin + inter + end;
		}else{
		    throw new RuntimeException("geometry type not supported");
		}
		return chaine;
	}
}
