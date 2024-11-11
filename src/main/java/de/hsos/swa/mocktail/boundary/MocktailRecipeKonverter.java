package de.hsos.swa.mocktail.boundary;

import de.hsos.swa.mocktail.acl.MocktailRecipeDTO;
import de.hsos.swa.mocktail.bl.MocktailRecipe;

public class MocktailRecipeKonverter {
    public static MocktailRecipeDTO convertToDTO(MocktailRecipe mocktailRecipe) {
        return new MocktailRecipeDTO(mocktailRecipe.getId(), mocktailRecipe.getName(), mocktailRecipe.getPreparation(), mocktailRecipe.getIngredients());
    }

    public static MocktailRecipe convertToEntity(MocktailRecipeDTO mocktailRecipeDTO) {
        return new MocktailRecipe(0, mocktailRecipeDTO.getName(), mocktailRecipeDTO.getPreparation(), mocktailRecipeDTO.getIngredients());
    }
}