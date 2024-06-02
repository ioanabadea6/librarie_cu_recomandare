import React from 'react';
import {Link} from "react-router-dom";
import "./HomePage.css"

class HomePage extends React.Component {
    render() {
        return(
            <div className="HomePage">

                <div className="HomePageHeader">
                    <h1 >Book Heaven</h1>
                    <h2>
                        <Link to='/book' className = "books">Books</Link>
                        <Link to='/blog' className = "blog">Blog</Link>
                        <Link to='/signup' className = "signup">SignUp</Link>
                    </h2>
                </div>

                <div className="HomePageBody">
                    <h3>Discover your new adventure</h3>
                    <button>
                        <Link to='/book' className="books">Discover</Link>
                    </button>
                </div>

            </div>
        )
    }
}
export default HomePage;