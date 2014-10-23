SELECT emp.empno, emp.ename AS "部下", mgr.empno, mgr.ename AS "上司"
FROM employees emp JOIN employees mgr
ON(emp.mgr = mgr.empno)
/
