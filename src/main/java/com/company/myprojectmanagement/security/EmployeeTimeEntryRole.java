package com.company.myprojectmanagement.security;

import com.company.myprojectmanagement.entity.TimeEntry;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "EmployeeTimeEntryRole", code = EmployeeTimeEntryRole.CODE)
public interface EmployeeTimeEntryRole {
    String CODE = "employee-time-entry";

    @JpqlRowLevelPolicy(entityClass = TimeEntry.class, where = "{E}.user.id = :current_user_id")
    void timeEntry();
}