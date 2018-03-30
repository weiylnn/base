package com.leap.base.util;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.leap.base.mgr.ContextMgr;

/**
 * 代码设置View控件圆角边框背景颜色
 * <p>
 * </> Created by ylwei on 2018/1/9.
 */
public class ViewUtil {

  /**
   * @param roundRadius
   *          圆角半径
   * @param strokeWidth
   *          边框宽度
   * @param strokeColor
   *          边框颜色
   * @param fillColor
   *          内部填充颜色
   * @param views
   *          需要设置的目标View
   */
  public static void setDrawable(int roundRadius, int strokeWidth, int strokeColor, int fillColor,
      View... views) {
    try {
      // 创建drawable
      GradientDrawable gd = new GradientDrawable();
      gd.setStroke(DensityUtil.dp2px(strokeWidth),
          ContextCompat.getColor(ContextMgr.getInstance(), strokeColor));
      gd.setCornerRadius(DensityUtil.dp2px(roundRadius));
      gd.setColor(ContextCompat.getColor(ContextMgr.getInstance(), fillColor));
      for (View view : views) {
        // 设置drawable
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
          view.setBackground(gd);
      }
    } catch (Resources.NotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   * @param roundRadius
   *          圆角半径
   * @param orientation
   *          方向
   * @param colors
   *          分别为开始颜色，中间夜色，结束颜色
   * @param views
   *          需要设置的目标View
   */
  public static void setDrawable(int roundRadius, GradientDrawable.Orientation orientation,
      int colors[], View... views) {
    // 创建drawable
    GradientDrawable gd = new GradientDrawable(orientation, colors);
    gd.setCornerRadius(roundRadius);
    for (View view : views) {
      // 设置drawable
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        view.setBackground(gd);
    }
  }
}
