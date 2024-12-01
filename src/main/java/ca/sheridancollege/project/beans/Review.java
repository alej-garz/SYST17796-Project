package ca.sheridancollege.project.beans;

import lombok.Data;

@Data
public class Review {
    private String author;
    private String description;
    private ReviewCategory rating;
}
