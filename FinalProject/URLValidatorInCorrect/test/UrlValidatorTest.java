

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
		 
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		 if ( incorrectCount == 5 && correctCount == 4) {
			 System.out.println("TEST PASSED! - THE CORRECT AMOUNT OF VALID AND INVALID URLS WERE FOUND");
		 }
		 else {
			 System.out.println("TEST FAILED! - THE CORRECT AMOUNT OF VALID AND INVALID URLS WAS NOT FOUND");
			 System.out.println("CORRECT URLS = " + correctCount + " INCORRECT URLS = " + incorrectCount);
		 }
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

} 
   

   public void testFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
	 //Correct count should be equal to the number of given urls and inccorrect count should be 0
	 System.out.println("-------------------------------------------------------------------------------------------------");
	 System.out.println("PARTITION TEST 1 -Testing Valid URL Parts");
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
		if (result == false) {
			//url is caught as invalid
			incorrectCount++;
			System.out.println(urlPartition1[i] + " is INVALID!");
		}
		else if (result == true){
			correctCount++;
			System.out.println(urlPartition1[i] + " is VALID!");
		}
	 
	 }
	 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	 if ( correctCount == urlAmount) {
		 System.out.println("TEST PASSED - ALL URL PARTS ARE VALID");
	 }
	 else {
		 System.out.println("TEST FAILED! - INVALID URL PARTS WERE FOUND");
		 System.out.println("VALID URL PARTS = " + correctCount + " INVALID URL PARTS = " + incorrectCount);
	 }
	 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

   }
   
   public void testSecondPartition()
   {
	 //You can use this function to implement your First Partition testing
	 //Correct count should be equal to the number of given urls and inccorrect count should be 0
	 System.out.println("-------------------------------------------------------------------------------------------------");
	 System.out.println("PARTITION TEST 2 -Testing Valid URLs");
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
		}
		//result = urlVal.isValid(urlPartition1[i]);
		if (result == false) {
			//url is caught as invalid
			incorrectCount++;
			System.out.println(urlPartition2[i] + " is INVALID!");
		}
		else if (result == true){
			correctCount++;
			System.out.println(urlPartition2[i] + " is VALID!");
		}
	 
	 }
	 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	 if ( correctCount == urlAmount) {
		 System.out.println("TEST PASSED! - ALL URLS ARE VALID");
	 }
	 else {
		 System.out.println("TEST FAILED! - INVALID URLS WERE FOUND");
		 System.out.println("VALID URLS = " + correctCount + " INVALID URLS = " + incorrectCount);
	 }
	 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

   }
   
   public void testThirdPartition(){
		 //You can use this function to implement your Second Partition testing
	     System.out.println("-------------------------------------------------------------------------------------------------");
		 System.out.println("PARTITION TEST 3 - Testing Invalid Parts");
	   	 int correctCount = 0;
		 int incorrectCount = 0;
		 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		 int urlAmount = urlPartition3.length;
		 int i;
		 boolean result = true;
		 for (i = 0; i < urlAmount; i++) {
			try {
				result = urlVal.isValid(urlPartition3[i]);
			}catch (Error err) {
				//System.out.println(err);
			}
			if (result == false) {
				//url is caught as invalid
				incorrectCount++;
				System.out.println(urlPartition3[i] + " is INVALID!");
			}
			else if (result == true){
				correctCount++;
				System.out.println(urlPartition3[i] + " is VALID!");
			}
		 
		 }
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		 if ( incorrectCount == urlAmount) {
			 System.out.println("TEST PASSED! - ALL URL PARTS ARE INVALID");
		 }
		 else {
			 System.out.println("TEST FAILED! - VALID URL PARTS WERE FOUND");
			 System.out.println("VALID URL PARTS = " + correctCount + " INVALID URL PARTS = " + incorrectCount);
		 }
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 }
   
   public void testFourthPartition(){
		 //You can use this function to implement your Second Partition testing
	     System.out.println("-------------------------------------------------------------------------------------------------");
		 System.out.println("PARTITION TEST 4 - Testing Invalid URLs");
	   	 int correctCount = 0;
		 int incorrectCount = 0;
		 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		 int urlAmount = urlPartition4.length;
		 int i;
		 boolean result = true;
		 for (i = 0; i < urlAmount; i++) {
			try {
				result = urlVal.isValid(urlPartition4[i]);
			}catch (Error err) {
				//System.out.println(err);
			}
			if (result == false) {
				//url is caught as invalid
				incorrectCount++;
				System.out.println(urlPartition4[i] + " is INVALID!");
			}
			else if (result == true){
				correctCount++;
				System.out.println(urlPartition4[i] + " is VALID!");
			}
		 
		 }
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		 if ( incorrectCount == urlAmount) {
			 System.out.println("TEST PASSED! - ALL URLS ARE INVALID");
		 }
		 else {
			 System.out.println("TEST FAILED! - VALID URLS WERE FOUND");
			 System.out.println("VALID URLS = " + correctCount + " INVALID URLS = " + incorrectCount);
		 }
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
	  fct.testThirdPartition();
	  fct.testFourthPartition();
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
   
   // All Correct URL parts
   String[] urlPartition1 = {"http://www.google.com",
							   "ftp://www.google.com",
							   "h3t://www.google.com",
							   "www.google.com",
							   "go.com",
							   "go.au",
							   "0.0.0.0",
							   "255.255.255.255",
							   "255.com",
							   "www.google.com:80",
							   "www.google.com:65535",
							   "www.google.com:0",
							   "www.google.com/test1",
							   "www.google.com/t123",
							   "www.google.com/$23",
							   "www.google.com/test1/",
							   "www.google.com/test1/file",
							   "www.google.com/test1",
							   "www.google.com/t123",
							   "www.google.com/$23",
							   "www.google.com/t123/file",
							   "www.google.com/$23/file",
							   "www.google.com/test1//file"
   							};
   
   //All Correct Strings
   String[] urlPartition2 = {"http://www.google.com", 
			  				 "https://www.bankofamerica.com", 
			  				 "ftp://172.16.254.1:8000", 
			  				 "http://www.google.com/search?key=star_wars",
			  				 "mail.google.com",
			  				 "google.com",
			  				 "oregonstate.edu:8000",
			  				 "ftp://go.com:80/test1/test1",
			  				 "h3t://go.au:65535/t123/t123",
			  				 "h3t://0.0.0.0:0/$23/$23",
			  				 "255.255.255.255/test1/file/test1/file",
			  				 "http://255.com:65535?action=view ",
			  				 "go.au",
			  				 "255.255.255.255",
			  				 "ftp://go.com:80/test1/test1?action=view"
   							};
  
   //All Incorrect Parts
   String[] urlPartition3 = {"3ht://www.google.com",
			 				 "http:/www.google.com",
			 				 "http:www.google.com",
			 				 "http/www.google.com",
			 				 "://www.google.com",
			 				 "256.256.256.256",
			 				 "1.2.3.4.5",
			 				 "1.2.3.4.",
			 				 "1.2.3",
			 				 ".1.2.3.4",
			 				 "go.a",
			 				 "go.a1a",
			 				 "go.1aa",
			 				 "aaa.",
			 				 ".aaa",
			 				 "aaa",
			 				 "",
			 				 "www.google.com:-1",
			 				 "www.google.com:65636",
			 				 "www.google.com:65a",
			 				 "www.google.com/..",
			 				 "www.google.com/../",
			 				 "www.google.com/..//file",
			 				 "www.google.com/test1//file",
			 				 "www.google.com/..",
			 				 "www.google.com/../",
			 				 "www.google.com/#",
			 				 "www.google.com/../file",
			 				 "www.google.com/..//file",
			 				 "www.google.com/#/file"
   						   };
   
   //All Incorrect Strings
   String[] urlPartition4 = {"://www.google.com", 
							 "https://1.2.3.4.5?#", 
							 "ftp://200.456.999.123:78000", 
							 "http://www.google.com/test1//file", 
							 "mailto:cappscoregonstate",
							 " "
   						    };
   
  
   
   
   
   
   
   


}
