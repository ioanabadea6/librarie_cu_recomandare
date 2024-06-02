import React, { Component } from 'react';
import axios from 'axios';
import './Books.css';
import { Link } from "react-router-dom";

class Books extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            loading: true,
            error: null,
            isAuthenticated: false,
            searchQuery: '',
            filters: {
                title: '',
                price: '',
                author: '',
                category: ''
            },
            currentPage: 1,
            booksPerPage: 15
        };
    }

    componentDidMount() {
        const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';
        if (isAuthenticated) {
            this.setState({ isAuthenticated: true });
        }
        this.fetchBooks();
    }

    fetchBooks = () => {
        axios.get('http://localhost:8080/book/findAll')
            .then(response => {
                this.setState({ books: response.data, loading: false });
            })
            .catch(error => {
                this.setState({ error: error.message, loading: false });
            });
    }

    handleSearch = (event) => {
        this.setState({ searchQuery: event.target.value });
    }

    handleFilterChange = (event) => {
        const { name, value } = event.target;
        this.setState(prevState => ({
            filters: {
                ...prevState.filters,
                [name]: value
            }
        }));
    }

    handlePageChange = (pageNumber) => {
        this.setState({ currentPage: pageNumber });
    }

    handleSearchButtonClick = () => {
        console.log('Search button clicked');
    }

    handleFilterButtonClick = () => {
        console.log('Filter button clicked');
    }

    render() {
        const { isAuthenticated, books, searchQuery, filters, currentPage, booksPerPage, loading, error } = this.state;

        if (loading) {
            return <div>Loading...</div>;
        }

        if (error) {
            return <div>Error: {error}</div>;
        }

        const filteredBooks = books.filter(book => {
            return (
                book.title.toLowerCase().includes(searchQuery.toLowerCase()) &&
                (filters.title ? book.title.toLowerCase().includes(filters.title.toLowerCase()) : true) &&
                (filters.price ? book.price <= parseFloat(filters.price) : true) &&
                (filters.author ? book.author.toLowerCase().includes(filters.author.toLowerCase()) : true) &&
                (filters.category ? book.category.toLowerCase().includes(filters.category.toLowerCase()) : true)
            );
        });

        const indexOfLastBook = currentPage * booksPerPage;
        const indexOfFirstBook = indexOfLastBook - booksPerPage;
        const currentBooks = filteredBooks.slice(indexOfFirstBook, indexOfLastBook);
        const totalPages = Math.ceil(filteredBooks.length / booksPerPage);

        return (
            <div className="Books">
                <div className="BooksHeader">
                    <div className="header-left">
                        <h1>Book Heaven</h1>
                    </div>
                    <div className="header-right">
                        <h2>
                            <Link to='/cartPage' className="books">Cart</Link>
                            <Link to='/blog' className="blog">Blog</Link>
                            {isAuthenticated ? (
                                <Link to='/account' className="account">Account</Link>
                            ) : (
                                <Link to='/login' className="login">Login</Link>
                            )}
                        </h2>
                    </div>
                </div>

                <div className="BooksBody">
                    <div className="BooksSidebar">
                        <div className="BooksSearch">
                            {/*<input*/}
                            {/*    type="text"*/}
                            {/*    placeholder="Search books..."*/}
                            {/*    value={searchQuery}*/}
                            {/*    onChange={this.handleSearch}*/}
                            {/*/>*/}
                            {/*<button onClick={this.handleSearchButtonClick}>Search</button>*/}
                        </div>
                        <div className="BooksFilters">
                            <h3>Filter by:</h3>
                            <input
                                type="text"
                                name="title"
                                placeholder="Title"
                                value={filters.title}
                                onChange={this.handleFilterChange}
                            />
                            <input
                                type="number"
                                name="price"
                                placeholder="Max Price"
                                value={filters.price}
                                onChange={this.handleFilterChange}
                            />
                            <input
                                type="text"
                                name="author"
                                placeholder="Author"
                                value={filters.author}
                                onChange={this.handleFilterChange}
                            />
                            <input
                                type="text"
                                name="category"
                                placeholder="Category"
                                value={filters.category}
                                onChange={this.handleFilterChange}
                            />
                            <button onClick={this.handleFilterButtonClick}>Filter</button>
                        </div>
                    </div>

                    <div className="BooksList">
                        {currentBooks.map(book => (
                            <Link to={`/book/${book.id}`} key={book.id} className="BookCardLink">
                                <div className="BookCard">
                                    {book.image ? (
                                        <img
                                            src={`data:image/jpeg;base64,${book.image}`}
                                            alt={book.title}
                                            className="BookImage"
                                        />
                                    ) : (
                                        <div className="PlaceholderImage">No Image Available</div>
                                    )}
                                    <h4>{book.title}</h4>
                                </div>
                            </Link>
                        ))}
                    </div>
                </div>

                <div className="Pagination">
                    <button
                        onClick={() => this.handlePageChange(currentPage - 1)}
                        disabled={currentPage === 1}
                        className="pagination-button"
                    >
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24">
                            <path d="M15.41 16.58L10.83 12l4.58-4.58L14 6l-6 6 6 6z" />
                            <path d="M0 0h24v24H0z" fill="none" />
                        </svg>
                    </button>
                    {Array.from({ length: totalPages }, (_, index) => (
                        <button
                            key={index}
                            onClick={() => this.handlePageChange(index + 1)}
                            className={`pagination-button ${currentPage === index + 1 ? 'active' : ''}`}
                        >
                            {index + 1}
                        </button>
                    ))}
                    <button
                        onClick={() => this.handlePageChange(currentPage + 1)}
                        disabled={currentPage === totalPages}
                        className="pagination-button"
                    >
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24">
                            <path d="M8.59 16.58L13.17 12l-4.58-4.58L10 6l6 6-6 6z" />
                            <path d="M0 0h24v24H0z" fill="none" />
                        </svg>
                    </button>
                </div>
            </div>
        );
    }
}

export default Books;
