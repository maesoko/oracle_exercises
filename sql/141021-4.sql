SELECT ename, 
             CASE deptno WHEN 10 THEN sal * 1.10
                         WHEN 20 THEN sal * 1.20
                         ELSE sal END AS "NEW_SAL"
FROM employees
/
