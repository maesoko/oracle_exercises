SELECT empno, ename, sal, deptno
FROM employees JOIN departments
USING(deptno)
WHERE sal >= (SELECT sal FROM employees WHERE empno = 1003)
AND dname = (SELECT dname FROM departments WHERE dname = '営業')
/
