package com.randomizer.event;

public class SelectionParameters {

	Integer cost;
	Integer prepTime;
	Integer duration;
	Boolean indoor;
	
	public SelectionParameters () {
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}
	
	public Integer getCost() {
		return cost;
	}
	
	public Integer getPrepTime() {
		return prepTime;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public Boolean getIndoor() {
		return indoor;
	}
	
	public boolean hasCost() {
		return cost != null;
	}
	
	public boolean hasPrepTime() {
		return prepTime != null;
	}
	
	public boolean hasDuration() {
		return duration != null;
	}
	
	public boolean hasIndoor() {
		return indoor != null;
	}
	
	public boolean meetsCriteria(Event event) {
		boolean isValid = true;
		if (hasCost()) {
			if (event.getCost() > getCost()) {
				isValid = false;
			}
		}
		else if (hasPrepTime()) {
			if (event.getPrepTime() > getPrepTime()) {
				isValid = false;
			}
		}
		
		else if (hasDuration()) {
			if (event.getDuration() > getDuration()) {
				isValid = false;
			}
		}
		
		else if (hasIndoor()) {
			if (event.getIndoors() != getIndoor()) {
				isValid = false;
				}
			}
		return isValid;
	}
	
	//add method meetsCriteria(Event) that will take a event and return true if it meets all the selection parameters
}

