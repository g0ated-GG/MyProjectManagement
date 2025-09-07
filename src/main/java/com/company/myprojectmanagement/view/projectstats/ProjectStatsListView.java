package com.company.myprojectmanagement.view.projectstats;

import com.company.myprojectmanagement.app.ProjectStatsService;
import com.company.myprojectmanagement.entity.ProjectStats;
import com.company.myprojectmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "project-statses", layout = MainView.class)
@ViewController(id = "ProjectStats.list")
@ViewDescriptor(path = "project-stats-list-view.xml")
@LookupComponent("projectStatsesDataGrid")
@DialogMode(width = "50em")
public class ProjectStatsListView extends StandardListView<ProjectStats> {

    @Autowired
    private ProjectStatsService projectStatsService;

    @Install(to = "projectStatsesDl", target = Target.DATA_LOADER)
    protected List<ProjectStats> projectStatsesDlLoadDelegate(LoadContext<ProjectStats> loadContext) {
        return projectStatsService.fetchProjectStatistics();
    }

}
