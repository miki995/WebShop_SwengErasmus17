package miki.uni.sarajevo.webshop.model;


import miki.uni.sarajevo.webshop.model.helpClasses.Address;
import miki.uni.sarajevo.webshop.model.helpClasses.Availability;
import miki.uni.sarajevo.webshop.model.helpClasses.City;
import miki.uni.sarajevo.webshop.model.helpClasses.Gender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static miki.uni.sarajevo.webshop.model.helpClasses.Availability.YES;
import static miki.uni.sarajevo.webshop.model.helpClasses.Country.BOSNIA;
import static org.junit.Assert.*;

public class OrderTest {

    private Order order1;
    private Order order2;
    private Customer miroslav;
    private Customer tomo;
    private Address sa;
    private Product book;
    private Product laptop;
    private Date orderDate;
    private int orderNum;
    private int quantity;
    private float amount;

    private static Logger LOG = LogManager.getLogger(OrderTest.class);



    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static  void afterClass(){
    }

    @Before
    public void setUp() throws ParseException {
        sa = new Address("73000", City.SARAJEVO,BOSNIA);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        this.miroslav = new Customer("Miroslav",
                "Maksimovic",
                Gender.MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        this.tomo = new Customer( "Tomo",
                "Klacar",
                Gender.MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);

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

        this.order1 = new Order(miroslav,laptop, dateFormat.parse("2017-10-05"),1,3);
        this.order2 = new Order(tomo,book, dateFormat.parse("2017-10-06"),2,1);

    }

    @After
    public void tearDown(){
    }


    @Test
    public void testBookAmount(){
        float currentAmount = 150;
        assertEquals(order2.getAmount(),currentAmount, 0.001);
    }

    @Test
    public void testLaptopAmount(){
        float currentAmount = 3 * 2999;
        LOG.info(order1.getAmount());
        assertEquals(order1.getAmount(),currentAmount, 0.001);
    }



    @Test
    public void testCustomer(){
        assertEquals(order1.getCustomer(), miroslav);

    }

    @Test
    public void testIsBookAvailable(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            assertEquals(order2.getOrderDate(),dateFormat.parse("2017-10-06"));
        } catch (ParseException e) {
            LOG.info(e.getMessage());
        }
    }


}
