package com.example.service.Impl;

import com.example.dto.UserDto;
import com.example.exception.NotFoundException;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        return userRepository.save(user);
    }

    @Override
    public User getUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден с таким id" + userId));

    }

    @Override
    public void deleteUserId(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден с таким id" + userId));

        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable)
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    /**
     * Узнать сколько осталось время на Аккаунте
     */
    @Override
    public User FindOutHowMuchTimeIsLeftOnYourAccount(String username) {
        return null;
    }


}
