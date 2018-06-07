

import junit.framework.TestCase;
import java.util.Random;
import java.security.SecureRandom;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

   private UrlValidator urlVal;
   private String nUrl="";
   public UrlValidatorTest(String testName) {
      super(testName);
      urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
   }

   
   
   public void testManualTest()
   {
	   //You can use this function to implement your manual testing
	   nUrl="http://www.google.com:80";
	   System.out.println(urlVal.isValid(nUrl));	
	   
	   nUrl="http://www.google.com:65535";
	   System.out.println(urlVal.isValid(nUrl));
	   
	   nUrl="http://www.google.com:6553";
	   System.out.println(urlVal.isValid(nUrl));
	   
	   nUrl="http://www.google.com:555";
	   System.out.println(urlVal.isValid(nUrl));
	   
	   nUrl="http://www.google.com:0";
	   System.out.println(urlVal.isValid(nUrl));
	   
	   nUrl="http://www.google.com:";
	   System.out.println(urlVal.isValid(nUrl));
	   
	   //Expected: Valid	Result: Valid
	   System.out.println(urlVal.isValid("http://www.google.com"));
	   //Expected: Invalid	Result: Invalid
	   System.out.println(urlVal.isValid("http://http://www.google.com"));
	   //Expected: Invalid	Result: Invalid
	   System.out.println(urlVal.isValid("http://www.goo/gle.com"));
	   //Expected: Valid	Result: Valid
	   System.out.println(urlVal.isValid("http://www.google.edu"));
	   //Expected: Invalid	Result: Invalid
	   System.out.println(urlVal.isValid("http://www.go>ogle.com"));
	   //Expected: Invalid	Result: Valid
	   System.out.println(urlVal.isValid("http://www.goog?le.com"));
	   
	   //Expected: Valid	Result: Valid
	   System.out.println(urlVal.isValid("http://www.google.edu?x=1"));
	   //Expected: InValid	Result: Valid
	   System.out.println(urlVal.isValid("http://www.google.edu?x="));
   }
   
  
   
   //Testting Scheme
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	  
	   int numTest = 0;
	   int numPass = 0;
	   int numFail = 0;
	   String url = "www.google.com";
	   String finalUrl="";
	   String[] validUrlScheme = {"http://",
			   					  "ftp://",
			   					  "h3t://",
			   					  ""};
	   String[] invalidUrlScheme = {"3ht://",
			   						"htp:",
			   						"http:/",
			   						"http:",
			   						"http/",
			   						"://"};
	   //Valid
	   for(int i=0;i<validUrlScheme.length;i++) {
		   numTest++;
		   finalUrl=""+validUrlScheme[i]+url;
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   //Invalid
	   for(int i=0;i<invalidUrlScheme.length;i++) {
		   numTest++;
		   finalUrl=""+invalidUrlScheme[i]+url;
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   System.out.println("\nTotal Test:  "+numTest+"  PASS: "+numPass+"  FAIL: "+numFail);
   }
   
   //Testing Authority
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   
	   
	   int numTest = 0;
	   int numPass = 0;
	   int numFail = 0;
	   String scheme = "http://";
	   String finalUrl="";
	   String[] validlAuthority = {"www.google.com",
			   					  "go.com",
			   					  "go.au",
			   					  "255.com",
			   					  "0.0.0.0",
			   					  "255.255.255.255"
			   					  };
	   String[] invalidAuthority = {"1.2.3.4.5",
			   						"1.2.3.",
			   						"go.a",
			   						"go.ala",
			   						"aaa.",
			   						".aaa",
			   						""};
	   
	   //Valid
	   for(int i=0;i<validlAuthority.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+validlAuthority[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   //Invalid
	   for(int i=0;i<invalidAuthority.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+invalidAuthority[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   System.out.println("\nTotal Test Authority:  "+numTest+"  PASS: "+numPass+"  FAIL: "+numFail);
	   
   }
   //You need to create more test cases for your Partitions if you need to 
   
   
   //Testing Authority
   public void testYourThirdPartition(){
		 //You can use this function to implement your Second Partition testing	   
	   
	   int numTest = 0;
	   int numPass = 0;
	   int numFail = 0;
	   String scheme = "http://www.google.com";
	   String finalUrl="";
	   String[] validlPort = 	 {":80",
			   					  ":65535",
			   					  ":0",
			   					  ""
			   					  };
	   String[] invalidPort = 		{":-1",
			   						":34a",
			   						":go.a",
			   						":/12",
			   						":?12a"
			   						};
	   
	   //Valid
	   for(int i=0;i<validlPort.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+validlPort[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   //Invalid
	   for(int i=0;i<invalidPort.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+invalidPort[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   System.out.println("\nTotal Test Port:  "+numTest+"  PASS: "+numPass+"  FAIL: "+numFail);
	   
   }
   
 //Testing Authority
   public void testYourFourPartition(){
		 //You can use this function to implement your Second Partition testing	   
	   
	   int numTest = 0;
	   int numPass = 0;
	   int numFail = 0;
	   String scheme = "http://www.google.com:80";
	   String finalUrl="";
	   String[] validlPart = 	 {"/test1",
			   					  "/t123",
			   					  "/$23",
			   					  "/test1/",
			   					  "/test1/file",
			   					  ""
			   					  };
	   String[] invalidPart = 		{"/..",
			   						"/../",
			   						"/..//file",
			   						"/test1//file",
			   						"/..//test"
			   						};
	   
	   //Valid
	   for(int i=0;i<validlPart.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+validlPart[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   //Invalid
	   for(int i=0;i<invalidPart.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+invalidPart[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   System.out.println("\nTotal Test Path:  "+numTest+"  PASS: "+numPass+"  FAIL: "+numFail);
	   
   }
   
 //Testing Authority
   public void testYourFifthPartition(){
		 //You can use this function to implement your Second Partition testing	   
	   
	   int numTest = 0;
	   int numPass = 0;
	   int numFail = 0;
	   String scheme = "http://www.google.com:80/test1";
	   String finalUrl="";
	   String[] validlQuery = 	 {"?action=view",
			   					  "?action=edit&mode=up",
			   					  ""
			   					  };
	   String[] invalidQuery = 		{"*action=view",
			   						"!action=view",
			   						"^action=view",
			   						"?action=edit?mode=up",
			   						};
	   
	   //Valid
	   for(int i=0;i<validlQuery.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+validlQuery[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   //Invalid
	   for(int i=0;i<invalidQuery.length;i++) {
		   numTest++;
		   finalUrl=""+scheme+""+invalidQuery[i];
		   if(urlVal.isValid(finalUrl)) {
			   numPass++;
			   System.out.println(""+finalUrl+" : PASSED");
		   }else {
			   numFail++;
			   System.out.println(""+finalUrl+"  : FAILED");
		   }
	   }
	   
	   System.out.println("\nTotal Test Query:  "+numTest+"  PASS: "+numPass+"  FAIL: "+numFail);
	   
   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
