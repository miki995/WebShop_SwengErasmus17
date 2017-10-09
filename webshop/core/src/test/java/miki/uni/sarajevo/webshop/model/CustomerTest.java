package miki.uni.sarajevo.webshop.model;


import miki.uni.sarajevo.webshop.model.helpClasses.Address;
import miki.uni.sarajevo.webshop.model.helpClasses.City;
import miki.uni.sarajevo.webshop.model.helpClasses.Gender;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static miki.uni.sarajevo.webshop.model.helpClasses.Country.BOSNIA;
import static  org.junit.Assert.*;

public class CustomerTest {

    private Customer miroslav;
    private Customer tomo;

    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static  void afterClass(){
    }

    @Before
    public void setUp() throws ParseException {
        Address sa = new Address("73000", City.SARAJEVO, BOSNIA);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                Gender.MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        this.tomo = new Customer(
                "Tomo",
                "Klacar",
                Gender.MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);
    }

    @After
    public void tearDown(){
    }


    @Test
    public void testFirstName(){
        assertEquals(miroslav.getFirstName(), "Miroslav");
    }

    @Test
    public void testLastName(){
        assertEquals(tomo.getLastName(), "Klacar");
    }

    @Test
    public void testIsCustomerMale(){
        assertTrue(miroslav.getGender() == Gender.MALE);
    }

    @Test
    public void testIsCustomerFemale(){
        assertFalse(tomo.getGender() == Gender.FEMALE);
    }

    @Test
    public void testIsSameCity() {
        assertEquals(miroslav.getCity(),City.SARAJEVO);

    }

}
