package com.bigkoo.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.contrarywind.interfaces.IPickerViewData;
import com.contrarywind.view.WheelView;

/**
 * author: lx Date: 2018/11/17 17:40 Description:
 */
public class EnglishMonthWheelView extends WheelView {
    public EnglishMonthWheelView(Context context) {
        super(context);
    }

    public EnglishMonthWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected String getContentText(Object item) {
        if (item == null || TextUtils.isEmpty(item.toString())) {
            return "";
        } else if (item instanceof IPickerViewData) {
            return ((IPickerViewData) item).getPickerViewText();
        } else if (item instanceof Integer) {
            // 如果为整形则最少保留两位数.
            int value = (int) item;
            String month = null;
            switch (value) {
                case 1:
                    month = "January";
                    break;
                case 2:
                    month = "February";
                    break;
                case 3:
                    month = "March";
                    break;
                case 4:
                    month = "April";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "June";
                    break;
                case 7:
                    month = "July";
                    break;
                case 8:
                    month = "August";
                    break;
                case 9:
                    month = "September";
                    break;
                case 10:
                    month = "October";
                    break;
                case 11:
                    month = "November";
                    break;
                case 12:
                    month = "December";
                    break;
            }
            return month;
        }
        return item.toString();
    }
}
