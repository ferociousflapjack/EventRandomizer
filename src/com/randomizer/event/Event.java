package com.randomizer.event;

import java.io.Serializable;

public class Event implements Serializable {
	String name;
	int cost;
	int prepTime;
	int duration;
	boolean indoors;
	boolean doneBefore;
	
	public Event(String name, int cost, int prepTime, int duration, boolean indoors) {
		this.name = name;
		this.cost = cost;
		this.prepTime = prepTime;
		this.duration = duration;
		this.indoors = indoors;
	}
	
	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}
	
	public int getPrepTime() {
		return prepTime;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public boolean getIndoors() {
		return indoors;
	}
	
	public void setDoneBefore() {
		doneBefore = true;
	}
}
