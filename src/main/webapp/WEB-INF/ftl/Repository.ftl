package com.yue.${pkg}.repository;
import com.yue.${pkg}.bean.${Bean};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ${Bean}Repository extends JpaRepository<${Bean}, Long>,JpaSpecificationExecutor<${Bean}>{
        <#if opTypes?seq_contains("edit")>
                @Query(value = "SELECT * FROM ${Bean} WHERE id = ?1", nativeQuery = true)
                public ${Bean} findById(long id);
        </#if>
}
