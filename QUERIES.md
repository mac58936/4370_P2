1.

2.
SELECT employees.first_name, employees.last_name, DATEDIFF(dept_manager.to_date, dept_manager.from_date) AS Total_Duration_Days
FROM dept_manager
INNER JOIN employees ON dept_manager.emp_no = employees.emp_no
WHERE DATEDIFF(dept_manager.to_date, dept_manager.from_date) = (SELECT MAX(DATEDIFF(dept_manager.to_date, dept_manager.from_date)) FROM dept_manager);

3. SET @now = curdate();
SELECT d.dept_name, COUNT(*) as numEmployeesBornInDecade, floor(year(e.birth_date) / 10) * 10 as decade, AVG(s.salary) as AvgSal
FROM employees.departments d, employees.dept_emp de, employees.employees e, employees.salaries s
WHERE d.dept_no = de.dept_no
AND de.emp_no = e.emp_no
AND @now BETWEEN de.from_date AND de.to_date
AND e.emp_no = s.emp_no
AND @now BETWEEN s.from_date AND s.to_date
GROUP BY d.dept_name, floor(year(e.birth_date) / 10) * 10
ORDER BY d.dept_name, floor(year(e.birth_date) / 10) * 10;

3b. SELECT d.dept_name, COUNT(*) as "Count", floor(year(e.birth_date) / 10) * 10 as decade, AVG(s.salary) as AvgSal
FROM employees.departments d, employees.dept_emp de, employees.employees e, employees.salaries s
WHERE d.dept_no = de.dept_no
AND de.emp_no = e.emp_no
AND curdate() BETWEEN de.from_date AND de.to_date
AND e.emp_no = s.emp_no
AND curdate() BETWEEN s.from_date AND s.to_date
GROUP BY d.dept_name, floor(year(e.birth_date) / 10) * 10
ORDER BY d.dept_name, floor(year(e.birth_date) / 10) * 10;

3c. SELECT d.dept_name, COUNT(*) as "Count", truncate(floor(year(e.birth_date) / 10) * 10, 4) as decade, AVG(s.salary) as AvgSal
FROM employees.departments d, employees.dept_emp de, employees.employees e, employees.salaries s
WHERE d.dept_no = de.dept_no
AND de.emp_no = e.emp_no
AND curdate() BETWEEN de.from_date AND de.to_date
AND e.emp_no = s.emp_no
AND curdate() BETWEEN s.from_date AND s.to_date
GROUP BY d.dept_name, floor(year(e.birth_date) / 10) * 10
ORDER BY d.dept_name, floor(year(e.birth_date) / 10) * 10;

4. SELECT first_name, last_name, gender, salary
FROM employees.employees, employees.titles, employees.salaries
WHERE gender="F" AND birth_date < '1990-01-01'
AND employees.emp_no = titles.emp_no AND titles.title="Manager"
AND curdate() BETWEEN titles.from_date AND titles.to_date
AND employees.emp_no = salaries.emp_no
AND curdate() BETWEEN salaries.from_date AND salaries.to_date
AND salary > 80000;

5a.

SELECT e1.emp_no AS employee1Num, e1.first_name AS employee1FirstName, e1.last_name AS employee1LastName, de1.from_date AS employee1FromDate, de1.to_date AS employee1ToDate, de1.dept_no AS employee1Dept, e2.emp_no AS employee2Num, e2.first_name AS employee2FirstName, e2.last_name AS employee2LastName, de2.from_date AS employee2FromDate, de2.to_date AS employee2ToDate, de2.dept_no AS employee2Dept
FROM employees e1, employees e2, dept_emp de1, dept_emp de2, departments
WHERE e1.emp_no=de1.emp_no AND de1.dept_no=departments.dept_no AND e2.emp_no=de2.emp_no AND de2.dept_no=departments.dept_no AND de1.dept_no=de2.dept_no AND e1.emp_no!=e2.emp_no AND (de1.from_date < de2.to_date OR de2.from_date < de1.to_date)
LIMIT 100

5b.

SELECT e1.emp_no AS employee1Num, e1.first_name AS employee1FirstName, e1.last_name AS employee1LastName, de1.from_date AS employee1FromDate, de1.to_date AS employee1ToDate, de1.dept_no AS employee1Dept, e21.emp_no AS employee3Num, e21.first_name AS employee3FirstName, e21.last_name AS employee3LastName, de21.from_date AS employee3FromDate, de21.to_date AS employee3ToDate, de21.dept_no AS employee3Dept, e22.emp_no AS employee3Num, e22.first_name AS employee3FirstName, e22.last_name AS employee3LastName, de22.from_date AS employee3FromDate, de22.to_date AS employee3ToDate, de22.dept_no AS employee3Dept ,e3.emp_no AS employee2Num, e3.first_name AS employee2FirstName, e3.last_name AS employee2LastName, de3.from_date AS employee2FromDate, de3.to_date AS employee2ToDate, de3.dept_no AS employee2Dept
FROM employees e1, employees e21, employees e22, employees e3, dept_emp de1, dept_emp de21, dept_emp de22, dept_emp de3
WHERE e1.emp_no=de1.emp_no AND e21.emp_no=de21.emp_no AND de1.dept_no=de21.dept_no AND e1.emp_no!=e21.emp_no AND (de1.from_date < de21.to_date OR de21.from_date < de1.to_date) AND e22.emp_no=de22.emp_no AND e3.emp_no=de3.emp_no AND de3.dept_no=de22.dept_no AND e3.emp_no!=e22.emp_no AND (de3.from_date < de22.to_date OR de22.from_date < de3.to_date) AND e21.emp_no=e22.emp_no AND e1.emp_no!=e3.emp_no
LIMIT 100
