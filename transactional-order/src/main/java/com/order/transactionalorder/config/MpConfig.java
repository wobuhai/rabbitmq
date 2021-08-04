package com.order.transactionalorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 zwj
 * @创建时间 2021/8/4
 * @描述
 */
@Configuration
@MapperScan("com.order.transactionalorder.mapper")
public class MpConfig {
}
