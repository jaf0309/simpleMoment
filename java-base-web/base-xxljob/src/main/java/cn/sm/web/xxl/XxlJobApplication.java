package cn.sm.web.xxl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;


@SpringBootApplication(scanBasePackages = {"cn.sm.web.xxl"})
//@EnableApolloConfig
public class XxlJobApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(XxlJobApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    【xxl-job】启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }

}
