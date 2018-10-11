package models;

import java.util.List;

public class Pet {
	String name;
	int type;
	List<String> feature;
	
	/*
	 * source > generate setter
	 * 
	 */

	public void setName(String name) {
		this.name = name;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setFeature(List<String> feature) {
		this.feature = feature;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", feature=" + feature + "]";
	}

	
	
	
}
