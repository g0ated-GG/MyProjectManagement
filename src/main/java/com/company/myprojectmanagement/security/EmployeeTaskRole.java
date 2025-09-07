package com.company.myprojectmanagement.security;

import com.company.myprojectmanagement.entity.Task;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "EmployeeTaskRole", code = EmployeeTaskRole.CODE)
public interface EmployeeTaskRole {
    String CODE = "employee-task";

    @JpqlRowLevelPolicy(entityClass = Task.class, where = "{E}.assignee.id = :current_user_id")
    void task();
}