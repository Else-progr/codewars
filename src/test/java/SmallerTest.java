import Smaller.Smaller;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.junit.runners.JUnit4;

public class SmallerTest {

        @Test
        public void initialTests() {
            assertArrayEquals(new int[] {4, 3, 2, 1,0}, Smaller.smaller(new int[] {5,4,3,2,1}));
            assertArrayEquals(new int[] {0,0,0}, Smaller.smaller(new int[] {1,2,3}));
            assertArrayEquals(new int[] {1,1,0}, Smaller.smaller(new int[] {1,2,0}));
            assertArrayEquals(new int[] {0,1,0}, Smaller.smaller(new int[] {1,2,1}));
            assertArrayEquals(new int[] {3,3,0,0,0}, Smaller.smaller(new int[] {1,1,-1,0,0}));
            assertArrayEquals(new int[] {4, 1, 5, 5, 0, 0, 0, 0, 0}, Smaller.smaller(new int[] {5, 4, 7, 9, 2, 4, 4, 5, 6}));

            assertArrayEquals(new int[] {7, 58, 30, 33, 23, 79, 63, 51, 42, 77, 8, 23, 47, 23, 28, 39, 67, 59, 64, 24, 29, 10, 7,
                            13, 55, 15, 44, 16, 7, 14, 11, 31, 24, 2, 29, 36, 9, 11, 14, 47, 12, 28, 28, 15, 22, 31,
                            34, 28, 18,

                            34, 27, 16, 26, 31, 21, 0, 29, 1, 18, 13, 16, 24, 13, 9, 0, 13,
                            8, 10, 5, 14,17, 6, 5, 9, 0, 4, 0, 0, 2, 2, 5, 2, 0, 4, 4, 1, 1, 0, 0},
                    Smaller.smaller(new int[] {15, 123, 65, 73, 53, 193, 138, 121, 103, 195, 20, 56, 120, 60, 72, 105,
                            183, 159, 181, 64, 81, 25, 18, 37, 165, 45, 127, 51, 20, 49, 32, 110, 92,
                            5, 110, 131, 31, 52, 68, 193, 60, 122, 123, 77, 106, 142, 162, 133, 92,

                            178, 134, 90, 134, 181, 114, 0, 187, 9, 107, 81, 104, 176, 91, 53, 0, 121,
                            64, 94, 28, 153, 199, 40, 38, 125, 10, 70, 11, 12, 76, 95, 156, 121, 21,
                            192, 199, 125, 143, 27, 175}));

        }



}
