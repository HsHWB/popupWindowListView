package com.example.bingoo.popupwindow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button button;
    private Button buttonPop;
    private View view;
    private LinearLayout mainView;
    private View popView;
    private PopupWindow popupWindow;
    public Animation animationOut;
    public WindowManager.LayoutParams lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lp = getWindow().getAttributes();
        initView();
        initPopWindow();
    }
    public void initView(){
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
        //findViewById()???
        mainView = (LinearLayout) this.findViewById(R.id.main_linear);
        view = this.getLayoutInflater().inflate(R.layout.pop_layout, null);
        popView = view.findViewById(R.id.view_pop);
        animationOut = AnimationUtils.loadAnimation(this,
                R.anim.popupbutton_out);
        popView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "透明popView", Toast.LENGTH_SHORT).show();
                Animation animationIn = AnimationUtils.loadAnimation(v.getContext(),
                        R.anim.popupbutton_in);
                popupWindow.dismiss();
                lp.alpha=1.0f;
                getWindow().setAttributes(lp);
            }
        });
    }

    public void initPopWindow(){

        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
//        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.PopWindowAnim);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(0x55000000));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button){
            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            lp.alpha=0.3f;
            getWindow().setAttributes(lp);
//            mainView.startAnimation(animationOut);
//            view.startAnimation(animationOut);
//            view.setBackgroundDrawable(new ColorDrawable(0x55000000));
//            mainView.setBackgroundDrawable(new ColorDrawable(0x55000000));
//            mainView.startAnimation(animationOut);
        }
    }
}
