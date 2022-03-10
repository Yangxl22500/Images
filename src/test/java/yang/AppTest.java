package yang;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String alt = "data-src/\\";
        System.out.println(alt);
        alt.replaceAll( ",/,","");
        System.out.println(alt);
        alt.replace("\\","");
        System.out.println(alt);
        alt.replace("/","");
        System.out.println(alt);
    }
}
