package com.example.department_search_manager.Service;

import com.example.department_search_manager.ennity.Department;
import com.example.department_search_manager.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService() {
        departmentRepository = new DepartmentRepository();
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    public List<Department> getDepartmentsByUserId(int userId) {
        return departmentRepository.getDepartmentsByUserId(userId);
    }

    public boolean addDepartment(Department department) {
        return departmentRepository.addDepartment(department);
    }

    public boolean deleteDepartment(int departmentId, int userId) {
        return departmentRepository.deleteDepartment(departmentId, userId);
    }
}
