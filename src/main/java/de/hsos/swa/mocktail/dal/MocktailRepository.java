package de.hsos.swa.mocktail.dal;

import de.hsos.swa.mocktail.bl.Ingredient;
import de.hsos.swa.mocktail.bl.MocktailMenu;
import de.hsos.swa.mocktail.bl.MocktailRecipe;

import java.util.Map;
import java.util.HashMap;

public class MocktailRepository implements MocktailMenu {
    static int idCounter = 0;
    private final Map<Integer, MocktailRecipe> mocktailRecipes;

    public MocktailRepository() {
        this.mocktailRecipes = new HashMap<int, MocktailRecipe>();
    }
    @Override
    public int createMocktailRecipe(String name, String ingredients, String instructions) {
        Ingredient[] ingredientArray = new Ingredient[ingredients.split(",").length];
        for (int i = 0; i < ingredients.split(",").length; i++) {
            ingredientArray[i] = Ingredient.valueOf(ingredients.split(",")[i]);
        }
        idCounter++;
        this.mocktailRecipes.put(idCounter, new MocktailRecipe(idCounter, name, instructions, ingredientArray));
        return idCounter;
    }

    @Override
    public MocktailRecipe readMocktailRecipe(int id) {
        return null;
    }

    @Override
    public MocktailRecipe[] readAllMocktailRecipes() {
        return new MocktailRecipe[0];
    }

    @Override
    public void deleteMocktailRecipe(int id) {

    }
}
