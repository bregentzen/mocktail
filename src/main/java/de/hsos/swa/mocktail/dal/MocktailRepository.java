package de.hsos.swa.mocktail.dal;

import de.hsos.swa.mocktail.bl.MocktailMenu;
import de.hsos.swa.mocktail.bl.MocktailRecipe;

public class MocktailRepository implements MocktailMenu {
    @Override
    public int createMocktailRecipe(String name, String ingredients, String instructions) {
        return 0;
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
