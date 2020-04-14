package com.codingdojo.zookeeper;

public class Bat extends Mammal {
//	protected int energyLevel = 300;
	
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("Whoosh");
		energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println("Ate a human");
		energyLevel += 25;
	}
	public void burninate() {
		System.out.println("Bat is burninating the town");
		energyLevel -= 100;
	}
}
