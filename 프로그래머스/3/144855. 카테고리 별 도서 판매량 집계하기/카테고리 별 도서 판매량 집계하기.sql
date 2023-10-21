-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) as 'TOTAL_SALES'
FROM book as b join book_sales as bs on b.book_id = bs.book_id
WHERE sales_date >= date("2022-01-01") and sales_date < date("2022-02-01")
GROUP BY category
ORDER BY category

