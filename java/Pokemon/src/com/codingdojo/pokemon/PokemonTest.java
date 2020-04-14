package com.codingdojo.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		Pokemon p1 = pokedex.createPokemon("Pikachu", 100, "Electric");
		Pokemon p2 = pokedex.createPokemon("Bulbasaur", 100, "Grass");
		
		pokedex.listPokemon();
		
		p1.attackPokemon(p2);
		System.out.println(p1.getHealth()); 
		System.out.println(p2.getHealth());
		
		System.out.println(pokedex.pokemonInfo(p1));
		System.out.println(pokedex.pokemonInfo(p2));
	}

}
