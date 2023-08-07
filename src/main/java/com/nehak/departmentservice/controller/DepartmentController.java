package com.nehak.departmentservice.controller;

import com.nehak.departmentservice.dto.DepartmentDto;
import com.nehak.departmentservice.enums.DepartmentCode;
import com.nehak.departmentservice.exception.ResourceNotFoundException;
import com.nehak.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@Tag(
        name = "CRUD APIs for Department",
        description = "Department API - Create Department, Get Department"
)
public class DepartmentController {

    DepartmentService departmentService;

    @Operation(summary = "Create Department")
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/getDepartmentByCode")
    @Operation(summary = "Get Department Details")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@Parameter(required = true, description = "Department Code",
            in = ParameterIn.QUERY, schema = @Schema(
            allowableValues = {"HR", "FIN", "IT", "MR"}
    )) @RequestParam("code") DepartmentCode departmentCode) throws ResourceNotFoundException {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
