## _BOOKSTORE WITH RECOMMENDATION_

This project is a web-based bookstore application that allows users to browse, search for, and purchase books. It features a recommendation system that suggests books based on the user's browsing and purchase history, as well as ratings and reviews, books can also be recommended based on a form that the user fills out.

## Features

- User Registration and Authentication: Users can sign up, log in, and manage their profiles.
- Book Catalog: Users can browse and search the catalog by various criteria (title, author, genre, etc.).
- Book Details: Detailed information about books, including descriptions, ratings, and reviews.
- Shopping Cart: Users can add books to their shopping cart and proceed to checkout.
- Recommendations: The system recommends books based on the user's preferences and previous interactions with the application, also based on a form.
- Admin Panel: Admin users can add, edit, or remove books, manage orders, and view user activities.

## Data base

1  Book Entity
- Description: Represents a book in the system.
Attributes:
-id: The unique identifier for a book.
-title: The title of the book.
-author: The author of the book.
-category: The category this book belongs to, which is a many-to-one -relationship because many books can belong to one category.
-description: A description of the book.
-price: The price of the book.

2  Category Entity
- Description: Represents a category of books.
Attributes:
-id: The unique identifier for a category.
-name: The name of the category.
-books: A list of books that fall under this category, which is a one-to-many relationship because one category can have many books.

3  Order Entity
- Description: Represents an order placed in the system.
Attributes:
-id: The unique identifier for an order.
-uuid: A universally unique identifier for the order.
-name: The name of the person who placed the order.
-email: The email address of the person who placed the order.
-contactNumber: The contact number of the person who placed the order.
-paymentMethod: The payment method used for the order.
-total: The total amount of the order.

4  User Entity
- Description: Represents a user in the system.
Attributes:
-id: The unique identifier for a user.
-name: The name of the user.
-contactNumber: The contact number of the user.
-email: The email address of the user.
-password: The password for the user account.
-role: The role of the user in the system (e.g., admin, customer).

These relationships are typically managed by JPA (Java Persistence API) using annotations like @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany. The @JoinColumn annotation is used to define the actual foreign key in the database.

