package de.hsos.swa.drink.dal;

import de.hsos.swa.drink.bl.Ingredient;
import de.hsos.swa.drink.bl.IngredientCatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.Map;

@ApplicationScoped
public class IngredientRepository implements IngredientCatalog {
    private static final Logger logging = Logger.getLogger(IngredientCatalog.class);

    @Inject
    Map<String, Ingredient> ingredients;

    @Override
    public Ingredient getIngredient(String name) {
        logging.info("Getting ingredient with name " + name);
        logging.trace("Ingredient: " + ingredients.get(name) + ", isAlcoholic: " + ingredients.get(name).getIsAlcoholic());
        return ingredients.get(name);
    }

    @Override
    public Map<String, Ingredient> getIngredients() {
        logging.info("Getting all ingredients");
        logging.trace("All ingredients: " + ingredients);
        return this.ingredients;
    }
}
