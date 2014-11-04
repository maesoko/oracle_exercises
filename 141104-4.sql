create table dept_copy as select * from departments where 0 = 1
/
INSERT INTO dept_copy(deptno, dname, loc)
SELECT deptno+1, dname, loc
FROM departments
/
SELECT * FROM dept_copy
/
DELETE FROM dept_copy
WHERE deptno IN(SELECT deptno+1 FROM departments)
/
SELECT * FROM dept_copy
/
