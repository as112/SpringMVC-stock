package com.example.stock.repo;

import com.example.stock.models.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    @Query(value = "select * from purchase t where t.employee_id = ?1", nativeQuery = true)
    Iterable<Purchase> findByEmployeeId(Long employeeId);
}
