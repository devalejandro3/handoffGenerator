package com.alain.core;

import java.util.List;

import com.alain.dto.FieldMetadataDTO;

public interface UtilsCore {
	List<FieldMetadataDTO> readFromExcel(String file, String sheet);
}
