package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.UserInfo;

/**
 * Created by Adel on 18.02.2018.
 */
@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {
    @Query("select u from UserInfo u where u.login =:login")
    UserInfo getUser(@Param("login") String login);
}
