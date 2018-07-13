package com.thorn.milk.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by pengj on 2018-7-13.
 * Github https://github.com/ThornFUN
 * Function:
 */

public class FrontIconModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfront.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcon.values();
    }
}
