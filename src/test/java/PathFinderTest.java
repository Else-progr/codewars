import PathFinder.PathFinder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PathFinderTest {

// TODO: Replace examples and use TDD development by writing your own tests

    @Test
    public void sampleTests() {

        String  a = ".W.\n"+
                    ".W.\n"+
                    "...",

                b = ".W.\n"+
                    ".W.\n"+
                    "W..",

                c = "......\n"+
                    "......\n"+
                    "......\n"+
                    "......\n"+
                    "......\n"+
                    "......",

                d = "......\n"+
                    "......\n"+
                    "......\n"+
                    "......\n"+
                    ".....W\n"+
                    "....W.";

        assertEquals(true,  PathFinder.pathFinder(a));
        assertEquals(false, PathFinder.pathFinder(b));
        assertEquals(true,  PathFinder.pathFinder(c));
        assertEquals(false, PathFinder.pathFinder(d));
    }


    @Test
    public void moreTests(){

        String input =  ".W...\n"+
                        ".W...\n"+
                        ".W.W.\n"+
                        "...W.\n"+
                        "...W.";

        assertEquals(true,  PathFinder.pathFinder(input));
    }


    @Test
    public void randomTests(){

        String a =  ".\n"+
                    "..\n"+
                    "..\n"+
                    "...\n"+
                    "..W\n"+
                    "WW.\n"+
                    "....\n"+
                    "..WW\n"+
                    "...W\n"+
                    "....\n"+
                    "..W..\n"+
                    ".WW..\n"+
                    "...W.\n"+
                    "W.W..\n"+
                    "...W.\n"+
                    "......W..";

        String b =
                "........W..W.W.....W..W.....WWW.WW...\n"+
                "...W..W..W.......W.W..W...W..WW.WW.WW\n"+
                "W...WWW......W...W....W.....WWWW..W..\n"+
                "...W.W.W..WWW.W.....WW.WW..W.......WW\n"+
                "W.WWW...WW.W.W......W..W..W..W....W.W\n"+
                ".W........W...W.W........W..WWW...W..\n"+
                ".....W...WWW...WW..WW...W..W.WWW.....\n"+
                "W..W..WW.WW.W.W..W.W..........W....W.\n"+
                "W..WWW.........WWWW...W....W..WW.WW..\n"+
                "........W.WWW..W.W...WW..W........W..\n"+
                "W......W....WWW.W..W.WW......W...WW..\n"+
                ".W..WW.............W..W........W.....\n"+
                "W.W...W.WWWW.........W.W...W..WW.W...\n"+
                "...W......W..WW.......W.....W..WW...W\n"+
                "...W......W.....W....W....WW..WW.....\n"+
                "..WW.....W.........W...W..WW.........\n"+
                "W.W......WW....W...WWW.........W.W...\n"+
                "......W...WW..W.W...W...WWW.W...WW...\n"+
                "............WW.W.WWW.W..WW.WWWW.W...W\n"+
                "..W...W..W...........W...........W.W.\n"+
                "..........WWWW..WWWW..W....W..W.W..WW\n"+
                "..WW.W.W..W..W....W..WWW.WWWW...WW.W.\n"+
                "...W....WWW.W.WWW.W.W...W..WW....W.W.\n"+
                "W...W.W...W.W..W...W.WWWW..W.WW.W..W.\n"+
                "W.W.W...W.....W........W.......W.WWW.\n"+
                "..WW...WW..W......W...W.W.W...WW.WWW.\n"+
                "WW...WWWW.WWW.....W..W.........W..WWW\n"+
                "..W.........WWW...W.W.W........WWW...\n"+
                "W..W..W....WW.WW.W.........WW.W.W...W\n"+
                ".W...W.W.W.......WW..WW.....W...W....\n"+
                ".......W.W.W.WW.WW..W....WW........W.\n"+
                "W.W.WWWW.W...W.WW...WW.W.WW.W...W.W..\n"+
                "W.W.WW.....WWW..W...W.........W.WWWWW\n"+
                ".W....WW...W..W...WW..........W..WW..\n"+
                "...WW.W.WW.W.W......W....W...W....W..\n"+
                "W....WW.WWW.....W.........W.W.W.W..W.\n"+
                "....WW.........W.W.WW..W.W....W......";


                assertEquals(true,  PathFinder.pathFinder(a));
                assertEquals(true,  PathFinder.pathFinder(b));
    }
}
