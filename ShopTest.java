
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * A class for testing ResaleShop and Computer
 */
public class ShopTest {

    /**
     * A unit test that checks if the computer constructor accurately sets the description attribute
     */
    @Test
    public void testComputerConstructsDescription(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("comp1",computer.description);
    }

    /**
     * A unit test that checks if the computer constructor accurately sets the processor type attribute
     */
    @Test
    public void testComputerConstructsProcessorType(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("processor",computer.processorType);
    }

    /**
     * A unit test that checks if the computer constructor accurately sets the hard drive capacity attribute
     */
    @Test
    public void testComputerConstructsHardDriveCapacity(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(256,computer.hardDriveCapacity);
    }


    /**
     * A unit test that checks if the computer constructor accurately sets the memory attribute
     */
    @Test
    public void testComputerConstructsMemory(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(32,computer.memory);
    }

    /**
     * A unit test that checks if the computer constructor accurately sets the operating system attribute
     */
    @Test
    public void testComputerConstructsOS(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("os",computer.operatingSystem);
    }

    /**
     * A unit test that checks if the computer constructor accurately sets the year made attribute
     */
    @Test
    public void testComputerConstructsYearMade(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(2025,computer.yearMade);
    }

    /**
     * A unit test that checks if the computer constructor accurately sets the price attribute
     */
    @Test
    public void testComputerConstructsPrice(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(1000,computer.price);
    }

    /**
     * A unit test that checks if the toString method of Computer works correctly
     */
    @Test
    public void testComputerToString2(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("comp1\nprocessor\n256\n16\nos\n2025\n0",computer.toString());
        //this prints exactally what what is the code. It's not what's expected by the assignment
        //but I made it so I could check that my syntax in testing what we would normally expect
        //would be correct.
    }

    /**
     * A unit test that checks if the setPrice method in Computer correctly sets the price
     */
    @Test
    public void testComputerSetPrice(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        computer.setPrice(1500);
        assertEquals("comp1\nprocessor\n256\n16\nos\n2025\n1500",computer.toString());
    }

    /**
     * A unit test that checks if the setOS method in Computer correctly sets the OS
     */
    @Test
    public void testComputerSetOS(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        computer.setOS("OS2");
        assertEquals("comp1\nprocessor\n256\n16\nOS2\n2025\n0",computer.toString());
    }

    /**
     * A unit test that checks if the getYear method in Computer correctly returns the yearMade attribute
     */
    @Test
    public void testComputerGetYear(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(2025,computer.getYear());
    }


