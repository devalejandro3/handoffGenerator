package com.alain.core;

import java.io.FileNotFoundException;

public interface ParsingCore {
	void handoffParsing(String handoffName, String excelDir, String excelWorkSheet) throws FileNotFoundException;
}
