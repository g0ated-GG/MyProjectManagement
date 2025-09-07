package com.company.myprojectmanagement.view.taskdetail;


import com.company.myprojectmanagement.entity.Task;
import com.company.myprojectmanagement.entity.TaskPriority;
import com.company.myprojectmanagement.view.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textarea.JmixTextArea;
import io.jmix.flowui.view.*;

import java.util.Objects;

@Route(value = "tasks/:id", layout = MainView.class)
@ViewController(id = "Task_.detail")
@ViewDescriptor(path = "task-detail-view.xml")
@EditedEntityContainer("taskDc")
@DialogMode(width = "AUTO", height = "AUTO")
public class TaskDetailView extends StandardDetailView<Task> {

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Task> event) {
        event.getEntity().setPriority(TaskPriority.NORMAL);
    }

    @Subscribe("descriptionField")
    public void onDescriptionFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixTextArea, ?> event) {
        var length = Objects.nonNull(event.getValue()) ? event.getValue().toString().length() : 0;
        var maxLength = event.getSource().getMaxLength();
        event.getSource().setHelperText(length + "/" + maxLength);
    }

}