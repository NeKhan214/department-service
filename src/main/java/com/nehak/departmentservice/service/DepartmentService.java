package com.nehak.departmentservice.service;

import com.nehak.departmentservice.dto.DepartmentDto;
import com.nehak.departmentservice.enums.DepartmentCode;
import com.nehak.departmentservice.exception.ResourceNotFoundException;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(DepartmentCode departmentCode) throws ResourceNotFoundException;
}
