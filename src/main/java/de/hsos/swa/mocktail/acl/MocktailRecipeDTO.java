package de.hsos.swa.mocktail.acl;

public class MocktailRecipeDTO {
    private String id;
    private String name;
    private String preparation;
    private String ingredients;

    public MocktailRecipeDTO(String id, String name, String preparation, String ingredients) {
        this.id = id;
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
