package com.codingdojo.pokemon;

public abstract class AbstractPokemon implements PokemonInterface {

	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon p = new Pokemon(name, health, type);
		Pokedex.setMyPokemon(p);
		return p;
	}

	public String pokemonInfo(Pokemon p) {
		return "Name: "+p.getName()+", Health: "+p.getHealth()+", Type: "+p.getType();
	}

	
}
