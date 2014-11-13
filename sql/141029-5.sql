SELECT emp.empno, emp.ename, mgr.ename AS "上司"
FROM employees emp JOIN employees mgr
ON(emp.mgr = mgr.empno)
WHERE emp.empno IN(SELECT mgr FROM employees WHERE ename IN('山田', '伊藤'))
/
