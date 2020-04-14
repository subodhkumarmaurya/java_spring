package com.codingdojo.objectmaster;

public class Wizard extends Human {
	
	public Wizard() {
		health = 50;
		intelligence = 8;
	}
	
	public void heal(Human h) {
		h.health += intelligence;
	}
	public void fireball(Human h) {
		h.health -= intelligence*3;
	}
	
}
