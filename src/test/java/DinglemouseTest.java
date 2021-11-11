import Dinglemouse.Dinglemouse;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class DinglemouseTest {


    @Test
    public void eatRightMulti() {
        String input = "giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda";
        String[] expected = 	{
                "giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda",
                "giraffe eats leaves",
                "giraffe eats leaves",
                "giraffe eats leaves",
                "bear eats bug",
                "bear eats leaves",
                "bear eats leaves",
                "giraffe,bear,panda"};
        assertArrayEquals(expected, Dinglemouse.whoEatsWho(input));
    }

    @Test
    public void example() {
        String input = "fox,bug,chicken,grass,sheep";
        String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, Dinglemouse.whoEatsWho(input));
    }
}
