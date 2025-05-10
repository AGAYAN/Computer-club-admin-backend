package com.example.service;

import com.example.dto.UserDto;
import com.example.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserDto userDto);

    User getUserId(Long userId);

    void deleteUserId(Long userId);

    List<UserDto> getAllUser(int page, int size);

    /**
     * Узнать сколько осталось время на Аккаунте
     */
    User FindOutHowMuchTimeIsLeftOnYourAccount(String username);
}
