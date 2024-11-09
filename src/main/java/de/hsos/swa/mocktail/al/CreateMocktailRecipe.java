package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.Ingredient;
import de.hsos.swa.mocktail.bl.MocktailRecipe;

import java.util.List;

public interface CreateMocktailRecipe {
    public MocktailRecipe createMocktailRecipe(int id, String name, List<Ingredient> ingredients, String instructions);
}
