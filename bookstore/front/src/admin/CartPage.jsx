import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import "./CartPage.css";

const Cart = () => {
    const [cartItems, setCartItems] = useState([]);
    const [showOrderForm, setShowOrderForm] = useState(false);
    const [contactNumber, setContactNumber] = useState('');
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [paymentMethod, setPaymentMethod] = useState('Credit Card');
    const [email, setEmail] = useState(localStorage.getItem('email') || '');
    const [error, setError] = useState('');
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    useEffect(() => {
        const authStatus = localStorage.getItem('isAuthenticated') === 'true';
        setIsAuthenticated(authStatus);
        fetchCartItems();
    }, []);

    const fetchCartItems = async () => {
        try {
            const response = await fetch('http://localhost:8080/orderBook/findAll');
            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(`Error fetching cart items: ${errorText}`);
            }
            const data = await response.json();
            setCartItems(data);
        } catch (error) {
            setError(error.message);
            console.error('Error fetching cart items:', error);
        }
    }

    const removeItem = async (bookId) => {
        try {
            const response = await fetch(`http://localhost:8080/orderBook/deleteByBookId/${bookId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(`Error removing item: ${errorText}`);
            }

            fetchCartItems(); // Refresh cart items
        } catch (error) {
            setError(error.message);
            console.error('Error removing item:', error);
        }
    }

    const handlePlaceOrderClick = () => {
        setShowOrderForm(true);
    }

    const handleFormChange = (event) => {
        const { name, value } = event.target;
        if (name === "contactNumber") {
            setContactNumber(value);
        } else if (name === "name") {
            setName(value);
        } else if (name === "paymentMethod") {
            setPaymentMethod(value);
        } else if (name === "address") {
            setAddress(value);
        } else if (name === "email") {
            setEmail(value);
        }
    }

    const placeOrder = async (event) => {
        event.preventDefault();
        try {
            const username = localStorage.getItem('username');

            if (!username) {
                alert('User is not logged in');
                return;
            }

            const orderData = {
                items: cartItems.map(item => ({
                    bookId: item.book.id,
                    quantity: item.quantity
                })),
                // userId: parseInt(userId, 10),
                name: name,
                email: email,
                contactNumber: contactNumber,
                address: address,
                paymentMethod: paymentMethod,
                total: cartItems.reduce((acc, item) => acc + item.book.price * item.quantity, 0)
            };

            const response = await fetch('http://localhost:8080/order/insert', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(orderData)
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(`Error placing order: ${errorText}`);
            }

            await deleteAllOrderBooks();

            alert('Order placed successfully!');
            setCartItems([]);
            setShowOrderForm(false);
        } catch (error) {
            setError(error.message);
            console.error('Error placing order:', error);
        }
    }

    const deleteAllOrderBooks = async () => {
        try {
            const response = await fetch('http://localhost:8080/orderBook/deleteAll', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(`Error deleting all order books: ${errorText}`);
            }
        } catch (error) {
            setError(error.message);
            console.error('Error deleting all order books:', error);
        }
    }

    const total = cartItems.reduce((acc, item) => acc + item.book.price * item.quantity, 0);

    return (
        <div className="CartPage">
            <div className="CartHeader">
                <h1>Book Heaven</h1>
                <h2>
                    <Link to='/book' className="books">Books</Link>
                    <Link to='/blog' className="blog">Blog</Link>
                    {isAuthenticated ? (
                        <Link to='/account' className="account">Account</Link>
                    ) : (
                        <Link to='/login' className="login">Login</Link>
                    )}
                </h2>
            </div>

            <div className="CartBody">
                <h3>Your Cart</h3>
                {error && <div className="error">{error}</div>}
                <table>
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {cartItems.map(item => (
                        <tr key={item.id}>
                            <td>{item.book.title}</td>
                            <td>${item.book.price}</td>
                            <td>{item.quantity}</td>
                            <td>${item.book.price * item.quantity}</td>
                            <td>
                                <button onClick={() => removeItem(item.book.id)}>Remove</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <div className="total">
                    Total: ${total}
                </div>
                <button className="place-order" onClick={handlePlaceOrderClick}>Place Order</button>
            </div>

            {showOrderForm && (
                <div className="OrderForm">
                    <h3>Enter Your Details</h3>
                    <form onSubmit={placeOrder}>
                        <div>
                            <label>Name:</label>
                            <input
                                type="text"
                                name="name"
                                value={name}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label>Email:</label>
                            <input
                                type="email"
                                name="email"
                                value={email}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label>Contact Number:</label>
                            <input
                                type="text"
                                name="contactNumber"
                                value={contactNumber}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label>Address:</label>
                            <input
                                type="text"
                                name="address"
                                value={address}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label>Payment Method:</label>
                            <select
                                name="paymentMethod"
                                value={paymentMethod}
                                onChange={handleFormChange}
                                required
                            >
                                <option value="Credit Card">Credit Card</option>
                                <option value="PayPal">PayPal</option>
                                <option value="Cash on Delivery">Cash on Delivery</option>
                            </select>
                        </div>
                        <button type="submit">Submit Order</button>
                    </form>
                </div>
            )}
        </div>
    );
}

export default Cart;
