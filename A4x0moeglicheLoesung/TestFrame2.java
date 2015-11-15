
/**
 * TestFrame
 * 
 * @author   Michael Schaefers 
 * @version  2015/11/10
 */
public class TestFrame2 {
    
    /**
     * ...
     */
    public void doTest(){
        K k = new K( 1, "k1" );
        L l = new L( 2, "l2" );
        M m = new M( 3, "m3" );
        M n = new M();
        System.out.printf( "%s\n",  k );
        System.out.printf( "%s\n",  new K() );
        System.out.printf( "%s\n",  l );
        System.out.printf( "%s\n",  new L() );
        System.out.printf( "%s\n",  m );
        System.out.printf( "%s\n",  n );
    }//method()
    
}//class
