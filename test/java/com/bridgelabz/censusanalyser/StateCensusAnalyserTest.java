package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCensusAnalyserTest {
	private static String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SOURABH HARALE\\eclipse-workspace\\censusanalyser\\src\\test\\resources\\StateCensus.csv";

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectNumberOfRecordTest() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.readCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}
}
