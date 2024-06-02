import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './LogoutPage.css';

const LogoutPage = () => {
    const navigate = useNavigate();

    useEffect(() => {
        const logout = async () => {
            try {
                await axios.post('http://localhost:8080/auth/logout');
                // Setează isAuthenticated la false
                localStorage.setItem('isAuthenticated', 'false');
                localStorage.removeItem('username');
                localStorage.removeItem('password');
                localStorage.clear();// Dacă ai un token, îl poți șterge
                navigate('/');
            } catch (error) {
                console.error('Logout failed', error);
                localStorage.setItem('isAuthenticated', 'false');
                localStorage.removeItem('username');
                localStorage.removeItem('username');
                localStorage.removeItem('password');
                localStorage.clear();// Dacă ai un token, îl poți șterge
                navigate('/');
            }
        };

        logout();
    }, [navigate]);

    return (
        <div className="LogoutPage">
            <h2>Logging out...</h2>
        </div>
    );
};

export default LogoutPage;
