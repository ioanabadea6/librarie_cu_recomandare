import React, { Component } from "react";
import { Link } from "react-router-dom";
import axiosInstance from '../axios';
import "./Account.css";

class Account extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accountData: {
                username: localStorage.getItem('username') || '',
                email: localStorage.getItem('email') || '',
                password: '',
                role: ''
            },
            wishlist: [],
            orders: [], // Inițializați orders ca un array gol
            successMessage: '',
            errorMessage: '',
            activeSection: ''
        };
    }

    componentDidMount() {
        if (this.state.accountData.username) {
            this.fetchAccountData();
            this.fetchWishlist();
            this.fetchOrders();
        } else {
            this.setState({ errorMessage: 'User is not authenticated' });
        }
    }

    fetchAccountData = async () => {
        try {
            const response = await axiosInstance.post('auth/find', { username: this.state.accountData.username });
            const accountData = response.data;
            this.setState({ accountData });
        } catch (error) {
            console.error('Failed to fetch account data', error);
            this.setState({ errorMessage: 'Failed to fetch account data' });
        }
    };

    fetchWishlist = async () => {
        try {
            const response = await axiosInstance.post('wishlist/getFavorite', { username: this.state.accountData.username });
            this.setState({ wishlist: response.data });
        } catch (error) {
            console.error('Failed to fetch wishlist', error);
            this.setState({ errorMessage: 'Failed to fetch wishlist' });
        }
    };

    fetchOrders = async () => {
        try {
            const response = await axiosInstance.post('order/findByUsername', { username: this.state.accountData.username });
            this.setState({ orders: response.data });
        } catch (error) {
            console.error('Failed to fetch orders', error);
            this.setState({ errorMessage: 'Failed to fetch orders' });
        }
    };

    handleInputChange = (e) => {
        const { name, value } = e.target;
        this.setState(prevState => ({
            accountData: {
                ...prevState.accountData,
                [name]: value
            }
        }));
    };

    handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axiosInstance.put('auth/update', this.state.accountData);
            this.setState({ successMessage: 'Account updated successfully!', errorMessage: '' });
        } catch (error) {
            console.error('Failed to update account', error);
            this.setState({ errorMessage: 'Failed to update account', successMessage: '' });
        }
    };

    handleSectionChange = (section) => {
        this.setState({ activeSection: section, successMessage: '', errorMessage: '' });
    };

    deleteWishlistItem = async (title) => {
        try {
            const username = this.state.accountData.username;
            await axiosInstance.delete('wishlist/delete', {
                data: { user: username, title: title }
            });
            this.fetchWishlist(); // Refresh the wishlist after deletion
        } catch (error) {
            console.error('Failed to delete wishlist item', error);
            this.setState({ errorMessage: 'Failed to delete wishlist item' });
        }
    };

    renderEditUserDetails = () => (
        <form onSubmit={this.handleSubmit}>
            <div className="form-group">
                <label>Username</label>
                <input
                    type="text"
                    name="username"
                    value={this.state.accountData.username}
                    onChange={this.handleInputChange}
                    disabled
                />
            </div>
            <div className="form-group">
                <label>Email</label>
                <input
                    type="email"
                    name="email"
                    value={this.state.accountData.email}
                    onChange={this.handleInputChange}
                />
            </div>
            <div className="form-group">
                <label>Password</label>
                <input
                    type="password"
                    name="password"
                    value={this.state.accountData.password}
                    onChange={this.handleInputChange}
                />
            </div>
            <button type="submit">Update Account</button>
        </form>
    );

    renderWishlist = () => (
        <div>
            <h3>Wishlist</h3>
            {this.state.wishlist.length > 0 ? (
                <ul>
                    {this.state.wishlist.map(item => (
                        <li key={item.id}>
                            {item.title}
                            <button className="small-delete-button" onClick={() => this.deleteWishlistItem(item.title)}>Remove</button>
                        </li>
                    ))}
                </ul>
            ) : (
                <p>Your wishlist is empty.</p>
            )}
        </div>
    );

    renderOrders = () => (
        <div>
            <h3>Orders</h3>
            {this.state.orders && this.state.orders.length > 0 ? (
                <ul>
                    {this.state.orders.map(order => (
                        <li key={order.id}>
                            <h4>Order #{order.id}</h4>
                            <p>Total: ${order.total}</p>
                            <p>Contact Number: {order.contactNumber}</p>
                            <p>Payment Method: {order.paymentMethod}</p>
                            <p>Address: {order.address}</p>
                            {/*<h5>Items:</h5>*/}
                            {/*<ul>*/}
                            {/*    {order.items && order.items.map(item => (*/}
                            {/*        <li key={item.id}>*/}
                            {/*            <p>Title: {item.title}</p>*/}
                            {/*            <p>Quantity: {item.quantity}</p>*/}
                            {/*            <p>Price: ${item.price}</p>*/}
                            {/*        </li>*/}
                            {/*    ))}*/}
                            {/*</ul>*/}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>You have no orders.</p>
            )}
        </div>
    );

    render() {
        const { accountData, successMessage, errorMessage, activeSection } = this.state;

        return (
            <div className="Account">
                <div className="AccountHeader">
                    <h1>Book Heaven</h1>
                    <h2>
                        <Link to='/book' className="home">Books</Link>
                        <Link to='/blog' className="blog">Blog</Link>
                        <Link to='/logout' className="logout">LogOut</Link>
                    </h2>
                </div>

                <div className="AccountBody">
                    {successMessage && <div className="success-message">{successMessage}</div>}
                    {errorMessage && <div className="error-message">{errorMessage}</div>}
                    <h3>Hello, {accountData.username}</h3>
                    <div className="button-group">
                        <button onClick={() => this.handleSectionChange('editUserDetails')}>Edit User Details</button>
                        <button onClick={() => this.handleSectionChange('viewWishlist')}>View Wishlist</button>
                        <button onClick={() => this.handleSectionChange('viewOrders')}>View Orders</button>
                    </div>
                    <div className="section-content">
                        {activeSection === 'editUserDetails' && this.renderEditUserDetails()}
                        {activeSection === 'viewWishlist' && this.renderWishlist()}
                        {activeSection === 'viewOrders' && this.renderOrders()}
                    </div>
                </div>
            </div>
        );
    }
}

export default Account;
