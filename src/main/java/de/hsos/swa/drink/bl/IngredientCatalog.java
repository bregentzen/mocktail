package de.hsos.swa.drink.bl;

import java.util.Map;

public interface IngredientCatalog {
    Ingredient getIngredient(String name);
    Map<String, Ingredient> getIngredients();
}
