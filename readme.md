Lab 2:

Create student:
**POST http://localhost:8080/student-management-system/api/v1/students/new**

Json body:

**{
"email": "lisa.ylikangas@iths.se",
"firstname": "Lisa",
"lastname": "Ylikangas",
"phoneNumber": "0725052055"
}**

----------------------------------------------
Create subject:
**POST http://localhost:8080/student-management-system/api/v1/subjects/new**

Json body:

**{
"name": "complex javaprogrammering"
}**

--------------------------------------------------
connect existing student with existing subject:

**PATCH http://localhost:8080/student-management-system/api/v1/subjects/{subjectId}/{studentId}**

------------------------------------------------
Create Teacher:

**POST http://localhost:8080/student-management-system/api/v1/teachers/new**

Json body:
**{
"name":"Pontus"
}**

-----------------------------------------------------
connect existing teacher with existing subject:
**PATCH http://localhost:8080/student-management-system/api/v1/subjects/{subjectId}/t/{teacherId}**

-------------------------------------
Get all subject + information:
**GET http://localhost:8080/student-management-system/api/v1/subjects/getall**

----------------------------------------------------
get teachers:
**GET http://localhost:8080/student-management-system/api/v1/teachers/getall**

----------------------------------------
find teacher by id:
**GET http://localhost:8080/student-management-system/api/v1/teachers/findbyid/{id}**

---------------------------------------
Delete teacher:
**DELETE http://localhost:8080/student-management-system/api/v1/teachers/{id}**

----------------------------------------
find subject by id:
**GET http://localhost:8080/student-management-system/api/v1/subjects/findbyid/{id}**
---------------------------------------
Delete subject:
**DELETE http://localhost:8080/student-management-system/api/v1/teachers/{id}**
---------------------------------------

**Other:**

Create student: 

POST http://localhost:8080/student-management-system/api/v1/students/new

Json body:

{ 
"email": "lisa.ylikangas@iths.se", "firstname": "Lisa", "lastname": "Ylikangas", "phoneNumber": "0725052055"
}

Get all students:
GET http://localhost:8080/student-management-system/api/v1/students/getall
-------------------------
Get student by id: 
GET http://localhost:8080/student-management-system/api/v1/students/{id}
-------------------------
Get student by lastname:
GET http://localhost:8080/student-management-system/api/v1/students/{lastname}
-------------------------
update firstname: 
Patch http://localhost:8080/student-management-system/api/v1/students/firstname/{id}

Json body: { "firstname":"lisa" }

-------------------------
update lastname:
Patch http://localhost:8080/student-management-system/api/v1/students/lastname/{id}

Json body: { "lastname":"ylikangas" }

----------------------
update email:
Patch http://localhost:8080/student-management-system/api/v1/students/email/{id}

Json body: { "email:":"lisa@iths.se" }