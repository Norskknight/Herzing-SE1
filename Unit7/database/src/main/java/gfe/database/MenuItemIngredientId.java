package gfe.database;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class MenuItemIngredientId implements Serializable {
    private int menuItemId;
    private int ingredientId;

    // Constructors, equals, and hashCode methods

    // ...
}
