package cn.mydrn.controller;

import cn.mydrn.utils.SensitiveWordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * controller 额外逻辑处理类 常用作异常处理
 * 
 * @author mydrn 2017年12月11日
 */
@Component
@ControllerAdvice
public class AdviceController {
	/**
	 * 日志对象
	 */
	private static Logger logger = LoggerFactory.getLogger(AdviceController.class);
	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				if (text ==null){
					setValue(null);
				}else{
					setValue(SensitiveWordUtil.replaceSensitiveWord(text, '*'));
				}
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
	}

}
