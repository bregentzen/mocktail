package de.hsos.swa.drink.bl;

public class Ingredient {
    private final String name;
    private final boolean isAlcoholic;
    public Ingredient(String name, boolean isAlcoholic){
        this.name = name;
        this.isAlcoholic = isAlcoholic;
    }

    public String getName() {
        return name;
    }
    public boolean getIsAlcoholic(){
        return isAlcoholic;
    }
}
