package com.marius.diploma.service.mapper;

import com.marius.diploma.domain.*;
import com.marius.diploma.service.dto.EmployeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Employee and its DTO EmployeeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmployeeMapper extends EntityMapper <EmployeeDTO, Employee> {
    @Mapping(source = "manager.id", target = "managerId")
    EmployeeDTO toDto(Employee employee); 
    @Mapping(source = "managerId", target = "manager")
    Employee toEntity(EmployeeDTO employeeDTO); 
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
