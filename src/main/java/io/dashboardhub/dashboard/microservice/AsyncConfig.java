package io.dashboardhub.dashboard.microservice;

import io.dashboardhub.dashboard.microservice.Config.AsyncParametersConfig;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Autowired
    private AsyncParametersConfig asyncParametersConfig;

    private final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    @Override
    public Executor getAsyncExecutor() {
        this.executor.setCorePoolSize(asyncParametersConfig.getCorePoolSize());
        this.executor.setMaxPoolSize(asyncParametersConfig.getMaxPoolSize());
        this.executor.setQueueCapacity(asyncParametersConfig.getQueueCapacity());
        this.executor.setThreadNamePrefix(asyncParametersConfig.getName());
        this.executor.initialize();

        return this.executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {

            }
        };
    }
}
