package dwetterling.springdatajpaassignment.controller;

import dwetterling.springdatajpaassignment.entity.Pokemon;
import dwetterling.springdatajpaassignment.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {
    private StockService stockService;

    @Autowired
    public PokemonController(StockService sts) {
        this.stockService = sts;
    }


    @RequestMapping("/stock")
    public String showStockPage(Model model) {
        model.addAttribute("pageTitle", "Pokemon Shop");
        model.addAttribute("pokemon", stockService.getPokemonList());
        return "stock";
    }



    @PostMapping("/updateStock")
    public String updateStock(Model model, Pokemon pokemon) {
        Pokemon mon = stockService.getPokemon(pokemon.getId());
        if(pokemon.getStock() < pokemon.getPurchased()){
            return "purchase-failed";
        }else
        mon.setStock(pokemon.getStock() - pokemon.getPurchased());


        stockService.updateStock(mon);

        model.addAttribute("pageTitle", "Thank You For Your Rating!");
        model.addAttribute("pokemon", stockService.getPokemon(mon.getId()));
        return "purchase-confirmation";
    }

    @GetMapping("/purchase")
    public String showPurchaseForm(Model model, @RequestParam("id") int pokemonId) {
        model.addAttribute("pageTitle", "Purchase a pokemon");

        Pokemon poke = stockService.getPokemon(pokemonId);
        model.addAttribute("pokemon", poke);
        return "purchase";
    }
}



