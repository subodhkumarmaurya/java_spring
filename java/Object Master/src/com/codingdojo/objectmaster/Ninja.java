package com.codingdojo.objectmaster;

public class Ninja extends Human {

	public Ninja() {
		stealth = 10;
	}
	
	public void steal(Human h) {
		h.health -= stealth;
		this.health += stealth;
	}
	public void runAway() {
		health -= 10;
	}
	
}
