package edu.bellevue.huskygpt.database;

import edu.bellevue.huskygpt.model.Piece;

/**
 * Populates the database with sample pieces for testing, temporary use
 */
public class DatabaseSeeder {

    public static void seed() {
        PieceRepository.addPiece(new Piece(
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
                "Heavy knitted sweater suitable for colder weather"
        ));

        PieceRepository.addPiece(new Piece(
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
                "Lightweight and breathable shirt for warm weather"
        ));

        PieceRepository.addPiece(new Piece(
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
                "Durable jacket that works well for layering"
        ));

        PieceRepository.addPiece(new Piece(
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
                "Comfortable casual sneaker with breathable upper"
        ));

        PieceRepository.addPiece(new Piece(
                "Levi's",
                "501 Original Fit Jeans",
                "Bottom",
                "32x30",
                "Blue",
                "Medium Wash",
                "All-Season",
                "Everyday",
                "Regular",
                "100% cotton denim",
                "Classic denim jeans suitable for everyday wear"
        ));

        PieceRepository.addPiece(new Piece(
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
                "Lightweight insulated jacket for cool weather and layering"
        ));

        PieceRepository.addPiece(new Piece(
                "COS",
                "Relaxed Linen Shirt",
                "Top",
                "M",
                "Beige",
                null,
                "Spring/Summer",
                "Casual",
                "Oversized",
                "100% linen",
                "Breathable lightweight shirt for hot weather"
        ));

        PieceRepository.addPiece(new Piece(
                "Adidas",
                "Track Pants",
                "Bottom",
                "M",
                "Black",
                null,
                "All-Season",
                "Casual",
                "Slim",
                "Polyester",
                "Lightweight athletic pants for casual wear"
        ));

        PieceRepository.addPiece(new Piece(
                "Dr. Martens",
                "1461 Leather Shoes",
                "Footwear",
                "US 9",
                "Black",
                "Smooth Black",
                "All-Season",
                "Special Occasion",
                "Regular",
                "Leather",
                "Structured leather shoes suitable for dressier outfits"
        ));

        PieceRepository.addPiece(new Piece(
                "Vintage",
                "Wool Cardigan",
                "Top",
                "L",
                "Gray",
                null,
                "Fall/Winter",
                "Casual",
                "Oversized",
                "Wool blend",
                "Warm oversized cardigan useful for layering"
        ));
    }
}