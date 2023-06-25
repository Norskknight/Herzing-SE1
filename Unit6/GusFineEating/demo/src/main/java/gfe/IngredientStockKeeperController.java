package gfe;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class IngredientStockKeeperController {
    
    @FXML
    private TextField ingredientNameTextField;
    
    @FXML
    private TextField quantityTextField;
    
    @FXML
    private TableView<Ingredient> ingredientTable;
    
    // ... other controller code
    
    @FXML
    private void addIngredient() {
        String ingredientName = ingredientNameTextField.getText();
        String quantity = quantityTextField.getText();
        
        // Validate input and perform necessary operations
        if (ingredientName.isEmpty() || quantity.isEmpty()) {
            // Display an error message or handle the invalid input
        } else {
            // Create a new Ingredient object
            Ingredient ingredient = new Ingredient(ingredientName, quantity);
            // Add the ingredient to the table view or update the existing ingredient
            // Clear the input fields
            ingredientNameTextField.clear();
            quantityTextField.clear();
        }
    }
    
    // ... other controller methods and code
}
