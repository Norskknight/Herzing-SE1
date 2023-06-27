package gfe.database;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableView;

import javafx.util.converter.IntegerStringConverter;

@Component
public class IngredientStockKeeperController {

    @Autowired private IngredientControler IC;
    @FXML
    private TextField ingredientNameTextField;
    
    @FXML
    private TextField quantityTextField;
    
    @FXML
    private TableView<Ingredient> ingredientTable;
    @FXML private TableColumn<Ingredient, String> nameColumn;
    
    @FXML private TableColumn<Ingredient, Integer> quantityColumn;
    private ObservableList<Ingredient> IList;
    // ... other controller code

public void initialize(){
    IList = (FXCollections.observableArrayList(IC.findAll()));
	ingredientTable.setItems(IList);
   

    
    nameColumn.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
    quantityColumn.setCellValueFactory(new PropertyValueFactory<Ingredient, Integer>("count"));
    quantityColumn.setEditable(true);
    ingredientTable.setEditable(true);
    nameColumn.setEditable(true);
    nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

    ingredientTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }   

    //dubble click to edit
    public void changeIngredeantName(CellEditEvent editedCell){
         Ingredient ingredientSelected = ingredientTable.getSelectionModel().getSelectedItem();
         ingredientSelected.setName(editedCell.getNewValue().toString());
         edit(ingredientSelected);
    }
    //dubble click to edit
    public void changeIngredeantQuantity(CellEditEvent<Ingredient,Integer> editedCell){
         Ingredient ingredientSelected = ingredientTable.getSelectionModel().getSelectedItem();
         ingredientSelected.setCount((int)editedCell.getNewValue());
         edit(ingredientSelected);
    }

    @FXML
    private void deleteButtonPushed(){
    ObservableList<Ingredient> selectedRows, allIngredients;
        allIngredients = ingredientTable.getItems();

         selectedRows = ingredientTable.getSelectionModel().getSelectedItems();

          for (Ingredient ingredient: selectedRows)
        {
            IC.delete(ingredient.getId());
        }
        IList = (FXCollections.observableArrayList(IC.findAll()));
	    ingredientTable.setItems(IList); 
    }
    @FXML
    private void edit(Ingredient ingredient){
        System.out.println(ingredient.getName());
        IC.update(ingredient);
        IList = (FXCollections.observableArrayList(IC.findAll()));
	    ingredientTable.setItems(IList);
    }
    
    @FXML
    private void addIngredient() {
        String ingredientName = ingredientNameTextField.getText();
        Integer quantity = Integer.valueOf(quantityTextField.getText());
        
        // Validate input and perform necessary operations
        if (ingredientName.isEmpty() || quantity == null) {
            // Display an error message or handle the invalid input
        } else {
            // Create a new Ingredient object
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientName);
            ingredient.setCount(quantity);
           
            // Add the ingredient to the table view or update the existing ingredient
            IC.save(ingredient);
            IList = (FXCollections.observableArrayList(IC.findAll()));
	        ingredientTable.setItems(IList);
            // Clear the input fields
            ingredientNameTextField.clear();
            quantityTextField.clear();
        }
    }
    
    // ... other controller methods and code
}
