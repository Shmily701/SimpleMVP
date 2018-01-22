package com.shmily.simplemvp.view;

import com.shmily.simplemvp.bean.StudentBean;

import java.util.List;

/**
 * Created by Shmily on 2018/1/18.
 * View 接口
 */

public interface IStudentView {
    /**
     * 显示进度条
     */
    void showLoading();

    /**
     * 展示失败结果
      */
    void showFailed();
    /**
     * 显示获取数据的结果,即数据
     * @param list
     */
    void showStudentList(List<StudentBean> list);
}
