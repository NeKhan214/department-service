package com.nehak.departmentservice.mapper;

import com.nehak.departmentservice.dto.DepartmentDto;
import com.nehak.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper DEPARTMENT_MAPPER = Mappers.getMapper(DepartmentMapper.class);
    @Mapping(source = "departmentCode", target = "departmentCode")
    DepartmentDto mapToDepartmentDto(Department department);
    @Mapping(source = "departmentCode", target = "departmentCode")
    Department mapToDepartmentEntity(DepartmentDto departmentDto);

}
