package com.shmily.simplemvp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.shmily.simplemvp.bean.StudentBean;
import com.shmily.simplemvp.presenter.StudentPresenter;
import com.shmily.simplemvp.view.IStudentView;

import java.util.List;

public class StudentActivity extends Activity implements IStudentView{

    private ListView listview;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initView();
        fetchData();
    }

    private void initView(){
        listview = (ListView) findViewById(R.id.listview);
    }


    private void fetchData(){
        // 调用presenter加载数据
        new StudentPresenter(this).fetch();
    }

    /**
     * 展示进度条
     */
    @Override
    public void showLoading() {
        Toast.makeText(this,getString(R.string.loading),Toast.LENGTH_SHORT).show();
    }

    /**
     * 展示数据
     */
    @Override
    public void showStudentList(List<StudentBean> list) {
        myAdapter = new MyAdapter(this,list);
        listview.setAdapter(myAdapter);
    }

    /**
     * 展示加载失败
     */
    @Override
    public void showFailed() {
        Toast.makeText(this,getString(R.string.loadfailed),Toast.LENGTH_SHORT).show();
    }
}
