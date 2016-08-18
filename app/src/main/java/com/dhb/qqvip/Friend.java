package com.dhb.qqvip;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by dhb on 2016/8/18.
 * com.tencent.mobileqq.data.Friends
 */
public class Friend {

    static Class<?> FriendClass;

    /**
     * @param packageParam
     * 初始化
     */
    public static void init(XC_LoadPackage.LoadPackageParam packageParam) {
        FriendClass = XposedHelpers.findClass("com.tencent.mobileqq.data.Friends",packageParam.classLoader);
        hookIsServiceEnabled();
        hookGetServiceLevel();
    }

    /**
     * hook Friend.isServiceEnabled()
     * 改变返回值为true（SVIP）
     */
    private static void hookIsServiceEnabled() {
        XposedHelpers.findAndHookMethod(FriendClass,
                "isServiceEnabled",
                "QQService.EVIPSPEC",
                XC_MethodReplacement.returnConstant(true));
    }

    /**
     * hook Friend.getServiceLevel()
     * 改变返回值为7 （SVIP为7级）
     */
    private static void hookGetServiceLevel() {
        XposedHelpers.findAndHookMethod(FriendClass,
                "getServiceLevel",
                "QQService.EVIPSPEC",
                XC_MethodReplacement.returnConstant(7));
    }
}
