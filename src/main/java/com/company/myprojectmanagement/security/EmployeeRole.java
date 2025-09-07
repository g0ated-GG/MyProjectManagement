package com.company.myprojectmanagement.security;

import com.company.myprojectmanagement.entity.Project;
import com.company.myprojectmanagement.entity.Task;
import com.company.myprojectmanagement.entity.TimeEntry;
import com.company.myprojectmanagement.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "EmployeeRole", code = EmployeeRole.CODE,
        description = "Используется вместе с CombinedEmployeeRowLevelRole")
public interface EmployeeRole extends UiMinimalRole {
    String CODE = "employee";

    @MenuPolicy(menuIds = {"User.list", "Project.list", "Task_.list", "TimeEntry.list"})
    @ViewPolicy(viewIds = {"User.list", "Project.list", "Task_.list", "TimeEntry.list", "Project.detail", "Task_.detail", "TimeEntry.detail", "User.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Project.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.READ)
    void project();

    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = EntityPolicyAction.ALL)
    void task();

    @EntityAttributePolicy(entityClass = TimeEntry.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = TimeEntry.class, actions = EntityPolicyAction.ALL)
    void timeEntry();

    @EntityAttributePolicy(entityClass = User.class, attributes = {"firstName", "lastName", "avatar"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = User.class, attributes = {"id", "version", "username", "email", "active", "timeZoneId"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void user();
}