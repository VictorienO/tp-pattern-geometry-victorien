package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{

	ByteArrayOutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}
	
    public void visit( Point point ){
        String resultat;
        if (point.isEmpty()){
        	resultat = "Je suis un point Vide :( ";
        } else {
        	resultat = "Je suis un point avec x="+point.getCoordinate().getX()+" et y="+point.getCoordinate().getY();
        }
        out.print(resultat);
    }

    public void visit( LineString lineString ) {
        String resultat;
        if (lineString.isEmpty()) {
        	resultat = "Je suis une LineString vide :(";
        } else {
        	resultat = "Je suis une LineString défnie par " + lineString.getNumPoints() + "points";
        }
        out.print(resultat);
    }
}