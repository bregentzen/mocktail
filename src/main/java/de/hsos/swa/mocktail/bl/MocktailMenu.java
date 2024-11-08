package de.hsos.swa.mocktail.bl;

import java.util.HashMap;

public interface MocktailMenu {
    public MocktailRecipe createMocktailRecipe(MocktailRecipe mocktailRecipe);
    public MocktailRecipe readMocktailRecipe(int id);
    public HashMap<Integer, MocktailRecipe> readAllMocktailRecipes();
    public void deleteMocktailRecipe(int id);
    public void updateMocktailRecipe(int id, MocktailRecipe mocktailRecipe);
}
