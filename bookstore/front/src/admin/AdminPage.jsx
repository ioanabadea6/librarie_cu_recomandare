import React from 'react';
import { Link } from "react-router-dom";
import axios from 'axios';
import "./AdminPage.css";
import axiosInstance from '../axios';

class AdminPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showOptions: '',
            selectedAction: '',
            formData: {},
            users: [],
            books: [],
            categories: [],
            orders: [],
            searchResult: null,
            successMessage: '',
            errorMessage: '',
            userData: null,
            categoryData: null,
            imageFile: null // Adăugăm un state pentru fișierul imaginii
        };
    }

    handleMouseEnter = (section) => {
        this.setState({ showOptions: section });
    };

    handleMouseLeave = () => {
        this.setState({ showOptions: '' });
    };

    handleOptionClick = (action) => {
        this.setState({ selectedAction: action, searchResult: null, successMessage: '', errorMessage: '' });
    };

    handleInputChange = (e) => {
        const { name, value } = e.target;
        this.setState(prevState => ({
            formData: {
                ...prevState.formData,
                [name]: value
            }
        }));
    };

    handleFileChange = (e) => {
        const file = e.target.files[0];
        this.setState({ imageFile: file });
    };

    handleSubmit = async (e) => {
        e.preventDefault();
        const { selectedAction, formData, imageFile } = this.state;
        let response;
        try {
            if (selectedAction === 'insertBook' || selectedAction === 'updateBook') {
                const form = new FormData();
                for (const key in formData) {
                    form.append(key, formData[key]);
                }
                if (imageFile) {
                    form.append('image', imageFile);
                }

                console.log('Form data:', formData);
                console.log('Image file:', imageFile);

                if (selectedAction === 'insertBook') {
                    response = await axios.post('http://localhost:8080/book/insert', form, {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    });
                    this.setState({ successMessage: 'Book was added successfully!' });
                } else if (selectedAction === 'updateBook') {
                    response = await axios.put('http://localhost:8080/book/update', form, {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    });
                    this.setState({ successMessage: 'Book was updated successfully!' });
                }
            } else {
                switch (selectedAction) {
                    case 'insertUser':
                        response = await axios.post('http://localhost:8080/auth/insert', formData);
                        this.setState({ successMessage: 'User was added successfully!' });
                        break;
                    case 'deleteUser':
                        response = await axios.delete('http://localhost:8080/auth/delete', { data: formData });
                        this.setState({ successMessage: 'User was deleted successfully!' });
                        break;
                    case 'findUser':
                        response = await axiosInstance.post("auth/find", { username: formData.username });
                        this.setState({
                            userData: response.data,
                            successMessage: 'User found successfully!'
                        });
                        break;
                    case 'findAllUsers':
                        response = await axios.get('http://localhost:8080/auth/findAll');
                        this.setState({ users: response.data });
                        break;
                    case 'updateUser':
                        response = await axios.put('http://localhost:8080/auth/update', formData);
                        this.setState({ successMessage: 'User was updated successfully!' });
                        break;
                    case 'deleteBook':
                        response = await axios.delete('http://localhost:8080/book/delete', { data: formData });
                        this.setState({ successMessage: 'Book was deleted successfully!' });
                        break;
                    case 'findBook':
                        response = await axios.post('http://localhost:8080/book/find', { params: formData });
                        this.setState({ searchResult: response.data });
                        break;
                    case 'findAllBooks':
                        response = await axios.get('http://localhost:8080/book/findAll');
                        this.setState({ books: response.data });
                        break;
                    case 'insertCategory':
                        response = await axios.post('http://localhost:8080/category/insert', formData);
                        this.setState({ successMessage: 'Category was added successfully!' });
                        break;
                    case 'deleteCategory':
                        response = await axios.delete('http://localhost:8080/category/delete', { data: formData });
                        this.setState({ successMessage: 'Category was deleted successfully!' });
                        break;
                    case 'findCategory':
                        response = await axios.post('http://localhost:8080/category/findByName', { params: formData });
                        this.setState({
                            categoryData: response.data,
                            successMessage: 'Category found successfully!'
                        });
                        break;
                    case 'findAllCategories':
                        response = await axios.get('http://localhost:8080/category/findAll');
                        this.setState({ categories: response.data });
                        break;
                    case 'updateCategory':
                        response = await axios.put('http://localhost:8080/category/update', formData);
                        this.setState({ successMessage: 'Category was updated successfully!' });
                        break;
                    case 'insertOrder':
                        response = await axios.post('http://localhost:8080/order/insert', formData);
                        this.setState({ successMessage: 'Order was added successfully!' });
                        break;
                    case 'deleteOrder':
                        response = await axios.delete('http://localhost:8080/order/delete', { data: formData });
                        this.setState({ successMessage: 'Order was deleted successfully!' });
                        break;
                    case 'findOrder':
                        response = await axios.get('http://localhost:8080/order/find', { params: formData });
                        this.setState({ searchResult: response.data });
                        break;
                    case 'findAllOrders':
                        response = await axios.get('http://localhost:8080/order/findAll');
                        this.setState({ orders: response.data });
                        break;
                    case 'updateOrder':
                        response = await axios.put('http://localhost:8080/order/update', formData);
                        this.setState({ successMessage: 'Order was updated successfully!' });
                        break;
                    default:
                        break;
                }
            }
            if (response && response.data) {
                console.log(response.data);
                this.setState({ formData: {}, imageFile: null });
            }
        } catch (error) {
            console.error('Error response:', error.response);
            this.setState({ errorMessage: 'An error occurred during the operation. Please try again.' });
        }
    };

    renderForm = () => {
        const { selectedAction, searchResult, successMessage, errorMessage } = this.state;
        return (
            <div>
                {(selectedAction === 'insertUser') &&
                    this.renderUserForm('Insert User', ['username', 'name', 'email', 'password', 'role'])}
                {(selectedAction === 'deleteUser') &&
                    this.renderUserForm('Delete User', ['username'])}
                {selectedAction === 'findAllUsers' && this.renderButtonForm('Find All Users', 'Fetch Users')}
                {(selectedAction === 'updateUser') &&
                    this.renderUserForm('Update User', ['username', 'name', 'email', 'password', 'role'])}
                {(selectedAction === 'findUser') &&
                    this.renderUserForm('Find User', ['username'])}

                {(selectedAction === 'insertBook') &&
                    this.renderBookForm('Insert Book', ['title', 'author', 'category', 'description', 'price', 'stock', 'image'])}
                {(selectedAction === 'deleteBook') &&
                    this.renderUserForm('Delete Book', ['title'])}
                {selectedAction === 'findAllBooks' && this.renderButtonForm('Find All Books', 'Fetch Books')}
                {(selectedAction === 'updateBook') &&
                    this.renderBookForm('Update Book', ['title', 'author', 'category', 'description', 'price', 'stock', 'image'])}
                {(selectedAction === 'findBook') &&
                    this.renderUserForm('Find Book', ['title'])}

                {(selectedAction === 'insertCategory') &&
                    this.renderUserForm('Insert Category', ['name'])}
                {(selectedAction === 'deleteCategory') &&
                    this.renderUserForm('Delete Category', ['name'])}
                {(selectedAction === 'updateCategory') &&
                    this.renderUserForm('Update Category', ['name'])}
                {(selectedAction === 'findCategory') &&
                    this.renderUserForm('Find Category', ['name'])}
                {selectedAction === 'findAllCategories' && this.renderButtonForm('Find All Categories', 'Fetch Categories')}

                {(selectedAction === 'insertOrder') &&
                    this.renderUserForm('Insert Order', ['customer_fk', 'book_fk', 'quantity', 'totalPrice', 'status', 'deliveryAddress', 'orderDate', 'orderNumber'])}
                {(selectedAction === 'deleteOrder') &&
                    this.renderUserForm('Delete Order', ['orderNumber'])}
                {(selectedAction === 'updateOrder') &&
                    this.renderUserForm('Update Order', ['orderNumber', 'status'])}
                {(selectedAction === 'findOrder') &&
                    this.renderUserForm('Find Order', ['orderNumber'])}
                {selectedAction === 'findAllOrders' && this.renderButtonForm('Find All Orders', 'Fetch Orders')}

                {searchResult && this.renderSearchResult(searchResult)}
                {successMessage && <div className="success-message">{successMessage}</div>}
                {errorMessage && <div className="error-message">{errorMessage}</div>}
            </div>
        );
    };

    renderUserForm = (title, fields) => (
        <form className="user-form" onSubmit={this.handleSubmit}>
            <h4>{title}</h4>
            <div className="form-fields">
                {fields.map(field => (
                    <label key={field}>
                        {field.charAt(0).toUpperCase() + field.slice(1)}:
                        <input
                            type={field === 'image' ? 'file' : 'text'}
                            name={field}
                            placeholder={field}
                            value={field === 'image' ? '' : (this.state.formData[field] || '')}
                            onChange={field === 'image' ? this.handleFileChange : this.handleInputChange}
                        />
                    </label>
                ))}
            </div>
            <button type="submit">Submit</button>
        </form>
    );

    renderBookForm = (title, fields) => (
        <form className="user-form" onSubmit={this.handleSubmit}>
            <h4>{title}</h4>
            <div className="form-fields">
                {fields.map(field => (
                    <label key={field}>
                        {field.charAt(0).toUpperCase() + field.slice(1)}:
                        <input
                            type={field === 'image' ? 'file' : 'text'}
                            name={field}
                            placeholder={field}
                            value={field === 'image' ? '' : (this.state.formData[field] || '')}
                            onChange={field === 'image' ? this.handleFileChange : this.handleInputChange}
                        />
                    </label>
                ))}
            </div>
            <button type="submit">Submit</button>
        </form>
    );

    renderButtonForm = (title, buttonText) => (
        <form className="button-form" onSubmit={this.handleSubmit}>
            <h4>{title}</h4>
            <button type="submit">{buttonText}</button>
        </form>
    );

    renderSearchResult = (result) => (
        <div className="search-result">
            <h4>Search Result:</h4>
            <pre>{JSON.stringify(result, null, 2)}</pre>
        </div>
    );

    renderUserDetails = (user) => (
        <div className="user-details">
            <h4>User Details:</h4>
            <table>
                <tbody>
                <tr>
                    <td>Username:</td>
                    <td>{user.username}</td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>{user.name}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>{user.email}</td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>{user.password}</td>
                </tr>
                </tbody>
            </table>
        </div>
    );

    render() {
        const { showOptions, users, books, categories, orders, userData } = this.state;

        return (
            <div className="AdminPage">
                <div className="AdminPageHeader">
                    <h1>Book Heaven</h1>
                    <h2>
                        <Link to="/logout">LogOut</Link>
                    </h2>
                </div>

                <div className="AdminPageBody">
                    <h4>Admin Page</h4>
                    <div
                        className="admin-options"
                        onMouseEnter={() => this.handleMouseEnter('user')}
                        onMouseLeave={this.handleMouseLeave}
                    >
                        <h3>User Administration</h3>
                        {showOptions === 'user' && (
                            <ul className="options-list">
                                <li onClick={() => this.handleOptionClick('insertUser')}>Insert</li>
                                <li onClick={() => this.handleOptionClick('deleteUser')}>Delete</li>
                                <li onClick={() => this.handleOptionClick('findUser')}>Find</li>
                                <li onClick={() => this.handleOptionClick('findAllUsers')}>Find All</li>
                                <li onClick={() => this.handleOptionClick('updateUser')}>Update</li>
                            </ul>
                        )}
                    </div>
                    <div
                        className="admin-options"
                        onMouseEnter={() => this.handleMouseEnter('book')}
                        onMouseLeave={this.handleMouseLeave}
                    >
                        <h3>Book Administration</h3>
                        {showOptions === 'book' && (
                            <ul className="options-list">
                                <li onClick={() => this.handleOptionClick('insertBook')}>Insert</li>
                                <li onClick={() => this.handleOptionClick('deleteBook')}>Delete</li>
                                <li onClick={() => this.handleOptionClick('findBook')}>Find</li>
                                <li onClick={() => this.handleOptionClick('findAllBooks')}>Find All</li>
                                <li onClick={() => this.handleOptionClick('updateBook')}>Update</li>
                            </ul>
                        )}
                    </div>
                    <div
                        className="admin-options"
                        onMouseEnter={() => this.handleMouseEnter('category')}
                        onMouseLeave={this.handleMouseLeave}
                    >
                        <h3>Category Administration</h3>
                        {showOptions === 'category' && (
                            <ul className="options-list">
                                <li onClick={() => this.handleOptionClick('insertCategory')}>Insert</li>
                                <li onClick={() => this.handleOptionClick('deleteCategory')}>Delete</li>
                                <li onClick={() => this.handleOptionClick('findCategory')}>Find</li>
                                <li onClick={() => this.handleOptionClick('findAllCategories')}>Find All</li>
                                <li onClick={() => this.handleOptionClick('updateCategory')}>Update</li>
                            </ul>
                        )}
                    </div>
                    <div
                        className="admin-options"
                        onMouseEnter={() => this.handleMouseEnter('order')}
                        onMouseLeave={this.handleMouseLeave}
                    >
                        <h3>Order Administration</h3>
                        {showOptions === 'order' && (
                            <ul className="options-list options-list-top">
                                <li onClick={() => this.handleOptionClick('insertOrder')}>Insert</li>
                                <li onClick={() => this.handleOptionClick('deleteOrder')}>Delete</li>
                                <li onClick={() => this.handleOptionClick('findOrder')}>Find</li>
                                <li onClick={() => this.handleOptionClick('findAllOrders')}>Find All</li>
                                <li onClick={() => this.handleOptionClick('updateOrder')}>Update</li>
                            </ul>
                        )}
                    </div>
                </div>

                <div className="AdminPageFooter">
                    {this.renderForm()}
                    {this.state.selectedAction === 'findAllUsers' && (
                        <div>
                            <h4>All Users</h4>
                            <ul>
                                {users.map(user => (
                                    <li key={user.id}>{user.username}</li>
                                ))}
                            </ul>
                        </div>
                    )}
                    {this.state.selectedAction === 'findAllBooks' && (
                        <div>
                            <h4>All Books</h4>
                            <ul>
                                {books.map(book => (
                                    <li key={book.id}>{book.title}</li>
                                ))}
                            </ul>
                        </div>
                    )}
                    {this.state.selectedAction === 'findAllCategories' && (
                        <div>
                            <h4>All Categories</h4>
                            <ul>
                                {categories.map(category => (
                                    <li key={category.id}>{category.name}</li>
                                ))}
                            </ul>
                        </div>
                    )}
                    {this.state.selectedAction === 'findAllOrders' && (
                        <div>
                            <h4>All Orders</h4>
                            <ul>
                                {orders.map(order => (
                                    <li key={order.id}>{order.orderNumber}</li>
                                ))}
                            </ul>
                        </div>
                    )}
                    {userData && this.renderUserDetails(userData)}
                </div>

            </div>
        );
    }
}

export default AdminPage;
