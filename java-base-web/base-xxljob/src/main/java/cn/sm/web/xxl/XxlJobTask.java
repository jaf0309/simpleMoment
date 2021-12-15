package cn.sm.web.xxl;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class XxlJobTask {

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("simplemomentHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World."+System.currentTimeMillis());
        return ReturnT.SUCCESS;
    }


}
