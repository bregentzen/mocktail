package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.Ingredient;
import de.hsos.swa.mocktail.bl.MocktailMenu;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.Map;
import java.util.List;

@Dependent
public class MockTailService {

    @Inject
    MocktailMenu mocktailMenu;

    public MocktailRecipe getMocktailRecipe(int id) {
        return mocktailMenu.readMocktailRecipe(id);
    }

    public Map<Integer, MocktailRecipe> getAllMocktailRecipes() {
        return  mocktailMenu.readAllMocktailRecipes();
    }

    public MocktailRecipe createMocktailRecipe(int id, String name, List<Ingredient> ingredients, String instructions) {
        return mocktailMenu.createMocktailRecipe(new MocktailRecipe(id, name, instructions, ingredients));
    }
    public void deleteMocktailRecipe(int id) {
        //TODO: convert id to Integer
        mocktailMenu.deleteMocktailRecipe(id);
    }

    public void updateMocktailRecipe(int id, String name, List<Ingredient> ingredients, String instructions) {
        //TODO: convert ingredients-String to Ingredients[]
        mocktailMenu.updateMocktailRecipe(id, new MocktailRecipe(id, name, instructions, ingredients));
    }
}
