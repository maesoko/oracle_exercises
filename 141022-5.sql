SELECT deptno, job, COUNT(*), AVG(sal)
FROM employees
GROUP BY deptno, job
HAVING COUNT(*) >= 2
/
