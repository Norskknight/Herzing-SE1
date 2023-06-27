package gfe.database;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_item_ingredients")
public class MenuItemIngredient {

    @EmbeddedId
    private MenuItemIngredientId id;

    @ManyToOne
    @MapsId("menuItemId")
    private MenuItem menuItem;

    @ManyToOne
    @MapsId("ingredientId")
    private Ingredient ingredient;

    private int count;

    public MenuItemIngredientId getId() {
        return id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // Constructors, getters, and setters

    // ...
}
