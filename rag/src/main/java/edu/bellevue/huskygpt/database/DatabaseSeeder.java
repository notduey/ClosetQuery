package edu.bellevue.huskygpt.database;

import edu.bellevue.huskygpt.model.Piece;

/**
 * Populates the database with varied sample wardrobe pieces for testing.
 */
public class DatabaseSeeder {

    public static void seed() {
        PieceRepository repository = new PieceRepository();

        try {
            // Tops
            addExisting(
                    repository,
                    "Stussy",
                    "8-Ball Knit Sweater",
                    "Top",
                    "XS",
                    "Beige",
                    "Cream Ivory",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Acrylic, Nylon, Wool, Mohair",
                    "Heavy knitted sweater suitable for colder weather",
                    "2026-08-18",
                    8
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "AIRism Oversized T-Shirt",
                    "Top",
                    "M",
                    "White",
                    null,
                    "Spring/Summer",
                    "Everyday",
                    "Oversized",
                    "Cotton and polyester blend",
                    "Lightweight breathable shirt for hot weather",
                    "2026-08-27",
                    34
            );

            addExisting(
                    repository,
                    "COS",
                    "Relaxed Linen Shirt",
                    "Top",
                    "M",
                    "Beige",
                    null,
                    "Spring/Summer",
                    "Casual",
                    "Oversized",
                    "Linen",
                    "Breathable lightweight shirt suited for warm weather",
                    "2026-08-21",
                    12
            );

            addExisting(
                    repository,
                    "Polo Ralph Lauren",
                    "Classic Fit Oxford Shirt",
                    "Top",
                    "M",
                    "Blue",
                    "Light Blue",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Classic button-up shirt suitable for smart casual outfits",
                    "2026-07-19",
                    7
            );

            addExisting(
                    repository,
                    "Nike",
                    "Sportswear Club Fleece Hoodie",
                    "Top",
                    "M",
                    "Gray",
                    "Dark Grey Heather",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton and polyester",
                    "Warm fleece hoodie for everyday casual wear",
                    "2026-08-24",
                    29
            );

            addExisting(
                    repository,
                    "Champion",
                    "Reverse Weave Hoodie",
                    "Top",
                    "M",
                    "Gray",
                    "Oxford Gray",
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Cotton and polyester",
                    "Heavyweight hoodie useful for cool weather",
                    "2026-07-30",
                    14
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Chase Sweatshirt",
                    "Top",
                    "M",
                    "Black",
                    null,
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton and polyester",
                    "Simple heavyweight sweatshirt for layering",
                    "2026-08-11",
                    17
            );

            addExisting(
                    repository,
                    "Supreme",
                    "Box Logo Tee",
                    "Top",
                    "M",
                    "White",
                    null,
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Graphic cotton T-shirt for casual outfits",
                    "2026-08-03",
                    9
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Cormac Crew",
                    "Top",
                    "M",
                    "Blue",
                    "Dark Blue",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester",
                    "Lightweight technical shirt suitable for hiking and activity",
                    "2026-08-26",
                    20
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Capilene Cool Daily Shirt",
                    "Top",
                    "M",
                    "Blue",
                    null,
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled polyester",
                    "Quick-drying technical shirt for hiking and warm weather",
                    "2026-08-25",
                    18
            );

            // Bottoms
            addExisting(
                    repository,
                    "Levi's",
                    "501 Original Fit Jeans",
                    "Bottom",
                    "32x30",
                    "Blue",
                    "Medium Wash",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton denim",
                    "Classic straight denim jeans for everyday wear",
                    "2026-08-23",
                    41
            );

            addExisting(
                    repository,
                    "Adidas",
                    "Adicolor Classics Firebird Track Pants",
                    "Bottom",
                    "M",
                    "Black",
                    null,
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Polyester",
                    "Lightweight athletic track pants for casual wear",
                    "2026-08-20",
                    25
            );

            addExisting(
                    repository,
                    "Nike",
                    "Club Fleece Joggers",
                    "Bottom",
                    "M",
                    "Gray",
                    "Dark Grey Heather",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton and polyester",
                    "Warm casual sweatpants for cool weather",
                    "2026-08-28",
                    36
            );

            addExisting(
                    repository,
                    "Dickies",
                    "874 Original Work Pants",
                    "Bottom",
                    "32x30",
                    "Black",
                    null,
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Polyester and cotton",
                    "Durable structured work pants for everyday outfits",
                    "2026-08-17",
                    22
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Newel Pant",
                    "Bottom",
                    "32",
                    "Brown",
                    "Hamilton Brown",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Relaxed casual pants with durable construction",
                    "2026-08-09",
                    13
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "Wide-Fit Parachute Cargo Pants",
                    "Bottom",
                    "M",
                    "Green",
                    "Olive",
                    "All-Season",
                    "Casual",
                    "Oversized",
                    "Nylon",
                    "Loose lightweight cargo pants with utility pockets",
                    "2026-08-22",
                    19
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Baggies Shorts",
                    "Bottom",
                    "M",
                    "Blue",
                    "Navy",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled nylon",
                    "Lightweight shorts for hiking, water, and hot weather",
                    "2026-08-27",
                    31
            );

            addExisting(
                    repository,
                    "Nike",
                    "Dri-FIT Challenger Shorts",
                    "Bottom",
                    "M",
                    "Black",
                    null,
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester",
                    "Lightweight athletic shorts for running and exercise",
                    "2026-08-26",
                    24
            );

            // Outerwear
            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Detroit Jacket",
                    "Outerwear",
                    "M",
                    "Brown",
                    "Hamilton Brown",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton canvas",
                    "Durable jacket suitable for layering and cool weather",
                    "2026-08-12",
                    16
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Nano Puff Jacket",
                    "Outerwear",
                    "M",
                    "Black",
                    null,
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Recycled polyester",
                    "Lightweight insulated jacket for cold weather and hiking",
                    "2026-08-19",
                    15
            );

            addExisting(
                    repository,
                    "The North Face",
                    "1996 Retro Nuptse Jacket",
                    "Outerwear",
                    "M",
                    "Black",
                    null,
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Nylon and down insulation",
                    "Warm insulated puffer jacket for very cold weather",
                    "2026-02-14",
                    11
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Beta Jacket",
                    "Outerwear",
                    "M",
                    "Black",
                    null,
                    "All-Season",
                    "Casual",
                    "Regular",
                    "GORE-TEX",
                    "Waterproof shell designed for rain, hiking, and mountain conditions",
                    "2026-08-16",
                    10
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Better Sweater Fleece Jacket",
                    "Outerwear",
                    "M",
                    "Gray",
                    null,
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Recycled polyester fleece",
                    "Warm fleece layer for cool weather and casual use",
                    "2026-07-22",
                    12
            );

            addExisting(
                    repository,
                    "Levi's",
                    "Trucker Jacket",
                    "Outerwear",
                    "M",
                    "Blue",
                    "Medium Wash",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton denim",
                    "Classic denim jacket for mild weather",
                    "2026-06-30",
                    9
            );

            addExisting(
                    repository,
                    "Alpha Industries",
                    "MA-1 Bomber Jacket",
                    "Outerwear",
                    "M",
                    "Green",
                    "Sage Green",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Nylon",
                    "Insulated bomber jacket for cool-weather casual outfits",
                    "2026-04-18",
                    6
            );

            // Footwear
            addExisting(
                    repository,
                    "Nike",
                    "Air Max 1",
                    "Footwear",
                    "US 9",
                    "Blue",
                    "University Blue",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Mesh and synthetic materials",
                    "Comfortable breathable sneaker for casual wear",
                    "2026-08-25",
                    32
            );

            addExisting(
                    repository,
                    "Nike",
                    "Air Force 1 '07",
                    "Footwear",
                    "US 9",
                    "White",
                    "Triple White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Leather and rubber",
                    "Versatile white sneaker for everyday outfits",
                    "2026-08-27",
                    48
            );

            addExisting(
                    repository,
                    "Adidas",
                    "Samba OG",
                    "Footwear",
                    "US 9",
                    "White",
                    "Cloud White Core Black",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Leather and suede",
                    "Low-profile casual sneaker suitable for everyday wear",
                    "2026-08-21",
                    27
            );

            addExisting(
                    repository,
                    "New Balance",
                    "990v6",
                    "Footwear",
                    "US 9",
                    "Gray",
                    "Grey",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Mesh and suede",
                    "Comfortable supportive sneaker suited for long walks",
                    "2026-08-28",
                    38
            );

            addExisting(
                    repository,
                    "Dr. Martens",
                    "1461 Smooth Leather Oxford Shoes",
                    "Footwear",
                    "US 9",
                    "Black",
                    "Smooth Black",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Leather",
                    "Structured leather shoes suited for dressier outfits",
                    "2026-06-20",
                    5
            );

            addExisting(
                    repository,
                    "Converse",
                    "Chuck 70 High Top",
                    "Footwear",
                    "US 9",
                    "Black",
                    "Black Egret",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Canvas and rubber",
                    "Classic high-top sneaker for casual everyday wear",
                    "2026-08-10",
                    21
            );

            addExisting(
                    repository,
                    "Salomon",
                    "XT-6",
                    "Footwear",
                    "US 9",
                    "Black",
                    "Black Phantom",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Mesh and synthetic materials",
                    "Technical trail-inspired shoe suitable for hiking and walking",
                    "2026-08-24",
                    17
            );

            addExisting(
                    repository,
                    "Birkenstock",
                    "Arizona",
                    "Footwear",
                    "US 9",
                    "Brown",
                    "Mocha",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Suede and cork",
                    "Open sandal suited for warm dry weather",
                    "2026-08-22",
                    14
            );

            addExisting(
                    repository,
                    "Crocs",
                    "Classic Clog",
                    "Footwear",
                    "US 9",
                    "Black",
                    null,
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Croslite foam",
                    "Lightweight casual clog useful around water and warm weather",
                    "2026-08-28",
                    26
            );

            // Accessories
            addExisting(
                    repository,
                    "New Era",
                    "59FIFTY New York Yankees Cap",
                    "Accessory",
                    "7 3/8",
                    "Blue",
                    "Navy",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Polyester",
                    "Structured baseball cap for casual outfits",
                    "2026-08-24",
                    23
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Watch Hat",
                    "Accessory",
                    "One Size",
                    "Black",
                    null,
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Acrylic",
                    "Warm knit beanie for colder weather",
                    "2026-03-11",
                    10
            );

            addExisting(
                    repository,
                    "Ray-Ban",
                    "Wayfarer Classic Sunglasses",
                    "Accessory",
                    "One Size",
                    "Black",
                    null,
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Acetate and glass",
                    "Classic sunglasses useful for bright sunny weather",
                    "2026-08-27",
                    30
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Refugio Daypack 26L",
                    "Accessory",
                    "One Size",
                    "Black",
                    null,
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Recycled polyester",
                    "Daypack useful for school, travel, and light hiking",
                    "2026-08-28",
                    42
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Base Camp Duffel",
                    "Accessory",
                    "One Size",
                    "Black",
                    null,
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Recycled polyester",
                    "Durable travel bag for trips and outdoor gear",
                    "2026-05-17",
                    4
            );

            addExisting(
                    repository,
                    "Casio",
                    "G-Shock DW-5600",
                    "Accessory",
                    "One Size",
                    "Black",
                    null,
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Resin",
                    "Durable digital watch suitable for everyday and outdoor use",
                    "2026-08-28",
                    63
            );

            addExisting(
                    repository,
                    "Apple",
                    "Apple Watch Sport Band",
                    "Accessory",
                    "M/L",
                    "Black",
                    "Midnight",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Fluoroelastomer",
                    "Simple sport watch band suitable for exercise and everyday use",
                    "2026-08-26",
                    52
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Conveyor Belt",
                    "Accessory",
                    "M",
                    "Black",
                    null,
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Nylon webbing",
                    "Durable everyday belt",
                    "2026-07-14",
                    15
            );

            // Full-body
            addExisting(
                    repository,
                    "Dickies",
                    "Bib Overalls",
                    "Full-body",
                    "M",
                    "Brown",
                    "Duck Brown",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton canvas",
                    "Durable workwear overalls suitable for casual layering",
                    "2026-06-08",
                    5
            );

            addExisting(
                    repository,
                    "Carhartt",
                    "Loose Fit Denim Bib Overall",
                    "Full-body",
                    "M",
                    "Blue",
                    "Dark Wash",
                    "All-Season",
                    "Casual",
                    "Oversized",
                    "Cotton denim",
                    "Heavy denim overalls suited for casual workwear outfits",
                    "2026-04-02",
                    3
            );

            // Undergarments
            addExisting(
                    repository,
                    "Uniqlo",
                    "AIRism Boxer Briefs",
                    "Undergarment",
                    "M",
                    "Black",
                    null,
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Polyester and elastane",
                    "Lightweight breathable base layer",
                    "2026-08-28",
                    58
            );

            addExisting(
                    repository,
                    "Nike",
                    "Everyday Plus Cushioned Crew Socks",
                    "Undergarment",
                    "M",
                    "White",
                    null,
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton, polyester, and elastane",
                    "Cushioned athletic socks suited for sneakers and activity",
                    "2026-08-28",
                    71
            );

            addExisting(
                    repository,
                    "Smartwool",
                    "Hike Classic Edition Crew Socks",
                    "Undergarment",
                    "M",
                    "Gray",
                    null,
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Merino wool blend",
                    "Warm hiking socks suited for cold-weather outdoor activity",
                    "2026-08-19",
                    9
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "HEATTECH Crew Neck Long Sleeve T-Shirt",
                    "Undergarment",
                    "M",
                    "Black",
                    null,
                    "Fall/Winter",
                    "Everyday",
                    "Slim",
                    "Polyester, acrylic, rayon, elastane",
                    "Warm fitted base layer for cold weather",
                    "2026-02-28",
                    12
            );

            // Intentionally rarely/never worn pieces for testing temporal queries
            addExisting(
                    repository,
                    "Comme des Garçons",
                    "Heart Logo T-Shirt",
                    "Top",
                    "M",
                    "White",
                    null,
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Minimal graphic T-shirt reserved for nicer casual outfits",
                    "2026-03-05",
                    2
            );

            addExisting(
                    repository,
                    "Clarks",
                    "Wallabee",
                    "Footwear",
                    "US 9",
                    "Beige",
                    "Maple Suede",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Suede and crepe rubber",
                    "Classic suede shoe for smart casual outfits",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Stone Island",
                    "Compass Patch Overshirt",
                    "Outerwear",
                    "M",
                    "Green",
                    "Olive",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Light overshirt useful as a casual layering piece",
                    "2026-01-17",
                    1
            );

            addExisting(
                    repository,
                    "Acne Studios",
                    "Canada Scarf",
                    "Accessory",
                    "One Size",
                    "Gray",
                    null,
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Wool",
                    "Large wool scarf for cold-weather outfits",
                    null,
                    0
            );

            System.out.println("Database seeded successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a sample existing wardrobe piece with wear history.
     */
    private static void addExisting(
            PieceRepository repository,
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
    ) throws Exception {

        Piece piece = Piece.existing(
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
                lastWorn,
                timesWorn
        );

        repository.addExistingPiece(piece);
    }
}