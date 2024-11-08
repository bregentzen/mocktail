package de.hsos.swa.mocktail.bl;

public interface MocktailMenu {
    public int createMocktailRecipe(String name, String ingredients, String instructions);
    public MocktailRecipe readMocktailRecipe(int id);
    public MocktailRecipe[] readAllMocktailRecipes();
    public void deleteMocktailRecipe(int id);
}
