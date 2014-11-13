SELECT empno, ename, deptno, dname
FROM employees RIGHT JOIN departments
USING(deptno)
/
