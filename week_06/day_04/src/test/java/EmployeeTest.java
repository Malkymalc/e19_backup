import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    Employee employee;

    @Before
    public void before(){
        this.employee = new Employee("Alan", "NI121315A", 25000.00);
    };

    @Test
    public void canGetName(){
        assertEquals("Alan", employee.getName());
    }
    @Test
    public void canGetNI(){
        assertEquals("NI121315A", employee.getNI());

    }
    @Test
    public void canGetSalary(){
        assertEquals(25000.00, employee.getSalary(), 0.01);
    }
    @Test
    public void canraiseSalary(){
        assertEquals(25000.00, employee.getSalary(), 0.01);
        employee.raiseSalary(2.0);
        assertEquals(50000.00, employee.getSalary(), 0.01);
    }
    @Test
    public void payBonus(){
        assertEquals(250.00, employee.payBonus(), 0.01);
    }
};
