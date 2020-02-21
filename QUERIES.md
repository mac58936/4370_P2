1.

2.
SELECT employees.first_name, employees.last_name, DATEDIFF(dept_manager.to_date, dept_manager.from_date) AS Total_Duration_Days
FROM dept_manager
INNER JOIN employees ON dept_manager.emp_no = employees.emp_no
WHERE DATEDIFF(dept_manager.to_date, dept_manager.from_date) = (SELECT MAX(DATEDIFF(dept_manager.to_date, dept_manager.from_date)) FROM dept_manager);

3.

4.

5a.

SELECT e1.emp_no, e1.first_name, e1.last_name, de1.from_date, de1.to_date, de1.dept_no, e2.emp_no, e2.first_name, e2.last_name, de2.from_date, de2.to_date, de2.dept_no
FROM employees e1, employees e2, dept_emp de1, dept_emp de2, departments
WHERE e1.emp_no=de1.emp_no AND de1.dept_no=departments.dept_no AND e2.emp_no=de2.emp_no AND de2.dept_no=departments.dept_no AND de1.dept_no=de2.dept_no AND e1.emp_no!=e2.emp_no AND (de1.from_date < de2.to_date OR de2.from_date < de1.to_date)

5b.

SELECT e1.emp_no, e1.first_name, e1.last_name, de1.from_date, de1.to_date, de1.dept_no, e21.emp_no, e21.first_name, e21.last_name, de21.from_date, de21.to_date, de21.dept_no, e22.emp_no, e22.first_name, e22.last_name, de22.from_date, de22.to_date, de22.dept_no ,e3.emp_no, e3.first_name, e3.last_name, de3.from_date, de3.to_date, de3.dept_no
FROM employees e1, employees e21, employees e22, employees e3, dept_emp de1, dept_emp de21, dept_emp de22, dept_emp de3
WHERE e1.emp_no=de1.emp_no AND e21.emp_no=de21.emp_no AND de1.dept_no=de21.dept_no AND e1.emp_no!=e21.emp_no AND (de1.from_date < de21.to_date OR de21.from_date < de1.to_date) AND e22.emp_no=de22.emp_no AND e3.emp_no=de3.emp_no AND de3.dept_no=de22.dept_no AND e3.emp_no!=e22.emp_no AND (de3.from_date < de22.to_date OR de22.from_date < de3.to_date) AND e21.emp_no=e22.emp_no AND e1.emp_no!=e3.emp_no
