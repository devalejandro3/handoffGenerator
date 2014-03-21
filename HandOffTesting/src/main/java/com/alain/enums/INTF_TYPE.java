package com.alain.enums;

public enum INTF_TYPE {
	RM("rm"),
	ALS("an,ac,co"),
	ES("es"),
	GL("gl"),
	AMLA("amla"),
	BECC("becc"),
	SALESTRACK("branch,booked");
	
	
	String prefix;
	
	INTF_TYPE(String prefix){
		this.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
}
