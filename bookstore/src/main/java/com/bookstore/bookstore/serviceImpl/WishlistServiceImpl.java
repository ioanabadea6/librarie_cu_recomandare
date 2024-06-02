package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.entity.Wishlist;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.model.WishlistData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.repo.WishlistRepo;
import com.bookstore.bookstore.service.WishlistService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {
    private UserRepo userRepo;
    private BookRepo bookRepo;
    private WishlistRepo wishlistRepo;

    public WishlistServiceImpl(UserRepo userRepo, BookRepo bookRepo, WishlistRepo wishlistRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.wishlistRepo = wishlistRepo;
    }

    @Override
    public Wishlist insert(WishlistData wishlistData) {
        User user = userRepo.findByUsername(wishlistData.getUser());
        Book book = bookRepo.findByTitle(wishlistData.getTitle());
        if(user == null || book == null){
            return null;
        }
        else{
            List<Wishlist> wishlists = wishlistRepo.findByUser(user);
            boolean findWishlist = false;
            for(Wishlist wish : wishlists){
                if(wish.getBook().getTitle().equals(wishlistData.getTitle())){
                    findWishlist = true;
                }
            }
            if(findWishlist == false){
                Wishlist wishlist = new Wishlist();
                wishlist.setBook(book);
                wishlist.setUser(user);
                return wishlistRepo.save(wishlist);
            }
        }
        return null;
    }

    @Override
    public Wishlist delete(WishlistData wishlistData) {
        User user = userRepo.findByUsername(wishlistData.getUser());
        Book book = bookRepo.findByTitle(wishlistData.getTitle());
        if(user == null || book == null){
            return null;
        }
        else{
            List<Wishlist> wishlists = wishlistRepo.findByUser(user);
            boolean findWishlist = false;
            for(Wishlist wish : wishlists){
                if(wish.getBook().getTitle().equals(wishlistData.getTitle())){
                    findWishlist = true;
                }
                if(findWishlist == true){
                   wishlistRepo.delete(wish);
                    return wish;
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> findUsersWishlist(UsernameData usernameData) {
        User user = userRepo.findByUsername(usernameData.getUsername());
        List<Book> bookList = new ArrayList<>();
        if(user == null){
            return null;
        }
        else{
            List<Wishlist> wishlistList = wishlistRepo.findAll();
            for(Wishlist wishlist : wishlistList){
                if(wishlist.getUser().getUsername().equals(user.getUsername())){
                    bookList.add(wishlist.getBook());
                }
            }
        }
        return bookList;
    }
}
