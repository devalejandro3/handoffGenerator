package com.alain.core.impl.readfile;

import java.util.List;

import com.alain.abstracts.Commons;
import com.alain.core.ReadingExcelFileMetaDataCore;
import com.alain.core.UtilsCore;
import com.alain.core.impl.utils.Utils;
import com.alain.dto.FieldMetadataDTO;

public class ReadingExcelfileMetadata extends Commons implements ReadingExcelFileMetaDataCore {
	UtilsCore utilsCore = new Utils();
	
	/**
	 * Metadata from Excel file
	 * 
	 * @param metaDataDir
	 * @param sheet
	 * @param dataHOF
	 * @return
	 */
	@Override
	public List<FieldMetadataDTO> parsedRowData(String metaDataDir, String sheet) {

		List<FieldMetadataDTO> lfm = utilsCore.readFromExcel(metaDataDir,
				sheet);
		return lfm;
	}


}
