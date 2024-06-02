## _BOOKSTORE WITH RECOMMENDATION_

This project is a web-based bookstore application that allows users to browse, search for, and purchase books. It features a recommendation system that suggests books based on the user's browsing and purchase history, as well as ratings and reviews, books can also be recommended based on a form that the user fills out.

## Features

- User Registration and Authentication: Users can sign up, log in, and manage their profiles.
- Book Catalog: Users can browse and search the catalog by various criteria (title, author, genre, etc.).
- Book Details: Detailed information about books, including descriptions, ratings, and reviews.
- Shopping Cart: Users can add books to their shopping cart and proceed to checkout.
- Recommendations: The system recommends random books.
- Admin Panel: Admin users can add, edit, or remove books, manage orders, and view user activities.

## Data base

1  Book Entity
- Description: Represents a user entity in the system.
Attributes:
-id (Integer): The unique identifier for a book, annotated with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY).
-title (String): The title of the book.
-author (String): The author of the book.
-category (Category): A many-to-one relationship indicating the category of the book. This uses lazy fetching to optimize performance.
-description (String): A description of the book.
-price (Integer): The price of the book in some unit of currency.
-stock (Integer): The quantity of this book available in stock.

2  Category Entity
- Description: Represents a category of books.
Attributes:
-id: The unique identifier for a category.
-name: The name of the category.
-books: A list of books that fall under this category, which is a one-to-many relationship because one category can have many books.

3  Order Entity
- Description: Represents an order placed in the system.
Attributes:
-id (Integer): Stored in the database column 'id'.
-name (String): Stored in the database column 'name'.
-email (String): Stored in the database column 'email'.
-contactNumber (String): Stored in the database column 'contactnumber'.
-paymentMethod (String): Stored in the database column 'paymentmethod'.
-total (Integer): Stored in the database column 'total'.
-user (User): Many-to-one relationship linked via 'user_id'.

4  User Entity
- Description: Represents a user in the system.
Attributes:
-id (Integer): Stored in the database column 'id'.
-username (String): Stored in the database column 'username'.
-name (String): Stored in the database column 'name'.
-contactNumber (String): Stored in the database column 'contactNumber'.
-email (String): Stored in the database column 'email'.
-password (String): Stored in the database column 'password'.
-role (String): Stored in the database column 'role'.

5  OrderBook Entity
- Description: Represents a many-to-many relationship between Orders and Books.
Attributes:
-id (Integer): Stored in the database column 'id'.
-book (Book): Many-to-one relationship linked via 'book_id'.
-quantity (Integer): Quantity of books ordered.

6. Wishlist Entity
- Description: Represents a user's wishlist.
Attributes:
-id: A unique identifier for each wishlist entry. It is the primary key and is auto-generated.
-user: Represents the user who owns the wishlist. It is mapped using a foreign key (user_id) to the User entity.
-book: Represents the book added to the wishlist. It is mapped using a foreign key (book_id) to the Book entity.

These relationships are typically managed by JPA (Java Persistence API) using annotations like @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany. The @JoinColumn annotation is used to define the actual foreign key in the database.

![Diagrama bd]
("E:\An3\PS\librarie_cu_recomandare\diagrama_bd.png")
("E:\An3\PS\librarie_cu_recomandare\bookstore.png")
![Admin]
("E:\An3\PS\librarie_cu_recomandare\admin.png")
![User]
("E:\An3\PS\librarie_cu_recomandare\user.png")

## Technology Stack

- Spring Boot: For creating the web application and handling backend logic.
- Spring Data JPA: For database operations, making it easier to work with relational data.
- MySQL: For the database to store book and user information.
- Spring Security: For authentication and authorization.
- Maven: For project management and build tool.
- React: For creating the frontend.

