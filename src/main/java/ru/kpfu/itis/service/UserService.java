package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entity.UserInfo;
import ru.kpfu.itis.repository.UserRepository;

/**
 * Created by Adel on 30.04.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfo getUser(String login) {
        return userRepository.getUser(login);
    }

    public UserInfo addUser(UserInfo user) {
        return userRepository.save(user);
    }

    public String checkLogin(String login) {
        UserInfo user = userRepository.getUser(login);
        if (user != null){
            return "ok";  //���� ���������� ���������� ok
        }
        else {
            return "no";
        }
    }
}
