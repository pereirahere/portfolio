package org.academiadecodigo.roundabout.model;

public class Review {

    private User author;
    private Roundabout target;
    private String reviewText;
    private Integer rating;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Roundabout getTarget() {
        return target;
    }

    public void setTarget(Roundabout target) {
        this.target = target;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
