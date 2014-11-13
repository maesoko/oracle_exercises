SELECT prodno, pname, price
FROM products
WHERE pname LIKE '%100\%%' ESCAPE '\'
/
