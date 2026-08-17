DROP TABLE IF EXISTS pieces; -- drop pieces if it exists, enforces idempotency

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