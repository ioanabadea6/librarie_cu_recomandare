package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Wishlist;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.model.WishlistData;

import java.util.List;

public interface WishlistService {
    /**
     * Insereaza un wishlist
     * @param wishlistData
     * @return
     */
    Wishlist insert(WishlistData wishlistData);

    /**
     * Sterge un wishlist
     * @param wishlistData
     * @return
     */
    Wishlist delete(WishlistData wishlistData);

    /**
     * Gaseste wishlist in functie de user
     * @param usernameData
     * @return
     */
    List<Book> findUsersWishlist(UsernameData usernameData);
}
