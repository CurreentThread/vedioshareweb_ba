package com.vsw.aspect;

import com.vsw.common.util.TokenUtils;
import com.vsw.domain.Testvedio;
import com.vsw.domain.Vediouser;
import com.vsw.modal.constant.SystemEnum;
import com.vsw.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Aspect
@Component
@Slf4j
public class LoginAspect {


    public static final String ACCESS_TOKEN_PARAM = "accessToken";

    public static final String VEDIOUSER_PARAM = "vediouser";


    @Autowired
    private UserService userService;

    //声明切入点
    @Pointcut("@annotation(com.vsw.common.config.LoginRequired)")
    public void annotationPointCut(){}


    @Before("com.vsw.aspect.LoginAspect.annotationPointCut()")
    public void beforeLogin(JoinPoint joinPoint){
        Object[] paramValues = joinPoint.getArgs();//获取joinpoint参数
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();//

        Vediouser transfer = new Vediouser();


        for(int i=0;i<paramNames.length;i++){

             if(StringUtils.pathEquals(paramNames[i],VEDIOUSER_PARAM)){
                transfer = (Vediouser) paramValues[i];
                continue;
            }
            //判断accesstoken是否为null
            if(StringUtils.pathEquals(paramNames[i],ACCESS_TOKEN_PARAM)){
                //获取accesstoken
                String accessToken =(String)paramValues[i];
                try {
                    Claims claims = TokenUtils.parseJWT(accessToken);
                    String mobile = claims.getId();

                    log.info(mobile);
                    Vediouser search = userService.automicLogin(mobile);
                    if(search!=null)
                       packageUser(transfer,search);

                }catch (Exception e){
                    log.error(SystemEnum.ERROR.getDetail());
                }

            }
        }

//
    }

    private void packageUser(Vediouser transfer, Vediouser search) {
        transfer.setMobile(search.getMobile());
        transfer.setPassword(search.getPassword());
        transfer.setUserid(search.getUserid());
        transfer.setUsername(search.getUsername());
        transfer.setUserphoto(search.getUserphoto());
    }


}
