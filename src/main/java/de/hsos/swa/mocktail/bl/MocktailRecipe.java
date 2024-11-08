package de.hsos.swa.mocktail.bl;

import jakarta.inject.Inject;


public class MocktailRecipe {

    @Inject
    int id;
    private String name;
    private String preparation;
    private Ingredient[] ingredients;

    public MocktailRecipe(String name, String preparation, Ingredient[] ingredients) {
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreparation() {
        return preparation;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Ingredient[] ingredientArray) {
        this.ingredients = ingredientArray;
    }

    public void setInstructions(String preparation) {
        this.preparation = preparation;
    }
}
