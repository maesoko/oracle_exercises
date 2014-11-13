SELECT deptno, empno, ename
FROM employees
WHERE deptno IN(10,20)
UNION ALL
SELECT deptno, empno, ename
FROM employees
WHERE deptno IN(20,30)
/
