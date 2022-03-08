package dwetterling.springdatajpaassignment.repo;

import dwetterling.springdatajpaassignment.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
}

