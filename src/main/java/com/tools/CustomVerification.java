package com.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
//import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.steps.AbstractSteps;
import com.tools.data.NavOrderImportReport;

import jxl.common.Assert;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.StepFailureException;

public class CustomVerification extends AbstractSteps{
	private static final long serialVersionUID = 3609006291221433240L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PageObject.class);
    static StringBuffer verificationMessages;
    public static int count=0;
    public static int count2=0;
    public static Map<String, String> errorData = new HashMap<String, String>();
    public static List<NavOrderImportReport> errorDataList=new ArrayList<NavOrderImportReport>();
	
    public CustomVerification(Pages pages){
		verificationMessages = new StringBuffer();
	}
	
	@Step
	public static void verifyTrue(String message, boolean condition) throws StepFailureException{
		
		try{
			Assert.verify(condition,message);
		}catch(Exception e){
			verificationMessages.append("\n" + e.getMessage());
			LOGGER.info(message);
			
			
		}
	}
	
	
	@Step
	@Screenshots(onlyOnFailures=true)
	public void  printErrors(){
		verifyNoErrors(verificationMessages.toString());
	}
	
	@Step
	public void  verifyNoErrors(String veriStr){
		org.junit.Assert.assertTrue("Errors Count: " + StringUtils.countMatches(veriStr, "\n"), !veriStr.contains("\n"));
		
	}
	

}
