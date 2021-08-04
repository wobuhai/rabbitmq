package com.disp.transactionaldisp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 zwj
 * @创建时间 2021/8/4
 * @描述
 */
@Configuration
@MapperScan("com.disp.transactionaldisp.mapper")
public class MpConfig {
}
