package de.hsos.swa.mocktail.bl;

public class MocktailRecipe {
    private int id;
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


}
