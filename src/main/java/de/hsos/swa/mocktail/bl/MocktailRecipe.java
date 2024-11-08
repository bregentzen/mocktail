package de.hsos.swa.mocktail.bl;

import java.util.List;

public class MocktailRecipe {
    private int id;
    private String name;
    private String preparation;
    private List<String> ingredients;

    public MocktailRecipe(String name, String preparation, List<String> ingredients) {
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }
    // Konstruktoren
    public MocktailRecipe(int id, String name, String preparation, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    // Getter und Setter
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}