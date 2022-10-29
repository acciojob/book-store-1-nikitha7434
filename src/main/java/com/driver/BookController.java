package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("books")
public class BookController {

    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.
     bookList.add(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id")int id){

        return new ResponseEntity<>(bookList.get(id),HttpStatus.ACCEPTED);
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()
@DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable("id")int id){
        bookList.remove(id);
}
    // get request /get-all-books
    // getAllBooks()
@GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){

        return new ResponseEntity<>(bookList,HttpStatus.FOUND);
}
    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookList.clear();
        return new ResponseEntity<>("Done",HttpStatus.ACCEPTED);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()


    @GetMapping("/get-books-by-author")
    public ResponseEntity<String> getBooksByAuthor(@RequestParam("author") String author){
              Book books =new Book();
              String name =books.getAuthor()+books.getName();
        return new ResponseEntity<>("sucessfull",HttpStatus.ACCEPTED);
    }
@GetMapping("/get-books-by-genre")
    public ResponseEntity<String> getBooksByGenre(@RequestParam("genre")String genre){

    Book books =new Book();
String name =books.getGenre()+books.getGenre();
    return new ResponseEntity<>("sucessfull",HttpStatus.OK);
}
    // get request /get-books-by-genre
    // pass genre name as request param
    //getBooksByGenre()

}
