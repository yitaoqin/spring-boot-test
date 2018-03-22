package com.example.multipledatasource.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.multipledatasource.annotation.ContentSecurity;
import com.example.multipledatasource.annotation.ContentSecurityConstants;
import com.example.multipledatasource.util.DES3Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Executors;

@Slf4j
public class ContentSecurityInterceptor  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean isPass =true;
        /*
        获取请求映射方法对象
         */
        HandlerMethod handlerMethod = (HandlerMethod) o;
        /*
        获取访问方法实例对象
         */
        Method method=handlerMethod.getMethod();
        ContentSecurity security=method.getAnnotation(ContentSecurity.class);
        if(security!=null){
            switch (security.away()){
                case DES:
                    isPass=checkDES(httpServletRequest,httpServletResponse);
                    break;
            }
        }
        return isPass;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    boolean checkDES(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String des=request.getParameter(ContentSecurityConstants.DES_PARAMETER_NAME);
        log.info("请求加密参数内容：{}",des);
        /*
        加密串不存在
         */
        if(des == null || des.length() == 0){
            JSONObject json=new JSONObject();
            json.put("msg","The DES Content Security Away Request , Parameter Required is "+ ContentSecurityConstants.DES_PARAMETER_NAME);
            response.getWriter().print(JSON.toJSONString(json));
            return false;
        }

        try{
            des=DES3Util.decrypt(des,DES3Util.DESKEY,"UTF-8");
            if(StringUtils.isNoneBlank(des)){
                JSONObject params=JSON.parseObject(des);
                log.info("解密请求后获得参数列表{}",des);
                Iterator it=params.keySet().iterator();
                while (it.hasNext()){
                    String parameterName=it.next().toString();
                    if(StringUtils.isNoneBlank(parameterName)){
                        request.setAttribute(ContentSecurityConstants.ATTRIBUTE_PREFFIX+ parameterName,params.get(parameterName));
                    }
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
            JSONObject json=new JSONObject();
            json.put("msg","The DES Content Security Error.  "+ ContentSecurityConstants.DES_PARAMETER_NAME);
            response.getWriter().print(JSON.toJSONString(json));
            return false;
        }
        return true;
    }
}
