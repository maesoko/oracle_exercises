SELECT deptno, empno, ename
FROM employees
WHERE deptno IN(10,20)
INTERSECT
SELECT deptno, empno, ename
FROM employees
WHERE deptno IN(20,30)
/
