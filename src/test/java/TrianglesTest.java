import Triangles.Triangles;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrianglesTest {

    @Test
    public void examples() {
        assertEquals('B', Triangles.triangle("B"));
        assertEquals('R', Triangles.triangle("GB"));
        assertEquals('R', Triangles.triangle("RRR"));
        assertEquals('B', Triangles.triangle("RGBG"));
        assertEquals('G', Triangles.triangle("RBRGBRB"));
        assertEquals('G', Triangles.triangle("RBRGBRBGGRRRBGBBBGG"));

    }


}
