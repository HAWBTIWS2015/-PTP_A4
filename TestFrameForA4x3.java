
/**
 * A4x3: Palindrom - see task
 * 
 * @author   Michael Schäfers ; P1@Hamburg-UAS.eu 
 * @version  2015/11/09
 */
public class TestFrameForA4x3 {
    
    /**
     * Die Methode dotest() testet die Loesung zu A3x4.
     * Diese Methode darf nicht geaendert werden.
     * 
     * @param text  der zu ueberearPositionrüfende Text.
     */
    public void doTest( final String text ){
        final String givenText = "Werner sagte: \"Es stellen sich neben dem Reliefpfeiler auf: Otto neben Otto und Ede neben Ede.\"";
        PalindromFinder pf = new PalindromFinder( givenText );
        System.out.printf( "Der folgende Text\n" );
        System.out.printf( "    %s\n",  pf.getText() );
        System.out.printf( "    ____________________~~~~______~~~~~~~___~~~~~~~~~~~~~~~____^^^^^^^^^^^^^^^^^___~~~~~~~~~~~~~~_\n" );
        System.out.printf( "liefert:\n" );
        printTestResult( pf.getLongestPalindrom() );
        System.out.printf( "\n\n" );
        
        pf.setText( text );
        System.out.printf( "Der folgene Text\n" );
        if( null != text ){
            System.out.printf( "    %s\n",  pf.getText() );
        }else{
            System.out.printf( "    null\n" );
        }//if
        System.out.printf( "liefert:\n" );
        printTestResult( pf.getLongestPalindrom() );
    }//method()
    
    
    private void printTestResult( final String testResult ){
        if( null != testResult ){
            System.out.printf( "\"%s\" -> length=%d\n",  testResult, testResult.length() );
        }else{
            System.out.printf( "null\n" );
        }//if
    }//method()
    
}//class
