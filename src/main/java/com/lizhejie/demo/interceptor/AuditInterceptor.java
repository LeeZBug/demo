package com.lizhejie.demo.interceptor;

import com.lizhejie.demo.model.entity.BaseEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class AuditInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if (target instanceof Executor) {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            Object parameter = invocation.getArgs()[1];

            // 判断是否需要填充审计字段
            if (parameter instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) parameter;
                Field createdTimeField = BaseEntity.class.getDeclaredField("createdTime");
                Field modifiedTimeField = BaseEntity.class.getDeclaredField("modifiedTime");
                Field isDeletedField = BaseEntity.class.getDeclaredField("isDeleted");

                createdTimeField.setAccessible(true);
                modifiedTimeField.setAccessible(true);
                isDeletedField.setAccessible(true);

                LocalDateTime currentTime = LocalDateTime.now();

                if (mappedStatement.getId().endsWith(".insert")) {
                    createdTimeField.set(entity, currentTime);
                    modifiedTimeField.set(entity, currentTime);
                    isDeletedField.set(entity, "0");
                } else if (mappedStatement.getId().endsWith(".update")) {
                    modifiedTimeField.set(entity, currentTime);
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 可以在这里设置一些属性
    }
}
