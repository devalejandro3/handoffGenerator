package com.alain;

import java.io.FileNotFoundException;

import com.alain.core.ParsingCore;
import com.alain.core.impl.parsing.Parsing;

public class App  {
	
	static ParsingCore parsing = new Parsing();
    public static void main( String[] args ) throws FileNotFoundException {
    	
    	String handoffName = "C:\\eloans\\handoff\\elnco032014.txt";
    	String excelDir = "C:\\eloans\\excel\\poi-test.xls";
    	String excelWorkSheet = "ALS-CO";
    	
    	parsing.handoffParsing(handoffName, excelDir, excelWorkSheet);
    }
    
    
    
}
