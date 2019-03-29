package cn.mydrn.filter;

import cn.mydrn.utils.CodecUtils;
import cn.mydrn.utils.HttpStatus;
import cn.mydrn.utils.SensitiveWordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 拦截器
 * @Author: nican
 * @Date: 2019/3/29
 */
public class FrontFilter implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.info("preHandleInterceptor start...");
            logger.info("拦截器===url:" + request.getRequestURL() + "***" + request.getMethod());
            logger.info("拦截器====query:" + request.getQueryString());
        }
        String data = CodecUtils.urlDecode(request.getQueryString());
        if (StringUtils.hasText(data)) {
            if (SensitiveWordUtil.contains(data)) {
                logger.error("拦截敏感字符:" + data);
                response.sendError(HttpStatus.SENSITIVE_PARAMETER.getValue());
                return false;
            }
            //不拦截 过滤请看AdviceController

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

}
