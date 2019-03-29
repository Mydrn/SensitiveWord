package cn.mydrn;

import cn.mydrn.utils.SensitiveWordUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

/**
 * 加载文件最好写上classpath:/  避免通过class 获取资源相对路径问题
 *
 * @author mydrn
 */

@SpringBootApplication
public class MydrnTestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MydrnTestApplication.class, args);
        SensitiveWordUtil.getRank();
    }


}