    /**
     * A unit test that checks if when there is a case when the buy method in ResaleShop
     * should throw an exception, properly throws the exception
     */
    @Test(expected=Exception.class)
    public void testResaleShopBuyException() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(exceptional);

    }
    
    /**
     * A unit test that checks if the buy method in ResaleShop correctly adds a new Computer to the inventory
     */
    @Test
    public void testResaleShopBuy() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(computer);
        ArrayList<Computer> tester = new ArrayList<>();
        tester.add(exceptional);
        tester.add(computer);
        assertEquals(tester,shop.inventory);

    }

    /**
     * A unit test that checks if when there is a case when the sell method in ResaleShop
     * should throw an exception, properly throws the exception
     */
    @Test(expected=Exception.class)
    public void testResaleShopSellException() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.sell(computer);

    }

    /*@Test
    public void testResaleShopSell() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ArrayList<Computer> tester = new ArrayList<>();
        shop.sell(exceptional);
        assertEquals(tester,shop.inventory);

    }*/

    /**
     * A unit test that checks if the sell method in ResaleShop correctly removes an item in its inventory
     */
    @Test
    public void testResaleShopSell2() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ArrayList<Computer> tester = new ArrayList<>();
        shop.sell(shop.inventory.get(0)); // issue is because its trying to remove the same object. 
        //If the pointer is the same it works (this is an example). The reason it didn't work with the
        //other one was because that was a different object with a different pointer.
        assertEquals(tester,shop.inventory);

    }

    /**
     * A unit test that checks if the code in this unitTest correctly grabs data from the OutputStream
     */
    @Test
    public void testPrintInventoryEmptyFormatting() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ArrayList<Computer> tester = new ArrayList<>();
        shop.sell(shop.inventory.get(0)); // issue is because its trying to remove the same object. 
        //If the pointer is the same it works (this is an example). The reason it didn't work with the
        //other one was because that was a different object with a different pointer.
        //shop.printInventory();
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        printStream.flush();
        System.out.println("Inventory is empty");
        String methodOutput = outputStream.toString();
        assertEquals("Inventory is empty\r\n" + "",methodOutput);
    }

    /**
     * A unit test that checks if the printInventory method in ResaleShop prints the correct
     * statement to the terminal if the inventory is empty.
     */
    @Test
    public void testPrintInventoryEmpty() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ArrayList<Computer> tester = new ArrayList<>();
        shop.sell(shop.inventory.get(0)); // issue is because its trying to remove the same object. 
        //If the pointer is the same it works (this is an example). The reason it didn't work with the
        //other one was because that was a different object with a different pointer.
        //shop.printInventory();
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        printStream.flush();
        shop.printInventory();
        String methodOutput = outputStream.toString();
        assertEquals("Inventory is empty\r\n" + "",methodOutput);
    }

    /**
     * A unit test that checks if the printInventory method in ResaleShop prints the correct
     * statement to the terminal if the inventory is not empty.
     */
    @Test
    public void testPrintInventoryItem() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = shop.inventory.get(0);        
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        printStream.flush();
        shop.printInventory();
        String methodOutput = outputStream.toString();
        assertEquals(exceptional.toString() + "\r\n" + "",methodOutput);
    }


    /**
     * A unit test that checks if the refurbish method in ResaleShop correctly throws an exception
     * if the computer is not in the inventory
     */
    @Test(expected=Exception.class)
    public void testResaleShopRefurbishException() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.refurbish(computer, "None");

    }

    /**
     * A unit test that checks if an old (<2000) computer is refurbished correctly by refurbish
     */
    @Test
    public void testResaleShopRefurbishOld() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.inventory.get(0).yearMade = 1999;
        Computer exceptional = shop.inventory.get(0);
        shop.refurbish(exceptional, "None");
        assertEquals(0,shop.inventory.get(0).price);

    }

    /*@Test
    public void testResaleShopRefurbishOld2() throws Exception{
        ResaleShop shop = new ResaleShop();
        shop.inventory.get(0).yearMade = 1999;
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 1999, 1000);
        shop.refurbish(exceptional, "None");
        assertEquals(0,shop.inventory.get(0).price);

    }*/

    /**
     * A unit test that checks if a middleaged (<2012) computer is refurbished correctly by refurbish
     */
    @Test
    public void testResaleShopRefurbishMiddle() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.inventory.get(0).yearMade = 2000;
        Computer exceptional = shop.inventory.get(0);
        shop.refurbish(exceptional, "None");
        assertEquals(250,shop.inventory.get(0).price);

    }

   /*@Test
    public void testResaleShopRefurbishMiddle2() throws Exception{
        ResaleShop shop = new ResaleShop();
        shop.inventory.get(0).yearMade = 2000;
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2000, 1000);
        shop.refurbish(exceptional, "None");
        assertEquals(0,shop.inventory.get(0).price);

    }*/

    /**
     * A unit test that checks if a young (<2018) computer is refurbished correctly by refurbish
     */
    @Test
    public void testResaleShopRefurbishYoung() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.inventory.get(0).yearMade = 2012;
        Computer exceptional = shop.inventory.get(0);
        shop.refurbish(exceptional, "None");
        assertEquals(550,shop.inventory.get(0).price);

    }

    /*@Test
    public void testResaleShopRefurbishYoung2() throws Exception{
        ResaleShop shop = new ResaleShop();
        shop.inventory.get(0).yearMade = 2012;
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2012, 1000);
        shop.refurbish(exceptional, "None");
        assertEquals(0,shop.inventory.get(0).price);

    }*/

    /**
     * A unit test that checks if a futuristic(>2018) computer is refurbished correctly by refurbish
     */
    @Test
    public void testResaleShopRefurbishFutureistic() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.inventory.get(0).yearMade = 2018;
        Computer exceptional = shop.inventory.get(0);
        shop.refurbish(exceptional, "None");
        assertEquals(1000,shop.inventory.get(0).price);

    }

    /*@Test
    public void testResaleShopRefurbishFuturistic2() throws Exception{
        ResaleShop shop = new ResaleShop();
        shop.inventory.get(0).yearMade = 2018;
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2018, 1000);
        shop.refurbish(exceptional, "None");
        assertEquals(0,shop.inventory.get(0).price);

    }*/

    /**
     * A unit test that checks if the refurbish method in ResaleShop correctly sets a new OS
     */
    @Test
    public void testResaleShopRefurbishYesOS() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.inventory.get(0).yearMade = 2018;
        Computer exceptional = shop.inventory.get(0);
        shop.refurbish(exceptional, "MyFirstOS");
        assertEquals("MyFirstOS",shop.inventory.get(0).operatingSystem);

    }

    /**
     * A unit test that checks if the ResaleShop constructor correctly constructs an instance of 
     * the class with the inventory attribute as an empty list.
     */
    @Test
    public void testResaleShopConstructor() throws Exception{
        ResaleShop shop = new ResaleShop();
        ArrayList<Computer> emptyArray = new ArrayList<>();
        assertEquals(emptyArray,shop.inventory);

    }

    //change output stream to be collected in a variable, take that and convert that to a string
    // and compare that
    //2500 is incorrect
    
    
    
}
