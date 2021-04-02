package com.d.api.common.utils;

import cn.hutool.core.date.DateTime;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author dsscccc
 * @Description
 * @date 2020/12/14 9:57
 */
public class FileUtil {

    public static String getFilePath(String mouleName,String fileName) {
        DateTime dateTime = new DateTime();
        return "images/"+mouleName+"/" + dateTime.toString("yyyy") + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() +
                RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(fileName, ".");
    }

}
