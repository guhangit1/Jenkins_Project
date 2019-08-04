package TestSteps;

import ReusableFunctionality.babyfunction;
import SupportLibraries.Excel;
import SupportLibraries.Report;
import SupportLibraries.pro_1;

public class NewTours extends TestSteps {
	
  public static pro_1 obj = new pro_1(file.show());
  public static pro_1 nt = new pro_1(file.nt());

  


  
  
  public static void ntLoginNew() 
  {
	try {
				babyfunction.inputbyname(nt.ReadProperty("ntUserName"), "Enter User name", Excel.Exceldata("NTTestData", "UserName"));
				babyfunction.inputbyname(nt.ReadProperty("ntPassword"), "Enter Password name", Excel.Exceldata("NTTestData", "Password"));
				babyfunction.clickbyname(nt.ReadProperty("ntLoginButton"), "Click on Login Button","Nil");
	}catch(Exception e){
		Report.fail("Error: "+e, "Nil", "Nil");
	}
  }
  
  public static void ntlabel_check() 
  {
	try {
				babyfunction.ObjectXpathYes(nt.ReadProperty("ntType"), "Read LabelName1", Excel.Exceldata("NTTestData", "LabelName1"));
				
	}catch(Exception e){
		Report.fail("Error: "+e, "Nil", "Nil");
	}
  }



  
  
  
}

  
  