SELECT empno, ename, dname
FROM employees NATURAL JOIN departments
WHERE deptno IN(10,20)
/
