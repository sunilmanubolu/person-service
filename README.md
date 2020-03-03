# person-service

Purpose:
The purpose of this application is to create an API which supports the employee operations in a particular organization. Like adding new Employee, Updating existing employee, deleting the employee, adding multiple employees in bulk.

1) Added an end point in the PersonController - /person/{pageNo} for the Pagination when we are fetching the number of persons. 
   This covers functionality one.
2) Added an end point in the PersonController - /persons for saving the list of persons in the Database.
3) Created new class PersonRepository and used Spring Data JPA for doing the Database operations.
4) All the database related information is configured in the application.properties.
5) Removed the Broiler plate code and used lombok in the Person Entity class.
6) I have tested via POSTMAN for saving the persons in bulk and below is sample request instead of csv file.

[
    {
        "id": "175731",
        "name": "Namke1",
        "salary": "30000",
		"age": "30"
    },
    {
        "id": "175890",
        "name": "Name2",
        "salary": "4000",
		"age": "21"
    },
    {
        "id": "175720",
        "name": "Name3",
        "salary": "10000",
		"age": "20"
    },
    {
        "id": "175767",
        "name": "Name4",
        "salary": "90000",
		"age": "60"
    }
]

7) Added two new dependencies lombok, spring-boot-starter-data-jpa for supporting lombok and Spring Data JPA.
8) Used PagingAndSortingRepository for Pagination.

