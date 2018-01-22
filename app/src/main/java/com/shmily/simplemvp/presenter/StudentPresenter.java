package com.shmily.simplemvp.presenter;

import com.shmily.simplemvp.bean.StudentBean;
import com.shmily.simplemvp.model.IStudentModel;
import com.shmily.simplemvp.model.StudentModelImpl;
import com.shmily.simplemvp.view.IStudentView;

import java.util.List;

/**
 * Created by Shmily on 2018/1/18.
 * 中间者,持有view与model的引用,利用对象组合的方式,将二者关联
 */

public class StudentPresenter {

    private IStudentView mStudentView;

    private IStudentModel mModel = new StudentModelImpl();

    public StudentPresenter(IStudentView studentView) {
        this.mStudentView = studentView;
    }

    /**
     * model获取数据
     */
    public void fetch(){
        //view show loading
        mStudentView.showLoading();
        // model 获取数据
        mModel.fetchData(new IStudentModel.OnLoadListener() {
            @Override
            public void onLoadSuccess(List<StudentBean> list) {
                // model获取数据成功后,由view来展示
                mStudentView.showStudentList(list);
            }

            @Override
            public void onLoadFailed() {
                mStudentView.showFailed();
            }
        });
    }
}
