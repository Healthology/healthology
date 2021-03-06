package com.example.healthology.repositories;

import com.example.healthology.models.Client;
import com.example.healthology.models.Group;
import com.example.healthology.models.Journal;
import com.example.healthology.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //Client client = clientDao.getClientByUserID(7)

    @Query("from Client c where c.user_id = :id")
    Client findClientByUser_id(User id);

    List<Client> getAllClientsByGroups(Group group);


}
