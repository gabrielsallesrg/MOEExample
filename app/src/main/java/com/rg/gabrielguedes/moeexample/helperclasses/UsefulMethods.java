package com.rg.gabrielguedes.moeexample.helperclasses;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by gabrielguedes on 31/07/17.
 */

public class UsefulMethods {

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 120);
        return noOfColumns;
    }
}
