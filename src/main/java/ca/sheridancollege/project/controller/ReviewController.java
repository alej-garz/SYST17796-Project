package ca.sheridancollege.project.controller;

import ca.sheridancollege.project.beans.Review;
import ca.sheridancollege.project.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {
    @Autowired
    private DatabaseAccess da;

    @GetMapping("/reviews")
    public String reviews(Model model) {
        List<Review> reviewList = da.getReviewsList();
        model.addAttribute("reviews", reviewList);

        return "reviews";
    }
}
