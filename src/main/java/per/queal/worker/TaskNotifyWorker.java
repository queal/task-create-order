package per.queal.worker;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import org.camunda.bpm.client.ExternalTaskClient;

import java.util.logging.Logger;

public class TaskNotifyWorker {
    private final static Logger LOGGER = Logger.getLogger(TaskNotifyWorker.class.getName());

    public static void main(String[] args) {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000)
                .build();


        client.subscribe("task-nodify")
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {

                    // Get a process variable
                    Console.log("{}", JSONUtil.toJsonStr(externalTask.getAllVariables()));

                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
