package com.codingdojo.objectmaster;

public class Samurai extends Human {
	static int count = 0;

	public Samurai() {
		health = 200;
		count += 1;
	}
	
	public void deathBlow(Human h) {
		h.health = 0;
		this.health /= 0.5;
	}
	public void meditate() {
		health *= 0.5;
	}
	public static void howMany() {
		System.out.println(count);
	}
	
}
