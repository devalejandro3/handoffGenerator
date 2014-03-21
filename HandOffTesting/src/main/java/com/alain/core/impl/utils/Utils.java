package com.alain.core.impl.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.alain.core.UtilsCore;
import com.alain.dto.FieldMetadataDTO;

public class Utils implements UtilsCore {
	
	/**
	 * Return the list of FieldMetatdata
	 */
	public List<FieldMetadataDTO> readFromExcel(String file, String sheet) {
		
		List<FieldMetadataDTO> lfmd = new ArrayList<FieldMetadataDTO>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file);

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

			HSSFSheet worksheet = workbook.getSheet(sheet);

			Iterator<?> rows = worksheet.rowIterator();
			
			int x=0;
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				if(x!=0){
					lfmd.add(getMetaData(row));
				}
				x++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lfmd;
	}
	
	/**
	 * Get the meta-data record from Excel File
	 */
	
	private FieldMetadataDTO getMetaData(HSSFRow row){
		FieldMetadataDTO fmd = null;
		fmd = new FieldMetadataDTO();
		fmd.setFieldName(row.getCell(0).getStringCellValue());
		fmd.setFieldLength(parseToInteger(row.getCell(1).getStringCellValue()));
		fmd.setRowNo(row.getCell(2).getStringCellValue());
		return fmd;
	}
	
	private int parseToInteger(String s){
		return Integer.parseInt(s);
	}

}
