/**
 * Write a description of class point here.
 * 
 * @author Stephan Jänecke
 * @author Markus Blechsschmidt 
 * @version 14.11.15
 */
public class Point {
    final public double[] coordinates;
    
    public Point( double x, double y, double z ) {
        this.coordinates = new double [] { x, y, z };
    }
    
    @Override public String toString() {
        return String.format( "( %d, %d, %d )", coordinates[0], coordinates[1], coordinates[2] );
    }
}
