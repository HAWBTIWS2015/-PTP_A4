
/**
 * Write a description of class TestClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestClass {
    public void doTest(){
        Cuboid cuboid = new Cuboid( new Point[] {
          new Point(0,0,0),new Point(0,0,5),new Point(0,5,0),new Point(5,0,0),
          new Point(5,5,0),new Point(0,5,5),new Point(5,0,5),new Point(5,5,5)
        }
        );
        System.out.printf("%f\n", cuboid.getVolume() );
        System.out.printf("%f\n\n", cuboid.getSurface() );
    }
}
