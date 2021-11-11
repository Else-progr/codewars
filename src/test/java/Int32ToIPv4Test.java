import int32ToIPv4.Int32ToIPv4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Int32ToIPv4Test {

    @Test
    public void simpleTest(){
        assertEquals("128.114.17.104", Int32ToIPv4.longToIP(2154959208L));
        assertEquals("0.0.0.0", Int32ToIPv4.longToIP(0));
        assertEquals("128.32.10.1", Int32ToIPv4.longToIP(2149583361L));
    }

}
