package edu.bellevue.huskygpt.model;

/**
 * Represents an individual piece in the wardrobe
 */
public class Piece {

    private int id; // database id

    private String brand;
    private String name;
    private String category;
    private String size;

    private String color; // normalized color category
    private String colorway; // exact colorway, if applicable

    private String season;
    private String occasion;
    private String fit;

    private String materials;
    private String notes;

    private String dateAdded;
    private String lastWorn;

    private int timesWorn;

    // Overloading constructors become inconvenient with many parameters
    // Creating setters is valid, but weakens encapsulation
    // Eventually, separate creation and update methods will be implemented

    // Constructor
    public Piece(
        String brand,
        String name,
        String category,
        String size,
        String color,
        String colorway,
        String season,
        String occasion,
        String fit,
        String materials,
        String notes
    ) {
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.size = size;
        this.color = color;
        this.colorway = colorway;
        this.season = season;
        this.occasion = occasion;
        this.fit = fit;
        this.materials = materials;
        this.notes = notes;
    }

    // Private constructor
    private Piece(
        int id,
        String brand,
        String name,
        String category,
        String size,
        String color,
        String colorway,
        String season,
        String occasion,
        String fit,
        String materials,
        String notes,
        String dateAdded,
        String lastWorn,
        int timesWorn
    ) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.size = size;
        this.color = color;
        this.colorway = colorway;
        this.season = season;
        this.occasion = occasion;
        this.fit = fit;
        this.materials = materials;
        this.notes = notes;
        this.dateAdded = dateAdded;
        this.lastWorn = lastWorn;
        this.timesWorn = timesWorn;
    }

    // Factory method
    // Uses private constructor to create Piece that already exists in SQLite
    public static Piece fromDatabase(
        int id,
        String brand,
        String name,
        String category,
        String size,
        String color,
        String colorway,
        String season,
        String occasion,
        String fit,
        String materials,
        String notes,
        String dateAdded,
        String lastWorn,
        int timesWorn
    ) {
        return new Piece(
            id,
            brand,
            name,
            category,
            size,
            color,
            colorway,
            season,
            occasion,
            fit,
            materials,
            notes,
            dateAdded,
            lastWorn,
            timesWorn
        );
    }

    // getters

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getColorway() {
        return colorway;
    }

    public String getSeason() {
        return season;
    }

    public String getOccasion() {
        return occasion;
    }

    public String getFit() {
        return fit;
    }

    public String getMaterials() {
        return materials;
    }

    public String getNotes() {
        return notes;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getLastWorn() {
        return lastWorn;
    }

    public int getTimesWorn() {
        return timesWorn;
    }

}