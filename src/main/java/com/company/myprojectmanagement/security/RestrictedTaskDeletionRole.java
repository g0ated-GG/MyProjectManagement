package com.company.myprojectmanagement.security;

import com.company.myprojectmanagement.entity.Task;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

@RowLevelRole(name = "RestrictedTaskDeletionRole", code = RestrictedTaskDeletionRole.CODE)
public interface RestrictedTaskDeletionRole {
    String CODE = "restricted-task-deletion";

    @PredicateRowLevelPolicy(entityClass = Task.class, actions = RowLevelPolicyAction.DELETE)
    default RowLevelBiPredicate<Task, ApplicationContext> taskPredicate() {
        return (task, applicationContext) -> Objects.isNull(task.getAttachment());
    }
}