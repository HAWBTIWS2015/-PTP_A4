
/**
 * Write a description of class cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends Cuboid{
    public Cube( Point[] points){
        super(points);
        assert ( this.side[0] == this.side[1] && this.side[1] == this.side[2] ) : "Not cube";
    }
}
