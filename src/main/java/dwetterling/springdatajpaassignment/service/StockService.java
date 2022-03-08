package dwetterling.springdatajpaassignment.service;

import dwetterling.springdatajpaassignment.entity.Pokemon;

import java.util.List;

public interface StockService {
    Pokemon getPokemon(int pokemon_id);

    void updateStock(Pokemon stock);

    List<Pokemon> getPokemonList();
}
