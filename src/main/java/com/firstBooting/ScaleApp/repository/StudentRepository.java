package com.firstBooting.ScaleApp.repository;
import com.firstBooting.ScaleApp.Entity.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends CrudRepository<Students,Long> {
List<Students> findAll();
List<Students> findAllByGroupId(Long groupId);
}
