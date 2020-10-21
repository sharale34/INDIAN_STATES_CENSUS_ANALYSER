package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCodeAnalyserTest {
	private static final String CODE_CSV_FILE_PATH = "C:\\Users\\SOURABH HARALE\\eclipse-workspace\\censusanalyser\\src\\test\\resources\\IndiaStateCode.csv";
	private static final String WRONG_CODE_CSV_FILE_PATH = "C:\\Users\\SOURABH HARALE\\eclipse-workspace\\censusanalyser\\src\\test\\IndiaStateCode.csv";
	private static final String WRONG_CODE_CSV_FILE_TYPE = "C:\\Users\\SOURABH HARALE\\eclipse-workspace\\censusanalyser\\src\\test\\IndiaStateCode.java";

	@Test
	public void givenIndianCodeCSVFile_ShouldReturnCorrectNumberOfRecordTest() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.readCodeData(CODE_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenWrongIndianCodeCSVFile_ShouldReturnCustomExceptionTest() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.readCensusData(WRONG_CODE_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}

	@Test
	public void givenWrongTypeIndianCodeCSVFile_ShouldReturnCustomExceptionTest() {
		try {
			StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			codeAnalyser.readCodeData(WRONG_CODE_CSV_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION, e.type);
		}
	}
}
