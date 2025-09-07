package com.company.myprojectmanagement.security;

import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "CombinedEmployeeRowLevelRole", code = CombinedEmployeeRowLevelRole.CODE)
public interface CombinedEmployeeRowLevelRole extends EmployeeUserRole, EmployeeTaskRole, EmployeeTimeEntryRole, RestrictedTaskDeletionRole {
    String CODE = "combined-employee-row-level-role";
}