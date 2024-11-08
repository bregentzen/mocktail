package de.hsos.swa.mocktail.boundary;

import de.hsos.swa.mocktail.acl.MocktailRecipeDTO;
import de.hsos.swa.mocktail.bl.MocktailRecipe;

public class MocktailRecipeKonverter {
    public static MocktailRecipeDTO convertToDTO(MocktailRecipe mocktailRecipe) {
        StringBuilder ingredientBuilder = new StringBuilder();
        for (int i = 0; i < mocktailRecipe.getIngredients().length; i++) {
            ingredientBuilder.append(mocktailRecipe.getIngredients()[i]).append(",");
        }
        String ingredient = ingredientBuilder.toString();
        if (!ingredient.isEmpty()) {
            ingredient = ingredient.substring(0, ingredient.length() - 1);
        }
        return new MocktailRecipeDTO(String.valueOf(mocktailRecipe.getId()), mocktailRecipe.getName(), mocktailRecipe.getPreparation(), ingredient);
    }
}
