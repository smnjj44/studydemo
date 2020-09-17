package com.study.tlcache.aspect;

import com.google.gson.Gson;
import com.study.tlcache.annotation.TlCache;
import com.study.tlcache.utils.TlCacheUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
public class TlCacheAspect {

    //在某个注解下围绕方法的结果进行环绕前后增强
    @Around(value = "@annotation(tlCache)")
    public Object aroundAdvice(ProceedingJoinPoint joinpoint, TlCache tlCache) throws Throwable{
            Object[] args = joinpoint.getArgs();
            Method method = ((MethodSignature) joinpoint.getSignature()).getMethod();
            String className = joinpoint.getTarget().getClass().getName();
            String methodName = method.getName();
            String key = "";
            if (StringUtils.isEmpty(tlCache.key())) {
                key = getDefaultKey(className, methodName, args);
            } else {
                key = ensureKey(className, methodName, method, tlCache.key());
            }
            Map cache = TlCacheUtil.get();
            if (cache == null) {
                Object result = joinpoint.proceed();//执行方法
                cache = new HashMap();
                Map finalCache = cache;
                finalCache.put(key, result);
                TlCacheUtil.set(finalCache);
                return result;//return直接修改加了注解的方法的返回结果
            } else {
                Map finalCache = cache;
                if (finalCache.containsKey(key)) {
                    return finalCache.get(key);
                }else {
                    Object result = joinpoint.proceed();
                    finalCache.put(key,result);
                    return result;
                }
            }
    }

    private String getDefaultKey(String className,String methodName,Object[] args){
        Gson gson = new Gson();
        if (args != null) {
            String key = className + "_" + methodName + "_" + gson.toJson(args);
            return key;
        }else {
            return className + "_" + methodName;
        }
    }

    /**
     * 自定义的key是类名+方法名+参数名+自定义注解上面的key
     * @param className
     * @param methodName
     * @param method
     * @param key
     * @return
     */
    private String ensureKey(String className,String methodName,Method method ,String key){
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = nameDiscoverer.getParameterNames(method);
        StringBuilder builder = new StringBuilder();
        builder.append(className+"_").append(methodName+"_");
        for (String s : paraNameArr) {
            builder.append(s+"_");
        }
        return builder.toString()+key;
    }
}
