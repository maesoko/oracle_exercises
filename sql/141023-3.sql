SELECT ordno, date_ordered, cname, ename
FROM orders JOIN customers
ON(orders.custno = customers.custno)
JOIN employees
ON(orders.salesman_no = employees.empno)
/
