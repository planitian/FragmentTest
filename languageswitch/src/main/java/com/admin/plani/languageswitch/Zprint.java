package com.admin.plani.languageswitch;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 创建时间 2018/8/22
 *
 * @author plani
 */
public class Zprint {
    public static void log(Object object, @Nullable String key, Object... out) {
        boolean next = false;
        String methodName;
        Class<?> objectClass = object.getClass();
        String simpleName = objectClass.getSimpleName();
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        for (StackTraceElement value : s) {
            if (value.getMethodName().startsWith("lambda")) {
                next = true;
            }
        }
        if (!next) {
            methodName = s[3].getMethodName();
        } else {
            methodName = s[5].getMethodName();
        }
        int lines = s[3].getLineNumber();
        StringBuilder temp = new StringBuilder();
        for (Object anOut : out) {
            temp.append(" ").append(anOut).append(",");
        }
        String TAG="类class: "+ simpleName+" : ";
        if (key==null||key.isEmpty()){
//            System.out.println("类class ： " + simpleName + "   方法method ：" + methodName + "  line:" + lines + "  输出： " + temp);
            String parameter= "方法method ：" + methodName + "  line:" + lines+" 输出： " + temp;
            Log.d(TAG,parameter);
        }else {
//            System.out.println("类class ： " + simpleName + "   方法method ：" + methodName + "  line:" + lines + "  输出： " + key + " :" + temp);
            String parameter ="方法method ：" + methodName + "  line:" + lines+"  输出： " + key + " :" + temp;
            Log.d(TAG,parameter);
        }
    }


    public static void log(Object object,Object... out) {
        boolean next = false;
        String methodName;
        Class<?> objectClass = object.getClass();
        String simpleName = objectClass.getSimpleName();
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        for (StackTraceElement value : s) {
            if (value.getMethodName().startsWith("lambda")) {
                next = true;
            }
        }
        if (!next) {
            methodName = s[3].getMethodName();
        } else {
            methodName = s[5].getMethodName();
        }
        int lines = s[3].getLineNumber();
        StringBuilder temp = new StringBuilder();
        for (Object anOut : out) {
            temp.append(" ").append(anOut).append(",");
        }
            String TAG="类class: "+ simpleName+" : ";
            String parameter= "方法method ：" + methodName + "  line:" + lines+" 输出： " + temp;
            Log.d(TAG,parameter);

    }
}
