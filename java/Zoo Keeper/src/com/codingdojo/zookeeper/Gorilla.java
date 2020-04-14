package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		
	}
	
	public void throwSomething() {
		System.out.println("The Gorilla has thrown something");
		energyLevel -= 5;
	}
	public void eatBanana() {
		System.out.println("The Gorilla ate a banana");
		energyLevel += 10;
	}
	public void climb() {
		System.out.println("The Gorilla climed a tree");
		energyLevel -= 10;
	}
}
