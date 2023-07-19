# User-Registration

## Table of contents

1. ###### [Technology Used]
 
2. ###### [Functionalities]

3. ###### [Postman Commands]




## Techonology Used

- ###### Java

- ###### Spring Boot

- ###### Hibernate

- ###### RESTful APIS

- ###### Maven

- ###### My SQL

- ###### Postman




## Functionalities

###### Users

	• Add User
	• Check Validation
	• Find All Users
	• Delete User By Email





## Postman Commands

###### To Add User:

	localhost:2222/users/registration

{

    "name":"String",
    "gender":"Enum Type",
    "email":"String",
    "password":"String"

    
}



###### To Check Validation:
	
	localhost:2222/users/checkValidation?email=String&password=String

	

###### To Find All Users:
	
	localhost:2222/users/findAllUsers
	

  
###### To Delete User By Email:	

	localhost:2222/users/deleteUserByEmail?email=String
  
	

## Future Scope

1. User Profile Update
2. Role-based Access control
3. Email Verification
4. Password Reset
5. Authentication and Authorization
