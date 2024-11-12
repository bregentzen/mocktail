package de.hsos.swa.drink.al;

import java.util.List;

public interface UpdateDrinkRecipe {
    void updateDrinkRecipe(int id, String name, List<String> ingredients, String instructions);
}
