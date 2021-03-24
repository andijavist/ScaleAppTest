package com.firstBooting.ScaleApp.repository;

import com.firstBooting.ScaleApp.Entity.Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Groups,Long> {
    List<Groups> findAll();
    Groups findByName(String name);
}
