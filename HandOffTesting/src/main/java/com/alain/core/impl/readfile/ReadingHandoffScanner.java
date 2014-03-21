package com.alain.core.impl.readfile;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.alain.abstracts.Commons;
import com.alain.core.ReadingHandoffScannerCore;

public class ReadingHandoffScanner extends Commons implements ReadingHandoffScannerCore {


	/**
	 * 
	 * @param dirname
	 * @return Record Row
	 * @throws FileNotFoundException
	 */
	public Map<Integer, String> getRecordRow(String dirname) throws FileNotFoundException{

		// dirname == directory + filename
		FileInputStream fis = new FileInputStream(dirname);
		Scanner scanner = new Scanner(fis);

		Map<Integer, String> recordRow = new HashMap<Integer, String>();

		recordRow = putRecordToMap(scanner);

		scanner.close();

		return recordRow; 
	}
	


	// Part of Result Maker
	public  void createTextFile(Map<Integer, Map<Integer, String>> xxx) {

		Set<Map.Entry<Integer, Map<Integer, String>>> s = xxx.entrySet();
		Iterator<Map.Entry<Integer, Map<Integer, String>>> i = s.iterator();
		
		while (i.hasNext()) {

			Map.Entry<Integer, Map<Integer, String>> recordPerRow = (Entry<Integer, Map<Integer, String>>) i
					.next();

			int key = recordPerRow.getKey();
			Map<Integer, String> y = recordPerRow.getValue();

			Set<Map.Entry<Integer, String>> ss = y.entrySet();
			Iterator<Map.Entry<Integer, String>> ii = ss.iterator();
			StringBuilder sb = new StringBuilder();
			sb.append("=== Handoff File Testing === \n");
			sb.append("Total Record: " + xxx.size() + " \n" );
			sb.append("Field Name               \t\t\tLength\t\tValue\n");
			sb.append("-------------------------------------------------------------------------------------\n");
			while (ii.hasNext()) {

				Map.Entry<Integer, String> rowValue = ii.next();
				log.debug("Parent Key : " + key + "  Key : "
								+ rowValue.getKey() + " value : "
								+ rowValue.getValue());

				sb.append(rowValue.getValue());
				sb.append('\n');

			}

			createNow(recordPerRow.getKey(), sb.toString());

		}

	}
	
	// Part of Handoff Reader
	private Map<Integer, String> putRecordToMap(Scanner scanner) {
		Map<Integer, String> recordRow = new HashMap<Integer, String>();
		int ctr = 0;
		while (scanner.hasNextLine()) {
			recordRow.put(ctr++, scanner.nextLine());
		}

		return recordRow;
	}

	// Part of Result Maker
	private void createNow(int key, String value) {
		BufferedWriter writer = null;

		String x = "C:\\eloans\\extracted\\";
		try {
			writer = new BufferedWriter(new FileWriter(x + "TestFile_ALS-CO("
					+ key+1 + ").txt"));
			writer.write(value);

		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}

}
