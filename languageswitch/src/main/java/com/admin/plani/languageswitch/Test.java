package com.admin.plani.languageswitch;

/**
 * 创建时间 2018/10/12
 *
 * @author plani
 */
public class Test {
    private String name;

    public String getName() {
        Zprint.log(this,name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
