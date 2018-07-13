package com.thorn.milk.app;

import android.hardware.camera2.params.InputConfiguration;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pengj on 2018-7-13.
 * Github https://github.com/ThornFUN
 * Function:
 * 提醒：尽量让变量具有不可变性（使用 final 修饰），一个避免误修改，二个可以提升性能
 */
public class Configurator {

    private static final HashMap<String, Object> MILK_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        MILK_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    /*
    * 2. 返回存储 Configurations 的 Map 实例，
    * */
    public static HashMap<String, Object> getMilkConfigs() {
        return MILK_CONFIGS;
    }

    /*
    * 3. 暴露外部调用的方法，以作初始化记录
    * */
    public final void configure() {
        MILK_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
        initIcons();
    }

    /*
    * 4. 传入 ApiHost 初始化数据
    * */
    public final Configurator withApiHost(String host) {
        MILK_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;//将原对象添加属性后，重新赋值回去
    }

    /*
    * 5. 从 Map 中获取指定 ConfigType 的 Object 的值
    * */
    @SuppressWarnings("unchecked")
    final <T> T getConfigurations(Enum<ConfigType> key) {
        checkConfigration();
        return (T) MILK_CONFIGS.get(key);
    }

    public final void checkConfigration() {
        final boolean isReady = (boolean) MILK_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Config is not ready,call configure");
        }
    }

    public void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = new Iconify.IconifyInitializer(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {// 0 已经被加入过了，从 1 开始
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor iconFontDescriptor) {
        ICONS.add(iconFontDescriptor);
        return this;
    }

    /*
    * 1. 返回 Configurator 实例，使用懒汉模型的单例模式，静态内部类方式实现
    * */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }
}
