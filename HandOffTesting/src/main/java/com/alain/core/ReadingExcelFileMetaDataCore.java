package com.alain.core;

import java.util.List;

import com.alain.dto.FieldMetadataDTO;

public interface ReadingExcelFileMetaDataCore {
	List<FieldMetadataDTO> parsedRowData(String metaDataDir, String sheet);
//	String getValue(int subStart, String length, String dataHOF);
}
