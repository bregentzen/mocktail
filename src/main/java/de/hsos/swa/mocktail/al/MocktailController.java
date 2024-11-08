package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.Map;

@Dependent
public class MocktailController implements CreateMocktailRecipe, ReadMocktailRecipe, UpdateMocktailRecipe, DeleteMocktailRecipe {

    @Inject
    MockTailService mockTailService;

    @Override
    public MocktailRecipe createMocktailRecipe(String name, String ingredients, String instructions) {

        return mockTailService.createMocktailRecipe(name, ingredients, instructions);
    }

    @Override
    public void deleteMocktailRecipe(int id) {
        mockTailService.deleteMocktailRecipe(id);
    }

    @Override
    public MocktailRecipe readMocktailRecipe(String id) {
        return mockTailService.getMocktailRecipe(id);
    }

    @Override
    public Map<Integer, MocktailRecipe> readAllMocktailRecipes() {
        return mockTailService.getAllMocktailRecipes();
    }

    @Override
    public void updateMocktailRecipe(String id, String name, String ingredients, String instructions) {
        mockTailService.updateMocktailRecipe(Integer.parseInt(id),
                name, instructions, ingredients);
    }

}
