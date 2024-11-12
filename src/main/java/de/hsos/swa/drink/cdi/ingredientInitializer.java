package de.hsos.swa.drink.cdi;

import de.hsos.swa.drink.bl.Ingredient;
import jakarta.enterprise.inject.Produces;
import org.jboss.logging.Logger;

import java.util.HashMap;

public class ingredientInitializer {
    private static final Logger logging = Logger.getLogger(ingredientInitializer.class);

    @Produces
    public static HashMap<String, Ingredient> initializeIngredients() {
        HashMap<String, Ingredient> ingredients = new HashMap<>();

        ingredients.put("Simple Syrup", new Ingredient("Simple Syrup", false));
        ingredients.put("Sugar", new Ingredient("Sugar", false));
        ingredients.put("Water", new Ingredient("Water", false));
        ingredients.put("Lemon Juice", new Ingredient("Lemon Juice", false));
        ingredients.put("Gin", new Ingredient("Gin", true));
        ingredients.put("Tonic Water", new Ingredient("Tonic Water", false));
        ingredients.put("Ice", new Ingredient("Ice", false));
        ingredients.put("Mint", new Ingredient("Mint", false));
        ingredients.put("Cucumber", new Ingredient("Cucumber", false));
        ingredients.put("Lime Juice", new Ingredient("Lime Juice", false));
        ingredients.put("Cointreau", new Ingredient("Cointreau", true));
        ingredients.put("Vodka", new Ingredient("Vodka", true));
        ingredients.put("Cranberry Juice", new Ingredient("Cranberry Juice", false));
        ingredients.put("Orange Juice", new Ingredient("Orange Juice", false));
        ingredients.put("Pineapple Juice", new Ingredient("Pineapple Juice", false));
        ingredients.put("Grenadine", new Ingredient("Grenadine", false));
        ingredients.put("Cola", new Ingredient("Cola", false));
        ingredients.put("Rum", new Ingredient("Rum", true));
        ingredients.put("Whiskey", new Ingredient("Whiskey", true));
        ingredients.put("Bourbon", new Ingredient("Bourbon", true));
        ingredients.put("Brandy", new Ingredient("Brandy", true));
        ingredients.put("Cognac", new Ingredient("Cognac", true));
        ingredients.put("Champagne", new Ingredient("Champagne", true));
        ingredients.put("Prosecco", new Ingredient("Prosecco", true));
        ingredients.put("Sparkling Wine", new Ingredient("Sparkling Wine", true));
        ingredients.put("Red Wine", new Ingredient("Red Wine", true));
        ingredients.put("White Wine", new Ingredient("White Wine", true));
        ingredients.put("Rosé Wine", new Ingredient("Rosé Wine", true));
        ingredients.put("Beer", new Ingredient("Beer", true));
        ingredients.put("Cider", new Ingredient("Cider", true));
        ingredients.put("Ale", new Ingredient("Ale", true));
        ingredients.put("Lager", new Ingredient("Lager", true));
        ingredients.put("Stout", new Ingredient("Stout", true));
        ingredients.put("Porter", new Ingredient("Porter", true));
        ingredients.put("Pilsner", new Ingredient("Pilsner", true));
        ingredients.put("IPA", new Ingredient("IPA", true));
        ingredients.put("Sake", new Ingredient("Sake", true));
        ingredients.put("Absynthe", new Ingredient("Absynthe", true));
        ingredients.put("Kahlua", new Ingredient("Kahlua", true));
        ingredients.put("Baileys", new Ingredient("Baileys", true));
        ingredients.put("Korn", new Ingredient("Korn", true));
        ingredients.put("Jägermeister", new Ingredient("Jägermeister", true));
        ingredients.put("Campari", new Ingredient("Campari", true));
        ingredients.put("Aperol", new Ingredient("Aperol", true));
        ingredients.put("Triple Sec", new Ingredient("Triple Sec", true));
        ingredients.put("Curacao", new Ingredient("Curacao", true));
        ingredients.put("Tabasco", new Ingredient("Tabasco", false));
        ingredients.put("Worcestershire Sauce", new Ingredient("Worcestershire Sauce", false));
        ingredients.put("Coconut Cream", new Ingredient("Coconut Cream", false));
        ingredients.put("Cream", new Ingredient("Cream", false));
        ingredients.put("Milk", new Ingredient("Milk", false));
        ingredients.put("Egg White", new Ingredient("Egg White", false));
        ingredients.put("Egg Yolk", new Ingredient("Egg Yolk", false));
        ingredients.put("Vanilla Extract", new Ingredient("Vanilla Extract", false));
        ingredients.put("Cinnamon", new Ingredient("Cinnamon", false));
        ingredients.put("Nutmeg", new Ingredient("Nutmeg", false));
        ingredients.put("Bitters", new Ingredient("Bitters", false));
        ingredients.put("Soda", new Ingredient("Soda", false));

        logging.info("Ingredients initialized");
        logging.trace("Ingredients: " + ingredients);
        return ingredients;
    }
}
