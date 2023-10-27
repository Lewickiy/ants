import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AntTest {

    @Parameterized.Parameter
    public int n;
    @Parameterized.Parameter(1)
    public int left;
    @Parameterized.Parameter(2)
    public int right;
    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters(name = "Plank length {0}, left position {1}, right position {2}. Result - {3} rounds")
    public static Object[][] getMultiplicationData() {
        return new Object[][] {
                {3, 3, 2, 1},
                {6, 6, 1, 5},
                {6, 5, 1, 4},
                {7, 4, 1, 4},
                {5, 4, 4, -1}
        };
    }

    @Test
    public void howManyRounds() {
        Ant ant = new Ant();
        int actual = ant.calculate(n, left, right);
        assertEquals(expected, actual);
    }
}
