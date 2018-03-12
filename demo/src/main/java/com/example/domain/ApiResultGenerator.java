package com.example.domain;

import java.util.List;

public class ApiResultGenerator {

    public static ApiResult result(boolean flag,String msg,Object result,String jumpUrl,
                                   int rows ,Throwable throwable){
        ApiResult apiResult=ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setMsg("".equals(msg)?"zhixingchenggong":msg);
        apiResult.setResult(result);
        apiResult.setJumpUrl(jumpUrl);
        apiResult.setTime(System.currentTimeMillis());
        apiResult.setRows(rows);
        return apiResult;
    }
    public static ApiResult successResult(Object result){
        int rows=0;
        if(result instanceof List){
            rows=((List)result).size();
        }
        return result(true,"",result,"",rows,null);
    }
    public static ApiResult errorResult(String msg,Throwable throwable){
        return result(false,msg,"","",0,throwable);
    }
}
