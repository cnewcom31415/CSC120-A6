## Bug 1
Brief description:  Checks whether the constructor properly set the memory attribute. It did not, it set it to 16 instead of the 32 it was supposed to be set to.
Failed unit test: testComputerConstructsMemory()

## Bug 2
Brief description:  Checks wether setOS works properly. Please note that for this test, I took into account that the constructor was incorrect. Once all bugs are corrected, this test will always fail because it assumes the incorrect constructor. For this test, the operating system was expected to be "OS2" but "None" was returned instead.
Failed unit test: testComputerSetOS()

## Bug 3
Brief description:  Method buy() in ResaleShop.java did not produce the expected exception. The exact computer that was to be bought was already in the inventory of the resale shop, therefore, an exception should have been thrown but was not.
Failed unit test: testResaleShopBuyException()

## Bug 4
Brief description:  Method buy() in ResaleShop.Java did not correctly add the new computer to the inventory.
Failed unit test: testResaleShopBuy()

## Bug 5
Brief description:  Method sell() in ResaleShop.java did not correctly throw an exception when the computer was not in the inventory.
Failed unit test: testResaleShopSellException()

## Bug 6
Brief description:  when calling PrintInventory() when there is an item in the inventory an ArrayOutOfBounds exception is unexpectedly thrown.
Failed unit test:  testPrintInventoryItem()


## Bug 7
Brief description:  Method refurbish in ResaleShop.java does not correctly update the price when the year is greater than or equal to 2000 and less than 2012. Outputted price was 2500 instead of 250
Failed unit test:testResaleShopRefurbishMiddle()

## Bug 8
Brief description:  Method refurbish in ResaleShop.java does not correctly update the OS when the newOS is not "None." Instead of the expected "MyFirstOS,"  the computer's OS was "None"
Failed unit test: testResaleShopRefurbishYesOS()

## Bug 9
Brief description:  The constructor for Resale shop does not initialize an expected empty array.
Failed unit test: testResaleShopConstructor()

## Bug 10
Brief description: Checks whether the constructor properly set the price attribute. It did not, it set it to 0 instead of the 1000 it was supposed to be set to. 
Failed unit test: testComputerConstructsPrice()