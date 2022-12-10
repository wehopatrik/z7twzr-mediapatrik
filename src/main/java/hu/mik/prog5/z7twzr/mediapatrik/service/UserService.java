package hu.mik.prog5.z7twzr.mediapatrik.service;

import hu.mik.prog5.z7twzr.mediapatrik.dao.UserDao;
import hu.mik.prog5.z7twzr.mediapatrik.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

}
