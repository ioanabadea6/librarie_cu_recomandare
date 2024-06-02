import React, { Component } from "react";
import { Link } from "react-router-dom";
import history from '../history';
import axiosInstance from '../axios';
import './LoginPage.css';

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            error: '',
            email:'',
            userId:''
        };
    }

    login = async (event) => {
        event.preventDefault();
        const { username, password, userId} = this.state;
        const user = {
            username,
            password
        };
        const userData={
            userId
        };
        console.log(user);
        if (username && password) {
            axiosInstance.post('auth/login', user)
                .then(response => {
                    console.log(response.data);
                    if (response.data === 0 || response.data === 1) {
                        console.log('Login successful');
                        if (response.data === 1) {
                            localStorage.setItem('isAuthenticated', 'true');
                            localStorage.setItem('username', username);

                            history.push('/adminPage');
                            window.location.reload();
                        } else if (response.data === 0) {
                            localStorage.setItem('isAuthenticated', 'true');
                            localStorage.setItem('username', username);  // Store the username
                            history.push('/book');
                            window.location.reload();
                        }
                    } else {
                        this.setState({ error: 'Invalid username or password' });
                    }
                }).catch(error => {
                console.error('There was an error fetching the rentals data!', error);
                this.setState({ error: error.message, loading: false });
            });
        } else {
            this.setState({ error: 'Username and password are required' });
        }
    };

    render() {
        return (
            <div className='wrapper'>
                <div className='login-container'>
                    <form onSubmit={this.login}>
                        <h1>LogIn</h1>
                        {this.state.error && <p className="error">{this.state.error}</p>}
                        <div className="input">
                            <input
                                type="text"
                                placeholder='Username'
                                value={this.state.username}
                                onChange={(e) => this.setState({ username: e.target.value })}
                            />
                        </div>

                        <div className="input">
                            <input
                                type="password"
                                placeholder='Password'
                                value={this.state.password}
                                onChange={(e) => this.setState({ password: e.target.value })}
                            />
                            <Link to="/updatePassword" className="updatePassword">Forget password?</Link>
                        </div>

                        <div>
                            <button type="submit">Login</button>
                        </div>

                        <h2>
                            <Link to="/signup" className="signup">Don't have an account? SignUp</Link>
                        </h2>
                    </form>
                </div>
            </div>
        );
    }
}

export default LoginPage;
