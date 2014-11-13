CREATE SYNONYM dept_s
FOR departments
/
SELECT * FROM dept_s
/
DROP SYNONYM dept_s
/
