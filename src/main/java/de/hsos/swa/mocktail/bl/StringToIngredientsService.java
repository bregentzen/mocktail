package de.hsos.swa.mocktail.bl;

import java.util.ArrayList;
import java.util.List;

public class StringToIngredientsService {
    public static List<String> convert(String ingredientString) {
        List<String> ingredientArray = new ArrayList<>(ingredientString.split(",").length);
        for (int i = 0; i < ingredientString.split(",").length; i++) {
            ingredientArray.set(i,String.valueOf(Ingredient.valueOf(ingredientString.split(",")[i])));
        }
        return ingredientArray;
    }
}
