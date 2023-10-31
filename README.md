# XMLtoDB_V2
Javovská aplikace, která stáhne data v xml z internetu, zpracuje je a uloží do sql databáze.

Celá aplikace se ovládá z index.html

# Project structure

Using InteliJ IDEA Ultimate, Spring Framework, GitHub, MySQL Database. 

## Dependencies

1) Spring Boot
2) Spring Web
3) Spring Data JPA
4) MySQL Driver
5) Lombok

## MVC

1) MODEL:

City, CityParts 

2) VIEW:

Views for displaying user-related information, drink menu, and order summary.
Views should render the data from the models in a user-friendly format for the end-users.

3) CONTROLLER:

FileHandlerController:
- Handles requests related to files.

CityController:
- Handles requests related to cities.

CityPartsController:
- Handles requests related to parts of city.

