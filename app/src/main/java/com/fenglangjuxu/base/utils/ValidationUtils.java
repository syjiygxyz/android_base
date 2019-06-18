package com.fenglangjuxu.base.utils;

import java.util.regex.Pattern;

/**
 * Created by wq on 2018/5/15.
 */

public class ValidationUtils {
    /**
     * 是否输入为空
     *
     * @param str
     * @return
     */
    public static boolean checkEmpty(String str) {

        if (!"".equals(str))
            return false;

        return true;
    }

    /**
     * 验证用户名是否合法
     *
     * @return
     */
    public static boolean checkUserName(String text) {

        String reg = "[\u4e00-\u9fa5]{2,4}$";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

    /**
     * 验证手机号码是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkTelPhone(String text) {
        String reg = "^1\\d{10}$";
        boolean result = Pattern.compile(reg).matcher(text).find();
        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

    /**
     * 验证qq号码是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkQQNumber(String text) {
        String reg = "[1-9][0-9]{4,}";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

    /**
     * 验证邮箱是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkEmail(String text) {
        String reg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }
    /**
     * 验证身份证号码是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkCard(String text) {
        String reg = "[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }
        return true;
    }

    /**
     * 验证住址是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkAddress(String text) {
        String reg = "^[\\u4E00-\\u9FA5A-Za-z\\d\\-\\_]{5,60}$";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

    /**
     * 验证邮政编码是否合法
     *
     * @return
     */
    public static boolean checkYb(String text) {
        String reg = "^[1-9]\\d{5}$";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

    /**
     * 验证昵称是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkNickName(String text) {
        String reg = "[^?!@#$%\\^&*()]+";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

    /**
     * 验证密码是否合法
     *
     * @param text
     * @return
     */
    public static boolean checkPassWord(String text) {
        String reg = "^([\u4e00-\u9fa5]+|[a-zA-Z0-9]+){6,20}$";

        boolean result = Pattern.compile(reg).matcher(text).find();

        if (!result) {// 验证失败
            return false;
        }

        return true;
    }

}
