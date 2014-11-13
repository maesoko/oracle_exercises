SELECT empno, ename, sal
FROM employees
WHERE sal >= (SELECT sal FROM employees WHERE empno = 1003)
/
