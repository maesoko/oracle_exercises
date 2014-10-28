insert into employees(empno, ename, deptno) values(1015, '山口', null)
/
SELECT empno, ename, deptno, dname
FROM employees LEFT JOIN departments
USING(deptno)
/
