package hu.mik.prog5.z7twzr.mediapatrik.dao;

import hu.mik.prog5.z7twzr.mediapatrik.entity.User;

public interface UserDao {

    User findByUsername(String username);

}
