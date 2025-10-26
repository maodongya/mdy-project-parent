package com.mdy.project.uitl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author dongya.mao
 * @date 2021/6/28
 * @describe
 */
public class MdyAssert {
    public static void check(boolean param) {
        if (!param) {
            error();
        }

    }

    public static void checkNull(Object param) {
        if (param != null) {
            error();
        }

    }

    public static <T> T checkNonNull(T param) {
        if (param == null) {
            error();
        }

        return param;
    }

    public static void check(boolean param, int message) {
        if (!param) {
            error(String.valueOf(message));
        }

    }

    public static void check(boolean param, long message) {
        if (!param) {
            error(String.valueOf(message));
        }

    }

    public static void check(boolean param, Object message) {
        if (!param) {
            error(String.valueOf(message));
        }

    }

    public static void check(boolean param, String message) {
        if (!param) {
            error(message);
        }

    }

    public static void checkNull(Object param, Object message) {
        if (param != null) {
            error(String.valueOf(message));
        }

    }

    public static void checkNull(Object param, String message) {
        if (param != null) {
            error(message);
        }

    }

    public static <T> T checkNonNull(T param, String message) {
        if (param == null) {
            error(message);
        }

        return param;
    }
    
    
    public static String checkNonBlack(String param, String message) {
        if(StringUtils.isBlank(param)){
            MdyAssert.error(message);
        }
        return param;
    }
    public static  Collection<?> checkNotEmpty(Collection<?> param, String message) {
        if(CollectionUtils.isEmpty(MdyAssert.checkNonNull(param,message))){
            MdyAssert.error(message);
        }
        return param;
    }
    public static void error() {
        throw new MdyAssertException();
    }
    public static void error(String message) {
        throw new MdyAssertException(message);
    }
    /**
     * 自定义异常
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年10月27日 下午10:11:27
     */
    @Data
    @EqualsAndHashCode(callSuper=false)
    public static class MdyAssertException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private String message;
        private int code = 500;
        public MdyAssertException() {
            super("");
            this.message = "";
        }
        public MdyAssertException(String message) {
            super(message);
            this.message = message;
        }
        public MdyAssertException(Throwable e) {
            super(e);
            this.message = e.getMessage();
        }
        public MdyAssertException(String message, Throwable e) {
            super(message, e);
            this.message = message;
        }

        public MdyAssertException(String message, int code) {
            super(message);
            this.message = message;
            this.code = code;
        }

        public MdyAssertException(String message, int code, Throwable e) {
            super(message, e);
            this.message = message;
            this.code = code;
        }
    }

}
