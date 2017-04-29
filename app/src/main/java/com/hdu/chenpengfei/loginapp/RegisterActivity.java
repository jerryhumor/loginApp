package com.hdu.chenpengfei.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText editSchoolNumber, editPassword, editName, editClassNumber;
    private TextView editBirthday, editCollege;
    private ImageButton imgBtnBirthday, imgBtnCollege;
    private Button registerButton;
    private RadioGroup rgSex;
    private RadioButton rbSex;
    private Toolbar toolbar;

    private TimePickerView pvBirthday;
    private OptionsPickerView pvCollege;

    private List<String> collegeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initCollegeList();
        initPvBirthday();
        initPvCollege();

        editSchoolNumber = (EditText) findViewById(R.id.register_edit_school_number);
        editPassword = (EditText) findViewById(R.id.register_edit_password);
        editName = (EditText) findViewById(R.id.register_edit_name);
        editClassNumber = (EditText) findViewById(R.id.register_edit_class_number);
        editBirthday = (TextView) findViewById(R.id.register_edit_birthday);
        editCollege = (TextView) findViewById(R.id.register_edit_college);
        imgBtnBirthday = (ImageButton) findViewById(R.id.register_img_btn_birthday);
        imgBtnCollege = (ImageButton) findViewById(R.id.register_img_btn_college);
        registerButton = (Button) findViewById(R.id.register_btn_register);
        rgSex = (RadioGroup) findViewById(R.id.register_rg_sex);
        toolbar = (Toolbar) findViewById(R.id.register_toolbar);

        setSupportActionBar(toolbar);

        imgBtnBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvBirthday.show();
            }
        });

        imgBtnCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvCollege.show();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = getStudent();
                student.save();
                setResult(RESULT_OK);
                finish();
            }
        });

    }

    public void initPvBirthday(){

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(1900, 0, 0);

        pvBirthday = new TimePickerView.Builder(RegisterActivity.this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                Calendar dateSelected = Calendar.getInstance();
                dateSelected.setTime(date);
                int year = dateSelected.get(Calendar.YEAR);
                int month = dateSelected.get(Calendar.MONTH) + 1;
                int day = dateSelected.get(Calendar.DAY_OF_MONTH);

                editBirthday.setText(year+"年"+month+"月"+day+"日");
            }
        }).setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("年", "月", "日", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.colorAccent)
                .setDate(endDate)
                .setRangDate(startDate, endDate)
                .setContentSize(20)
                .build();

    }

    public void initPvCollege(){

        pvCollege = new  OptionsPickerView.Builder(RegisterActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3 ,View v) {
                editCollege.setText(collegeList.get(options1).toString());
            }
        }).setTitleText("学院选择")
                .setLabels("", "", "")
                .build();
        pvCollege.setNPicker(collegeList, null, null);
    }

    public void initCollegeList(){

        collegeList = new ArrayList<>();
        collegeList.add("机械工程学院");
        collegeList.add("生命信息与仪器工程学院");
        collegeList.add("经济学院");
        collegeList.add("外国语学院");
        collegeList.add("马克思主义学院");
        collegeList.add("国际教育学院");
        collegeList.add("电子信息学院");
        collegeList.add("材料与环境工程学院");
        collegeList.add("卓越学院");
        collegeList.add("继续教育学院");
        collegeList.add("通信工程学院");
        collegeList.add("软件工程学院");
        collegeList.add("管理学院");
        collegeList.add("数字媒体和艺术设计学院");
        collegeList.add("体育与艺术教学部");
        collegeList.add("浙江保密学院");
        collegeList.add("计算机学院");
        collegeList.add("自动化学院");
        collegeList.add("会计学院");
        collegeList.add("理学院");
        collegeList.add("人文与法学院");
        collegeList.add("学院");

    }

    public Student getStudent(){

        Student student = new Student();
        student.setSchoolNumber(editSchoolNumber.getText().toString());
        student.setPassword(editPassword.getText().toString());
        student.setName(editName.getText().toString());
        student.setBirthday(editBirthday.getText().toString());
        rbSex = (RadioButton) findViewById(rgSex.getCheckedRadioButtonId());
        student.setSex(rbSex.getText().toString());
        student.setCollege(editCollege.getText().toString());
        student.setClassNumber(editClassNumber.getText().toString());

        return student;
    }
}
