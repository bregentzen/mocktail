package de.hsos.swa.drink.dal;

import de.hsos.swa.drink.bl.Ingredient;
import de.hsos.swa.drink.bl.IngredientCatalog;
import de.hsos.swa.shared.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.Map;

@ApplicationScoped
@Log(Log.Level.TRACE)
public class IngredientRepository implements IngredientCatalog {


    @Inject
    Map<String, Ingredient> ingredients;

    @Override
    public Ingredient getIngredient(String name) {

        return ingredients.get(name);
    }

    @Override
    public Map<String, Ingredient> getIngredients() {


        return this.ingredients;
    }
}
