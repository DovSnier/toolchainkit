package com.dvsnier.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/26.
 */

public class FileUtils implements IFile {

    private static final FileUtils instance = new FileUtils();

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        return instance;
    }

    @Override
    public File getDiskCacheDir(Context context, String uniqueName) {
        if (null == context) return null;
        File cache;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            cache = context.getExternalCacheDir();
        } else {
            cache = context.getCacheDir();
        }
        if (null != uniqueName && !"".equals(uniqueName)) {
            File uniqueCache = new File(cache.getPath(), uniqueName);
            if (!uniqueCache.exists()) cache.mkdir();
            return uniqueCache;
        } else {
            return cache;
        }
    }

    @Override
    public File getDiskDir(Context context, String name) {
        if (null == context) return null;
        File diskFile;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            diskFile = context.getExternalFilesDir(name);
        } else {
            diskFile = context.getFilesDir();
        }
        return diskFile;
    }

    public static boolean isDeleteSDCardDSLFile(String pattern, int dayOfMonth) {
        boolean isDelete = false;
        if (null == pattern || dayOfMonth <= 0) return isDelete;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1 * dayOfMonth);
        final Date expiredDate = calendar.getTime();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date patternDate = simpleDateFormat.parse(pattern);
            isDelete = patternDate.before(expiredDate);
        } catch (ParseException e) {
            isDelete = false;
        }
        return isDelete;
    }

    public static void deleteSDCardExpiredFile(String directory, String name) {
        if (null == directory || null == name) return;
        File file = new File(directory);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (null != listFiles && listFiles.length > 0) {
                for (File itemFile : listFiles) {
                    String itemName = itemFile.getName();
                    if (name.equals(itemName)) {
                        continue;
                    }
                    String dateOfItemFile = itemName.substring(0, itemName.indexOf("."));
                    if (isDeleteSDCardDSLFile(dateOfItemFile, 7)) {
                        itemFile.delete();
                    }
                }
            }
        }
    }
}