## Frontend 
- The BookStore application is an e-commerce platform dedicated to selling books online. The frontend of the application is developed using React for building the user interface, Redux for managing the application state, and Axios for communicating with the backend. The project is organized in a clear directory structure, which separates reusable components, main containers, state management logic, and API services. This facilitates the maintenance and further extension of the application. Users can navigate the site, add books to the cart, view product details, and place orders. User authentication allows managing personal preferences and viewing previous orders.


## Backend
- Endpoints
- Book: /book
Endpoints
POST/insert: Adds a new book to the system.
POST/find: Retrieves a book based on criteria.
DELETE/delete: Deletes a specified book from the system.
PUT/update: Updates details of an existing book.
GET/findAll: Retrieves all books available in the system.
GET/{id}: Retrieves a book based on id.
GET/random: Retrieves a random book.
GET/findByTitlePriceAuthorAndCategory: Searches books based on title, price, author, and category criteria.
GET/findByTitleAuthor: Searches books based on title, author.
PUT/updateStock: Updates stock of an existing book.

- Category: /category
POST/insert: Adds a new category to the system.
GET/find: Retrieves a category based on specified criteria.
DELETE/delete: Deletes a specified category from the system.
Request Body: CategoryData (details of the category to be deleted)
PUT/update: Updates details of an existing category.
GET/findAll: Retrieves all categories available in the system.

- OrderBook: /orderBook
POST/insert: Adds a new order book record to the system.
POST/find: Retrieves an order book based on specified criteria.
DELETE
Path:/deleteByBookId/{bookId}: Removes a specified order book from the system.
Path:/deleteAll: Removes all orderBooks from the system.
PUT/update: Updates details of an existing order book.
GET/findAll: Retrieves all order books in the system.

- Order: /order
POST/insert: Creates a new order in the system.
POST/find: Retrieves an order based on specified criteria.
DELETE/delete: Deletes an existing order from the system.
PUT/update: Updates an existing order with new information.
GET/findAll: Retrieves all ordes in the system.

- User: /auth
POST/insert: Registers a new user in the system.
POST/find: Retrieves a user based on the provided username data.
DELETE/delete: Removes a user from the system based on provided username data.
PUT/update: Updates details of an existing user.
PUT/updatePass: Updates password of an existing user.
GET/findAll: Retrieves a list of all users in the system.
PUT/findAll: Retrieves all users in the system.
POST/login: Login a user.
POST/logout: logout a user.

- Wishlist: /wishlist
POST/insert: Adds a book to the user's favorite list.
DELETE/delete: Removes a book from the user's favorite list.
POST/getFavorite: Retrieves the wishlist books for a user.

- Observer pattern

The Observer pattern is a software design pattern that establishes a one-to-many relationship between objects so that when one object changes state, all of its dependents are notified and updated automatically. This pattern is especially useful for implementing distributed event-handling systems, where the state of one object needs to trigger actions in other objects without making the objects tightly coupled.

Key Components of the Observer Pattern
-Subject: This is the core of the pattern. The subject maintains a list of its dependents, called observers, and notifies them of any state changes, usually by calling one of their methods defined by the observer interface.
-Observer: This is an interface that defines the update method that must be implemented by any object that wishes to receive notifications from the subject. Observers register themselves with a subject to receive updates.
-Concrete Subject: A concrete implementation of the subject interface. This class maintains the state of the object and when a change in the state occurs, it notifies the list of observers attached to it.
-Concrete Observer: An object that wishes to be notified about changes in the concrete subject. It implements the observer interface and contains logic in the update method to react to the changes being notified.

Benefits of Using the Observer Pattern
-Decoupling: The subject doesn't need to know anything about the observers. This level of abstraction allows for dynamic interaction systems without tight coupling between components.
-Dynamic Relationships: You can add and remove observers dynamically without altering the subject.
Supports Broadcast Communication: Whenever there's a change to the subject, all registered observers are notified and updated in one go, which is more efficient than polling for changes.

The Subject interface defines the core operations for managing observers in the Observer design pattern. Implementations of this interface will handle adding, removing, and notifying observers.
The Observer interface defines the operation for receiving updates from the Subject. Implementations of this interface will include the update method, which is called when the Subject changes.

