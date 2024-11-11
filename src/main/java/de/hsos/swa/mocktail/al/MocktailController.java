package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.Ingredient;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Dependent
public class MocktailController implements CreateMocktailRecipe, ReadMocktailRecipe, UpdateMocktailRecipe, DeleteMocktailRecipe {

    @Inject
    MockTailService mockTailService;

    @Override
    public MocktailRecipe createMocktailRecipe(int id, String name, List<Ingredient> ingredients, String instructions) {

        return mockTailService.createMocktailRecipe(id, name, ingredients, instructions);
    }

    @Override
    public void deleteMocktailRecipe(int id) {
        mockTailService.deleteMocktailRecipe(id);
    }

    @Override
    public MocktailRecipe readMocktailRecipe(int id) {
        return mockTailService.getMocktailRecipe(id);
    }

    @Override
    public Map<Integer, MocktailRecipe> readAllMocktailRecipes() {
        return mockTailService.getAllMocktailRecipes();
    }

    @Override
    public void updateMocktailRecipe(int id, String name, List<Ingredient> ingredients, String instructions) {
        mockTailService.updateMocktailRecipe(id,
                name, ingredients, instructions);
    }
}
