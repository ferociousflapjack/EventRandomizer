package com.randomizer.event;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EventManager {
	HashMap<String, Event> eventMap;
	
	public EventManager() {
		eventMap = new HashMap<String, Event>();
	}
	public Collection<Event> getEventList() {
		return eventMap.values();
	}
	public void addEvent(String eventName, int cost, int prepTime, int duration, boolean indoors) {
		eventMap.put(eventName, new Event(eventName, cost, prepTime, duration, indoors));
	}
	public Event getEvent(int randNum) {
		Event[] eventPile = new Event[1];
		Event[] eventArray = getEventList().toArray(eventPile);
		return eventArray[randNum];
	}
	
	private void initHashMap() {
		
		//TODO set up delimiter so that strings with more than one word in them are valid
		
		Scanner scanner = new Scanner(System.in);
		
		boolean indoor;
		boolean keepRunning;
		
		do {
			System.out.println("Please enter the name of the activity: ");
			String eventName = scanner.next();
			System.out.println("Please enter the cost for " + eventName + ": ");
			int cost = scanner.nextInt();
			System.out.println("Please enter the approximate prep time needed for " + eventName + ": ");
			int prepTime = scanner.nextInt();
			System.out.println("Please enter the approximate duration of " + eventName + ": ");
			int duration = scanner.nextInt();
			System.out.println("Is this an indoor or outdoor activity? ");
			
			if (scanner.next().toLowerCase() == "indoor") {
				indoor = true;
			} else {
				indoor = false;
			}
			addEvent(eventName, cost, prepTime, duration, indoor);
			
			System.out.println("Would you like to add another event? ");
			if (scanner.next().equalsIgnoreCase("yes")) {
				System.out.println("you made it to the if statement");
				keepRunning = true;
			} else {
				System.out.println("you made it to the else statement");
				keepRunning = false;
			}
			
		} while (keepRunning);
	}
	
	public void saveList(String fileName, boolean append) throws IOException {
		
		//TODO normalize the furkin' output that I save so that I have a readable text file
		
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(eventMap);
		oos.close();
	}
	
	public void loadList(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		if (fis.available() > 0) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			eventMap = (HashMap<String, Event>) ois.readObject();	
			ois.close();
		} else {
			initHashMap();
			System.out.println("this is the loadlist function");
		fis.close();
		}
	}
}
