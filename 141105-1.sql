create table emp_copy as select * from employees
/
UPDATE emp_copy
SET deptno = 10
WHERE deptno IS NULL
/
SELECT * FROM emp_copy
/
ROLLBACK
/
SELECT * FROM emp_copy
/
