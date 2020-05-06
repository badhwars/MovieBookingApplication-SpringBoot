# MovieBookingApplication-SpringBoot
The application is created using Spring Boot and uses thymeleaf for the web pages
The main features of the application are
1. Ability to book a movie as a guest
2. Abiliy to create an user account and recieve 20% discount
3. Functionality added to get discount if movie is booked on tuesday
4. Functionality is added which prevents user from booking child tickets if movie has rating 18
5. Admin side is added which can only be accessed by Admin (Spring Security) - seperate role created
6. Admin has ability to create new movies and delete movies
7. Admin can view all the bookings

The application stores data in MySQL Database and h2 database was used for testing purposes
The Application also uses JPA repositories to store data in repositories which is stored in a table in database

