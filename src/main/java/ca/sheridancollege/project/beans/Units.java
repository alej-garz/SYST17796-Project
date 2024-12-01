package ca.sheridancollege.project.beans;

import lombok.Getter;

@Getter
public enum Units {
    KG("Kilograms"),
    LITERS("Liters"),
    PIECES("Pieces"),
    OZ("Ounces"),
    G("Grams"),
    ROLLS("Rolls"); 

    private final String description;

    Units(String description) {
        this.description = description;
    }
}
