package com.bridgelabz.censusanalyser;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Logger;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());
		log.info("Welcome to the Indian States Census Analyser Problem.");
	}

	public int readCensusData(String csvFilePath) throws CensusAnalyserException {
		try {
			//Abstract class for reading character streams
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			//This class makes it possible to bypass all the intermediate steps and classes in setting up to read from a CSV source to a list of beans. 
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			//Converts CSV data to objects
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION);
		}
	}
}
