package com.thorn.fastec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.thorn.milk.app.Milk;
import com.thorn.milk.ec.icon.FrontIconModule;

/**
 * Created by pengj on 2018-7-13.
 * Github https://github.com/ThornFUN
 * Function:
 */

public class FastECApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Milk.init(getApplicationContext())
                .withIcon(new FrontIconModule())
                .withIcon(new FontAwesomeModule())
//                .withApiHost("这里写服务器地址")
                .configure();
    }
}
