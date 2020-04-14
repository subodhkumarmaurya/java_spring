package com.codingdojo.pokemon;
import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
	private static ArrayList<Pokemon> myPokemon = new ArrayList<Pokemon>();

	public void listPokemon() {
		for(Pokemon p : myPokemon) {
			System.out.println(p.getName());
		}
		
	}
	public static void setMyPokemon(Pokemon p) {
		myPokemon.add(p);
	}

}
