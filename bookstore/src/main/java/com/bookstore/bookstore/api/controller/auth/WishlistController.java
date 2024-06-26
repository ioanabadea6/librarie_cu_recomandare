package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Wishlist;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.model.WishlistData;
import com.bookstore.bookstore.service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    /**
     Insert a book in whishlist.
     */
    @PostMapping("/insert")
    public Wishlist insertFavorite(@RequestBody WishlistData wishlistData){
        return wishlistService.insert(wishlistData);
    }

    /**
     Delete a book from whishlist.
     */
    @DeleteMapping("/delete")
    public Wishlist deleteFavorite(@RequestBody WishlistData wishlistData){
        return wishlistService.delete(wishlistData);
    }

    /**
     * Lists all books from wishlist.
     * @param usernameData
     * @return
     */
    @PostMapping("/getFavorite")
    public List<Book> findUsersWishlist(@RequestBody UsernameData usernameData){
        return wishlistService.findUsersWishlist(usernameData);
    }
}
