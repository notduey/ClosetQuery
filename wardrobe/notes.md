SQLite Quick Reference

CLI
.schema [table]     - show table structure
.tables             - list tables
.headers on         - show column names
.mode column        - readable output
.read file.sql      - run file in session
.open file.db       - switch database
.quit               - exit

sqlite3 db.sql < file.sql   -- one-shot from bash (no session)
db_filename.db < sql_filename.sql -- creates db if it doesn't exist

Put .headers on / .mode column in ~/.sqliterc for defaults.

QUERY
SELECT col FROM table WHERE cond ORDER BY col ASC|DESC LIMIT n;
SELECT DISTINCT col FROM table;

WHERE: = , IN ('a','b'), BETWEEN x AND y, LIKE '%pat%',
       IS NULL / IS NOT NULL, AND/OR/NOT
LIKE '%y%'  -- contains y, case-insensitive, needs quotes

INSERT
INSERT INTO table (col1, col2) VALUES (v1, v2), (v3, v4);

UPDATE / DELETE
- SELECT first to confirm target columns/rows
- No WHERE = affects ALL rows
- DELETE removes whole row (more destructive than UPDATE); ids not reused
- RETURNING *  -- see affected rows

UPDATE table SET col = val WHERE cond;
DELETE FROM table WHERE cond;

CASE (SELECT or UPDATE SET only)
CASE
    WHEN cond THEN val
    ELSE col          -- omit = NULL; use col in UPDATE to keep existing
END AS alias           -- AS only valid in SELECT

WHERE = filters rows | WHEN = picks value per row (CASE only)

TABLE STRUCTURE
CREATE TABLE table (col TYPE constraints, ...);
DROP TABLE IF EXISTS table;
ALTER TABLE table ADD COLUMN col TYPE;

Constraints: NOT NULL, UNIQUE, PRIMARY KEY, CHECK(cond), DEFAULT val,
FOREIGN KEY (col) REFERENCES other(col)  -- later

AGGREGATES
COUNT(*), SUM(col), AVG(col), MIN(col), MAX(col)
GROUP BY col
HAVING cond   -- like WHERE, but after aggregation

VIEWS
CREATE VIEW name AS SELECT ...;   -- saved query, no stored data
DROP VIEW IF EXISTS name;

JOINS (later)
SELECT * FROM a JOIN b ON a.id = b.a_id;