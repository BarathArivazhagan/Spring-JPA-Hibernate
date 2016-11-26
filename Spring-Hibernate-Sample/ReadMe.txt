

Simple Spring Hibernate Sample demonstrating hibernate CRUD operations using session factory and postgresql 




Endpoints : 


Add employee: 

http://localhost:8080/emp/add

{ "employeeId":1000,
  "employeeName":"Barath",
    "employeeAge":23,
    "employeeGender": "MALE"
    
 }
 
 Read employee: 
 
 http://localhost:8080/emp/get?employeeId=?
 

Find employee by employee name through Criteria:


http://localhost:8080/emp/getByNameQuery?employeeName=Barath

Find employee by employee name through Query:

http://localhost:8080/emp/getByName?employeeName=Barath


Find all the employees less than employee age 
Ex:
http://localhost:8080//emp/age/lessthan?employeeAge=30

Find all the employee names : 

http://localhost:8080/emp/getAllNames

Find all the employees :

http://localhost:8080/emp/getAll

