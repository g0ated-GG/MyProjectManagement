package com.company.myprojectmanagement.security;

import com.company.myprojectmanagement.entity.User;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "EmployeeUserRole", code = EmployeeUserRole.CODE)
public interface EmployeeUserRole {
    String CODE = "employee-user";

    @JpqlRowLevelPolicy(entityClass = User.class, where = "{E}.id = :current_user_id")
    void user();
}