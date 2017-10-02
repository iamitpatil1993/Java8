package com.example.streams;

public enum DISH_TYPE {
	VEG("Vegetarian"), NON_VEG("Non Vegetarian");

	private final String disType;

	private DISH_TYPE(final String disType) {
		this.disType = disType;
	}
	
	@Override
	public String toString() {
		return this.disType;
	}
}