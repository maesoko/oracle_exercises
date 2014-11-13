SELECT empno, ename, sal, grade
FROM employees JOIN salgrades
ON employees.sal BETWEEN salgrades.losal AND salgrades.hisal
/
