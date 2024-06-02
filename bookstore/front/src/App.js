import LoginPage from './admin/LoginPage';
import Signup from "./admin/Signup";
import UpdatePassword from "./admin/UpdatePassword";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "./user/HomePage";
import Books from "./admin/Books";
import Blog from "./admin/Blog";
import AdminPage from "./admin/AdminPage";
import Account from "./user/Account";
import LogoutPage from "./admin/LogoutPage";
import CartPage from "./admin/CartPage";
import BookPage from "./admin/BookPage";
import RandomBook from "./admin/RandomBook";

function App() {
  return (
    <Router>
        <Routes>
            <Route path="/" element={<HomePage/>}/>
            <Route path="/login" element={<LoginPage/>}/>
            <Route path="/signup" element={<Signup/>}/>
            <Route path="/updatePassword" element={<UpdatePassword/>}/>
            <Route path="/book" exact element={<Books/>}/>
            <Route path="/blog" element={<Blog/>}/>
            <Route path="/adminPage" element={<AdminPage/>}/>
            <Route path="/account" element={<Account/>}/>
            <Route path="/logout" element={<LogoutPage/>}/>
            <Route path="/cartPage" element={<CartPage/>}/>
            <Route path="/book/:id" element={<BookPage/>}/>
            <Route path="/random-book" element={<RandomBook />} />
        </Routes>
    </Router>
  );
}

export default App;
