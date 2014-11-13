SELECT deptno, COUNT(*), AVG(sal)
FROM employees
GROUP BY deptno
/
