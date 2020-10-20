package com.bridgelabz.censusanalyser;

@SuppressWarnings("serial")
public class CensusAnalyserException extends Exception {
	enum ExceptionType {
		CENSUS_FILE_EXCEPTION
	}

	ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
