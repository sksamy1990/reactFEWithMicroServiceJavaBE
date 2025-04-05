package com.example.demo.Repository;

import com.example.demo.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

//    @Query("SELECT r.id FROM Registration r WHERE r.name = :name")
//    Integer findIdByName(@Param("name")String getName);
    Registration findIdByName(String getName);
}

