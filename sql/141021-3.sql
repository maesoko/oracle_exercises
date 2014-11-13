SELECT ename, sal, comm, sal + COALESCE(comm, 0, 0)
FROM employees
/
