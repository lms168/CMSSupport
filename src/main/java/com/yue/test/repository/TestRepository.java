package com.yue.test.repository;
import com.yue.test.bean.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long>,JpaSpecificationExecutor<Test>{
                @Query(value = "SELECT * FROM Test WHERE id = ?1", nativeQuery = true)
                public Test findById(long id);
}
