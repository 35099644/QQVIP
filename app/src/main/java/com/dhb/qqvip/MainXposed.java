package com.dhb.qqvip;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by dhb on 2016/8/18.
 * xposed 初始化
 */
public class MainXposed implements IXposedHookLoadPackage {
    private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam packageParam) throws Throwable {
        if (!packageParam.packageName.equals(QQ_PACKAGE_NAME)) {
            return;
        }

        Friend.init(packageParam);
    }
}
