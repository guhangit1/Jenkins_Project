package TestSteps;

import ReusableFunctionality.babyfunction;
import SupportLibraries.Excel;
import SupportLibraries.Report;
import SupportLibraries.pro_1;

public class Badminton extends TestSteps {
	
  public static pro_1 obj = new pro_1(file.show());
  public static pro_1 b = new pro_1(file.b());

  


  
  
  public static void BLoginNew() 
  {
	  System.out.println(b.ReadProperty("BPassword"));
	  System.out.println(b.ReadProperty("BLoginButton"));
	  System.out.println(b.ReadProperty("BLogout"));
	try {
				babyfunction.inputbyname(b.ReadProperty("BUserName"), "Enter User name", Excel.Exceldata("BTestData", "UserName"));
				babyfunction.inputbyname(b.ReadProperty("BPassword"), "Enter Password name", Excel.Exceldata("BTestData", "Password"));
				babyfunction.clickbyname(b.ReadProperty("BLoginButton"), "Click on Login Button","Nil");
	}catch(Exception e){
		Report.fail("Error: "+e, "Nil", "Nil");
	}
  }
  
  /*public static void GClickNewCust() 
  {
	  System.out.println(g.ReadProperty("GPassword"));
	  System.out.println(g.ReadProperty("GLoginButton"));
	  System.out.println(g.ReadProperty("GLogout"));
	try {
				babyfunction.inputbyname(g.ReadProperty("GUserName"), "Enter User name", Excel.Exceldata("GTestData", "UserName"));
				babyfunction.inputbyname(g.ReadProperty("GPassword"), "Enter Password name", Excel.Exceldata("GTestData", "Password"));
				babyfunction.clickbyname(g.ReadProperty("GLoginButton"), "Click on Login Button","Nil");
				babyfunction.Savebyxpath(g.ReadProperty("marqueeText"), "Get Marquee Text", Excel.Exceldata("GTestData", "Text"));
	}catch(Exception e){
		Report.fail("Error: "+e, "Nil", "Nil");
	}
  }
  */
  
  
public static void BLogoutFromApplicatoin() 
{
	  try{
		  babyfunction.clickbyxpath(b.ReadProperty("BLogout"), "Click on Logout", "Nil");
	  }catch(Exception e)
	  {
		  Report.fail("Error: "+e, "Nil", "Nil");
	  }
}
}
			