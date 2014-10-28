UPDATE emp_copy
SET ename = '林', deptno = 20
WHERE empno = 1012
/
SELECT * FROM emp_copy WHERE empno = 1012
/
