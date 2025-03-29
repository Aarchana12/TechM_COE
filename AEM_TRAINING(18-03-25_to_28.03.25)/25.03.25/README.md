# AEM Custom Workflow, Event Handler, Sling Job & Scheduler

## 📌 Overview
This document provides step-by-step instructions to create a custom workflow, workflow process, event handler, sling job, scheduler, and user permissions in AEM.

## 📖 Table of Contents
- [Create Custom Workflow](#create-custom-workflow)
- [Create Custom Workflow Process](#create-custom-workflow-process)
- [Create Event Handler](#create-event-handler)
- [Create Sling Job](#create-sling-job)
- [Create Scheduler](#create-scheduler)
- [Create Users & Group with Permissions](#create-users--group-with-permissions)

---

## 📌 Create Custom Workflow
### Steps:
1. Navigate to **AEM Start → Tools → Workflow → Models**.
2. Click on **Create** → **Create Model**.
3. Enter Title: `My Custom Workflow`.
4. Open the newly created workflow and click **Edit**.
5. Drag and drop **Process Step**.
6. Configure the Process Step:
   - Title: `Custom Workflow Process`
   - Process: `com.example.core.workflows.CustomWorkflowProcess`
7. Click **Save & Close**.

---

## 📌 Create Custom Workflow Process
### Steps:
1. Navigate to **AEM Project Codebase → core module**.
2. Create a new Java class `CustomWorkflowProcess.java` inside `com.example.core.workflows`.

```java
package com.example.core.workflows;

import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowSession;
import com.adobe.granite.workflow.model.WorkflowNode;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = WorkflowProcess.class, property = {"process.label=Custom Workflow Process"})
public class CustomWorkflowProcess implements WorkflowProcess {

    private static final Logger LOG = LoggerFactory.getLogger(CustomWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, WorkflowNode workflowNode) {
        String pagePath = workItem.getWorkflowData().getPayload().toString();
        LOG.info("Workflow executed for page: {}", pagePath);
    }
}
```

3. Deploy the code and verify the logs.

---

## 📌 Create Event Handler
### Steps:
1. Create a new Java class `CustomEventHandler.java` inside `com.example.core.listeners`.

```java
package com.example.core.listeners;

import org.apache.sling.api.SlingConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EventHandler.class, immediate = true,
    property = {"event.topics=" + SlingConstants.TOPIC_RESOURCE_ADDED})
public class CustomEventHandler implements EventHandler {
    
    private static final Logger LOG = LoggerFactory.getLogger(CustomEventHandler.class);
    
    @Override
    public void handleEvent(Event event) {
        LOG.info("Resource added at: {}", event.getProperty("path"));
    }
}
```

2. Deploy and check logs when a new resource is created.

---

## 📌 Create Sling Job
### Steps:
1. Create a new Java class `CustomSlingJob.java` inside `com.example.core.jobs`.

```java
package com.example.core.jobs;

import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = JobConsumer.class, property = {"job.topics=custom/job/helloworld"})
public class CustomSlingJob implements JobConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(CustomSlingJob.class);

    @Override
    public JobResult process(Job job) {
        LOG.info("Hello World from Sling Job!");
        return JobResult.OK;
    }
}
```

2. Deploy and trigger the job.

---

## 📌 Create Scheduler
### Steps:
1. Create a new Java class `CustomScheduler.java` inside `com.example.core.schedulers`.

```java
package com.example.core.schedulers;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component(service = Runnable.class, configurationPolicy = ConfigurationPolicy.REQUIRE, immediate = true)
@Designate(ocd = CustomScheduler.Config.class)
public class CustomScheduler implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(CustomScheduler.class);
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @ObjectClassDefinition(name = "Custom Scheduler")
    public @interface Config {
        @AttributeDefinition(name = "Cron Expression")
        String cronExpression() default "0 0/5 * * * ?"; // Every 5 minutes
    }

    @Activate
    @Modified
    protected void activate(Config config) {
        scheduler.scheduleAtFixedRate(this, 0, 5, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        LOG.info("Yellow World from Scheduler!");
    }
}
```

2. Deploy and check logs every 5 minutes.

---

## 📌 Create Users & Group with Permissions
### Steps:
1. Navigate to **AEM Start → Security → Users**.
2. Create 3 users: `user1`, `user2`, `user3`.
3. Navigate to **Groups** → **Create Group**: `Dev Author`.
4. Add users to `Dev Author`.
5. Go to **Permissions**:
   - `/content` → **Read** ✅
   - `/dam` → **Read** ✅
   - **Replication** Access ✅

---

## ✅ Conclusion
This guide provides step-by-step instructions and code snippets for:
- Custom Workflow
- Workflow Process
- Event Handler
- Sling Job
- Scheduler
- User & Group Permissions
