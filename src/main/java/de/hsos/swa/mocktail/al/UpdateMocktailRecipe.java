package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.Ingredient;

import java.util.List;

public interface UpdateMocktailRecipe {
    public void updateMocktailRecipe(int id, String name, List<Ingredient> ingredients, String instructions);
}
