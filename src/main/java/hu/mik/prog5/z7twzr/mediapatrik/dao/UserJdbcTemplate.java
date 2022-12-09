package hu.mik.prog5.z7twzr.mediapatrik.dao;

import hu.mik.prog5.z7twzr.mediapatrik.dao.rowmapper.UserRowMapper;
import hu.mik.prog5.z7twzr.mediapatrik.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserJdbcTemplate implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    private final UserRowMapper userRowMapper;

    @Override
    public User findByUsername(String username) {
        return this.jdbcTemplate
                .queryForObject("SELECT u.id, u.username, u.password FROM \"user\" u WHERE u.username = ?",
                this.userRowMapper, username);
    }

}
