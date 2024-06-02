import {Component} from 'react';
import {Link} from "react-router-dom";
import './UpdatePassword.css';
import axiosInstance from "../axios";
import history from '../history';

class UpdatePassword extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            success2: '',
            error: '',
            Success: false,
        }
    }

    changePassword = async (event) => {
        event.preventDefault();
        const { username, password } = this.state;
        const user = {
            username: username,
            password: password
        };
        console.log(user);
        if (username && password) {
            axiosInstance.put('auth/updatePass', user)
                .then(response => {
                    console.log(response.data);
                    history.push('/login');
                    window.location.reload();
                    if (response.data.success) {
                        console.log('Password change successful');
                        this.setState({ success2: 'Password was changed successfully!' });
                    } else {
                        this.setState({ error: 'Failed to change password' });
                    }
                }).catch(error => {
                console.error('There was an error changing the password!', error);
                this.setState({ error: error.message, loading: false });
            });
        } else {
            this.setState({ error: 'Username and new password are required' });
        }
    };


    render() {
        return(
            <div className='wrapper'>
                <div className='update-password-container'>
                    <form onSubmit={this.changePassword}>

                        <h1>Change Password</h1>

                        <div className="input">
                            <input
                                type="text"
                                placeholder='Username'
                                value={this.state.username}
                                onChange={(e) => this.setState({username: e.target.value})}
                            />
                        </div>

                        <div className="input">
                            <input
                                type="password"
                                placeholder='New Password'
                                value={this.state.password}
                                onChange={(e) => this.setState({password: e.target.value})}
                            />
                        </div>

                        <div>
                            <button type="submit">Change</button>
                        </div>

                        <h2>
                            <Link to="/login" className="login">LogIn</Link>
                        </h2>

                    </form>
                </div>

            </div>
        )
    }
}

export default UpdatePassword;