INSERT INTO dept_copy(deptno, dname, loc)
VALUES (50, '教育', '大手町')
/
INSERT INTO dept_copy(deptno, dname, loc)
VALUES (60, 'システム', '横浜')
/
SELECT * FROM dept_copy
/
ROLLBACK
/
SELECT * FROM dept_copy
/
INSERT INTO dept_copy(deptno, dname, loc)
VALUES (50, '教育', '大手町')
/
INSERT INTO dept_copy(deptno, dname, loc)
VALUES (60, 'システム', '横浜')
/
SELECT * FROM dept_copy
/
COMMIT
/
ROLLBACK
/
SELECT * FROM dept_copy
/
