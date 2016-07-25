package com.github.katsurakkkk;

import org.activiti.engine.*;

/**
 * Created by katsurakkkk on 7/25/16.
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.test();
    }

    private void test() {
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        repositoryService.createDeployment().addClasspathResource("interview.bpmn").deploy();
        String processId = runtimeService.startProcessInstanceByKey("interview").getId();

        TaskService taskService = processEngine.getTaskService();
    }
}
