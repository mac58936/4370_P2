Team
- return that_attitude

Members
- Katie Brown
- Matt Colley
- Daniel Garcia

To Compile
- Open Main.java, replace YOUR-SQL-SERVER, YOUR-USERNAME, and YOUR-PASSWORD with your own SQL server and database credentials. Then, enter the command below in the current working directory containing Main.java.
- javac Main.java

To Run
- Enter the command below in the current working directory containing Main.java and the MySQL Connector Jar File.
- java -cp "mysql-connector-java-8.0.19.jar" Main.java

Assumptions/Justifications
- For Query 1, we first found both the female average salary and male average salary for each department. Then, we only selected the departments where the female average salary was greater than the male average salary. Next, we used those average salaries to calculate the Ratio for each department and selected the maximum Ratio. Our answer is different from the expected output, but the female and male average salaries are also included in our solution to show that our answer is correct. If you would like to see all departments where the female average salary was greater than the male average salary, run Query 1 without "LIMIT 1" in the last line of the query.

Help
- We used the free code found in the link below from Tutorials Point to help us establish and setup the JDBC Driver and to connect to our database.
- https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
