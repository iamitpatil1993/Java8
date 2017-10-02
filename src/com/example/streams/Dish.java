package com.example.streams;

import java.util.ArrayList;
import java.util.List;

public class Dish {

	private String name;
	private Integer calories;
	private DISH_TYPE type;
	private List<Characterstic> characterstics = new ArrayList<>();
	private boolean isVegetarian;

	public Dish(String name, Integer calories) {
		super();
		this.name = name;
		this.calories = calories;
	}
	
	public Dish(String name, Integer calories, DISH_TYPE type) {
		super();
		this.name = name;
		this.calories = calories;
		this.type = type;
	}

	public Dish() {

	}

	public List<Characterstic> getCharacterstics() {
		return characterstics;
	}

	public void setCharacterstics(List<Characterstic> characterstics) {
		this.characterstics = characterstics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public DISH_TYPE getType() {
		return type;
	}

	public void setType(DISH_TYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + "]";
	}
	
	public boolean getIsVegetarian() {
		if(DISH_TYPE.VEG.equals(this.type))
			return true;
		else
			return false;
	}
}

