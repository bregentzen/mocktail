package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.Ingredient;
import de.hsos.swa.mocktail.bl.MocktailMenu;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import de.hsos.swa.mocktail.bl.StringToIngredientsService;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Dependent
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
            return new MocktailRecipe( 0, null, null, null); //TODO: change
        }

        return mocktailMenu.readMocktailRecipe(mocktailId);
    }

    public Map<Integer, MocktailRecipe> getAllMocktailRecipes() {

        return  mocktailMenu.readAllMocktailRecipes();
    }

    public MocktailRecipe createMocktailRecipe(String name, String ingredients, String instructions) {

        List<String> ingredients1 = StringToIngredientsService.convert(ingredients); // TODO: Convert ingredients to Ingredient[]
        return mocktailMenu.createMocktailRecipe(new MocktailRecipe( name, instructions, ingredients1));
    }
    public void deleteMocktailRecipe(int id) {
        //TODO: convert id to Integer
        mocktailMenu.deleteMocktailRecipe(id);
    }

    public void updateMocktailRecipe(Integer id, String name, String ingredients, String instructions) {
        List<String> ingredients1 = new ArrayList<>(); //TODO: convert ingredients-String to Ingredients[]
        mocktailMenu.updateMocktailRecipe(id, new MocktailRecipe( name, instructions, ingredients1));
    }
}
