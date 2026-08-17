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

-- SELECT * FROM pieces 
--WHERE fit = 'Oversized'; -- returns all pieces with oversized fit

-- SELECT * FROM pieces 
-- ORDER BY fit, season; -- returns all pieces ordered by fit, then season

-- SELECT COUNT(*) FROM pieces
-- WHERE occasion = 'Beater' -- returns count of all beater entries
-- OR fit = 'Slim'; - or slim fit

-- SELECT * FROM pieces
-- WHERE name LIKE '%Dress%'; -- returns all entries with dress in name

-- SELECT * FROM pieces
-- WHERE id BETWEEN 3 AND 6; -- returns all entries between ids 3 and 6

-- SELECT category, COUNT(*) AS total -- renames COUNT(*) to alias total
-- FROM PIECES -- from pieces table
-- GROUP BY category
-- HAVING COUNT(*) > 1; -- returns only categories with more than 1 entry

-- SELECT DISTINCT brand FROM pieces; -- returns all unique brands

-- SELECT * FROM pieces 
--ORDER BY id DESC LIMIT 3 OFFSET 3; -- returns next 3 after the first 3 by id descendings

-- UPDATE pieces SET size = 'S' WHERE id = 10; -- updates size of piece with id 10
-- SELECT * FROM pieces;

DROP VIEW IF EXISTS main_info;
CREATE VIEW main_info AS -- creates a view
SELECT brand, name, category FROM pieces; -- selects brand, name, and category from pieces

-- SELECT * FROM pieces  -- test first with SELECT as UPDATE is destructive (column changes)
-- WHERE brand = 'Rick Owens';
-- UPDATE pieces SET occasion = 'Reserved' 
-- WHERE brand = 'Rick Owens';

-- SELECT brand, occasion FROM pieces WHERE brand LIKE '%y%';
-- UPDATE pieces
-- SET occasion = CASE -- update occasion with case expression
--     WHEN brand LIKE '%y%'  THEN 'Beater' -- if brand contains 'y', then return 'Beater'
--     ELSE occasion -- else return original value
-- END;
-- SELECT brand, occasion FROM pieces WHERE brand LIKE '%y%';

-- SELECT * FROM pieces
-- WHERE size IS NULL -- returns entries with null value in any column
--     OR color IS NULL
--     OR season IS NULL
--     OR occasion IS NULL
--     OR fit IS NULL
--     OR materials IS NULL;
-- UPDATE pieces 
-- SET size = 'XL', season = 'Spring/Summer', fit = 'Regular' 
-- WHERE id = 9
-- RETURNING *; -- returns all columns so changes can be seen

-- SELECT * FROM pieces -- test first with SELECT as DELETE is even more destructive (entire row)
-- WHERE brand LIKE '%a%' AND occasion = 'Staple' -- returns all 'Staple' entries with 'a' in brand
-- DELETE FROM pieces
-- WHERE brand LIKE '%a%' AND occasion = 'Staple';