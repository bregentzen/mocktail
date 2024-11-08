package de.hsos.swa.mocktail.al;

public class MocktailController implements CreateMocktailRecipe, ReadMocktailRecipe, UpdateMocktailRecipe, DeleteMocktailRecipe {

    @Override
    public int createMocktailRecipe(String name, String ingredients, String instructions) {
        return 0;
    }

    @Override
    public void deleteMocktailRecipe(String id) {

    }

    @Override
    public void readMocktailRecipe(String id) {

    }

    @Override
    public void readAllMocktailRecipes() {

    }

    @Override
    public void updateMocktailRecipe(String id, String name, String ingredients, String instructions) {

    }
}
