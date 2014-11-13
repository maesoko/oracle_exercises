CREATE VIEW v_emp_dept
AS SELECT empno, ename, dname
FROM employees NATURAL JOIN departments
WHERE deptno = 10
/
SELECT * FROM v_emp_dept
/
DROP VIEW v_emp_dept
/
