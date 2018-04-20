import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumberListTest {
    private NumberList myNumbers;

    @Before
    public void before(){
        ArrayList<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);
        this.myNumbers = new NumberList(testNumbers);
    }

    @Test
    public void hasNumberOfEntries(){
        assertEquals(4, myNumbers.getNumberCount());
    }

    @Test
    public void canAddNumberToList(){
        myNumbers.addNumber(5);
        assertEquals(5, myNumbers.getNumberCount());
    }

    @Test
    public void canGeFirstNumber(){
        assertEquals(1, myNumbers.getNumberAtIndex(0));
    }

    @Test
    public void canGetTotal(){
        assertEquals(10, myNumbers.getTotal());
    }

    @Test
    public void canGetRandom(){
        ArrayList<Integer> copy = myNumbers.getNumbers();
        int randomNumber = myNumbers.getRandomNumber();
        assertTrue(copy.contains(randomNumber));
    }

}
