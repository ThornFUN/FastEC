package com.thorn.milk.ec.icon;

/**
 * Created by pengj on 2018-7-13.
 * Github https://github.com/ThornFUN
 * Function:
 */

public enum EcIcon implements com.joanzapata.iconify.Icon {

    icon_ali_pay('\ue606'),
    icon_scan('\ue606');
    private char character;

    EcIcon(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
