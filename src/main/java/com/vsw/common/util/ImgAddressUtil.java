package com.vsw.common.util;

public class ImgAddressUtil {

    public static String rewriteImgAddressByHashCode(String originalName) {
        int index = originalName.lastIndexOf(".");


        String resetName = originalName.substring(0, index);

        String suffix = originalName.substring(index);

        String realName = resetName.hashCode()+suffix;
        return realName;
    }
}
