package SupportLibraries;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.http.conn.params.ConnManagerParams;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ReusableFunctionality.babyfunction;
import TestExecute.TestRun;
import TestSteps.TestSteps;

public class Report extends TestSteps{
	  static int i=0;
	  static int ii=0;
	  static int j=0;
	  static int a=0;
	  
	  public static void valueReset() 
	  {
		  ii=ii-ii;
//		  System.out.println("pskk"+ii);
		  i=i-i;
//		  System.out.println("pskk"+ii);
		  j=j-j;
//		  System.out.println("pskk"+j);
		  a=a-a;
//		  System.out.println("pskk"+a);
	    
	  }
	  public static int count()
	  {
		return j;
		  
	  }
	  
	  
	  public static void headingStatus() throws IOException
	    {
	  	  
	  	 
	  	  bw.write("<tr>");
	  	  bw.write("<th width="+50+" bgcolor ="+green+"><center>PASS</center></th>");
	  	  bw.write("<th width="+50+" bgcolor="+red+"><center>FAIL</center></th>");
	  	  bw.write("<th width="+150+" bgcolor="+Orange+"><center>Total Steps</center></th>");
	  	  bw.write("</tr>"); 
	    }
	    
	  public static void totalStatus() throws IOException
	    {
	  	  bw.write("<tr>");
	  	  bw.write("<td width="+50+"><font><center>"+i+"</center></font></td>");
	  	  bw.write("<td width="+50+"><font><center>"+j+"</center></font></td>");
	  	  a=i+j;
	  	  bw.write("<td width="+50+"><font><center>"+a+"</center></font></td>");
	  	  bw.write("</tr>"); 
	  	  bw.write("</body>");
		  bw.write("</html>");
		  bw.close();
	    }
	    

	 
	public static void heading() throws IOException
    {
  	  
  	 
  	  bw.write("<tr>");
  	  bw.write("<th width="+50+" bgcolor ="+gray+"><center>S.No</center></th>");
  	  bw.write("<th width="+75+" bgcolor ="+gray+"><center>Status</center></th>");
  	  bw.write("<th width="+500+" bgcolor="+gray+"><center>Test Steps</center></th>");
  	  bw.write("<th width="+250+" bgcolor="+gray+"><center>Selenium Objects</center></th>");
  	  bw.write("<th width="+200+" bgcolor="+gray+"><center>Test data</center></th>");
  	  bw.write("<th width="+150+" bgcolor ="+gray+"><center>Date/Time</center></th>");
  	  bw.write("</tr>"); 
    }
    
    public static void pass(String description, String boj, String TC)
    {
    	try{
  	  i=i+1;
  	  ii=ii+1;
	  
  	  bw.write("<tr>");
  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
  	  bw.write("<td border="+2+" width="+50+"><font color="+green+"><b><center>Pass</center></b></font></td>");
  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
  	  bw.write("<td border="+2+" width="+300+">"+boj+"</td>");
  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
  	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  	  Date date = new Date();
  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
  	  bw.write("</tr>"); 
  	   System.out.println("PASS: "+description+"     "+dateFormat.format(date));
    	}catch(Exception e)
    	{
    		System.out.println("Error: "+e);
    	}
    }
    
	  public static void fail(String description, String objects,String TC) 
	    {
		  try{
	        if(!Browser1.equals("HTML Unit Driver"))
	        {
	    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	     	 Date date = new Date();
	    	
	    	 DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
	     	 Date date1 = new Date();
	     	//new File("FailReport\\").mkdir();
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(scrFile, new File("Reports//"+date23+"//"+dateFormat1.format(date1)+"screenshot.png"));
	    	
		      j=j+1;
		      ii=ii+1;
//		      System.out.println("sen"+j);
		  	  bw.write("<tr>");
		  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
		  	  bw.write("<td border="+2+" width="+50+">" +
		  	  		"<a href="+dateFormat1.format(date1)+"screenshot.png"+"><font color="+red+"><b><center>Fail</center></font></a></td>");
		  	  
		  	
		  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
		  	  bw.write("<td border="+2+" width="+300+">"+objects+"</td>");
		  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
		  	 
		  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
		  	  bw.write("</tr>"); 
		  	  System.out.println("FAIL: "+description+"     "+dateFormat.format(date));
	        }else
	        {
		    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		     	 Date date = new Date();
		    	
		    	 DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
		     	 Date date1 = new Date();
		     	//new File("FailReport\\").mkdir();
		    	
			      j=j+1;
			      ii=ii+1;
//			      System.out.println("sen"+j);
			  	  bw.write("<tr>");
			  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
			  	  bw.write("<td border="+2+" width="+50+"><font color="+red+"><b><center>Fail</center></font></a></td>");
			  	  
			  	
			  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
			  	  bw.write("<td border="+2+" width="+300+">"+objects+"</td>");
			  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
			  	 
			  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
			  	  bw.write("</tr>"); 
			  	  System.out.println("PASS: "+description+"     "+dateFormat.format(date));
	        }
		  }catch(Exception e)
	    	{
	    		System.out.println("Error: "+e);
	    	}
	  
}

	  public static void failm(String description, String objects,String TC) 
	    {
		  try{
	        if(!Browser1.equals("HTML Unit Driver"))
	        {
	    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	     	 Date date = new Date();
	    	
	    	 DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
	     	 Date date1 = new Date();
	     	//new File("FailReport\\").mkdir();
	    	File scrFile = ((TakesScreenshot)mobiledriver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(scrFile, new File("Reports//"+date23+"//"+dateFormat1.format(date1)+"screenshot.png"));
	    	
		      j=j+1;
		      ii=ii+1;
//		      System.out.println("sen"+j);
		  	  bw.write("<tr>");
		  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
		  	  bw.write("<td border="+2+" width="+50+">" +
		  	  		"<a href="+dateFormat1.format(date1)+"screenshot.png"+"><font color="+red+"><b><center>Fail</center></font></a></td>");
		  	  
		  	
		  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
		  	  bw.write("<td border="+2+" width="+300+">"+objects+"</td>");
		  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
		  	 
		  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
		  	  bw.write("</tr>"); 
		  	  System.out.println("FAIL: "+description+"     "+dateFormat.format(date));
	        }else
	        {
		    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		     	 Date date = new Date();
		    	
		    	 DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
		     	 Date date1 = new Date();
		     	//new File("FailReport\\").mkdir();
		    	
			      j=j+1;
			      ii=ii+1;
//			      System.out.println("sen"+j);
			  	  bw.write("<tr>");
			  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
			  	  bw.write("<td border="+2+" width="+50+"><font color="+red+"><b><center>Fail</center></font></a></td>");
			  	  
			  	
			  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
			  	  bw.write("<td border="+2+" width="+300+">"+objects+"</td>");
			  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
			  	 
			  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
			  	  bw.write("</tr>"); 
			  	  System.out.println("PASS: "+description+"     "+dateFormat.format(date));
	        }
		  }catch(Exception e)
	    	{
	    		System.out.println("Error: "+e);
	    	}
	  
}
	  
	  

}
