package com.company.myprojectmanagement.view.task;

import com.company.myprojectmanagement.entity.Task;
import com.company.myprojectmanagement.view.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import io.jmix.core.Messages;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.download.Downloader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


@Route(value = "tasks", layout = MainView.class)
@ViewController(id = "Task_.list")
@ViewDescriptor(path = "task-list-view.xml")
@LookupComponent("tasksDataGrid")
@DialogMode(width = "64em")
public class TaskListView extends StandardListView<Task> {
    @ViewComponent
    private DataGrid<Task> tasksDataGrid;
    @Autowired
    private UiComponents uiComponents;
    @Autowired
    private Messages messages;
    @Autowired
    private Downloader downloader;

    @Subscribe
    public void onInit(final InitEvent event) {
        tasksDataGrid.addComponentColumn(attachment -> {
            Button button = uiComponents.create(Button.class);
            button.setText(messages.getMessage(getClass(), "attachment"));
            button.addThemeName("tertiary-inline");
            button.setEnabled(Objects.nonNull(attachment.getAttachment()));
            button.addClickListener(clickEvent -> {
                downloader.download(attachment.getAttachment());
            });
            return button;
        }).setHeader(messages.getMessage(getClass(), "attachment"));
    }
}