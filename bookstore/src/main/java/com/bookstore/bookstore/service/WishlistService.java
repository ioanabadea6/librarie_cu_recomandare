package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Wishlist;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.model.WishlistData;

import java.util.List;

public interface WishlistService {
    Wishlist insert(WishlistData wishlistData);
    Wishlist delete(WishlistData wishlistData);
    List<Book> findUsersWishlist(UsernameData usernameData);
}
