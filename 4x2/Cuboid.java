import java.lang.Math;
import java.util.Arrays;
/**
 * Write a description of class cuboid here.
 * 
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuboid implements MathematicalBody{
    final protected double[] side;
    
    public Cuboid( Point[] points) {
        double[] side = new double[3];  // side lengths
        double[] diag = new double[3];  // surface diagonal lengths
        double internDiag = 0;          // internal diagonal length
        assert points.length == 8 : "Array length not met";
        
        /* 
         * If we have a cuboid, there should be seven four-tupels of lengths.
         * The two smallest lengths belong to the short edges of the cuboid.
         * The longest legth belongs to the big diagonals trought the cuboid.
         */
        double[] length = new double[28];
        int index = 0;
        
        for ( int j = 0; j < 7 ; j++){                                                              // get all lengths
            for ( int i = j+1; i < 8; i++ ){
                length[index] = Math.sqrt(
                    Math.pow( ( points[j].coordinates[0]-points[i].coordinates[0] ), 2 ) +
                    Math.pow( ( points[j].coordinates[1]-points[i].coordinates[1] ), 2 ) +
                    Math.pow( ( points[j].coordinates[2]-points[i].coordinates[2] ), 2 ) 
                );
                index++;
            }
        }
        
        Arrays.sort(length);
        
        // for ( int i = 0; i < 28; i++ ) System.out.printf("%f\n", length[i] );                    // debugging stuff
        
        double[] side0          = new double[] { length[0], length[1], length[2], length[3] };      // get 1st four-tupel   (1st length = shortest side)
        double[] side1          = new double[] { length[4], length[5], length[6], length[7] };      // get 2nd four-tupel   (2nd length = second longest side)
        double[] temp0          = new double[] { length[8], length[9], length[10], length[11] };    // get 3rd four-tupel   (3rd length = third side or first surface diagonal)
        double[] temp1          = new double[] { length[12], length[13], length[14], length[15] };  // get 4th four-tupel   (4th length = third side or first surface diagonal)
        double[] diag1          = new double[] { length[16], length[17], length[18], length[19] };  // get 5th four-tupel   (4th length = second longest surface diagonal)
        double[] diag2          = new double[] { length[12], length[13], length[14], length[15] };  // get 6th four-tupel   (4th length = longest surface diagonal)
        double[] internDiagArr  = new double[] { length[24], length[25], length[26], length[27] };  // get 7th four-tupel   (7th length = internal diagonal)
        
        //System.out.printf("%f\n%f\n\n", side1avg, side2avg );                                     // debugging stuff
        
        // check for inconsistency
        assert rangeCheck( side0 ) : "Points don't form cuboid";
        assert rangeCheck( side1 ) : "Points don't form cuboid";
        assert rangeCheck( temp0 ) : "Points don't form cuboid";
        assert rangeCheck( temp1 ) : "Points don't form cuboid";
        assert rangeCheck( diag1 ) : "Points don't form cuboid";
        assert rangeCheck( diag2 ) : "Points don't form cuboid";
        assert rangeCheck( internDiagArr ) : "Points don't form cuboid";
        
        side[0] = computeAverage( side0 );
        side[1] = computeAverage( side1 );
        diag[1] = computeAverage( diag1 );
        diag[2] = computeAverage( diag2 );
        internDiag = computeAverage( internDiagArr );
        
        diag[0] = Math.sqrt( Math.pow( side[0], 2 ) + Math.pow( side[1], 2 ) );
        side[2] = Math.sqrt( Math.pow( diag[1], 2 ) - Math.pow( side[0], 2 ) );
        
        double temp0Avg = computeAverage( temp0 );
        double temp1Avg = computeAverage( temp1 );
        
        if( ( ! rangeCheck( new double[] { temp0Avg, diag[0] } ) ) || 
            ( ! rangeCheck( new double[] { temp1Avg, side[2] } ) ) ){
            if( ( ! rangeCheck( new double[] { temp1Avg, diag[0] } ) ) || 
                ( ! rangeCheck( new double[] { temp0Avg, side[2] } ) ) ){
                    assert false: "Points don't form cuboid";
            }
        }
        
        assert rangeCheck( new double[] { ( side[0]*side[0] + side[1]*side[1] ), diag[0]*diag[0] } ) : "Sides not orthogonal";
        assert rangeCheck( new double[] { ( side[0]*side[0] + side[2]*side[2] ), diag[1]*diag[1] } ) : "Sides not orthogonal";
        assert rangeCheck( new double[] { ( side[1]*side[1] + side[2]*side[2] ), diag[2]*diag[2] } ) : "Sides not orthogonal";
        
        this.side = side;
    }
    
    public double getSurface(){
        return( side[0]*side[1]+side[1]*side[2]+side[0]*side[2] );
    }
    
    public double getVolume(){
        return( side[0]*side[1]*side[2] );
    }
    
    public Point getCenter(){
        return( new Point( 0, 0, 0 ) );
    }
    
    
    /******** Helping Functions ********/
    private boolean rangeCheck( double[] input ){                                    // checks wether inputs are in epsilon of average
        final double average = computeAverage( input );
        final double el = epsilonLow( average );
        final double eh = epsilonHigh( average );
        
        boolean inRange = true;
        
        for (double i : input)
            inRange = inRange && ( el <= i ) && ( i <= eh);
        
        return( inRange );
    }
    
    private double computeAverage( double... input){
        double average = 0;
        for (double i : input)
          average += i;
        return( average/input.length);
    }
    
    private double epsilonLow( double input){
        return( input*(1-Math.pow( 2, -52 ) ) );
    }
    
    private double epsilonHigh( double input){
        return( input*(1+Math.pow( 2, -52 ) ) );
    }    
}
