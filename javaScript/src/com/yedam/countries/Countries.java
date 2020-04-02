package com.yedam.countries;

public class Countries {
	private String name;
	private String id;
	private int region;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public Countries(String name, String id, int region) {
		super();
		this.name = name;
		this.id = id;
		this.region = region;
	}
	@Override
	public String toString() {
		return "Countries [name=" + name + ", id=" + id + ", region=" + region + "]";
	}
	
	
}

