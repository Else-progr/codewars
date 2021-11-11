import Columnize.Columnize;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;

public class ColumnizeTest {

    @Test
    public void shouldHandleSingleColumn() {

        String[] input = { "1", "12", "123", "1234", "12345", "123456" };
        var expected = "1     \n"
                + "12    \n"
                + "123   \n"
                + "1234  \n"
                + "12345 \n"
                + "123456";
        assertEquals(expected, Columnize.columnize(input, 1));
    }

    @Test
    public void shouldHandleMultipleColumns() {

        String[] input = { "1", "12", "123", "1234", "12345", "123456" };
        var expected = "1    | 12    | 123   \n"
                + "1234 | 12345 | 123456";
        assertEquals(expected, Columnize.columnize(input, 3));
    }

    @Test
    public void shouldHandleUnevenColumns() {

        String[] input = { "1", "12", "123", "1234", "12345", "123456" };
        var expected = "1      | 12 | 123 | 1234 | 12345\n"
                + "123456";
        assertEquals(expected, Columnize.columnize(input, 5));
    }

    @Test
    public void shouldHandleMoreColumnsThanInput() {

        String[] input = { "1", "12", "123", "1234", "12345", "123456" };
        var expected = "1 | 12 | 123 | 1234 | 12345 | 123456";
        assertEquals(expected, Columnize.columnize(input, 999));
    }

    @Test
    public void shouldHandleEmptyStrings() {

        String[] input = { "", "12", "123", "", "12345", "" };
        var expected = "      | 12\n"
                + "123   |   \n"
                + "12345 |   ";
        assertEquals(expected, Columnize.columnize(input, 2));
    }

    @Test
    public void shouldHandleEmptyColumns() {

        String[] input = { "", "", "", ""};
        var expected = " | \n"
                + " | ";
        assertEquals(expected, Columnize.columnize(input, 2));
    }

    @Test
    public void shouldHandleWhitespace() {

        String[] input = { "1          ", "12", "123", "1234", "12345", "      " };
        var expected = "1           | 12    \n"
                + "123         | 1234  \n"
                + "12345       |       ";
        assertEquals(expected, Columnize.columnize(input, 2));
    }

    @Test
    public void shouldHandleRandomInput() {

        String[] input = { "u&§(/$", " |1§()§/|2", "12?=(/%|3", "   &/(§", " !§/$/( ", "        " ,"32adsf   &/( "};
        var expected = "u&§(/$   |  |1§()§/|2    | 12?=(/%|3 |    &/(§ |  !§/$/( \n"
                + "         | 32adsf   &/( ";
        assertEquals(expected, Columnize.columnize(input, 5));
    }


}
