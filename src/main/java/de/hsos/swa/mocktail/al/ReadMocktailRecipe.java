package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.MocktailRecipe;

import java.util.Map;

public interface ReadMocktailRecipe {
    public MocktailRecipe readMocktailRecipe(int id);
    public Map<Integer, MocktailRecipe> readAllMocktailRecipes();
}
