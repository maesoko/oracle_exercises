SELECT empno, ename, deptno
FROM employees JOIN departments
USING(deptno)
WHERE dname = (SELECT dname FROM departments WHERE dname = '営業')
/
