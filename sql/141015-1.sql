alter session set nls_date_format = 'DD-MON-RR'
/
alter session set nls_date_language = 'AMERICAN'
/
SELECT ename, hiredate
FROM employees
WHERE deptno = 10
/
