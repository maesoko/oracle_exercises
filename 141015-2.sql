alter session set nls_date_format = 'RR-MM-DD'
/
alter session set nls_date_language = 'JAPANESE'
/
SELECT ename, hiredate
FROM employees
WHERE deptno = 10
/
