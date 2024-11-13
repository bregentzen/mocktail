package de.hsos.swa.drink.acl;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Schema(name = "DrinkRecipe", description = "Data Transfer Object for safe usage of data")
public class DrinkRecipeDTO {

    @Schema(required = true, example = "Doppelter Daniel")
    private String name;
    @Schema(required = true, example = "Viel hilft viel")
    private String preparation;
    @Schema(required = true, example = "[\"Jägermeister\", \"Jägermeister\", \"Beer\"]")
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