SELECT empno, ename, deptno, dname
FROM employees FULL JOIN departments
USING(deptno)
/
