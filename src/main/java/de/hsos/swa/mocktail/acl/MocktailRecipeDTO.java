package de.hsos.swa.mocktail.acl;

import de.hsos.swa.mocktail.bl.Ingredient;
import java.util.List;

public class MocktailRecipeDTO {
    private int id;
    private String name;
    private String preparation;
    private List<Ingredient> ingredients;

    public MocktailRecipeDTO() {}

    public MocktailRecipeDTO(int id, String name, String preparation, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}