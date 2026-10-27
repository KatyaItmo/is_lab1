package org.example.is_lab1.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.is_lab1.exceptions.IllegalPasswordException;
import org.example.is_lab1.exceptions.NotFoundException;
import org.example.is_lab1.exceptions.OccupiedUsernameException;

import java.util.UUID;

@RequestScoped
@Transactional
public class UserService {

    @Inject
    private UserDao userDao;

    public User register(UserDto userDto) {
        if (userDao.findByUsername(userDto.getUsername()).isPresent()) {
            throw new OccupiedUsernameException("этот username уже зарегистрирован");
        }

        User user = new User(userDto.getUsername(), userDto.getPassword());
        return userDao.create(user);
    }

    public User login(UserDto userDto) {
        User user = userDao.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new NotFoundException("неверный логин или пароль"));

        if (!user.getPassword().equals(userDto.getPassword())) {
            throw new IllegalPasswordException("неверный пароль");
        }

        String token = UUID.randomUUID().toString();
        user.setSessionToken(token);
        userDao.update(user);

        return user;
    }

    public void logout(String token) {
        if (token != null && !token.isBlank()) {
            userDao.findBySessionToken(token).ifPresent(user -> {
                user.setSessionToken(null);
                userDao.update(user);
            });
        }
    }

    public User getUserByToken(String token) {
        if (token == null || token.isBlank()) {
            return null;
        }
        return userDao.findBySessionToken(token).orElse(null);
    }
}
