import React from 'react';
import { Link, useNavigate } from "react-router-dom";
import './Signup.css';
import { FaUser, FaLock, FaEnvelope, FaUserAlt } from 'react-icons/fa';
import axiosInstance from "../axios";
import history from "../history";

class Signup extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            name: '',
            email: '',
            password: '',
            role: 'user',
            error: ''
        };
    }

    signup = async (event) => {
        event.preventDefault();
        const { username, name, email, password, role } = this.state;
        const user = { username, name, email, password, role };

        if (username && name && email && password) {
            axiosInstance.post('auth/insert', user)
                .then(response => {
                    history.push('/book');
                    window.location.reload();
                    if (response.data) {
                        console.log('Signup successful');
                    } else {
                        this.setState({ error: 'Signup failed' });
                    }
                })
                .catch(error => {
                    console.error('There was an error during signup!', error);
                    this.setState({ error: error.message });
                });
        } else {
            this.setState({ error: 'All fields are required' });
        }
    };


    render() {
        return (
            <div className="wrapper">
                <div className='signup-container'>
                    <form onSubmit={this.signup}>
                        <h1>SignUp</h1>
                        <div className="input">
                            <FaUser className="icon" />
                            <input type="text" placeholder='Username' onChange={e => this.setState({ username: e.target.value })} />
                        </div>
                        <div className="input">
                            <FaUserAlt className="icon" />
                            <input type="text" placeholder='Name' onChange={e => this.setState({ name: e.target.value })} />
                        </div>
                        <div className="input">
                            <FaEnvelope className="icon" />
                            <input type="email" placeholder='Email' onChange={e => this.setState({ email: e.target.value })} />
                        </div>
                        <div className="input">
                            <FaLock className="icon" />
                            <input type="password" placeholder='Password' onChange={e => this.setState({ password: e.target.value })} />
                        </div>
                        {this.state.error && <p className="error">{this.state.error}</p>}
                        <div>
                            <button type="submit">SignUp</button>
                        </div>
                        <h2>
                            <Link to="/login" className="login">Already have an account? LogIn</Link>
                        </h2>
                    </form>
                </div>
            </div>
        );
    }
}

export default Signup;
