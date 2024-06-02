import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useParams } from "react-router-dom";
import './BookPage.css';

const BookPage = () => {
    const { id } = useParams();
    const [book, setBook] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [quantity, setQuantity] = useState(1);
    const [reviews, setReviews] = useState([]);
    const [newReview, setNewReview] = useState({ rating: '', message: '' });

    useEffect(() => {
        const authStatus = localStorage.getItem('isAuthenticated') === 'true';
        setIsAuthenticated(authStatus);
        fetchBook();
    }, [id]);

    const fetchBook = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/book/${id}`);
            setBook(response.data);
            setLoading(false);
            fetchReviews(response.data.title);
        } catch (error) {
            setError(error.message);
            setLoading(false);
        }
    };

    const fetchReviews = async (title) => {
        try {
            const response = await axios.post('http://localhost:8080/review/getReviews', { title });
            setReviews(response.data);
        } catch (error) {
            console.error('Error fetching reviews:', error);
        }
    };

    const handleAddToCart = async () => {
        try {
            const userId = localStorage.getItem('userId'); // Assumes you store userId in localStorage

            await axios.post(`http://localhost:8080/orderBook/insert`, {
                book_id: book.id,
                quantity: quantity // Use the selected quantity
            });

            console.log('Added to cart:', book.title);
            window.location.href = '/cartPage'; // Redirect to cart page after adding to cart
        } catch (error) {
            console.error('Error adding to cart:', error);
        }
    };

    const handleAddToWishlist = async () => {
        try {
            const username = localStorage.getItem('username'); // Assumes you store username in localStorage
            await axios.post(`http://localhost:8080/wishlist/insert`, {
                user: username,
                title: book.title
            });
            console.log('Added to wishlist:', book.title);
        } catch (error) {
            console.error('Error adding to wishlist:', error);
        }
    };

    const handleAddReview = async () => {
        try {
            const username = localStorage.getItem('username'); // Assumes you store username in localStorage
            await axios.post('http://localhost:8080/review/insert', {
                username,
                title: book.title,
                rating: newReview.rating,
                message: newReview.message
            });
            setNewReview({ rating: '', message: '' });
            fetchReviews(book.title); // Refresh reviews
        } catch (error) {
            console.error('Error adding review:', error);
        }
    };

    const handleDeleteReview = async (reviewId) => {
        try {
            await axios.delete('http://localhost:8080/review/delete', { data: { id: reviewId } });
            fetchReviews(book.title); // Refresh reviews
        } catch (error) {
            console.error('Error deleting review:', error);
        }
    };

    const handleReviewChange = (e) => {
        const { name, value } = e.target;
        setNewReview(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    if (!book) {
        return <div>No book found</div>;
    }

    return (
        <div className="BookPage">
            <div className="BookPageHeader">
                <div className="header-left">
                    <h1>Book Heaven</h1>
                </div>
                <div className="header-right">
                    <h2>
                        <Link to='/cartPage' className="cart">Cart</Link>
                        <Link to='/blog' className="blog">Blog</Link>
                        {isAuthenticated ? (
                            <Link to='/account' className="account">Account</Link>
                        ) : (
                            <Link to='/login' className="login">Login</Link>
                        )}
                    </h2>
                </div>
            </div>

            <div className="BookPageBody">
                <img src={`data:image/jpeg;base64,${book.image}`} alt={book.title} className="BookPageImage" />
                <div className="BookDetails">
                    <h2>{book.title}</h2>
                    <p><strong>Author:</strong> {book.author}</p>
                    <p><strong>Category:</strong> {book.category ? book.category.name : 'No Category'}</p>
                    <p><strong>Price:</strong> ${book.price}</p>
                    <p><strong>Description:</strong> {book.description}</p>
                    <div className="BookActions">
                        <input
                            type="number"
                            value={quantity}
                            onChange={(e) => setQuantity(parseInt(e.target.value))}
                            min="1"
                            className="quantity-input"
                        />
                        <button onClick={handleAddToWishlist} className="wishlist-button">Add to Wishlist</button>
                        <button onClick={handleAddToCart} className="cart-button">Add to Cart</button>
                    </div>
                </div>
                <div className="BookReviews">

                    <div className="AddReview">
                        <h4>Add a Review</h4>
                        <input
                            type="number"
                            name="rating"
                            value={newReview.rating}
                            onChange={handleReviewChange}
                            placeholder="Rating"
                            min="1"
                            max="5"
                            className="review-input"
                        />
                        <textarea
                            name="message"
                            value={newReview.message}
                            onChange={handleReviewChange}
                            placeholder="Message"
                            className="review-textarea"
                        ></textarea>
                        <button onClick={handleAddReview}>Submit Review</button>
                    </div>
                    <h3>Reviews</h3>
                    {reviews.map(review => (
                        <div key={review.id} className="review">
                            <p><strong>Rating:</strong> {review.rating}</p>
                            <p><strong>Message:</strong> {review.message}</p>
                            {/*<button onClick={() => handleDeleteReview(review.id)}>Delete</button>*/}
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default BookPage;
