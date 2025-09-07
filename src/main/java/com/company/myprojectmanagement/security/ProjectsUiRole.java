package com.company.myprojectmanagement.security;

import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "ProjectsUi", code = ProjectsUiRole.CODE)
public interface ProjectsUiRole {
    String CODE = "projects-ui";

    @MenuPolicy(menuIds = "Project.list")
    @ViewPolicy(viewIds = {"Project.list", "Project.detail"})
    void screens();
}