package de.hsos.swa.drink.al;

import de.hsos.swa.drink.acl.DrinkRecipeConverter;
import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.bl.DrinkService;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Dependent
public class DrinkController implements CreateDrinkRecipe, ReadDrinkRecipe, UpdateDrinkRecipe, DeleteDrinkRecipe {

    @Inject
    DrinkService drinkService;

    @Override
    public DrinkRecipeDTO createDrinkRecipe(DrinkRecipeDTO drinkRecipeDTO) {


        return DrinkRecipeConverter.convertToDTO(drinkService.createDrinkRecipe(
                drinkRecipeDTO.getName(),
                drinkRecipeDTO.getIngredients(),
                drinkRecipeDTO.getPreparation()
        ));
    }

    @Override
    public boolean deleteDrinkRecipe(int id) {
        return drinkService.deleteDrinkRecipe(id);
    }

    @Override
    public DrinkRecipeDTO readDrinkRecipe(int id) {
        return DrinkRecipeConverter.convertToDTO(drinkService.getDrinkRecipe(id));
    }

    @Override
    public List<DrinkRecipeDTO> readAllDrinkRecipes() {
       return drinkService.getAllDrinkRecipes().values().stream().map(DrinkRecipeConverter::convertToDTO).toList();
    }

    @Override
    public List<DrinkRecipeDTO> readAllCocktailRecipes() {
       return drinkService.getAllCocktailRecipes().stream().map(DrinkRecipeConverter::convertToDTO).toList();
    }

    @Override
    public List<DrinkRecipeDTO> readAllMocktailRecipes() {
        return drinkService.getAllMocktailRecipes().stream().map(DrinkRecipeConverter::convertToDTO).toList();
    }

    @Override
    public void updateDrinkRecipe(int id, String name, List<String> ingredients, String instructions) {
        drinkService.editDrinkRecipe(id,
                name, ingredients, instructions);
    }
}
