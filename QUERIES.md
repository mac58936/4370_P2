1.

2.
SELECT employees.first_name, employees.last_name, DATEDIFF(dept_manager.to_date, dept_manager.from_date) AS Total_Duration_Days
FROM dept_manager
INNER JOIN employees ON dept_manager.emp_no = employees.emp_no
WHERE DATEDIFF(dept_manager.to_date, dept_manager.from_date) = (SELECT MAX(DATEDIFF(dept_manager.to_date, dept_manager.from_date)) FROM dept_manager);
