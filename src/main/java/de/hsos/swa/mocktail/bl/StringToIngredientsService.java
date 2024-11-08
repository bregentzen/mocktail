package de.hsos.swa.mocktail.bl;

public class StringToIngredientsService {
    public static Ingredient[] convert(String ingredientString) {
        Ingredient[] ingredientArray = new Ingredient[ingredientString.split(",").length];
        for (int i = 0; i < ingredientString.split(",").length; i++) {
            ingredientArray[i] = Ingredient.valueOf(ingredientString.split(",")[i]);
        }
        return ingredientArray;
    }
}
