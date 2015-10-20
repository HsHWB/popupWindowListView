package com.example.bingoo.popupwindow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button button;
    private Button buttonPop;
    private View view;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initPopWindow();
    }
    public void initView(){
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);

        view = this.getLayoutInflater().inflate(R.layout.pop_layout, null);
        buttonPop = (Button) view.findViewById(R.id.button_pop);
        buttonPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    public void initPopWindow(){

        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
//        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.PopWindowAnim);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button){
            popupWindow.showAsDropDown(v);
        }
    }
}
