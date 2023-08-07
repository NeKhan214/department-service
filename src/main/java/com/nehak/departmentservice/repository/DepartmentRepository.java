package com.nehak.departmentservice.repository;

import com.nehak.departmentservice.entity.Department;
import com.nehak.departmentservice.enums.DepartmentCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentCode(DepartmentCode departmentCode);
}
