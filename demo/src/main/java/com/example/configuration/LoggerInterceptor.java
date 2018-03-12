package com.example.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.controller.ClinicController;
import com.example.domain.LoggerInfos;
import com.example.jpa.LoggerInfosJpa;
import com.example.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {
    private static final String LOGGER_SEND_TIME="_send_time";
    private static final String LOGGER_ENTITY="_logger_entity";
    private Logger logger= LoggerFactory.getLogger(getClass().getName());
    /**
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        LoggerInfos log=new LoggerInfos();
        String sessionId=request.getRequestedSessionId();
        String uri=request.getRequestURI();
        String paramData= JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        log.setClientIp(LoggerUtils.getCliectIp(request));
        log.setMethod(request.getMethod());
        log.setType(LoggerUtils.getRequestType(request));
        log.setParamData(paramData);
        log.setUri(uri);
        log.setSessionId(sessionId);
        log.setTime(System.currentTimeMillis()+"");
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY,log);
//        logger.info("----------------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        int status=response.getStatus();
        //结束时间
        long currentTime=System.currentTimeMillis();
        //获取开始时间
        long time=Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        LoggerInfos log=(LoggerInfos)request.getAttribute(LOGGER_ENTITY);
        log.setTimeConsuming((int)(currentTime-time));
        log.setReturnTime(currentTime+"");
        log.setHttpStatusCode(status+"");
        log.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        LoggerInfosJpa dao=getDAO(LoggerInfosJpa.class,request);
        dao.save(log);
    }
    private <T> T getDAO(Class<T> clazz,HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
