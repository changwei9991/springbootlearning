package com.example.repository;

import com.example.model.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {

    Cart findByUserId(Long userId);

    @Modifying
    @Query(value = "DELETE FROM cart c WHERE c.userId = :id")
    int deleteByUserId(@Param("id") Long userId);

}
