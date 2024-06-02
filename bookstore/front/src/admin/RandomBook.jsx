import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './RandomBook.css';

const RandomBook = () => {
    const [book, setBook] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/book/random')
            .then(response => {
                setBook(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the random book!", error);
            });
    }, []);

    if (!book) return <div>Loading...</div>;

    return (
        <div className="RandomBook">
            <div className="book-container">
                <div className="book-image">
                    <img src={`data:image/jpeg;base64,${book.image}`} alt={book.title}/>
                </div>
                <div className="book-details">
                    <h1>{book.title}</h1>
                    <h2>{book.author}</h2>
                    <p>{book.description}</p>
                    <button onClick={() => navigate('/')}>Close</button>
                </div>
            </div>
        </div>
    );
};

export default RandomBook;
