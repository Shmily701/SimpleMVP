package com.shmily.simplemvp.model;

import com.shmily.simplemvp.bean.StudentBean;

import java.util.List;

/**
 * Created by Shmily on 2018/1/18.
 * Model接口
 */

public interface IStudentModel {
    /**
     * 加载数据
     * @param listener
     */
    void fetchData(OnLoadListener listener);
    /**
     * 加载完成的回调
     */
    interface OnLoadListener {
        void onLoadSuccess(List<StudentBean> list);

        void onLoadFailed();
    }
}
