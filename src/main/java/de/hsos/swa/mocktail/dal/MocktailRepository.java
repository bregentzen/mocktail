package de.hsos.swa.mocktail.dal;

import de.hsos.swa.mocktail.bl.MocktailMenu;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.HashMap;

@ApplicationScoped
public class MocktailRepository implements MocktailMenu {
    private final Map<Integer, MocktailRecipe> mocktailRecipes;

    public MocktailRepository() {
        this.mocktailRecipes = new HashMap<>();
    }

    @Override
    public MocktailRecipe createMocktailRecipe(MocktailRecipe mocktailRecipe) {
        this.mocktailRecipes.put(mocktailRecipe.getId(), mocktailRecipe);
        return mocktailRecipe;
    }

    @Override
    public MocktailRecipe readMocktailRecipe(int id) {
        return this.mocktailRecipes.get(id);
    }

    @Override
    public HashMap<Integer, MocktailRecipe> readAllMocktailRecipes() {
        return (HashMap<Integer, MocktailRecipe>) this.mocktailRecipes;
    }

    @Override
    public void deleteMocktailRecipe(int id) {
        this.mocktailRecipes.remove(id);
    }

    @Override
    public void updateMocktailRecipe(int id,MocktailRecipe mocktailRecipe) {
        this.mocktailRecipes.put(id, mocktailRecipe);
    }
}
