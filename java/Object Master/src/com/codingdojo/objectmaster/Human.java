package com.codingdojo.objectmaster;

public class Human {
	int strength = 3;
	int stealth = 3;
	int intelligence = 3;
	int health = 100;
	
	public Human() {
		
	}
	
	public void attackHuman(Human h) {
		h.health -= this.strength;
		System.out.println(h.health);
	}
	public void displayStats() {
		System.out.println("Strength = "+strength+" Stealth = "+stealth+" Intelligence = "+intelligence+" Health = "+health);
	}
}
