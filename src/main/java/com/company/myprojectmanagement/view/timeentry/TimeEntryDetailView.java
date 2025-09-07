package com.company.myprojectmanagement.view.timeentry;

import com.company.myprojectmanagement.entity.TimeEntry;
import com.company.myprojectmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

import java.time.LocalDateTime;

@Route(value = "time-entries/:id", layout = MainView.class)
@ViewController(id = "TimeEntry.detail")
@ViewDescriptor(path = "time-entry-detail-view.xml")
@EditedEntityContainer("timeEntryDc")
@DialogMode(width = "AUTO", height = "AUTO")
public class TimeEntryDetailView extends StandardDetailView<TimeEntry> {

    @Subscribe
    public void onInitEntity(final InitEntityEvent<TimeEntry> event) {
        event.getEntity().setEntryDate(LocalDateTime.now());
    }

}