package com.example.info_coehgns.User.service;

import com.example.info_coehgns.User.dto.request.UserRequestDTO;
import com.example.info_coehgns.User.dto.response.UserResponseDTO;
import com.example.info_coehgns.User.entity.User;
import com.example.info_coehgns.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDTO> showAllTodos() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build()).toList();
    }

    public UserResponseDTO userFindById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found."));

        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    @Transactional
    public void createTodo(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .username(userRequestDTO.getUsername())
                .build();
    }

}
