package hu.me.lev.BookExample.service;


import hu.me.lev.BookExample.controller.BookDTO;
import hu.me.lev.BookExample.persist.BookEntity;
import hu.me.lev.BookExample.persist.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private  AuthorerService authorerService;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.authorerService = authorerService;
    }

    public void addBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(bookDTO.getIsbn());
        bookEntity.setName(bookDTO.getName());
        bookEntity.setType(bookDTO.getType());
        bookEntity.setAvailable(bookDTO.getAvailable());

        bookEntity.setAuthorerEntity(
                authorerService.getAuthorer(bookDTO.getAuthor_id()));
        bookRepository.save(bookEntity);
    }

    public List<BookDTO> getAllBook()  {
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (BookEntity bookEntity : bookRepository.findAll()){
            bookDTOList.add(new BookDTO(bookEntity.getIsbn(), bookEntity.getName(), bookEntity.getType(), bookEntity.getAvailable(), bookEntity.getAuthorerEntity().getId()));
        }
        return bookDTOList;
    }

}