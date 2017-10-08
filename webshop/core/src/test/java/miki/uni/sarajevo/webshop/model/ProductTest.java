package miki.uni.sarajevo.webshop.model;


import miki.uni.sarajevo.webshop.model.helpClasses.Availability;
import org.junit.*;

import java.text.ParseException;

import static miki.uni.sarajevo.webshop.model.helpClasses.Availability.YES;
import static org.junit.Assert.*;

public class ProductTest {

    private Product book;
    private Product laptop;
    private Product nuke;
    private Product iphone;


    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static  void afterClass(){
    }

    @Before
    public void setUp() throws ParseException {

        this.book = new Product(
                "Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                150,
                YES);
        this.laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                2999,
                YES);
        this.iphone = new Product(
                "Apple Iphone X",
                "Best phone ever.",
                2999,
                YES);

        this.nuke = new Product(
                "Nuclear Bomb",
                "Manufactured in North Corea by Kim Dzong Un.",
                999999,
                Availability.NO);

    }

    @After
    public void tearDown(){
    }


    @Test
    public void testPrice(){
        assertNotEquals(laptop.getPrice(),nuke.getPrice());
    }

    @Test
    public void testName(){
        assertEquals(iphone.getName(),"Apple Iphone X");

    }

    @Test
    public void testIsBookAvailable(){

        assertTrue(book.isAvailable() == YES);
    }

    @Test
    public void testNukeNotAvailable(){

        assertFalse(nuke.isAvailable() == YES);
    }

    @Test
    public void testNotSame() {
        assertNotSame(laptop,nuke);

    }

}
