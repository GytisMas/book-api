INSERT INTO books (title, author, year, rating)
SELECT 'A Tale of Two Cities', 'Charles Dickens', 1859, 4
WHERE NOT EXISTS (SELECT 1 
                 FROM books 
                 WHERE title='A Tale of Two Cities');

INSERT INTO books (title, author, year, rating)
SELECT 'The Catcher in the Rye', 'J. D. Salinger', 1951, 4
WHERE NOT EXISTS (SELECT 1 
                 FROM books 
                 WHERE title='The Catcher in the Rye');

INSERT INTO books (title, author, year, rating)
SELECT 'The Hobbit', 'J. R. R. Tolkien', 1937, 5
WHERE NOT EXISTS (SELECT 1 
                 FROM books 
                 WHERE title='The Hobbit');

INSERT INTO books (title, author, year, rating)
SELECT 'The Little Prince', 'Antoine de Saint-Exupéry', 1943, 3
WHERE NOT EXISTS (SELECT 1 
                 FROM books 
                 WHERE title='The Little Prince');

INSERT INTO books (title, author, year, rating)
SELECT 'Watership Down', 'Richard Adams', 1972, 2
WHERE NOT EXISTS (SELECT 1 
                 FROM books 
                 WHERE title='Watership Down');
