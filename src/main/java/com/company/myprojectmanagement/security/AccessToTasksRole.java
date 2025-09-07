package com.company.myprojectmanagement.security;

import com.company.myprojectmanagement.entity.Task;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "AccessToTasksRole", code = AccessToTasksRole.CODE)
public interface AccessToTasksRole {
    String CODE = "access-to-tasks";

    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = EntityPolicyAction.ALL)
    void task();

    @MenuPolicy(menuIds = "Task_.list")
    @ViewPolicy(viewIds = {"Task_.list", "Task_.detail"})
    void screens();
}