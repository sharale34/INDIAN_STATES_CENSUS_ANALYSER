package com.bridgelabz.censusanalyser;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import com.opencsv.bean.*;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());
		log.info("Welcome to the Indian States Census Analyser Problem.");
	}

	public int readCensusData(String csvCensusFilePath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvCensusFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			Iterable<CSVStateCensus> csvIterable = () -> censusCSVIterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION);
		}
	}

	public int readCodeData(String csvCodeFilePath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvCodeFilePath));
			CsvToBeanBuilder<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStates.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStates> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStates> codeCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			Iterable<CSVStates> csvIterable = () -> codeCSVIterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION);
		}
	}
}
