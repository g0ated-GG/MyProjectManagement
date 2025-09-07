package com.company.myprojectmanagement.app;

import com.company.myprojectmanagement.entity.ProjectStats;

import java.util.List;

public interface ProjectStatsService {
    List<ProjectStats> fetchProjectStatistics();
}
