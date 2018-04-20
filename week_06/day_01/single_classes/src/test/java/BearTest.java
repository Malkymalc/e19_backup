import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BearTest {

    private Bear bear;
    private Bear bear2;

    @Before
    public void before(){
        this.bear = new Bear("Baloo", 25, 95.62);
        this.bear2 = new Bear("bobo", 35, 79.00);
    }

    @Test
    public void hasName(){
        String name = this.bear.getName();
        assertEquals("Baloo", name);
    }

    @Test
    public void hasAge(){
        int age = this.bear.getAge();
        assertEquals(25, age);
    }

    @Test
    public void hasWeight(){
        double weight = this.bear.getWeight();
        assertEquals(95.62, weight, 0.01);
    }

    @Test
    public void ReadyToHibernateIfGreaterThanEighty(){
        boolean isReady = bear.readyToHibernate();
        assertEquals(true, isReady);
    }

    @Test
    public void notReadyToHibernateIfLessThanEighty(){
        boolean isReady = bear2.readyToHibernate();
        assertEquals(false, isReady);
    }

}
