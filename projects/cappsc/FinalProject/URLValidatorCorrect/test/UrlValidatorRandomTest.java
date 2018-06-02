/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;
import java.util.Random;

/**
 * Performs Randomly generated Validation Test for url validations.
 *
 * @version $Revision: 1739358 $
 */
public class UrlValidatorRandomTest extends TestCase {
	
	public UrlValidatorRandomTest(String testName) {
		super(testName);
	}
	
	public void testIsValid() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		for (int i = 0; i < 1000; i++) {
			String url = randomInvalidUrls();
			boolean result = urlVal.isValid(url);
			assertEquals(url, false, result);
		}
		for (int i = 0; i < 1000; i++) {
			String url = generateValidUrl();
			boolean result = urlVal.isValid(url);
			assertEquals(url, true, result);
		}
	}
	
	static String randomInvalidUrls() {
		Random rand = new Random();
		StringBuilder scheme = new StringBuilder();
		//choose a scheme length between 3 and 8 characters
		int length = rand.nextInt(2080) + 3;
		for (int i = 0; i < length; i++) {
			int n = rand.nextInt(255);
			scheme.append((char)n);
		}
		return scheme.toString();
	}
	
	static String generateRandomScheme() {
		String[] schemes = {"http://", "https://"};
		Random rand = new Random();
		int index = rand.nextInt(2);
		return schemes[index];
	}
	
	static String generateRandomPort() {
		Random rand = new Random();
		int length = rand.nextInt(65535);
		return Integer.toString(length);
	}
	
	static String generateRandomAuthority() {
		int[] validChars = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70,
				71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 
				97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
				114, 115, 116, 117, 118, 119, 120, 121, 122};
		//System.out.format("length is currently: %d\n", validChars.length);
		Random rand = new Random();
		StringBuilder scheme = new StringBuilder();
		int n;
		//choose an subdomain length between 15 and 3 characters
		int length = rand.nextInt(12) + 3;
		for (int i = 0; i < length; i++) {
			n = rand.nextInt(validChars.length);
			//System.out.format("n is currently: %d\n", n);
			scheme.append((char)validChars[n]);
		}
		scheme.append('.');
		//choose an host length between 25 and 3 characters
		length = rand.nextInt(22) + 3;
		for (int i = 0; i < length; i++) {
		    n = rand.nextInt(validChars.length);
			//System.out.format("n is currently: %d\n", n);
			scheme.append((char)validChars[n]);
		}
		String[] tlds = {".com", ".gov", ".org", ".io", ".net"};
		n = rand.nextInt(tlds.length);
		scheme.append(tlds[n]);
		return scheme.toString();
	}
	
	static String generateRandomPath() {
		int[] validChars = {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70,
				71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 
				97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
				114, 115, 116, 117, 118, 119, 120, 121, 122};
		//System.out.format("length is currently: %d\n", validChars.length);
		Random rand = new Random();
		StringBuilder path = new StringBuilder();
		path.append('/');
		//choose a path length between 0 and 50
		int length = rand.nextInt(50);
		int n;
		for (int i = 0; i < length; i++) {
			n = rand.nextInt(validChars.length);
			//System.out.format("n is currently: %d\n", n);
			// make sure that the proceeding character is not a '/'
			if (n != 1 || path.charAt(path.length() - 1) != '/')
				path.append((char)validChars[n]);
		}
		return path.toString();
	}
	
	static String generateRandomQuery() {
		int[] validChars = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 63, 65, 66, 67, 68, 69, 70,
				71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 
				97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
				114, 115, 116, 117, 118, 119, 120, 121, 122};
		//System.out.format("length is currently: %d\n", validChars.length);
		Random rand = new Random();
		StringBuilder query = new StringBuilder();
		query.append('?');
		//choose the number of key-value pairs
		int length = rand.nextInt(10);
		int n;
		int keyLength = rand.nextInt(10);
		int valueLength = rand.nextInt(20);
		for (int j = 0; j < length; j++) {
			for (int i = 0; i < keyLength; i++) {
				n = rand.nextInt(validChars.length);
				query.append((char)validChars[n]);
			}
			
			if (keyLength != 0) {
				query.append('=');
				
				for (int i = 0; i < valueLength; i++) {
					n = rand.nextInt(validChars.length);
					query.append((char)validChars[n]);
				}
				if (j != length)
					query.append('&');
			}
		}
		return query.toString();
	}
	
	static String generateValidUrl() {
		StringBuilder url = new StringBuilder();
		url.append(generateRandomScheme());
		url.append(generateRandomAuthority());
		url.append(":");
		url.append(generateRandomPort());
		url.append(generateRandomPath());
		url.append(generateRandomQuery());
		return url.toString();
	}
	

	public static void main(String[] args) {
		UrlValidatorRandomTest fct = new UrlValidatorRandomTest("Random tests");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		//System.out.println(urlVal.isValidAuthority("wfkgS.7n92jJ2ecJ.com:48699"));
		//System.out.println(urlVal.isValidScheme("http"));
		//System.out.println(urlVal.isValidPath("//"));
		//System.out.println(urlVal.isValidQuery("?"));
		//fct.testIsValid();
		for (int i = 0; i < 100; i++) {
			String path = generateRandomPath();
			boolean result = urlVal.isValidPath(path);
			if (result == false)
			System.out.println(path);
		}
		System.out.println();
		//for (int i = 0; i < 20; i++) {
		//	System.out.println(randomInvalidUrls());
		// }

	}
}
