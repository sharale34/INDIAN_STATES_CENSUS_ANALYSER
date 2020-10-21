package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class StateCodeAnalyserTest {
	private static final String CODE_CSV_FILE_PATH = "C:\\Users\\SOURABH HARALE\\eclipse-workspace\\censusanalyser\\src\\test\\resources\\IndiaStateCode.csv";
	@Test
	public void givenIndianCodeCSVFile_ShouldReturnCorrectNumberOfRecordTest()  {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.readCodeData(CODE_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}
}
