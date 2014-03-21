package com.alain.core;

import java.io.FileNotFoundException;
import java.util.Map;

public interface ReadingHandoffScannerCore {
	Map<Integer, String> getRecordRow(String dirname) throws FileNotFoundException;
	void createTextFile(Map<Integer, Map<Integer, String>> xxx) ;
}
