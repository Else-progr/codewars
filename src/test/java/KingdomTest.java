import Kingdom.Kingdom;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingdomTest{
    
    @Test
    public void sample() {
        assertEquals("hello world!", Kingdom.translate("***lo w***d!", new String[]{"hello", "world"}));
        System.out.println("Test 1 beendet!");
        assertEquals("cell, weak!", Kingdom.translate("c**l, w*ak!", new String[]{"hell", "cell", "week", "weak"}));
        System.out.println("Test 2 beendet!");
        assertEquals("hello, world!", Kingdom.translate("hell*, w***d!", new String[]{"hello", "hell", "word", "world"}));
        System.out.println("Test 3 beendet!");
        assertEquals("mel", Kingdom.translate("***", new String[]{"mel", "dell"}));
        System.out.println("Test 4 beendet!");
        assertEquals("", Kingdom.translate("", new String[]{"hell", "weak"}));
        System.out.println("Test 5 beendet!");
        assertEquals("bbbb. aaa,", Kingdom.translate("****. ***,", new String[]{"aaa", "bbbb"}));
        System.out.println("Test 6 beendet!");
    }

    @Test
    public void newEdge() {
        String result = "qow qqqovq qpqq ooqqu oqqqy ptqqq. sqopq. qropoo, qpx";
        String sp = "*ow ****v* **** ****u oq**y *t***. s*opq. qro***, q*x";
        String[] voc = new String[]{"ooqqu","ptqqq","qqqovq","qpqq","qpx","oqqqy","qropoo","sqopq","qow"};
        assertEquals(result, Kingdom.translate(sp, voc));
    }


}
