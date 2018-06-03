

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	  //You can use this function to implement your manual testing
	  UrlValidator urlVal = new UrlValidator(null, null, 0);
	  
	  for (int i = 0; i < manualTestUrls.length; i++) {
		  boolean result = urlVal.isValid(manualTestUrls[i]);
		  assertEquals(manualTestUrls[i], true, result);
	  }
	  
	  for (int i = 0; i < manualTestInvalidUrls.length; i++) {
		  boolean result =  urlVal.isValid(manualTestInvalidUrls[i]);
		  assertEquals(manualTestInvalidUrls[i], false, result);
	  }
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   
   // Used for debug only
   public static void main(String[] argv) {

	  UrlValidatorTest fct = new UrlValidatorTest("url test");
      //fct.setUp();
      fct.testManualTest();
   }
   
   String[] manualTestUrls = {//"http://www.google.com", 
		   					  //"https://www.bankofamerica.com", 
		   					  //"ftp://172.16.254.1:8000", 
		   					  //"http://www.google.com/search?key=star_wars", 
		   					  //"mailto:cappsc@oregonstate.edu"
		   };
   
   String[] manualTestInvalidUrls = {"h3tp:www.google.com", "https://www.bank/ofamerica.com=?#", "ftp://200.456.999.123:78000", "http://www.google.com//", "mailto:cappscoregonstate"};


}
