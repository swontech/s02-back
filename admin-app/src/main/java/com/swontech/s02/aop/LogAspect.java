package com.swontech.s02.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);


//    @Around("within(com.swontech.s02.client..controller..*.*)")
//    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
//        return null;
//    }

    // get requset value
    private String getRequestParams() {
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();

        if (requestAttribute != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();

            Map<String, String[]> params = request.getParameterMap();

        }
        return null;
    }
//
//    private String paramMapToString(Map<String, String[]> paramMap) {
//        return paramMap.entrySet().stream()
//                .map(entry -> String.format("%s -> (%s)",
//                        entry.getKey(), Joiner.on(",").join(entry.getValue())))
//                .collect(Collectors.joining(", "));
//    }

}
