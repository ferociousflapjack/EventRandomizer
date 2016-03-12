package com.randomizer.event;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class EventPicker {
	private ArrayList<Event> eventList;

	public EventPicker(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	
	public Event pickEvent(SelectionParameters selectionParameters) {
		ArrayList<Event> eligibleEvents = new ArrayList<Event>();
		for (Event event : eventList) {
			if (selectionParameters.meetsCriteria(event)) {
				eligibleEvents.add(event);
			}
		}
		Random randNum = new Random();
		int randChoice = randNum.nextInt(eligibleEvents.size());
		return eligibleEvents.get(randChoice);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//TODO Build initial event pile piler
		EventManager eventManager = new EventManager();
		
		eventManager.loadList("eventqueue.txt");
		
		eventManager.addEvent("Rock Climbing", 10, 30, 120, false);
		eventManager.addEvent("Road trip", 200, 120, 2880, false);
		eventManager.addEvent("Learn to juggle", 5, 10, 60, true);
		eventManager.addEvent("Fly a kite", 10, 30, 60, true);
		eventManager.addEvent("cook some shit", 5, 15, 75, true);
		eventManager.saveList("eventqueue.txt", true);
		
		ArrayList<Event> currentList = new ArrayList<Event>(eventManager.getEventList());
		
		EventPicker eventPicker = new EventPicker(currentList);
		SelectionParameters selParams = new SelectionParameters();
		
		//selParams.setCost(7);
		//selParams.setPrepTime(45);
		
		Event theChoice = eventPicker.pickEvent(selParams);
		System.out.println(theChoice.getName() + ", " + theChoice.getCost());
		
	}

}
