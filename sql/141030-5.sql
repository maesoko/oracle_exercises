SELECT deptno, empno, ename
FROM employees
WHERE deptno IN(10,20)
UNION
SELECT deptno, empno, ename
FROM employees
WHERE deptno IN(20,30)
ORDER BY empno
/
