SELECT ename, sal, comm, sal + NVL2(comm, comm, 0)
FROM employees
/
