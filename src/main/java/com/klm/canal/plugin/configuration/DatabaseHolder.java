package com.klm.canal.plugin.configuration;

/**
 * mysql key holder
 * @date  2020-07-08
 * @author  quinn
 */
public class DatabaseHolder {

    /**
     * ThreadLocal每个线程都独有的保存其线程所属的变量值
     */
    private static ThreadLocal<String> holder = new ThreadLocal<>();


    /**
     * mysql
     */
    public static void setDatabaseSource(String ds) {
        holder.set(ds);
    }

    public static String getDatabaseSource() {
        return holder.get();
    }

    public static void clearDatabaseSource() {
        holder.remove();
    }
}
