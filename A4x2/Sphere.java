import java.lang.Math;
/**
 * Write a description of class sphere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Sphere implements MathematicalBody{
    final private Point center;
    final private double radius;
    
    public Sphere( Point center, double radius ){
        this.center = center;
        this.radius = radius;
    }
    
    public double getSurface() {
        return( 4*Math.PI*radius*radius );
    }
    
    public double getVolume() {
        return( 4*Math.PI*radius*radius*radius/3 );
    }
    public Point getCenter() {
            return( center );
    }
}