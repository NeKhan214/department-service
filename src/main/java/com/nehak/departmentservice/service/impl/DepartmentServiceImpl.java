package com.nehak.departmentservice.service.impl;

import com.nehak.departmentservice.dto.DepartmentDto;
import com.nehak.departmentservice.entity.Department;
import com.nehak.departmentservice.enums.DepartmentCode;
import com.nehak.departmentservice.exception.ResourceNotFoundException;
import com.nehak.departmentservice.mapper.DepartmentMapper;
import com.nehak.departmentservice.repository.DepartmentRepository;
import com.nehak.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(DepartmentCode departmentCode) throws ResourceNotFoundException {
        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow( () -> new ResourceNotFoundException("Department", "DepartmentCode", departmentCode.toString())
                );
        return DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(department);
    }
}
