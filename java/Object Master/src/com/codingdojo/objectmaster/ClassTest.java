package com.codingdojo.objectmaster;

public class ClassTest {

	public static void main(String[] args) {
		
		Wizard w1 = new Wizard();
		w1.displayStats();
		
		Ninja n1 = new Ninja();
		n1.displayStats();
		
		Samurai s1 = new Samurai();
		Samurai s2 = new Samurai();
		s1.displayStats();
		s1.howMany();
		
		w1.fireball(n1);
		w1.heal(n1);
		n1.displayStats();
		
		n1.steal(s1);
		n1.runAway();
		s1.displayStats();
		n1.displayStats();
		
		s1.deathBlow(n1);
		s1.meditate();
		n1.displayStats();
		s1.displayStats();

	}

}
