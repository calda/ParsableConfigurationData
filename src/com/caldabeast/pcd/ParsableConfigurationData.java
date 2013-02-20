package com.caldabeast.pcd;

import java.util.ArrayList;
import java.util.List;

public class ParsableConfigurationData{
	
	private final String name;
	private String parsedData;
	private List<Data> data = new ArrayList<Data>();
	
	/**
	 * Create a new ParsableConfigurationData, ready for new data bits and modules
	 * @param name the name of the new Parsable Module
	 */
	public ParsableConfigurationData(String name){
		this.name = name;
	}
	
	private void updateParsedData() throws PCDUnallowedException{
		parsedData = "$" + name + "~";
		for(Data d : data){
			parsedData = parsedData + d.getParsedString();
			if(!d.equals(data.get(data.size() - 1))) parsedData += ";";
		}
	}
	
	/**
	 * Get a parsed version of the current module status and data bits
	 * @return parsed version of the current module status and data bits
	 * @throws PCDUnallowedException if not data bits have been added
	 */
	public String getParsedString() throws PCDUnallowedException{
		if(data.size() == 0){
			throw new PCDUnallowedException("You cannot parse an empty configuration.");
		}updateParsedData();
		return parsedData;
	}
	
	/**
	 * @return the name of the PCD
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Add a new DataBit of the type BooleanData, IntData, FloatData, or StringData
	 * @param db the data bit to add to the module
	 * @throws PCDUnallowedException 
	 */
	public void addNewData(Data d) throws PCDUnallowedException{
		data.add(d);
		if(data.size() != 1) parsedData += ";";
		parsedData += d.getParsedString();
	}
	
	
}
