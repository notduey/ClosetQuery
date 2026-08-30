package dev.notduey.closetquery.model;

/**
 * Represents one clothing piece in the wardrobe.
 *
 * <p>The object stores both descriptive information used for retrieval and
 * database-managed information such as its ID, date added, and wear history.</p>
 *
 * <p>New pieces can be created directly, while pieces that already exist in
 * SQLite are reconstructed through factory methods.</p>
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

    /**
     * Creates a new wardrobe piece before it has been saved to SQLite.
     *
     * <p>Database-managed fields such as ID, date added, last worn date, and wear
     * count are left unset so SQLite can apply its defaults when the piece is
     * inserted.</p>
     *
     * @param brand piece brand
     * @param name piece name
     * @param category wardrobe category
     * @param size piece size
     * @param color normalized color category
     * @param colorway exact colorway, if applicable
     * @param season intended season
     * @param occasion intended occasion
     * @param fit piece fit
     * @param materials piece materials
     * @param notes optional notes
     */
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

    /**
     * Reconstructs a complete Piece from a row already stored in SQLite.
     *
     * <p>This factory is mainly used by the repository when mapping database
     * results back into Java objects.</p>
     *
     * @param id database ID
     * @param brand piece brand
     * @param name piece name
     * @param category wardrobe category
     * @param size piece size
     * @param color normalized color category
     * @param colorway exact colorway, if applicable
     * @param season intended season
     * @param occasion intended occasion
     * @param fit piece fit
     * @param materials piece materials
     * @param notes optional notes
     * @param dateAdded date the piece was added to ClosetQuery
     * @param lastWorn most recent worn date, if known
     * @param timesWorn total recorded wear count
     * @return Piece populated with database values
     */
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

    /**
     * Creates a piece that already has wear history but has not yet been saved
     * to ClosetQuery.
     *
     * <p>The database still assigns the real ID and date added when the piece is
     * inserted, while the supplied last-worn date and wear count are preserved.</p>
     *
     * @param brand piece brand
     * @param name piece name
     * @param category wardrobe category
     * @param size piece size
     * @param color normalized color category
     * @param colorway exact colorway, if applicable
     * @param season intended season
     * @param occasion intended occasion
     * @param fit piece fit
     * @param materials piece materials
     * @param notes optional notes
     * @param lastWorn most recent worn date, if known
     * @param timesWorn existing wear count
     * @return Piece ready to be inserted as an existing wardrobe item
     */
    public static Piece existing(
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
        String lastWorn,
        int timesWorn
    ) {
        return new Piece(
            0, // database assigns real id when inserted
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
            null,
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