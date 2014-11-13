DEFINE employee_num = &empno
INSERT INTO employees(empno, ename, hiredate)
VALUES (&employee_num, '&ename', TO_DATE('&年-&月-&日', 'YYYY-MM-DD'))
/
SELECT * FROM employees
/
DELETE FROM employees
WHERE empno = &employee_num
/
SELECT * FROM employees
/
UNDEFINE employee_num