(https://drive.google.com/file/d/1nY4k881mOZJE_tmENT2RYwzbi9_2NDaa/view?usp=drive_link)

## Technology Stack

- Spring Boot: For creating the web application and handling backend logic.
- Spring Data JPA: For database operations, making it easier to work with relational data.
- MySQL: For the database to store book and user information.
- Spring Security: For authentication and authorization.
- Maven: For project management and build tool.

## Backend
  - Endpoints
 
POST /auth/insert
Registers a new user in the system.
Parameters:
userData (UserData): The data of the user to be registered.
Returns:
(UserData): The UserData object containing registration information of the newly created user.
Response Statuses:
200 OK: User successfully registered.
400 Bad Request: Invalid user data provided.
500 Internal Server Error: An error occurred during registration.

GET /auth/find
Finds a user based on the provided criteria.
Parameters:
userData (UserData): The criteria for the user search.
Returns:
(UserData): The found UserData object matching the search criteria.
Response Statuses:
200 OK: User successfully found.
404 Not Found: No matching user found.
400 Bad Request: Search criteria are invalid.
500 Internal Server Error: An error occurred during the search.

DELETE /auth/delete
Deletes a user from the system.
Parameters:
userData (UserData): The data of the user to be deleted.
Response Statuses:
200 OK: User successfully deleted.
404 Not Found: No matching user to delete.
400 Bad Request: Deletion criteria are invalid.
500 Internal Server Error: An error occurred during deletion.

PUT /auth/update
Updates an existing user's data.
Parameters:
userData (UserData): The new data for the user update.
Returns:
(UserData): The updated UserData object reflecting the changes made.
Response Statuses:
200 OK: User successfully updated.
404 Not Found: No matching user to update.
400 Bad Request: Update data is invalid.
500 Internal Server Error: An error occurred during the update.

GET /auth/findAll
Retrieves all users in the system.
Returns:
List<User>: A list of User entities representing all registered users.
Response Statuses:
200 OK: Successfully retrieved all users.
500 Internal Server Error: An error occurred retrieving users.

POST /book/insert
Inserts a new book record into the system.
Parameters:
bookData (BookData): An object containing the data of the book to be inserted.
Returns:
(BookData): The BookData object that was inserted.
Throws:
HTTP 400 Bad Request: If the book data is incomplete or invalid.
HTTP 500 Internal Server Error: If an error occurs during the insertion process.

GET /book/find
Retrieves the details of a book based on the provided book data.
Parameters:
bookData (BookData): An object containing the search criteria for the book to be found.
Returns:
(BookData): The found BookData object with full details.
Throws:
HTTP 404 Not Found: If no book matching the criteria is found.
HTTP 400 Bad Request: If the search criteria are invalid.

DELETE /book/delete
Deletes a book record from the system.
Parameters:
bookData (BookData): An object representing the book to be deleted.
Throws:
HTTP 404 Not Found: If no book matching the criteria is found for deletion.
HTTP 400 Bad Request: If the provided book data is invalid.
HTTP 500 Internal Server Error: If an error occurs during the deletion process.

PUT /book/update
Updates an existing book record with new information.
Parameters:
bookData (BookData): An object containing the updated data for the book.
Returns:
(BookData): The updated BookData object.
Throws:
HTTP 404 Not Found: If the book to be updated is not found.
HTTP 400 Bad Request: If the updated data is incomplete or invalid.
HTTP 500 Internal Server Error: If an error occurs during the update process.

POST /category/insert
Creates a new category in the system.
Parameters:
categoryData (CategoryData): The category information for the new category.
Returns:
(CategoryData): The data of the category that was successfully inserted.
Response Statuses:
200 OK: Successfully inserted the category.
400 Bad Request: Input data validation failed.
500 Internal Server Error: Unexpected error occurred.

GET /category/find
Finds a category based on the provided criteria.
Parameters:
categoryData (CategoryData): The criteria used to find a category.
Returns:
(CategoryData): The data of the found category.
Response Statuses:
200 OK: Successfully found the category.
404 Not Found: No category matched the criteria.
400 Bad Request: Search criteria are invalid.
500 Internal Server Error: Unexpected error occurred.

DELETE /category/delete
Removes a category from the system.
Parameters:
categoryData (CategoryData): The category to be deleted.
Response Statuses:
200 OK: Successfully deleted the category.
404 Not Found: The category to be deleted does not exist.
400 Bad Request: Deletion criteria are invalid.
500 Internal Server Error: Unexpected error occurred during deletion.

PUT /category/update
Updates the details of an existing category.
Parameters:
categoryData (CategoryData): The updated category data.
Returns:
(CategoryData): The data of the updated category.
Response Statuses:
200 OK: Successfully updated the category.
404 Not Found: The category to be updated does not exist.
400 Bad Request: Update data is invalid or incomplete.
500 Internal Server Error: Unexpected error occurred during the update.

POST /order/insert
Creates a new order record.
Parameters:
orderData (OrderData): The data of the order to be inserted.
Returns:
(OrderData): The inserted OrderData object reflecting the newly created order.
Response Statuses:
200 OK: Order successfully inserted.
400 Bad Request: Invalid order data provided.
500 Internal Server Error: An error occurred during the process.

GET /order/find
Retrieves a specific order based on provided data.
Parameters:
orderData (OrderData): The criteria for the order search.
Returns:
(OrderData): The found OrderData object matching the provided criteria.
Response Statuses:
200 OK: Order successfully found.
404 Not Found: No matching order found.
400 Bad Request: Invalid criteria provided.
500 Internal Server Error: An error occurred during the search process.

DELETE /order/delete
Deletes an existing order record.
Parameters:
orderData (OrderData): The data of the order to be deleted.
Response Statuses:
200 OK: Order successfully deleted.
404 Not Found: No matching order to delete.
400 Bad Request: Invalid data provided.
500 Internal Server Error: An error occurred during the deletion process.

PUT /order/update
Updates an existing order record with new information.
Parameters:
orderData (OrderData): The updated order data.
Returns:
(OrderData): The updated OrderData object reflecting the changes made.
Response Statuses:
200 OK: Order successfully updated.
404 Not Found: No matching order to update.
400 Bad Request: Invalid update data provided.
500 Internal Server Error: An error occurred during the update process.

- The Subject interface defines the core operations for managing observers in the Observer design pattern. Implementations of this interface will handle adding, removing, and notifying observers.

- The Observer interface defines the operation for receiving updates from the Subject. Implementations of this interface will include the update method, which is called when the Subject changes.

## Frontend

## Bibliography


