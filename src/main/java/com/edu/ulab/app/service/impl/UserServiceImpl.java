package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dao.UserDao;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDao.saveUser(userDto);
        // сгенерировать идентификатор
        // создать пользователя
        // вернуть сохраненного пользователя со всеми необходимыми полями id
        return userDto;
    }

    public List<UserDto> getAll() {
        return userDao.getAllUser();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return userDao.updateUser(id, userDto);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUser(id);
    }
}
