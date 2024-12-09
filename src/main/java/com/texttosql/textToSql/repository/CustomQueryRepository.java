//package com.texttosql.textToSql.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CustomQueryRepository extends JpaRepository<Object, Long> {
//
//    @Query(value = "SELECT * FROM your_table WHERE some_condition = :param", nativeQuery = true)
//    List<Object> findWithCustomQuery(String param);
//}
