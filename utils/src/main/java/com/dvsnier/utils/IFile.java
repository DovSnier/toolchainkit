package com.dvsnier.utils;

import android.content.Context;

import java.io.File;

/**
 * Created by ROOTS on 2017/6/1.
 */
public interface IFile {

    File getDiskCacheDir(Context context, String uniqueName);

    File getDiskDir(Context context, String name);
}
