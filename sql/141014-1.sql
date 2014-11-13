SELECT empno, ename, UPPER(yomi)
FROM employees
WHERE UPPER(yomi) = 'TAKAHASHI'
/
