SELECT emp.job, emp.empno, emp.ename AS "部下", mgr.empno, mgr.ename AS "上司"
FROM employees emp LEFT OUTER JOIN employees mgr
ON(emp.mgr = mgr.empno)
/
