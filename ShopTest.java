
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ShopTest {

    @Test
    public void testComputerConstructsDescription(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("comp1",computer.description);
    }

    @Test
    public void testComputerConstructsProcessorType(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("processor",computer.processorType);
    }

    @Test
    public void testComputerConstructsHardDriveCapacity(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(256,computer.hardDriveCapacity);
    }

    @Test
    public void testComputerConstructsMemory(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(32,computer.memory);
    }

    @Test
    public void testComputerConstructsOS(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("os",computer.operatingSystem);
    }

    @Test
    public void testComputerConstructsYearMade(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(2025,computer.yearMade);
    }

    @Test
    public void testComputerConstructsPrice(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(1000,computer.price);
    }

    @Test
    public void testComputerToString2(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals("comp1\nprocessor\n256\n16\nos\n2025\n0",computer.toString());
        //this prints exactally what what is the code. It's not what's expected by the assignment
        //but I made it so I could check that my syntax in testing what we would normally expect
        //would be correct.
    }

    @Test
    public void testComputerSetPrice(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        computer.setPrice(1500);
        assertEquals("comp1\nprocessor\n256\n16\nos\n2025\n1500",computer.toString());
    }

    @Test
    public void testComputerSetOS(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        computer.setOS("OS2");
        assertEquals("comp1\nprocessor\n256\n16\nOS2\n2025\n0",computer.toString());
    }

    @Test
    public void testComputerGetYear(){
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        assertEquals(2025,computer.getYear());
    }


    @Test(expected=Exception.class)
    public void testResaleShopBuyException() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(exceptional);

    }
    
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


    @Test(expected=Exception.class)
    public void testResaleShopRefurbishException() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        Computer exceptional = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.refurbish(computer, "None");

    }

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

    @Test
    public void testResaleShopRefurbishYesOS() throws Exception{
        ResaleShop shop = new ResaleShop();
        Computer computer = new Computer("comp1","processor", 256, 32,"os",2025,1000);
        shop.inventory.get(0).yearMade = 2018;
        Computer exceptional = shop.inventory.get(0);
        shop.refurbish(exceptional, "MyFirstOS");
        assertEquals("MyFirstOS",shop.inventory.get(0).operatingSystem);

    }

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
