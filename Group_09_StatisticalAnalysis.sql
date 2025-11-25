USE library_db;
SHOW TABLES;
USE library_db;


SELECT 
    b.title AS Book_Title,
    COUNT(br.book_id) AS Times_Borrowed
FROM borrow_records AS br
JOIN books AS b
    ON br.book_id = b.book_id
GROUP BY b.title
ORDER BY Times_Borrowed DESC
LIMIT 10;

SELECT 
    CONCAT(m.first_name, ' ', m.last_name) AS Member_Name,
    COUNT(*) AS Total_Borrowed
FROM borrow_records br
JOIN members m ON br.member_id = m.member_id
GROUP BY Member_Name
ORDER BY Total_Borrowed DESC
LIMIT 10;

SELECT 
    ROUND(AVG(days_borrowed), 2) AS Avg_Borrow_Duration
FROM borrow_records;

SELECT 
    COUNT(*) AS Overdue_Count
FROM borrow_records
WHERE days_borrowed > 14;

SELECT 
    b.genre AS Genre,
    COUNT(*) AS Borrow_Count
FROM borrow_records br
JOIN books b ON br.book_id = b.book_id
GROUP BY b.genre
ORDER BY Borrow_Count DESC;

SELECT days_borrowed FROM borrow_records;


