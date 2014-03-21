package com.alain.core.impl.parsing;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alain.abstracts.Commons;
import com.alain.core.ParsingCore;
import com.alain.core.ReadingExcelFileMetaDataCore;
import com.alain.core.ReadingHandoffScannerCore;
import com.alain.core.impl.readfile.ReadingExcelfileMetadata;
import com.alain.core.impl.readfile.ReadingHandoffScanner;
import com.alain.dto.FieldMetadataDTO;

public class Parsing extends Commons implements ParsingCore {

	ReadingHandoffScannerCore rfc = new ReadingHandoffScanner();
	ReadingExcelFileMetaDataCore refmeta = new ReadingExcelfileMetadata();
	
	public void handoffParsing(String handoffName, String excelDir, String excelWorkSheet) throws FileNotFoundException{
		Iterator<Map.Entry<Integer, String>> i = getRowRecord(handoffName).entrySet().iterator();
		
		//While handoff file has row
		while (i.hasNext()) {
			Map.Entry<Integer, String> e = (Entry<Integer, String>) i.next();
			rfc.createTextFile(getSplitedRowValues(e.getKey(), e.getValue(), excelDir,excelWorkSheet ));
		} 
	}
	
	private Map<Integer, String> getRowRecord(String handoffName) throws FileNotFoundException{
    	return rfc.getRecordRow(handoffName);
    }
    
	/**
	 * 
	 * @param key
	 * @param str[0] row
	 * @param str[1] Meta file directory
	 * @param str[2] Meta worksheet
	 * @return
	 */
    private  Map<Integer, Map<Integer, String>> getSplitedRowValues(
		int key, String ...str ) {
		// value per Row
		Map<Integer, Map<Integer, String>> rowItem = new HashMap<Integer, Map<Integer, String>>();
		// value per record
		Map<Integer, String> xxx = new HashMap<Integer, String>();
		
		List<FieldMetadataDTO> parsedRowData = refmeta.parsedRowData(str[1],str[2]);
		int ctrLength = 0;
		Integer ctr = 0;
		 for (FieldMetadataDTO fmeta: parsedRowData) {
			 xxx.put( ctr, ctr + "\t" + fmeta.getRowNo() + "\t"+ fmeta.getFieldName() + "\t" +
			 fmeta.getFieldLength() + "\t\t\t" +
			 str[0].substring(ctrLength, ctrLength + fmeta.getFieldLength()));
			 ctrLength+=fmeta.getFieldLength();
			 ctr++;
		 }
		rowItem.put(key, xxx);
		return rowItem;
	}

}
