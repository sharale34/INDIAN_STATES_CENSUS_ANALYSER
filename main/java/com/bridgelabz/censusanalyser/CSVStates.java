package com.bridgelabz.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
	@CsvBindByName(column = "SrNo", required = true)
	public String srNo;

	@CsvBindByName(column = "StateName", required = true)
	public String stateName;

	@CsvBindByName(column = "TIN", required = true)
	public int tin;

	@CsvBindByName(column = "StateCode", required = true)
	public String stateCode;

	@Override
	public String toString() {
		return "IndiaStateCodeCSV{" + "SrNo='" + srNo + '\'' + ", StateName=" + stateName + ", TIN=" + tin
				+ ", StateCode=" + stateCode + '}';
	}
}
