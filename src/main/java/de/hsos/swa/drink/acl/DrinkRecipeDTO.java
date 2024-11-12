package de.hsos.swa.drink.acl;

import java.util.List;

public class DrinkRecipeDTO {

    private String name;
    private String preparation;
    private List<String> ingredients;

    public DrinkRecipeDTO() {}

    public DrinkRecipeDTO(String name, String preparation, List<String> ingredients) {
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}