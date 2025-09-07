package com.company.myprojectmanagement.security;

import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "ProjectManager2Role", code = ProjectManager2Role.CODE)
public interface ProjectManager2Role extends EditProjectsRole, ProjectsUiRole, AccessToTasksRole {
    String CODE = "project-manager2";
}