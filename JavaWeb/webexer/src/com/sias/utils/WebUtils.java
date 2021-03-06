package com.sias.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 *@ClassName WebUtils
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/28 10:58
 *@Version 1.0
 */
public class WebUtils {

    /**
     *  把Map中的值注入到对应的JavaBean属性中
     *  代替 req.getParameterMap() 这样写扩展性更好
     * @param value
     * @param bean
     */

    public static <T> T copyParamToBean(Map value, T bean){

        try {
            System.out.println("注入之前" + bean);
            /**
             * 把所有的请求的参数都注入到student对象中
             */
            BeanUtils.populate(bean,value);
            System.out.println("注入之后" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){

        try {
            return  Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;

    }

}

