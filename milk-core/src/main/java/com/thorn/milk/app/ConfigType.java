package com.thorn.milk.app;

/**
 * 1. enum 修饰的枚举类
 * 2. 特点：整个程序里面保证唯一的单例，只能被初始化一次，在进行多线程操作时使用，是一种多线程安全的懒汉模式
 */

public enum ConfigType {
    API_HOST,
    APPLICATION_CONTEXT,
    CONFIG_READY,
    ICON
}
