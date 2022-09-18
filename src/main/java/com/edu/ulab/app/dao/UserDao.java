package com.edu.ulab.app.dao;

import com.edu.ulab.app.dto.UserDto;
//import com.edu.ulab.app.mapper.UserMapper;
import com.edu.ulab.app.storage.Storage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    private static Long PEOPLE_COUNT = 0L; // сгенерировать идентификатор
    private final Storage storage;

    public UserDao(Storage storage) {
        this.storage = storage;
    }

    public List<UserDto> getAllUser() {
        return storage.getAllUsers();
    }

    public UserDto getUserById(Long id) {
        return storage.getUser(id);
    }

    public UserDto saveUser(UserDto user) {
        if (PEOPLE_COUNT < 0) {
            return null;
        }
        user.setId(++PEOPLE_COUNT);
        storage.addUser(user);
        return user;
    }

    public UserDto updateUser(Long id, UserDto user){
        return storage.updateUser(id, user);
    }

    public boolean deleteUser(Long id) {
        if (PEOPLE_COUNT <= 0) {
            return false;
        }
        --PEOPLE_COUNT;
        return storage.deleteUser(id);
    }

}
