package com.bsnl.Bsnldata.Repository;

import com.bsnl.Bsnldata.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByName(String name);

}
