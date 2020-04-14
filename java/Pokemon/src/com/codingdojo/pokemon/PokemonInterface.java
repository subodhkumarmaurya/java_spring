package com.codingdojo.pokemon;

public interface PokemonInterface {
	
	Pokemon createPokemon(String name, int health, String type);
	String pokemonInfo(Pokemon p);
	void listPokemon();
}