- Test

BookServiceImplTest
1.setUp()
-Initializes mocks and the BookServiceImpl instance before each test.
-Attaches an observer to the BookServiceImpl for notification testing.
2.insertBookAndObserver()
-Tests the insertion of a book and verifies that the observer is notified correctly.
3.testUpdateBookWithStockChangeAndObserver()
-Tests updating a book's stock and verifies that the observer is notified of the stock change.
4.deleteBookTest()
-Tests the deletion of a book and ensures the repository's delete method is called.
5.findBookTest()
-Tests finding a book by data and ensures the correct repository method is called.
6.findAllBooksTest()
-Tests retrieving all books and ensures the correct repository method is called.
7.findByTitlePriceAuthorAndCategoryTest()
-Tests finding books by multiple criteria such as title, price, author, and category.
8.createNotifyMessagePriceTest()
-Tests the creation of a notification message when a book's price changes.
createNotifyMessageStockTest()
-Tests the creation of a notification message when a book's stock changes.

CategoryServiceImplTest
1.setUp()
-Prepares the test environment by initializing mocks and creating an instance of CategoryServiceImpl with a mocked CategoryRepo.
2.insertCategoryTest()
-Verifies that the category repository's save method is called when inserting a new category.
-Ensures that the category is properly created and persisted.
3.deleteCategoryTest()
-Tests the deletion of a category, verifying that the category repository's delete method is invoked with the correct category.
4.updateCategoryTest()
-Checks the update functionality by ensuring that the category repository's findById method is called.
-Verifies that the category is updated correctly based on the provided data.
5.findCategoryTest()
-Tests finding a category by ID, verifying that the category repository's findById method is used to retrieve the correct category.

OrderBookServiceImplTest
1.1setUp()
-Initializes mocks and creates an instance of OrderBookServiceImpl with mocked repositories for preparation before each test.
2.insertOrderBook()
-Tests the insertion of an order book and verifies that the save method of the OrderBookRepo is called.
3.deleteOrderBook()
-Tests the deletion of an order book and verifies that the delete method of the OrderBookRepo is called.
4.updateOrderBook()
-Tests the update functionality for an order book, including verification that the appropriate find method is called to locate the existing order book before updating.
5.findOrderBook()
-Tests the functionality to find an order book based on a specific order ID, ensuring the correct repository method is invoked.
6.findAllTest()
-Tests retrieving all order books from the repository, verifying that the findAll method of the OrderBookRepo is correctly called.

OrderServiceImplTest
1.setUp()
-Initializes the test environment by creating mocks for necessary repositories and an instance of OrderServiceImpl.
2.insertOrderTest()
-Tests the insertion of an order and verifies that the save method of the OrderRepo is called.
3.deleteOrderTest()
-Tests the deletion of an order by finding the order first and then ensuring that the delete method of the OrderRepo is called with the correct order.
4.updateOrderTest()
-Tests the update functionality by first finding an existing order and then verifying that the updated order is saved correctly.
5.findOrderTest()
-Tests the retrieval of an order by name, verifying that the findByName method of the OrderRepo is used to locate the order.

UserServiceImplTest
1.setUp()
-Prepares the test environment by initializing mocks and creating an instance of UserServiceImpl.
2.insertUserTest()
-Tests the insertion of a user and verifies that the save method of the UserRepo is called.
3.deleteUserTest()
-Tests the deletion of a user by verifying that the delete method of the UserRepo is invoked with the correct user.
4.updateUserTest()
-Tests the update functionality by first finding an existing user and then verifying that the updated user is saved correctly.
5.findUserTest()
-Tests the retrieval of a user by username, verifying that the findByUsername method of the UserRepo is used to locate the user.
6.findAll()
-Tests retrieving all users from the repository, verifying that the findAll method of the UserRepo is correctly called.



