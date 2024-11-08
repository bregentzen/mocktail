package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.Ingredient;
import de.hsos.swa.mocktail.bl.MocktailMenu;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.inject.Inject;

import java.util.Map;

public class MockTailService {

    @Inject
    MocktailMenu mocktailMenu;

    public MocktailRecipe getMocktailRecipe(String id) {
        //TODO: convert id to Integer
        Integer mocktailId;
        try {
            mocktailId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Mocktail ID: " + id);
            return new MocktailRecipe( null, null, null); //TODO: change
        }

        return mocktailMenu.readMocktailRecipe(mocktailId);
    }

    public Map<Integer, MocktailRecipe> getAllMocktailRecipes() {

        return  mocktailMenu.readAllMocktailRecipes();
    }

    public Integer createMocktailRecipe(String name, String ingredients, String instructions) {

        Ingredient[] ingredients1 = null; // TODO: Convert ingredients to Ingredient[]
        return mocktailMenu.createMocktailRecipe(new MocktailRecipe( name, instructions, ingredients1));
    }
    public void deleteMocktailRecipe(String id) {
        //TODO: convert id to Integer
        mocktailMenu.deleteMocktailRecipe(Integer.parseInt(id));
    }

    public void updateMocktailRecipe(Integer id, String name, String ingredients, String instructions) {
        Ingredient[] ingredients1 = new Ingredient[ingredients.length()]; //TODO: convert ingredients-String to Ingredients[]
        mocktailMenu.updateMocktailRecipe(id, new MocktailRecipe( name, instructions, ingredients1));
    }
}
