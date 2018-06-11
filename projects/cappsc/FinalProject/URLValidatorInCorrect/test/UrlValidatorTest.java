

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

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
		 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		 assertTrue(urlVal.isValid("http://www.google.com")); 
		 //assertTrue(urlVal.isValid("https://www.bankofamerica.com")); 
		 //assertTrue(urlVal.isValid("ftp://172.16.254.1:8000")); 
		 //assertTrue(urlVal.isValid("https://1.2.3.4.5?#")); 
		 //assertTrue(!(urlVal.isValid("ftp://200.456.999.123:78000"))); 
		 assertTrue(urlVal.isValid("http://www.google.com/search?q=star+wars"));
		 //assertTrue(urlVal.isValid("mailto:cappsc@oregonstate.edu")); 
		 assertTrue(!(urlVal.isValid("://www.google.com"))); 
		 assertTrue(!(urlVal.isValid("http://www.google.com/test1//file"))); 
		 assertTrue(!(urlVal.isValid("mailto:cappscoregonstate"))); 
		 //assertTrue(urlVal.isValid("h3t://255.com:80/$23/t123/file?action=view")); 
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
   
   
   public void testIsValid()
   {
	     System.out.println("-------------------------------------------------------------------------------------------------");
		 System.out.println("UNIT TESTS");
	   // creating an object instance
	   UrlValidator urlVal= new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   // quick verification
	   assertTrue(urlVal.isValid("http://www.google.com"));
	   
	   // variables to track our success rate
	   int totalFailed = 0;
	   int totalPassed = 0;
	   int totalTest = 200;
	   
	   // list to store any failed test
	   List<String> failedURLs = new ArrayList();
	   
	   for (int x = 0; x < totalTest; x++)
	   {
		   // collecting a random index for each category
		   int[] randomURLIndexes = new int[6];
		   randomURLIndexes[0] = (int) (Math.random()*testUrlScheme.length); // scheme
		   randomURLIndexes[1]= (int) (Math.random()*testUrlAuthority.length); // authority
		   randomURLIndexes[2] = (int) (Math.random()*testUrlPort.length); // port
		   randomURLIndexes[3]= (int) (Math.random()*testPath.length); // path
		   randomURLIndexes[4] = (int) (Math.random()*testUrlPathOptions.length); // pathOptions
		   randomURLIndexes[5] = (int) (Math.random()*testUrlQuery.length); // query
		   
		   // generating our random URL
		   String currentURL = testUrlScheme[randomURLIndexes[0]].item + 
				   testUrlAuthority[randomURLIndexes[1]].item + 
				   testUrlPort[randomURLIndexes[2]].item + 
				   testPath[randomURLIndexes[3]].item + 
				   testUrlPathOptions[randomURLIndexes[4]].item +
				   testUrlQuery[randomURLIndexes[5]].item;

		   // various flags to analyze the current URL we created
		   boolean result; // actual result
		   boolean expectedResult; // expected result
		   boolean error = false; // signal when an exception is thrown
		   
		   // condition to check what the expected result should be based on the parts we are utilizing
		   // note due to the inverse bug inside the ResultPair class, we also inverse the boolean value to match what is expected
		   if (!testUrlScheme[randomURLIndexes[0]].valid &&
		   !testUrlAuthority[randomURLIndexes[1]].valid &&
		   !testUrlPort[randomURLIndexes[2]].valid &&
		   !testPath[randomURLIndexes[3]].valid &&
		   !testUrlPathOptions[randomURLIndexes[4]].valid &&
		   !testUrlQuery[randomURLIndexes[5]].valid)
		   {
			   System.out.println("should all be TRUE");
			   expectedResult = true;
		   }
		   else
		   {
			   System.out.println("should be FALSE");
			   expectedResult = false;
		   }
		   
		   // block to check the validity of our random URL
		   try
		   {
			   result = urlVal.isValid(currentURL);
		   }
		   catch(Error er)
		   {
			   System.out.println("ERROR with URL: " + currentURL);
			   error = true;
			   result = false;
		   }
		   
		   // comparison
		   if (error || result != expectedResult)
		   {
			   failedURLs.add(currentURL);
			   totalFailed++;
		   }
		   else if (result == expectedResult)
		   {
			   totalPassed++;
		   }
		   System.out.println("EXPECTED = " + expectedResult + "    ACTUAL = " + result + "   URL: " + currentURL);
		   System.out.println();
	   }
	   
	   System.out.printf("\nTEST RESULTS\n");
	   System.out.printf("Success rate for PASSED TESTS: %d of %d\n",totalPassed,totalTest);
	   System.out.printf("Success rate for FAILED TESTS: %d of %d\n",totalFailed,totalTest);
	   
	   if (failedURLs.size() > 0)
	   {
		   System.out.printf("\n\nLIST OF FAILED URLS\n");
		   for (String current: failedURLs)
		   {
			   System.out.println(current);
		   }
	   }
   }
   
   // Used for debug only
   public static void main(String[] argv) {

	  UrlValidatorTest fct = new UrlValidatorTest("url test");
      //fct.setUp();
      fct.testManualTest();
	  //fct.testFirstPartition();
	  //fct.testSecondPartition();
	  //fct.testThirdPartition();
	  //fct.testFourthPartition();
	  //fct.testIsValid();
   }
   
   // Manual test Strings 4 correct 5 incorrect
   String[] manualTestUrls = {"http://www.google.com", 
			 				 "https://www.bankofamerica.com", 
			 				 "ftp://172.16.254.1:8000", 
			 				 "http://www.google.com/search?q=star+wars",
			 				 "://www.google.com", 
							 "https://1.2.3.4.5?#", 
							 "ftp://200.456.999.123:78000", 
							 "http://www.google.com/test1//file", 
							 "mailto:cappscoregonstate",
							 "h3t://255.com:80/$23/t123/file?action=view"
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
   
   //-------------------- Test data for creating a composite URL
   /**
    * The data given below approximates the 4 parts of a URL
    * <scheme>://<authority><path>?<query> except that the port number
    * is broken out of authority to increase the number of permutations.
    * A complete URL is composed of a scheme+authority+port+path+query,
    * all of which must be individually valid for the entire URL to be considered
    * valid.
    */
   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
           new ResultPair("ftp://", true),
           new ResultPair("h3t://", true),
           new ResultPair("3ht://", false),
           new ResultPair("http:/", false),
           new ResultPair("http:", false),
           new ResultPair("http/", false),
           new ResultPair("://", false),
           new ResultPair("", true)};

	ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
	              new ResultPair("go.com", true),
	              new ResultPair("go.au", true),
	              new ResultPair("0.0.0.0", true),
	              new ResultPair("255.255.255.255", true),
	              new ResultPair("256.256.256.256", false),
	              new ResultPair("255.com", true),
	              new ResultPair("1.2.3.4.5", false),
	              new ResultPair("1.2.3.4.", false),
	              new ResultPair("1.2.3", false),
	              new ResultPair(".1.2.3.4", false),
	              new ResultPair("go.a", false),
	             new ResultPair("go.a1a", false),
	              new ResultPair("go.1aa", false),
	              new ResultPair("aaa.", false),
	              new ResultPair(".aaa", false),
	              new ResultPair("aaa", false),
	              new ResultPair("", false)
	};
	ResultPair[] testUrlPort = {new ResultPair(":80", true),
	         new ResultPair(":65535", true),
	         new ResultPair(":0", true),
	         new ResultPair("", true),
	         new ResultPair(":-1", false),
	        new ResultPair(":65636",false),
	         new ResultPair(":65a", false)
	};
	ResultPair[] testPath = {new ResultPair("/test1", true),
	      new ResultPair("/t123", true),
	      new ResultPair("/$23", true),
	      new ResultPair("/..", false),
	      new ResultPair("/../", false),
	      new ResultPair("/test1/", true),
	      new ResultPair("", true),
	      new ResultPair("/test1/file", true),
	      new ResultPair("/..//file", false),
	      new ResultPair("/test1//file", false)
	};
	//Test allow2slash, noFragment
	ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
	                new ResultPair("/t123", true),
	                new ResultPair("/$23", true),
	                new ResultPair("/..", false),
	                new ResultPair("/../", false),
	                new ResultPair("/test1/", true),
	                new ResultPair("/#", false),
	                new ResultPair("", true),
	                new ResultPair("/test1/file", true),
	                new ResultPair("/t123/file", true),
	                new ResultPair("/$23/file", true),
	                new ResultPair("/../file", false),
	                new ResultPair("/..//file", false),
	                new ResultPair("/test1//file", true),
	                new ResultPair("/#/file", false)
	};
	
	ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
	          new ResultPair("?action=edit&mode=up", true),
	          new ResultPair("", true)
	};

}
