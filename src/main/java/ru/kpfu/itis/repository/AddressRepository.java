package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.Address;

/**
 * Created by Adel on 18.02.2018.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    @Query("select a from Address a where a.userInfo.id =:userId")
    Address getAddressByUserId(@Param("userId") Long userId);
}
