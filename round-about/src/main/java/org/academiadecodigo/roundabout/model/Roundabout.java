package org.academiadecodigo.roundabout.model;

public class Roundabout {

    private String name;
    private String xCoord;
    private String yCoord;
    private Integer id;
    private Double[] coordinates;
    private Integer avgRating;
    private Integer timesReviewed;

    public Roundabout() {
        coordinates = new Double[2];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double[] getCoordinates(){

        coordinates[0] = Double.parseDouble(xCoord);
        coordinates[1] = Double.parseDouble(yCoord);

        return coordinates;
    }

    public void setxCoord(String xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(String yCoord) {
        this.yCoord = yCoord;
    }

    public String getxCoord() {
        return xCoord;
    }

    public String getyCoord() {
        return yCoord;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }

    public Integer getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Integer avgRating) {
        this.avgRating = avgRating;
    }

    public Integer getTimesReviewed() {
        return timesReviewed;
    }

    public void setTimesReviewed(Integer timesReviewed) {
        this.timesReviewed = timesReviewed;
    }
}
