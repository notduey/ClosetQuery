PRAGMA foreign_keys = ON; -- enable foreign key supports

DROP TABLE IF EXISTS outfit_pieces; -- drop child (has FKs); drop child before parent
DROP TABLE IF EXISTS pieces; -- drop table if it exists, enforces idempotency
DROP TABLE IF EXISTS outfits;

----------------------------------------------------------------------------------
-- pieces table
---------------------------------------------------------------------------------
CREATE TABLE pieces(
    id INTEGER PRIMARY KEY, -- primary key
    brand TEXT NOT NULL, -- required field
    name TEXT NOT NULL, -- required
    category TEXT NOT NULL CHECK( -- required, check if category is in list
        category IN ('Top', 'Bottom', 'Outerwear', 'Dress', 'Shoe', 'Accessory', 'Undergarment')
    ),
    size TEXT,
    color TEXT,
    season TEXT CHECK(
        season IN ('Spring/Summer', 'Fall/Winter')
    ),
    occasion TEXT CHECK(
        occasion IN ('Beater', 'Staple', 'Reserved')
    ),
    fit TEXT CHECK(
        fit IN ('Oversized', 'Regular', 'Slim')
    ),
    materials TEXT
);

INSERT INTO pieces (brand, name, category, size, color, season, occasion, fit, materials)
VALUES
    ('Rick Owens', 'Geobasket High-Top', 'Shoe', '43', 'Dust', 'Fall/Winter', 'Reserved', 'Regular', 'Leather'),
    ('Comme des Garçons', 'Body Meets Dress Blazer', 'Outerwear', 'S', 'Black', 'Fall/Winter', 'Reserved', 'Oversized', 'Wool'),
    ('Issey Miyake', 'Pleats Please Tunic', 'Top', 'M', 'Charcoal', 'Spring/Summer', 'Staple', 'Oversized', 'Polyester'),
    ('Yohji Yamamoto', 'Wide-Leg Wool Trouser', 'Bottom', '32', 'Black', 'Fall/Winter', 'Staple', 'Oversized', 'Wool'),
    ('Maison Margiela', 'Tabi Ankle Boot', 'Shoe', '42', 'Off-White', 'Fall/Winter', 'Reserved', 'Slim', 'Leather'),
    ('Ann Demeulemeester', 'Asymmetric Wrap Dress', 'Dress', 'S', 'Black', 'Spring/Summer', 'Reserved', 'Slim', 'Silk'),
    ('Junya Watanabe', 'Deconstructed Denim Jacket', 'Outerwear', 'M', 'Indigo', 'Fall/Winter', 'Staple', 'Regular', 'Denim'),
    ('Balenciaga', 'Oversized Distressed Tee', 'Top', 'L', 'Grey', 'Spring/Summer', 'Beater', 'Oversized', 'Cotton'),
    ('Yohji Yamamoto', 'Origami Fold Clutch', 'Accessory', NULL, 'Black', NULL, 'Reserved', NULL, 'Leather'),
    ('Rick Owens', 'Ribbed Thermal Layer', 'Undergarment', 'M', 'Bone', 'Fall/Winter', 'Beater', 'Slim', 'Cotton Blend');

DROP VIEW IF EXISTS required_info;
CREATE VIEW required_info AS -- create view
SELECT brand, name, category FROM pieces; -- selects brand, name, and category from pieces

---------------------------------------------------------------------------------
-- outfits table
---------------------------------------------------------------------------------
CREATE TABLE outfits(
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    favorite INTEGER NOT NULL DEFAULT -- NOT NULL blocks explicit insertion of NULL (DEFAULT alone doesn't)
    0 CHECK(favorite IN (0, 1)) -- restricts to 0 or 1, idiomatic for booleans
);

INSERT INTO outfits (name, favorite)
VALUES
    ('Mostly Rick', 1),
    ('Calm Tabi Fit', 0),
    ('GO JAPAN', 0);

---------------------------------------------------------------------------------
-- outfit_pieces table
---------------------------------------------------------------------------------
CREATE TABLE outfit_pieces(
    outfit_id INTEGER NOT NULL 
        REFERENCES outfits(id) -- foreign key referencing outfits table
        ON DELETE CASCADE, -- if row from parent table is deleted, delete corresponding rows from this table (child)
    piece_id INTEGER NOT NULL 
        REFERENCES pieces(id) -- foreign key referencing pieces table
        ON DELETE CASCADE,
    PRIMARY KEY(outfit_id, piece_id) -- define composite primary key
);

INSERT INTO outfit_pieces (outfit_id, piece_id)
VALUES
    (1, 1), (1, 10), (1, 6),
    (2, 5), (2, 4), (2, 2), (2, 8),
    (3, 2), (3, 3), (3, 4), (3, 7), (3, 9);

-- SELECT * FROM outfit_pieces;

---------------------------------------------------------------------------------
-- tests
---------------------------------------------------------------------------------
-- INSERT INTO outfit_pieces (outfit_id, piece_id)
-- VALUES
--     (1, 1), -- duplicate entry
--     (99, 1), -- non-existent outfit
--     (1, 99); -- non-existent piece

-- DELETE FROM pieces WHERE id = 4; -- delete from piece to test cascade
-- SELECT * FROM outfit_pieces;

-- SELECT outfits.name AS outfit_name, pieces.name AS piece_name, pieces.brand
-- FROM outfit_pieces
-- JOIN outfits on outfits.id = outfit_pieces.outfit_id
-- JOIN pieces on pieces.id = outfit_pieces.piece_id; -- two-way join through junction table (outfit_pieces)

-- SELECT pieces.name, pieces.brand -- view from pieces
-- FROM outfit_pieces
-- JOIN pieces ON pieces.id = outfit_pieces.piece_id -- inner join on pieces.id and outfit_pieces.piece_id
-- WHERE outfit_pieces.outfit_id = 1; -- join where outfit_id is 1

-- DELETE FROM outfit_pieces WHERE piece_id = 4; -- delete from outfit_pieces, piece 4 still exists in pieces
-- SELECT pieces.name
-- FROM pieces
-- LEFT JOIN outfit_pieces ON pieces.id = outfit_pieces.piece_id -- left join pieces.id and outfit_pieces.piece_id
-- WHERE outfit_pieces.piece_id IS NULL; -- join where piece_id NULL, i.e. piece not in outfit