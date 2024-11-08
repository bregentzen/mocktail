package de.hsos.swa.mocktail.boundary;

import de.hsos.swa.mocktail.acl.MocktailRecipeDTO;
import de.hsos.swa.mocktail.bl.MocktailRecipe;

import java.util.List;

public class MocktailRecipeKonverter {
    /*public static MocktailRecipeDTO convertToDTO(MocktailRecipe mocktailRecipe) {
        StringBuilder ingredients = new StringBuilder();
        if (mocktailRecipe.getIngredients() != null) {
            for (int i = 0; i < mocktailRecipe.getIngredients().length; i++) {
                ingredients.append(mocktailRecipe.getIngredients()[i]);
                if (i < mocktailRecipe.getIngredients().length - 1) {
                    ingredients.append(",");
                }
            }
        }
        return new MocktailRecipeDTO(String.valueOf(mocktailRecipe.getId()), mocktailRecipe.getName(), mocktailRecipe.getPreparation(), ingredients.toString());
    }*/

    public static MocktailRecipeDTO convertToDTO(MocktailRecipe mocktailRecipe) {
        StringBuilder ingredients = new StringBuilder();
        if (mocktailRecipe.getIngredients() != null) {
            for (int i = 0; i < mocktailRecipe.getIngredients().size(); i++) {
                ingredients.append(mocktailRecipe.getIngredients().get(i));
                if (i < mocktailRecipe.getIngredients().size() - 1) {
                    ingredients.append(",");
                }
            }
        }
        return new MocktailRecipeDTO(
                String.valueOf(mocktailRecipe.getId()),
                mocktailRecipe.getName(),
                mocktailRecipe.getPreparation(),
                ingredients.toString()
        );
    }

    public static MocktailRecipe convertToEntity(MocktailRecipeDTO mocktailRecipeDTO) {
        return new MocktailRecipe(
                Integer.parseInt(mocktailRecipeDTO.getId()),
                mocktailRecipeDTO.getName(),
                mocktailRecipeDTO.getPreparation(),
                List.of(mocktailRecipeDTO.getIngredients().split(","))
        );
    }
}
