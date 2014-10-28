UPDATE emp_copy
SET deptno = NULL
WHERE empno IN(1013,1014)
/
SELECT * FROM emp_copy WHERE empno IN(1013,1014)
/
