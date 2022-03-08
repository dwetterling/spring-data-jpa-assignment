package dwetterling.springdatajpaassignment.service;


import dwetterling.springdatajpaassignment.entity.Pokemon;
import dwetterling.springdatajpaassignment.repo.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class BasicStockService implements StockService {
        private PokemonRepository pokemonRepository;

        @Autowired
        public BasicStockService(PokemonRepository pr) {
            this.pokemonRepository = pr;
        }


    @Override
    public Pokemon getPokemon(int pokemon_id) {
        Optional<Pokemon> p = pokemonRepository.findById(pokemon_id);
        if (p.isPresent()) {
            return p.get();
        }

        return null;
    }

    @Override
    public void updateStock(Pokemon stock) {

            pokemonRepository.save(stock);
    }

    @Override
    public List<Pokemon> getPokemonList() {
        List<Pokemon> list = new ArrayList<>();
        pokemonRepository.findAll().forEach(list::add);
        return list;
    }
}

