package com.ahzc.stu;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(FdfsClientConfig.class)
@SpringBootApplication
@MapperScan("com.ahzc.stu.mapper")
public class StuApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class, args);
    }

}
