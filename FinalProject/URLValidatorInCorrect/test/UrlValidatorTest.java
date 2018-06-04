

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest(){
	   	 System.out.println("-------------------------------------------------------------------------------------------------");
	   	 System.out.println("MANUAL TEST");
	     //Mixed URL set
	   	 int correctCount = 0;
		 int incorrectCount = 0;
		 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		 int urlAmount = manualTestUrls.length;
		 int i;
		 boolean result = true;
		 for (i = 0; i < urlAmount; i++) {
			try {
				result = urlVal.isValid(manualTestUrls[i]);
			}catch (Error err) {
				//System.out.println(err);
			}
			
			if (manualTestUrls[i] == "http://www.google.com" && result == true) {
				correctCount++;
				System.out.println(manualTestUrls[i] + " is VALID!");
			}
			if (manualTestUrls[i] == "https://www.bankofamerica.com" && result == true) {
				correctCount++;
				System.out.println(manualTestUrls[i] + " is VALID!");
			}
			if (manualTestUrls[i] == "ftp://172.16.254.1:8000" && result == true) {
				correctCount++;
				System.out.println(manualTestUrls[i] + " is VALID!");
			}
			if (manualTestUrls[i] == "http://www.google.com/search?key=star_wars" && result == true) {
				correctCount++;
				System.out.println(manualTestUrls[i] + " is VALID!");
			}
			
			if (manualTestUrls[i] == "://www.google.com" && result == false) {
				incorrectCount++;
				System.out.println(manualTestUrls[i] + " is INVALID!");
			}
			if (manualTestUrls[i] == "https://1.2.3.4.5?#" && result == false) {
				incorrectCount++;
				System.out.println(manualTestUrls[i] + " is INVALID!");
			}
			if (manualTestUrls[i] == "ftp://200.456.999.123:78000" && result == false) {
				incorrectCount++;
				System.out.println(manualTestUrls[i] + " is INVALID!");
			}
			if (manualTestUrls[i] == "http://www.google.com/test1//file" && result == false) {
				incorrectCount++;
				System.out.println(manualTestUrls[i] + " is INVALID!");
			}
			if (manualTestUrls[i] == "mailto:cappscoregonstate" && result == false) {
				incorrectCount++;
				System.out.println(manualTestUrls[i] + " is INVALID!");
			}
			
		 }
		 if ( incorrectCount == 5 && correctCount == 4) {
			 System.out.println("THE CORRECT AMOUNT OF VALID AND INVALID URLS WERE FOUND - TEST PASSED");
		 }
		 else {
			 System.out.println("THE CORRECT AMOUNT OF VALID AND INVALID URLS WAS NOT FOUND - TEST FAILED");
			 System.out.println("CORRECT URLS = " + correctCount + "INCORRECT URLS = " + incorrectCount);
		 }

} 
   

   public void testFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
	 //Correct count should be equal to the number of given urls and inccorrect count should be 0
	 System.out.println("-------------------------------------------------------------------------------------------------");
	 System.out.println("PARTITION TEST 1");
	 int correctCount = 0;
	 int incorrectCount = 0;
	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 int urlAmount = urlPartition1.length;
	 int i;
	 boolean result = true;
	 for (i = 0; i < urlAmount; i++) {
		try {
			result = urlVal.isValid(urlPartition1[i]);
		}catch (Error err) {
		}
		//result = urlVal.isValid(urlPartition1[i]);
		if (result != true) {
			//url is caught as invalid
			incorrectCount++;
			System.out.println(urlPartition1[i] + " is INVALID!");
		}
		else {
			correctCount++;
			System.out.println(urlPartition1[i] + " is VALID!");
		}
	 
	 }
	 if ( correctCount == urlAmount) {
		 System.out.println("ALL URLS ARE VALID - TEST PASSED");
	 }
	 else {
		 System.out.println("INVALID URLS WERE FOUND - TEST FAILED");
		 System.out.println("CORRECT URLS = " + correctCount + "INCORRECT URLS = " + incorrectCount);
	 }
	 

   }
   
   public void testSecondPartition(){
		 //You can use this function to implement your Second Partition testing
	     System.out.println("-------------------------------------------------------------------------------------------------");
		 System.out.println("PARTITION TEST 2");
	   	 int correctCount = 0;
		 int incorrectCount = 0;
		 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		 int urlAmount = urlPartition2.length;
		 int i;
		 boolean result = true;
		 for (i = 0; i < urlAmount; i++) {
			try {
				result = urlVal.isValid(urlPartition2[i]);
			}catch (Error err) {
				//System.out.println(err);
			}
			if (result != true) {
				//url is caught as invalid
				incorrectCount++;
				System.out.println(urlPartition2[i] + " is INVALID!");
			}
			else {
				correctCount++;
				System.out.println(urlPartition1[i] + " is VALID!");
			}
		 
		 }
		 if ( incorrectCount == urlAmount) {
			 System.out.println("ALL URLS ARE INVALID - TEST PASSED");
		 }
		 else {
			 System.out.println("VALID URLS WERE FOUND - TEST FAILED");
			 System.out.println("CORRECT URLS = " + correctCount + "INCORRECT URLS = " + incorrectCount);
		 }

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
	  fct.testFirstPartition();
	  fct.testSecondPartition();
   }
   
 //Manual test Strings 4 correct 5 incorrect
   String[] manualTestUrls = {"http://www.google.com", 
			 				 "https://www.bankofamerica.com", 
			 				 "ftp://172.16.254.1:8000", 
			 				 "http://www.google.com/search?key=star_wars",
			 				 "://www.google.com", 
							 "https://1.2.3.4.5?#", 
							 "ftp://200.456.999.123:78000", 
							 "http://www.google.com/test1//file", 
							 "mailto:cappscoregonstate"
							};
   
   //All Correct Strings
   String[] urlPartition1 = {"http://www.google.com", 
			  				 "https://www.bankofamerica.com", 
			  				 "ftp://172.16.254.1:8000", 
			  				 "http://www.google.com/search?key=star_wars" 
   							};
   //All Incorrect Strings
   String[] urlPartition2 = {"://www.google.com", 
							 "https://1.2.3.4.5?#", 
							 "ftp://200.456.999.123:78000", 
							 "http://www.google.com/test1//file", 
							 "mailto:cappscoregonstate"					
   							};
   
   
   
   
   
   


}
