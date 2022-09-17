package com.edu.ulab.app.storage;

import com.edu.ulab.app.dao.BookDao;
import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {

    private List<UserDto> users = new ArrayList<>();
    private List<BookDto> books = new ArrayList<>();

    public UserDto addUser(UserDto user) {
        users.add(user);
        users.forEach(System.out::println);
        return user;
    }

    public List<UserDto> getAllUsers() {
        return users;
    }

    public UserDto getUser(Long id) {
        return users.stream()
                .filter(userDto -> userDto.getId().equals(id))
                .findAny()
                .orElse(null);

    }

    public boolean deleteUser(Long id) {
        deleteBooksByAuthorId(id);
        boolean remove = users.remove(getUser(id));
        users.forEach(System.out::println);
        return remove;
    }

    public UserDto updateUser(Long id, UserDto user) {
        if (getUser(id) == null) {
            return null;
        }
        user.setId(id);
        users.set(users.indexOf(getUser(id)), user);
        users.forEach(System.out::println);
//        UserDto updated = getUser(user.getId());
//        updated.setAge(user.getAge());
//        updated.setFullName(user.getFullName());
//        updated.setTitle(user.getTitle());
//        updated.setAge(user.getAge());
//        for (UserDto userDto : users) {
//            if (userDto)
//        }
//        users.stream()
//                .filter(userDto -> userDto.getId().equals(id))
//                .peek(userDto -> userDto = user);

        return user;
    }

//    public BookDto updateBook(Long id, BookDto book) {
//        books.stream()
//                .filter(bookDto -> bookDto.getUserId().equals(id))
//                .peek(bookDto -> bookDto = book);
//
//        return book;
//    }

    public BookDto addBook(BookDto book) {
        books.add(book);
        return book;
    }

    public List<BookDto> getAllBooks() {
        return books;
    }

    public List<BookDto> getBooksByAuthorId(Long id) {
        return books.stream()
                .filter(bookDto -> bookDto.getUserId().equals(id))
                .toList();
    }

    public boolean deleteBooksByAuthorId(Long id) {
        return books.removeAll(getBooksByAuthorId(id));
    }


    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции
}
