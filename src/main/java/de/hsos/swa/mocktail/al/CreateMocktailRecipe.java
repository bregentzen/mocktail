package de.hsos.swa.mocktail.al;

import de.hsos.swa.mocktail.bl.MocktailRecipe;

public interface CreateMocktailRecipe {
    public MocktailRecipe createMocktailRecipe(String name, String ingredients, String instructions);
}
