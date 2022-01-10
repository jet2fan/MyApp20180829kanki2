package com.example.yo.myapp20180829kanki2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //変数定義
    private String str交通方式;//  "対面通行";	//List1.Text    '"対面通"
    private String str道路区分;//= "第3種";		//List2.Text    '"第3種"f
    private String str道路地域;//= "地方部";	//List3.Text    '"地方部"
    private String str道路地形;//= "平地部";	//List4.Text    '"平地部"
    private String str沿道状況;//= "市街化していない地域";//List5.Text    '"市街化していない地域"
    private String str車線幅員;// 3.5;			//Text1.Text    '3.5
    private String str側方余裕;//= 0.75;		//Text2.Text    '0.75
    private String str道路勾配;//= 2.078;		//Text3.Text    '2.078
    private String str大型車混入率;//=0.12;		//Text4.Text    '0.12
    private String str計画交通量;//= 23191;		//Text5.Text  '23191
    private String str設計速度;//= 60;			//Combo1.Text   '70
    private String str屈曲数;//=4;		//Combo2.Text
    private String str区間延長0;//=100; 	//Text6.Text
    private String str区間延長1;//=101; 	//Text6.Text
    private String str区間延長2;//=102; 	//Text6.Text
    private String str区間延長3;//=103; 	//Text6.Text
    private String str区間延長4;//=104; 	//Text6.Text
    private String str区間勾配0;//=1.0; 	//Text7.Text
    private String str区間勾配1;//=1.1; 	//Text7.Text
    private String str区間勾配2;//=1.2; 	//Text7.Text
    private String str区間勾配3;//=1.3; 	//Text7.Text
    private String str区間勾配4;//=1.4; 	//Text7.Text
    private String strトンネル標高;//= 200;//Text22.Text
    private String strトンネル断面;//= 57;	//Text21.Text
    private String str代表寸法;//=7.2; 	//Text23.Text
    private String str供用年度;//Combo3.Text   '20
    private String str選定交通量;// 設計交通容量 or 設計時間交通量
    //クラスの定義
    DebugPrint db = new DebugPrint();
    Form01 form01 = new Form01();
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setScreenMain();
        }
    //プリファレンス読出関数
    private String Str01読出(String strキー, String str値) {
        SharedPreferences pref = getSharedPreferences("kanki01.txt", MODE_PRIVATE);
        return pref.getString(strキー, str値);
    }
    //プリファレンス保存関数
    private void S02保存(String strキー, String str値) {
        SharedPreferences pref = getSharedPreferences("kanki01.txt",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(strキー,str値);
        editor.apply();
    }
    //プリファレンスclear
    private void S03clear() {
        SharedPreferences pref = getSharedPreferences("kanki01.txt",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear().commit();
    }
    private void S04設計条件読出Form設定(){
        str交通方式=   Str01読出("S交通方式","一方通行");
        str道路区分=   Str01読出("S道路区分","第1種");
        str道路地域=   Str01読出("S道路地域","地方部");
        str道路地形=   Str01読出("S道路地形","山地部");
        str沿道状況=   Str01読出("S沿道状況","市街化していない地域");
        str車線幅員=   Str01読出("S車線幅員","3.5");
        str側方余裕=   Str01読出("S側方余裕","1.25");
        str道路勾配=   Str01読出("S道路勾配","3.0");
        str大型車混入率=Str01読出("S大型車混入率","0.40");
        str計画交通量= Str01読出("S計画交通量","27000");
        str選定交通量= Str01読出("S選定交通量","設計交通容量");
        str設計速度=   Str01読出("S設計速度","80.0");
        str屈曲数=     Str01読出("S屈曲数","1");
        str区間延長0=  Str01読出("S区間延長0","5000.0");
        str区間延長1=  Str01読出("S区間延長1","1000.0");
        str区間延長2=  Str01読出("S区間延長2","0.0");
        str区間延長3=  Str01読出("S区間延長3","0.0");
        str区間延長4=  Str01読出("S区間延長4","0.0");
        str区間勾配0=  Str01読出("S区間勾配0","3.0");
        str区間勾配1=  Str01読出("S区間勾配1","-1.0");
        str区間勾配2=  Str01読出("S区間勾配2","0.0");
        str区間勾配3=  Str01読出("S区間勾配3","0.0");
        str区間勾配4=  Str01読出("S区間勾配4","0.0");
        strトンネル標高=Str01読出("Sトンネル標高","400.0");
        strトンネル断面=Str01読出("Sトンネル断面","63.5");
        str代表寸法=   Str01読出("S代表寸法","8.2");
        str供用年度=   Str01読出("S供用年度","25");
        form01.S01換気量計算条件設定_入力(
                str交通方式,
                str道路区分,
                str道路地域,
                str道路地形,
                str沿道状況,
                str車線幅員,
                str側方余裕,
                str道路勾配,
                str大型車混入率,
                str計画交通量,
                str選定交通量,
                str設計速度,
                str屈曲数,
                str区間延長0,
                str区間延長1,
                str区間延長2,
                str区間延長3,
                str区間延長4,
                str区間勾配0,
                str区間勾配1,
                str区間勾配2,
                str区間勾配3,
                str区間勾配4,
                strトンネル標高,
                strトンネル断面,
                str代表寸法,
                str供用年度
                );
    }
    private void S04設計条件読出Form設定_交通量(){
        str交通方式=   Str01読出("S交通方式","一方通行");
        str道路区分=   Str01読出("S道路区分","第1種");
        str道路地域=   Str01読出("S道路地域","地方部");
        str道路地形=   Str01読出("S道路地形","山地部");
        str沿道状況=   Str01読出("S沿道状況","市街化していない地域");
        str車線幅員=   Str01読出("S車線幅員","3.5");
        str側方余裕=   Str01読出("S側方余裕","1.25");
        str道路勾配=   Str01読出("S道路勾配","3.0");
        str大型車混入率=Str01読出("S大型車混入率","0.40");
        str計画交通量= Str01読出("S計画交通量","27000");
        form01.S01換気量計算条件設定_入力_交通量(
                str交通方式,
                str道路区分,
                str道路地域,
                str道路地形,
                str沿道状況,
                str車線幅員,
                str側方余裕,
                str道路勾配,
                str大型車混入率,
                str計画交通量
                );
    }
    private void setScreenMain() {
        setContentView(R.layout.activity_main);
        //buf clear
        db.BufClear();
        //プリファレンスの内容に従ってテキストエディットを設定
        //次ボタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button01);
        sendButton.setOnClickListener(v -> setScreenSub10());
        Button clearButton = findViewById(R.id.PreClear);
        clearButton.setOnClickListener(v -> S03clear());
    }
    private void setScreenSub10(){ //交通方式
        setContentView(R.layout.activity_sub10);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str交通方式 = Str01読出(getString(R.string.S交通方式),getString(R.string.一方通行));
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01交通方式 = findViewById(R.id.radioGroup交通方式);
        if(str交通方式.equals(getString(R.string.一方通行))){
            rdo01交通方式.check(R.id.radioButton11一方通行);
        }
        else if(str交通方式.equals(getString(R.string.対面通行))){
            rdo01交通方式.check(R.id.radioButton12対面通行);
        }
        else{
            db.debugError("error:MainActivity:onCreate:交通方式のラジオボックスが選択されていない。");
        }
        //戻るバタンを押したときの処理記述
        Button returnButton = findViewById(R.id.return_button10);
        returnButton.setOnClickListener(v -> {
            //ラジオボタンのプリファレンス保存
            String str交通方式 = getString(R.string.未選択);
            RadioGroup rdo01交通方式1 = findViewById(R.id.radioGroup交通方式);
            int id = rdo01交通方式1.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton11一方通行:
                    str交通方式 = getString(R.string.一方通行);
                    break;
                case R.id.radioButton12対面通行:
                    str交通方式 = getString(R.string.対面通行);
                    break;
            }
            S02保存(getString(R.string.S交通方式), str交通方式);
            db.debugPrint("MainActivity:rdo01通行方式=" + str交通方式 );
            setScreenMain();
        });
        //次ボタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button10);
        sendButton.setOnClickListener(v -> {
            //ラジオボタンのプリファレンス保存
            String str交通方式 = MainActivity.this.getString(R.string.未選択);
            RadioGroup rdo01交通方式12 = MainActivity.this.findViewById(R.id.radioGroup交通方式);
            int id = rdo01交通方式12.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton11一方通行:
                    str交通方式 = MainActivity.this.getString(R.string.一方通行);
                    break;
                case R.id.radioButton12対面通行:
                    str交通方式 = MainActivity.this.getString(R.string.対面通行);
                    break;
            }
            MainActivity.this.S02保存(MainActivity.this.getString(R.string.S交通方式), str交通方式);
            db.debugPrint("MainActivity:rdo01通行方式=" + str交通方式);
            MainActivity.this.setScreenSub11();
        });
    }//交通方式
    private void setScreenSub11(){ //道路交通規格 交通区分
        setContentView(R.layout.activity_sub11);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str道路区分 = Str01読出("S道路区分","第1種");
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01道路区分 = findViewById(R.id.radioGroup道路区分);
        if(str道路区分.equals(getString(R.string.第1種))){
            rdo01道路区分.check(R.id.radioButton21第1種);
        }
        else if(str道路区分.equals(getString(R.string.第2種))){
            rdo01道路区分.check(R.id.radioButton22第2種);
        }
        else if(str道路区分.equals(getString(R.string.第3種))){
            rdo01道路区分.check(R.id.radioButton23第3種);
        }
        else if(str道路区分.equals(getString(R.string.第4種))){
            rdo01道路区分.check(R.id.radioButton24第4種);
        }
        else{
            db.debugError("error:MainActivity:onCreate:道路区分のラジオボックスが選択されていない。");
        }
        //戻るバタンを押したときの処理記述
        Button returnButton = findViewById(R.id.return_button11);
        returnButton.setOnClickListener(v -> {
            str道路区分 = getString(R.string.未選択);
            RadioGroup rdo01交通区分 = (RadioGroup)findViewById(R.id.radioGroup道路区分);
            int id = rdo01交通区分.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21第1種:
                    str道路区分 = getString(R.string.第1種);
                    break;
                case R.id.radioButton22第2種:
                    str道路区分 = getString(R.string.第2種);
                    break;
                case R.id.radioButton23第3種:
                    str道路区分 = getString(R.string.第3種);
                    break;
                case R.id.radioButton24第4種:
                    str道路区分 = getString(R.string.第4種);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S道路区分), str道路区分);
            db.debugPrint("MainActivity:rdo01道路区分=" + str道路区分 );
            setScreenSub10();
        });
        //次バタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button11);
        sendButton.setOnClickListener(v -> {
            str道路区分 = getString(R.string.未選択);
            RadioGroup rdo01交通区分 = (RadioGroup)findViewById(R.id.radioGroup道路区分);
            int id = rdo01交通区分.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21第1種:
                str道路区分 = getString(R.string.第1種);
                break;
            case R.id.radioButton22第2種:
                str道路区分 = getString(R.string.第2種);
                break;
            case R.id.radioButton23第3種:
                str道路区分 = getString(R.string.第3種);
                break;
            case R.id.radioButton24第4種:
                str道路区分 = getString(R.string.第4種);
                break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S道路区分), str道路区分);
            db.debugPrint("MainActivity:rdo01道路区分=" + str道路区分 );
            setScreenSub12();
        });
    }//道路交通規格 交通区分
    private void setScreenSub12(){ //道路交通規格 道路地域
        setContentView(R.layout.activity_sub12);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str道路地域 = Str01読出(getString(R.string.S道路地域),getString(R.string.地方部));
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01道路地域 = (RadioGroup) findViewById(R.id.radioGroup道路地域);
        if(str道路地域.equals(getString(R.string.都市部))){
            rdo01道路地域.check(R.id.radioButton21都市部);
        }
        else if(str道路地域.equals(getString(R.string.地方部))){
            rdo01道路地域.check(R.id.radioButton22地方部);
        }
        else{
            db.debugError("error:MainActivity:onCreate:道路地域のラジオボックスが選択されていない。");
        }

        Button returnButton = findViewById(R.id.return_button12);
        returnButton.setOnClickListener(v -> {
            str道路地域 = getString(R.string.未選択);
            RadioGroup rdo01道路地域1 = (RadioGroup)findViewById(R.id.radioGroup道路地域);
            int id = rdo01道路地域1.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21都市部:
                    str道路地域 = getString(R.string.都市部);
                    break;
                case R.id.radioButton22地方部:
                    str道路地域 = getString(R.string.地方部);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S道路地域), str道路地域);
            db.debugPrint("MainActivity:rdo01道路地域=" + str道路地域 );
            setScreenSub11();
        });

        Button sendButton = findViewById(R.id.send_button12);
        sendButton.setOnClickListener(v -> {
            String str道路地域 = getString(R.string.未選択);
            RadioGroup rdo01道路地域12 = (RadioGroup)findViewById(R.id.radioGroup道路地域);
            int id = rdo01道路地域12.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21都市部:
                    str道路地域 = getString(R.string.都市部);
                    break;
                case R.id.radioButton22地方部:
                    str道路地域 = getString(R.string.地方部);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S道路地域), str道路地域);
            db.debugPrint("MainActivity:rdo01道路地域=" + str道路地域 );
            setScreenSub13();
        });
    }//道路交通規格 道路地域
    private void setScreenSub13(){ //路線状況
        setContentView(R.layout.activity_sub13);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str道路地形 = Str01読出(getString(R.string.S道路地形),getString(R.string.山地部));
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01道路地形 = (RadioGroup) findViewById(R.id.radioGroup道路地形);
        if(str道路地形.equals(getString(R.string.平地部))){
            rdo01道路地形.check(R.id.radioButton21平地部);
        }
        else if(str道路地形.equals(getString(R.string.山地部))){
            rdo01道路地形.check(R.id.radioButton22山地部);
        }
        else{
            db.debugError("error:MainActivity:onCreate:道路地形のラジオボックスが選択されていない。");
        }
        Button returnButton = findViewById(R.id.return_button13);
        returnButton.setOnClickListener(v -> {
            str道路地形 = getString(R.string.未選択);
            RadioGroup rdo01S道路地形 = (RadioGroup)findViewById(R.id.radioGroup道路地形);
            int id = rdo01S道路地形.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21平地部:
                    str道路地形 = getString(R.string.平地部);
                    break;
                case R.id.radioButton22山地部:
                    str道路地形 = getString(R.string.山地部);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S道路地形), str道路地形);
            db.debugPrint("MainActivity:rdo01道路地形=" + str道路地形);
            setScreenSub12();
        });
        Button sendButton = findViewById(R.id.send_button13);
        sendButton.setOnClickListener(v -> {
            str道路地形 = getString(R.string.未選択);
            RadioGroup rdo01S道路地形 = (RadioGroup)findViewById(R.id.radioGroup道路地形);
            int id = rdo01S道路地形.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21平地部:
                    str道路地形 = getString(R.string.平地部);
                    break;
                case R.id.radioButton22山地部:
                    str道路地形 = getString(R.string.山地部);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S道路地形), str道路地形);
            db.debugPrint("MainActivity:rdo01道路地形=" + str道路地形);
            setScreenSub14();
        });
    }//路線状況
    private void setScreenSub14(){ //路沿道状況の入力
        setContentView(R.layout.activity_sub14);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str沿道状況 = Str01読出(getString(R.string.S沿道状況),getString(R.string.市街化していない地域));
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01沿道状況 = (RadioGroup) findViewById(R.id.radioGroup沿道状況);
        if(str沿道状況.equals(getString(R.string.市街化していない地域))){
            rdo01沿道状況.check(R.id.radioButton21市街化していない地域);
        }
        else if(str沿道状況.equals(getString(R.string.幾分市街化している地域))){
            rdo01沿道状況.check(R.id.radioButton22幾分市街化している地域);
        }
        else if(str沿道状況.equals(getString(R.string.市街化している地域))){
            rdo01沿道状況.check(R.id.radioButton23市街化している地域);
        }
        else{
            db.debugError("error:MainActivity:onCreate:沿道状況のラジオボックスが選択されていない。");
        }
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button14);
        returnButton.setOnClickListener(v -> {
            str沿道状況 = getString(R.string.未選択);
            RadioGroup rdo01沿道状況1 = (RadioGroup)findViewById(R.id.radioGroup沿道状況);
            int id = rdo01沿道状況1.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21市街化していない地域:
                    str沿道状況 = getString(R.string.市街化していない地域);
                    break;
                case R.id.radioButton22幾分市街化している地域:
                    str沿道状況 = getString(R.string.幾分市街化している地域);
                    break;
                case R.id.radioButton23市街化している地域:
                    str沿道状況 = getString(R.string.市街化している地域);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S沿道状況), str沿道状況);
            db.debugPrint("MainActivity:rdo01沿道状況=" + str沿道状況);
            setScreenSub13();
        });
        //次のボタン
        Button sendButton = findViewById(R.id.send_button14);
        sendButton.setOnClickListener(v -> {
            str沿道状況 = getString(R.string.未選択);
            RadioGroup rdo01沿道状況12 = (RadioGroup)findViewById(R.id.radioGroup沿道状況);
            int id = rdo01沿道状況12.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton21市街化していない地域:
                    str沿道状況 = getString(R.string.市街化していない地域);
                    break;
                case R.id.radioButton22幾分市街化している地域:
                    str沿道状況 = getString(R.string.幾分市街化している地域);
                    break;
                case R.id.radioButton23市街化している地域:
                    str沿道状況 = getString(R.string.市街化している地域);
                    break;
            }
            //プリファレンス保存
            S02保存(getString(R.string.S沿道状況), str沿道状況);
            db.debugPrint("MainActivity:rdo01沿道状況=" + str沿道状況);
            setScreenSub15();
        });
    }//路沿道状況
    private void setScreenSub15(){ //道路諸元の入力
        setContentView(R.layout.activity_sub15);
        str車線幅員 =Str01読出(getString(R.string.S車線幅員),"3.5");
        str側方余裕 =Str01読出(getString(R.string.S側方余裕),"1.25");
        str道路勾配 =Str01読出(getString(R.string.S道路勾配),"3.0");
        str大型車混入率 =Str01読出(getString(R.string.S大型車混入率),"0.4");
        str計画交通量 =Str01読出(getString(R.string.S計画交通量),"27000.0");
        EditText edt車線幅員 = findViewById(R.id.editText4車線幅員);
        EditText edt側方余裕 = (EditText)findViewById(R.id.editText5側方余裕);
        EditText edt道路勾配 = (EditText)findViewById(R.id.editText3道路勾配);
        EditText edt大型車混入率 = (EditText)findViewById(R.id.editText6大型車混入率);
        EditText edt計画交通量 = (EditText)findViewById(R.id.editText計画交通量);
        edt車線幅員.setText(str車線幅員);
        edt側方余裕.setText(str側方余裕);
        edt道路勾配.setText(str道路勾配);
        edt大型車混入率.setText(str大型車混入率);
        edt計画交通量.setText(str計画交通量);
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button15);
        returnButton.setOnClickListener(v -> {
            //テキストボックスの内容をプリファレンスに保存
            EditText edt車線幅員1 = (EditText)findViewById(R.id.editText4車線幅員);
            S02保存(getString(R.string.S車線幅員), edt車線幅員1.getText().toString());
            EditText edt側方余裕1 = (EditText)findViewById(R.id.editText5側方余裕);
            S02保存(getString(R.string.S側方余裕), edt側方余裕1.getText().toString());
            EditText edt道路勾配1 = (EditText)findViewById(R.id.editText3道路勾配);
            S02保存(getString(R.string.S道路勾配), edt道路勾配1.getText().toString());
            EditText edt大型車混入率1 = (EditText)findViewById(R.id.editText6大型車混入率);
            S02保存(getString(R.string.S大型車混入率), edt大型車混入率1.getText().toString());
            EditText edt計画交通量1 = (EditText)findViewById(R.id.editText計画交通量);
            S02保存(getString(R.string.S計画交通量), edt計画交通量1.getText().toString());
            setScreenSub14();
        });
        //次のボタン
        Button sendButton = findViewById(R.id.send_button15);
        sendButton.setOnClickListener(v -> {
            //テキストボックスの内容をプリファレンスに保存
            EditText edt車線幅員12 = (EditText)findViewById(R.id.editText4車線幅員);
            S02保存(getString(R.string.S車線幅員), edt車線幅員12.getText().toString());
            EditText edt側方余裕12 = (EditText)findViewById(R.id.editText5側方余裕);
            S02保存(getString(R.string.S側方余裕), edt側方余裕12.getText().toString());
            EditText edt道路勾配12 = (EditText)findViewById(R.id.editText3道路勾配);
            S02保存(getString(R.string.S道路勾配), edt道路勾配12.getText().toString());
            EditText edt大型車混入率12 = (EditText)findViewById(R.id.editText6大型車混入率);
            S02保存(getString(R.string.S大型車混入率), edt大型車混入率12.getText().toString());
            EditText edt計画交通量12 = (EditText)findViewById(R.id.editText計画交通量);
            S02保存(getString(R.string.S計画交通量), edt計画交通量12.getText().toString());
            setScreenSub17();
        });
    }//道路諸元
    private void setScreenSub17(){  //交通量選択
        setContentView(R.layout.activity_sub17);
        S04設計条件読出Form設定_交通量();
        //テキストビューを特定
        TextView textView12設計交通容量 = findViewById(R.id.textView12設計交通容量);
        TextView textView13設計時間交通量 = findViewById(R.id.textView13設計時間交通量);
        //テキストビューに表示
        textView12設計交通容量.setText(form01.S09str設計交通容量());
        textView13設計時間交通量.setText(form01.S10str設計時間交通量());
        //プリファレンスの内容に従ってラジオボックスを設定
        str選定交通量 = Str01読出("S選定交通量","設計交通容量");
        //ラジオボタンをプログラムで設定する。
        RadioGroup rdo02選定交通量 = (RadioGroup)findViewById(R.id.radioGroup選定交通量);
        if(str選定交通量.equals(getString(R.string.設計交通容量))){
            rdo02選定交通量.check(R.id.radioButton31設計交通容量);
        }
        else if(str選定交通量.equals(getString(R.string.設計時間交通量))){
            rdo02選定交通量.check(R.id.radioButton32設計時間交通量);
        }
        else{
            db.debugError("error:MainActivity:onCreate:選定交通量のラジオボタンが選択されていない。");
        }
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button17);
        returnButton.setOnClickListener(v -> {
            str選定交通量="未選択";
            RadioGroup rdo02選定交通量1 = (RadioGroup)findViewById(R.id.radioGroup選定交通量);
            int id = rdo02選定交通量1.getCheckedRadioButtonId();
            switch (id){
                case R.id.radioButton31設計交通容量:
                    str選定交通量="設計交通容量";
                    break;
                case R.id.radioButton32設計時間交通量:
                    str選定交通量="設計時間交通量";
                    break;
                default:
                    db.debugError("error:MainActivity:sub17:設計交通量の選択エラー");
            }
            //プリファレンス保存
            S02保存("S選定交通量",str選定交通量);
            db.debugPrint("MainActivity:rdo01選定交通量=" + str選定交通量 );
            setScreenSub15();
        });
        //次のボタン
        Button sendButton = findViewById(R.id.send_button17);
        sendButton.setOnClickListener(v -> {
            str選定交通量="未選択";
            RadioGroup rdo02選定交通量12 = (RadioGroup)findViewById(R.id.radioGroup選定交通量);
            int id = rdo02選定交通量12.getCheckedRadioButtonId();
            switch(id){
                case R.id.radioButton31設計交通容量:
                    str選定交通量 = "設計交通容量";
                    break;
                case R.id.radioButton32設計時間交通量:
                    str選定交通量= "設計時間交通量";
                    break;
                default:
                    db.debugError("error:MainActivity:sub17:設計交通量の選択エラー");
            }
            //プリファレンス保存
            S02保存("S選定交通量",str選定交通量);
            db.debugPrint("MainActivity:rdo02選定交通量=" + str選定交通量);
            setScreenSub18();
        });
    }//交通量選択 交通量計算
    private void setScreenSub18(){ //設計速度
        setContentView(R.layout.activity_sub18);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str設計速度 = Str01読出("S設計速度","80");
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01設計速度 = (RadioGroup) findViewById(R.id.radioGroup設計速度);
        if(str設計速度.equals(getString(R.string.設計速度80))){
            rdo01設計速度.check(R.id.radioButton181設計速度80);
        }
        else if(str設計速度.equals(getString(R.string.設計速度70))){
            rdo01設計速度.check(R.id.radioButton182設計速度70);
        }
        else if(str設計速度.equals(getString(R.string.設計速度60))){
            rdo01設計速度.check(R.id.radioButton183設計速度60);
        }
        else if(str設計速度.equals(getString(R.string.設計速度50))){
            rdo01設計速度.check(R.id.radioButton184設計速度50);
        }
        else{
            db.debugError("error:MainActivity:onCreate:設計速度のラジオボックスが選択されていない。");
        }
        //戻るバタンを押したときの処理記述
        Button returnButton = findViewById(R.id.return_button18);
        returnButton.setOnClickListener(v -> {
            str設計速度 = getString(R.string.未選択);
            RadioGroup rdo01設計速度1 = (RadioGroup)findViewById(R.id.radioGroup設計速度);
            int id = rdo01設計速度1.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton181設計速度80:
                    str設計速度 = getString(R.string.設計速度80);
                    break;
                case R.id.radioButton182設計速度70:
                    str設計速度 = getString(R.string.設計速度70);
                    break;
                case R.id.radioButton183設計速度60:
                    str設計速度 = getString(R.string.設計速度60);
                    break;
                case R.id.radioButton184設計速度50:
                    str設計速度 = getString(R.string.設計速度50);
                    break;
            }
            //プリファレンス保存
            S02保存("S設計速度", str設計速度);
            db.debugPrint("MainActivity:18設計速度=" + str設計速度 );
            setScreenSub17();
        });
        //次バタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button18);
        sendButton.setOnClickListener(v -> {
            str設計速度 = getString(R.string.未選択);
            RadioGroup rdo01設計速度12 = (RadioGroup)findViewById(R.id.radioGroup設計速度);
            int id = rdo01設計速度12.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton181設計速度80:
                    str設計速度 = getString(R.string.設計速度80);
                    break;
                case R.id.radioButton182設計速度70:
                    str設計速度 = getString(R.string.設計速度70);
                    break;
                case R.id.radioButton183設計速度60:
                    str設計速度 = getString(R.string.設計速度60);
                    break;
                case R.id.radioButton184設計速度50:
                    str設計速度 = getString(R.string.設計速度50);
                    break;
            }
            //プリファレンス保存
            S02保存("S設計速度", str設計速度);
            db.debugPrint("MainActivity:18設計速度=" + str設計速度 );
            setScreenSub19();
        });
    }//設計速度
    private void setScreenSub19(){ //トンネル縦断屈曲数
        setContentView(R.layout.activity_sub19);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str屈曲数 = Str01読出("S屈曲数","1");
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01屈曲数 = (RadioGroup) findViewById(R.id.radioGroupトンネル縦断屈曲数);
        if(str屈曲数.equals(getString(R.string.S屈曲数0))){
            rdo01屈曲数.check(R.id.radioButton190屈曲数0);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数1))){
            rdo01屈曲数.check(R.id.radioButton191屈曲数1);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数2))){
            rdo01屈曲数.check(R.id.radioButton192屈曲数2);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数3))){
            rdo01屈曲数.check(R.id.radioButton193屈曲数3);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数4))){
            rdo01屈曲数.check(R.id.radioButton194屈曲数4);
        }
        else{
            db.debugError("error:MainActivity:onCreate:屈曲数のラジオボックスが選択されていない。");
        }
        //戻るバタンを押したときの処理記述
        Button returnButton = findViewById(R.id.return_button19);
        returnButton.setOnClickListener(v -> {
            str屈曲数 = getString(R.string.未選択);
            RadioGroup rdo01屈曲数12 = (RadioGroup)findViewById(R.id.radioGroupトンネル縦断屈曲数);
            int id = rdo01屈曲数12.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton190屈曲数0:
                    str屈曲数 = getString(R.string.S屈曲数0);
                    break;
                case R.id.radioButton191屈曲数1:
                    str屈曲数 = getString(R.string.S屈曲数1);
                    break;
                case R.id.radioButton192屈曲数2:
                    str屈曲数 = getString(R.string.S屈曲数2);
                    break;
                case R.id.radioButton193屈曲数3:
                    str屈曲数 = getString(R.string.S屈曲数3);
                    break;
                case R.id.radioButton194屈曲数4:
                    str屈曲数 = getString(R.string.S屈曲数4);
                    break;
            }
            //プリファレンス保存
            S02保存("S屈曲数", str屈曲数);
            db.debugPrint("MainActivity:19屈曲数=" + str屈曲数 );
            setScreenSub18();
        });
        //次バタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button19);
        sendButton.setOnClickListener(v -> {
            str屈曲数 = getString(R.string.未選択);
            RadioGroup rdo01屈曲数1 = (RadioGroup)findViewById(R.id.radioGroupトンネル縦断屈曲数);
            int id = rdo01屈曲数1.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton190屈曲数0:
                    str屈曲数 = getString(R.string.S屈曲数0);
                    break;
                case R.id.radioButton191屈曲数1:
                    str屈曲数 = getString(R.string.S屈曲数1);
                    break;
                case R.id.radioButton192屈曲数2:
                    str屈曲数 = getString(R.string.S屈曲数2);
                    break;
                case R.id.radioButton193屈曲数3:
                    str屈曲数 = getString(R.string.S屈曲数3);
                    break;
                case R.id.radioButton194屈曲数4:
                    str屈曲数 = getString(R.string.S屈曲数4);
                    break;
            }
            //プリファレンス保存
            S02保存("S屈曲数", str屈曲数);
            db.debugPrint("MainActivity:19屈曲数=" + str屈曲数 );
            setScreenSub20();
        });
    }//トンネル縦断屈曲数
    private void setScreenSub20(){ //トンネル縦断諸元
        setContentView(R.layout.activity_sub20);
        //プリファレンスの内容に従って設定。
        str区間延長0 =Str01読出("S区間延長0","5000.0");
        str区間延長1 =Str01読出("S区間延長1","1000.0");
        str区間延長2 =Str01読出("S区間延長2","0.0");
        str区間延長3 =Str01読出("S区間延長3","0.0");
        str区間延長4 =Str01読出("S区間延長4","0.0");
        EditText edt区間延長0 = (EditText)findViewById(R.id.editText区間延長0);
        EditText edt区間延長1 = (EditText)findViewById(R.id.editText区間延長1);
        EditText edt区間延長2 = (EditText)findViewById(R.id.editText区間延長2);
        EditText edt区間延長3 = (EditText)findViewById(R.id.editText区間延長3);
        EditText edt区間延長4 = (EditText)findViewById(R.id.editText区間延長4);
        edt区間延長0.setText(str区間延長0);
        edt区間延長1.setText(str区間延長1);
        edt区間延長2.setText(str区間延長2);
        edt区間延長3.setText(str区間延長3);
        edt区間延長4.setText(str区間延長4);

        str区間勾配0 =Str01読出("S区間勾配0","3.0");
        str区間勾配1 =Str01読出("S区間勾配1","-1.0");
        str区間勾配2 =Str01読出("S区間勾配2","0.0");
        str区間勾配3 =Str01読出("S区間勾配3","0.0");
        str区間勾配4 =Str01読出("S区間勾配4","0.0");
        EditText edt区間勾配0 = (EditText)findViewById(R.id.editText区間勾配0);
        EditText edt区間勾配1 = (EditText)findViewById(R.id.editText区間勾配1);
        EditText edt区間勾配2 = (EditText)findViewById(R.id.editText区間勾配2);
        EditText edt区間勾配3 = (EditText)findViewById(R.id.editText区間勾配3);
        EditText edt区間勾配4 = (EditText)findViewById(R.id.editText区間勾配4);
        edt区間勾配0.setText(str区間勾配0);
        edt区間勾配1.setText(str区間勾配1);
        edt区間勾配2.setText(str区間勾配2);
        edt区間勾配3.setText(str区間勾配3);
        edt区間勾配4.setText(str区間勾配4);
        edt区間勾配0.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt区間勾配1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt区間勾配2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt区間勾配3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt区間勾配4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        //
        str屈曲数 = Str01読出("S屈曲数","1");
        if(str屈曲数.equals(getString(R.string.S屈曲数0))){
            edt区間延長1.setText("0.0"); edt区間勾配1.setText("0.0");
            edt区間延長2.setText("0.0"); edt区間勾配2.setText("0.0");
            edt区間延長3.setText("0.0"); edt区間勾配3.setText("0.0");
            edt区間延長4.setText("0.0"); edt区間勾配4.setText("0.0");
            edt区間延長1.setEnabled(false); edt区間勾配1.setEnabled(false);
            edt区間延長2.setEnabled(false); edt区間勾配2.setEnabled(false);
            edt区間延長3.setEnabled(false); edt区間勾配3.setEnabled(false);
            edt区間延長4.setEnabled(false); edt区間勾配4.setEnabled(false);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数1))){
            edt区間延長2.setText("0.0"); edt区間勾配2.setText("0.0");
            edt区間延長3.setText("0.0"); edt区間勾配3.setText("0.0");
            edt区間延長4.setText("0.0"); edt区間勾配4.setText("0.0");
            edt区間延長1.setEnabled(true); edt区間勾配1.setEnabled(true);
            edt区間延長2.setEnabled(false); edt区間勾配2.setEnabled(false);
            edt区間延長3.setEnabled(false); edt区間勾配3.setEnabled(false);
            edt区間延長4.setEnabled(false); edt区間勾配4.setEnabled(false);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数2))){
            edt区間延長3.setText("0.0"); edt区間勾配3.setText("0.0");
            edt区間延長4.setText("0.0"); edt区間勾配4.setText("0.0");
            edt区間延長1.setEnabled(true); edt区間勾配1.setEnabled(true);
            edt区間延長2.setEnabled(true); edt区間勾配2.setEnabled(true);
            edt区間延長3.setEnabled(false); edt区間勾配3.setEnabled(false);
            edt区間延長4.setEnabled(false); edt区間勾配4.setEnabled(false);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数3))){
            edt区間延長4.setText("0.0"); edt区間勾配4.setText("0.0");
            edt区間延長1.setEnabled(true); edt区間勾配1.setEnabled(true);
            edt区間延長2.setEnabled(true); edt区間勾配2.setEnabled(true);
            edt区間延長3.setEnabled(true); edt区間勾配3.setEnabled(true);
            edt区間延長4.setEnabled(false); edt区間勾配4.setEnabled(false);
        }
        else if(str屈曲数.equals(getString(R.string.S屈曲数4))){
            edt区間延長1.setEnabled(true); edt区間勾配1.setEnabled(true);
            edt区間延長2.setEnabled(true); edt区間勾配2.setEnabled(true);
            edt区間延長3.setEnabled(true); edt区間勾配3.setEnabled(true);
            edt区間延長4.setEnabled(true); edt区間勾配4.setEnabled(true);
        }
        else{
            db.debugError("error:MainActivity:onCreate:屈曲数のラジオボックスが選択されていない。");
        }
        //戻るバタンを押したときの処理記述
        Button returnButton = findViewById(R.id.return_button20);
        returnButton.setOnClickListener(v -> {
            //テキストボックスの内容をプリファレンスに保存
            EditText edt区間延長01 = (EditText)findViewById(R.id.editText区間延長0);
            EditText edt区間延長11 = (EditText)findViewById(R.id.editText区間延長1);
            EditText edt区間延長21 = (EditText)findViewById(R.id.editText区間延長2);
            EditText edt区間延長31 = (EditText)findViewById(R.id.editText区間延長3);
            EditText edt区間延長41 = (EditText)findViewById(R.id.editText区間延長4);
            EditText edt区間勾配01 = (EditText)findViewById(R.id.editText区間勾配0);
            EditText edt区間勾配11 = (EditText)findViewById(R.id.editText区間勾配1);
            EditText edt区間勾配21 = (EditText)findViewById(R.id.editText区間勾配2);
            EditText edt区間勾配31 = (EditText)findViewById(R.id.editText区間勾配3);
            EditText edt区間勾配41 = (EditText)findViewById(R.id.editText区間勾配4);
            S02保存("S区間延長0", edt区間延長01.getText().toString());
            S02保存("S区間延長1", edt区間延長11.getText().toString());
            S02保存("S区間延長2", edt区間延長21.getText().toString());
            S02保存("S区間延長3", edt区間延長31.getText().toString());
            S02保存("S区間延長4", edt区間延長41.getText().toString());
            S02保存("S区間勾配0", edt区間勾配01.getText().toString());
            S02保存("S区間勾配1", edt区間勾配11.getText().toString());
            S02保存("S区間勾配2", edt区間勾配21.getText().toString());
            S02保存("S区間勾配3", edt区間勾配31.getText().toString());
            S02保存("S区間勾配4", edt区間勾配41.getText().toString());
            //前の画面に戻る
            setScreenSub19();
        });
        //次バタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button20);
        sendButton.setOnClickListener(v -> {
            //テキストボックスの内容をプリファレンスに保存
            EditText edt区間延長012 = (EditText)findViewById(R.id.editText区間延長0);
            EditText edt区間延長112 = (EditText)findViewById(R.id.editText区間延長1);
            EditText edt区間延長212 = (EditText)findViewById(R.id.editText区間延長2);
            EditText edt区間延長312 = (EditText)findViewById(R.id.editText区間延長3);
            EditText edt区間延長412 = (EditText)findViewById(R.id.editText区間延長4);
            EditText edt区間勾配012 = (EditText)findViewById(R.id.editText区間勾配0);
            EditText edt区間勾配112 = (EditText)findViewById(R.id.editText区間勾配1);
            EditText edt区間勾配212 = (EditText)findViewById(R.id.editText区間勾配2);
            EditText edt区間勾配312 = (EditText)findViewById(R.id.editText区間勾配3);
            EditText edt区間勾配412 = (EditText)findViewById(R.id.editText区間勾配4);
            S02保存("S区間延長0", edt区間延長012.getText().toString());
            S02保存("S区間延長1", edt区間延長112.getText().toString());
            S02保存("S区間延長2", edt区間延長212.getText().toString());
            S02保存("S区間延長3", edt区間延長312.getText().toString());
            S02保存("S区間延長4", edt区間延長412.getText().toString());
            S02保存("S区間勾配0", edt区間勾配012.getText().toString());
            S02保存("S区間勾配1", edt区間勾配112.getText().toString());
            S02保存("S区間勾配2", edt区間勾配212.getText().toString());
            S02保存("S区間勾配3", edt区間勾配312.getText().toString());
            S02保存("S区間勾配4", edt区間勾配412.getText().toString());
            //次の画面に戻る
            setScreenSub21();
        });
    }//トンネル縦断諸元
    private void setScreenSub21(){ //トンネル諸元
        setContentView(R.layout.activity_sub21);
        //トンネル延長計算
        str屈曲数=     Str01読出("S屈曲数","4");
        str区間延長0=  Str01読出("S区間延長0","100.0");
        str区間延長1=  Str01読出("S区間延長1","101.0");
        str区間延長2=  Str01読出("S区間延長2","102.0");
        str区間延長3=  Str01読出("S区間延長3","103.0");
        str区間延長4=  Str01読出("S区間延長4","104.0");
        form01.S01換気量計算条件設定_入力_トンネル延長(
                str屈曲数,
                str区間延長0,
                str区間延長1,
                str区間延長2,
                str区間延長3,
                str区間延長4
                );
        //プリファレンスの内容に従って設定。
        strトンネル断面 =Str01読出(getString(R.string.Sトンネル断面),"63.5");
        str代表寸法 =Str01読出(getString(R.string.S代表寸法),"8.2");
        strトンネル標高 =Str01読出(getString(R.string.Sトンネル標高),"400.0");
        //edittext設定
        TextView textView1トンネル延長= findViewById(R.id.textView1トンネル延長);
        EditText edtトンネル断面    = (EditText)findViewById(R.id.editTextトンネル断面);
        EditText edt代表寸法        = (EditText)findViewById(R.id.editText代表寸法);
        EditText edtトンネル標高    = (EditText)findViewById(R.id.editTextトンネル標高);
        //テキスト表示
        textView1トンネル延長.setText("トンネル延長(m)     " + form01.S17strトンネル延長() );
        edtトンネル断面.setText(strトンネル断面);
        edt代表寸法.setText(str代表寸法);
        edtトンネル標高.setText(strトンネル標高);
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button21);
        returnButton.setOnClickListener(v -> {
            //テキストボックスの内容をプリファレンスに保存
            EditText edtトンネル断面1 = (EditText)findViewById(R.id.editTextトンネル断面);
            S02保存(getString(R.string.Sトンネル断面), edtトンネル断面1.getText().toString());
            EditText edt代表寸法1 = (EditText)findViewById(R.id.editText代表寸法);
            S02保存(getString(R.string.S代表寸法), edt代表寸法1.getText().toString());
            EditText edtトンネル標高1 = (EditText)findViewById(R.id.editTextトンネル標高);
            S02保存(getString(R.string.Sトンネル標高), edtトンネル標高1.getText().toString());
            setScreenSub20();
        });
        //次のボタン
        Button sendButton = findViewById(R.id.send_button21);
        sendButton.setOnClickListener(v -> {
            //テキストボックスの内容をプリファレンスに保存
            EditText edtトンネル断面12 = (EditText)findViewById(R.id.editTextトンネル断面);
            S02保存(getString(R.string.Sトンネル断面), edtトンネル断面12.getText().toString());
            EditText edt代表寸法12 = (EditText)findViewById(R.id.editText代表寸法);
            S02保存(getString(R.string.S代表寸法), edt代表寸法12.getText().toString());
            EditText edtトンネル標高12 = (EditText)findViewById(R.id.editTextトンネル標高);
            S02保存(getString(R.string.Sトンネル標高), edtトンネル標高12.getText().toString());
            setScreenSub22();
        });
    }//トンネル諸元
    private void setScreenSub22(){ //供用年度
        setContentView(R.layout.activity_sub22);
        //プリファレンスの内容に従ってラジオボックスを設定。
        str供用年度 = Str01読出("S供用年度","25");
        //ラジオボタンをプログラムで設定する
        RadioGroup rdo01供用年度 = (RadioGroup) findViewById(R.id.radioGroupトンネル供用年度);
        switch (str供用年度) {
            case "20":
                rdo01供用年度.check(R.id.radioButton220供用年度20);
                break;
            case "21":
                rdo01供用年度.check(R.id.radioButton221供用年度21);
                break;
            case "22":
                rdo01供用年度.check(R.id.radioButton222供用年度22);
                break;
            case "23":
                rdo01供用年度.check(R.id.radioButton223供用年度23);
                break;
            case "24":
                rdo01供用年度.check(R.id.radioButton224供用年度24);
                break;
            case "25":
                rdo01供用年度.check(R.id.radioButton225供用年度25);
                break;
            default:
                db.debugError("error:MainActivity:onCreate:供用年度のラジオボックスが選択されていない。");
                break;
        }
        //戻るバタンを押したときの処理記述
        Button returnButton = findViewById(R.id.return_button22);
        returnButton.setOnClickListener(v -> {
            str供用年度 = getString(R.string.未選択);
            RadioGroup rdo01供用年度1 = (RadioGroup)findViewById(R.id.radioGroupトンネル供用年度);
            int id = rdo01供用年度1.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton220供用年度20:
                    str供用年度 = "20";//getString(R.string.S供用年度20);
                    break;
                case R.id.radioButton221供用年度21:
                    str供用年度 = "21";//getString(R.string.S供用年度21);
                    break;
                case R.id.radioButton222供用年度22:
                    str供用年度 = "22";//getString(R.string.S供用年度22);
                    break;
                case R.id.radioButton223供用年度23:
                    str供用年度 = "23";//getString(R.string.S供用年度23);
                    break;
                case R.id.radioButton224供用年度24:
                    str供用年度 = "24";//getString(R.string.S供用年度24);
                    break;
                case R.id.radioButton225供用年度25:
                    str供用年度 = "25";//getString(R.string.S供用年度25);
                    break;
            }
            //プリファレンス保存
            S02保存("S供用年度", str供用年度);
            db.debugPrint("MainActivity:22供用年度=" + str供用年度 );
            setScreenSub21();
        });
        //次バタンを押したときの処理記述
        Button sendButton = findViewById(R.id.send_button22);
        sendButton.setOnClickListener(v -> {
            str供用年度 = getString(R.string.未選択);
            RadioGroup rdo01供用年度12 = (RadioGroup)findViewById(R.id.radioGroupトンネル供用年度);
            int id = rdo01供用年度12.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton220供用年度20:
                    str供用年度 = "20";//getString(R.string.S供用年度20);
                    break;
                case R.id.radioButton221供用年度21:
                    str供用年度 = "21";//getString(R.string.S供用年度21);
                    break;
                case R.id.radioButton222供用年度22:
                    str供用年度 = "22";//getString(R.string.S供用年度22);
                    break;
                case R.id.radioButton223供用年度23:
                    str供用年度 = "23";//getString(R.string.S供用年度23);
                    break;
                case R.id.radioButton224供用年度24:
                    str供用年度 = "24";//getString(R.string.S供用年度24);
                    break;
                case R.id.radioButton225供用年度25:
                    str供用年度 = "25";//getString(R.string.S供用年度25);
                    break;
            }
            //プリファレンス保存
            S02保存("S供用年度", str供用年度);
            db.debugPrint("MainActivity:22供用年度=" + str供用年度 );
            setScreenSub23();
        });
    }//供用年度
    private void setScreenSub23(){ //計算結果 換気量
        setContentView(R.layout.activity_sub23);
        //db.debugPrint("MainActivity setScreenSub23");
        S04設計条件読出Form設定();
        //プリファレンスから読出
        str交通方式 =Str01読出(getString(R.string.S交通方式),getString(R.string.一方通行));
        str選定交通量 = Str01読出(getString(R.string.S選定交通量),getString(R.string.設計交通容量));
        //テキストビューを特定
        TextView textView2交通方式    = findViewById(R.id.textView2交通方式);
        TextView textView3選定交通量  = findViewById(R.id.textView3選定交通量);
        TextView textView4所要換気量  = findViewById(R.id.textView4所要換気量);
        TextView textView5自然換気量  = findViewById(R.id.textView5自然換気量);
        //テキストビューに表示
        textView2交通方式.setText("交通方式    ：" + str交通方式);
        textView3選定交通量.setText("選定交通量：" + str選定交通量);
        switch(str選定交通量){ //煤煙換気量表示
            case "設計交通容量":
                textView4所要換気量.setText("煤煙換気量：" + form01.S11str煤煙換気量_設計交通容量() + " (㎥)");
                break;
            case "設計時間交通量":
                textView4所要換気量.setText("煤煙換気量：" + form01.S12str煤煙換気量_設計時間交通量()+ " (㎥)");
                break;
            default:// Case Else
                db.debugError("error:MainActivity：S23自然一方換気H20：S選定交通量=" + str選定交通量);
        }//switch End Select
        switch(str交通方式){ //煤煙換気量表示
            case "対面通行":
                textView5自然換気量.setText("自然換気量：" + form01.S13str自然換気量_対面通行() +" (㎥)" );
                break;
            case "一方通行":
                textView5自然換気量.setText("自然換気量：" + form01.S14str自然換気量_一方通行() +" (㎥)" );
                break;
            default:// Case Else
                db.debugError("error:MainActivity：S23自然一方換気H20：S交通方式=" + str交通方式);
        }//switch End Select
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button23);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScreenSub22();
            }
        });
        //次へボタン
        Button sendButton = findViewById(R.id.send_button23);
        sendButton.setOnClickListener(v -> setScreenSub24());
    }//計算結果 換気量
    private void setScreenSub24(){ //計算結果 JF台数
        setContentView(R.layout.activity_sub24);
        //テキストビューを特定
        TextView textView2_JF600      = findViewById(R.id.textView2_JF600 );
        TextView textView2_JF600_2      = findViewById(R.id.textView2_JF600_2 );
        TextView textView3_JF1000     = findViewById(R.id.textView3_JF1000);
        TextView textView3_JF1000_2     = findViewById(R.id.textView3_JF1000_2);
        TextView textView4_JF1250     = findViewById(R.id.textView4_JF1250);
        TextView textView4_JF1250_2     = findViewById(R.id.textView4_JF1250_2);
        TextView textView5_JF1500     = findViewById(R.id.textView5_JF1500 );
        TextView textView5_JF1500_2     = findViewById(R.id.textView5_JF1500_2 );
        TextView textView6_JF600_35   = findViewById(R.id.textView6_JF600_35 );
        TextView textView6_JF600_35_2   = findViewById(R.id.textView6_JF600_35_2 );
        TextView textView7_JF1000_35  = findViewById(R.id.textView7_JF1000_35);
        TextView textView7_JF1000_35_2  = findViewById(R.id.textView7_JF1000_35_2);
        TextView textView8_JF1250_35  = findViewById(R.id.textView8_JF1250_35);
        TextView textView8_JF1250_35_2  = findViewById(R.id.textView8_JF1250_35_2);
        //テキストビューに表示
        int intJF種類;
        intJF種類 = form01.S16JF種類();
        String[] strJF台数 = new String[ intJF種類];
        String[] strJF台数ceil = new String[ intJF種類];
        form01.S15JF台数( strJF台数 );
        form01.S15JF台数ceil( strJF台数ceil );
        //textView1トンネル名称.setText( strトンネル名称 );
        textView2_JF600.setText(    "JF600 - 30 : " + strJF台数[0] );
        textView2_JF600_2.setText(    " → "+ strJF台数ceil[0] + " (台)");
        textView3_JF1000.setText(   "JF1000-30 : " + strJF台数[1]);
        textView3_JF1000_2.setText(   " → "+ strJF台数ceil[1] + " (台)");
        textView4_JF1250.setText(   "JF1250-30 : " + strJF台数[2]);
        textView4_JF1250_2.setText(   " → "+ strJF台数ceil[2] + " (台)");
        textView5_JF1500.setText(   "JF1500-30 : " + strJF台数[3]);
        textView5_JF1500_2.setText(   " → "+ strJF台数ceil[3] + " (台)");
        textView6_JF600_35.setText( "JF600 - 35 : " + strJF台数[4]);
        textView6_JF600_35_2.setText( " → "+ strJF台数ceil[4] + " (台)");
        textView7_JF1000_35.setText("JF1000-35 : " + strJF台数[5]);
        textView7_JF1000_35_2.setText( " → "+ strJF台数ceil[5] + " (台)");
        textView8_JF1250_35.setText("JF1250-35 : " + strJF台数[6] );
        textView8_JF1250_35_2.setText(" → "+ strJF台数ceil[6] + " (台)");
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button24);
        returnButton.setOnClickListener(v -> setScreenSub23());
        //次へボタン
        Button sendButton = findViewById(R.id.send_button24);
        sendButton.setOnClickListener(v -> setScreenSub25());
    }//計算結果 JF台数
    private void setScreenSub25(){ //計算結果 排煙用JF
        setContentView(R.layout.activity_sub25);
        //テキストビューを特定
        TextView textView2_JF600      = findViewById(R.id.textView2_JF600 );
        TextView textView3_JF1000     = findViewById(R.id.textView3_JF1000);
        TextView textView4_JF1250     = findViewById(R.id.textView4_JF1250);
        TextView textView5_JF1500     = findViewById(R.id.textView5_JF1500 );
        TextView textView6_JF600_35   = findViewById(R.id.textView6_JF600_35 );
        TextView textView7_JF1000_35  = findViewById(R.id.textView7_JF1000_35);
        TextView textView8_JF1250_35  = findViewById(R.id.textView8_JF1250_35);
        TextView textView2_JF600_2      = findViewById(R.id.textView2_JF600_2 );
        TextView textView3_JF1000_2     = findViewById(R.id.textView3_JF1000_2);
        TextView textView4_JF1250_2     = findViewById(R.id.textView4_JF1250_2);
        TextView textView5_JF1500_2     = findViewById(R.id.textView5_JF1500_2 );
        TextView textView6_JF600_35_2   = findViewById(R.id.textView6_JF600_35_2 );
        TextView textView7_JF1000_35_2  = findViewById(R.id.textView7_JF1000_35_2);
        TextView textView8_JF1250_35_2  = findViewById(R.id.textView8_JF1250_35_2);
        //テキストビューに表示
        int intJF種類;
        intJF種類 = form01.S19排煙JF種類();
        String[] strJF台数 = new String[ intJF種類];
        String[] strJF台数ceil = new String[ intJF種類];
        form01.S18排煙JF台数( strJF台数 );
        form01.S18排煙JF台数ceil( strJF台数ceil );
        textView2_JF600.setText(    "JF600 - 30 : " + strJF台数[0]);
        textView2_JF600_2.setText(    " → "+ strJF台数ceil[0] + " (台)");
        textView3_JF1000.setText(   "JF1000-30 : " + strJF台数[1]);
        textView3_JF1000_2.setText(   " → "+ strJF台数ceil[1] + " (台)");
        textView4_JF1250.setText(   "JF1250-30 : " + strJF台数[2] );
        textView4_JF1250_2.setText(   " → "+ strJF台数ceil[2] + " (台)");
        textView5_JF1500.setText(   "JF1500-30 : " + strJF台数[3] );
        textView5_JF1500_2.setText(   " → "+ strJF台数ceil[3] + " (台)");
        textView6_JF600_35.setText( "JF600 - 35 : " + strJF台数[4] );
        textView6_JF600_35_2.setText( " → "+ strJF台数ceil[4] + " (台)");
        textView7_JF1000_35.setText("JF1000-35 : " + strJF台数[5] );
        textView7_JF1000_35_2.setText( " → "+ strJF台数ceil[5] + " (台)");
        textView8_JF1250_35.setText("JF1250-35 : " + strJF台数[6] );
        textView8_JF1250_35_2.setText( " → "+ strJF台数ceil[6] + " (台)");
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button25);
        returnButton.setOnClickListener(v -> setScreenSub24());
        //次へボタン
        Button sendButton = findViewById(R.id.send_button25);
        sendButton.setOnClickListener(v -> setScreenSub26());
    }//計算結果 排煙用JF
    private void setScreenSub26() { //Print Log
        setContentView(R.layout.activity_sub26);
        TextView textView_PrintLog   = findViewById(R.id.textView_PrintLog );
        TextView textView_PrintLog1   = findViewById(R.id.textView_PrintLog1 );
        textView_PrintLog.setText(db.Massage());

        int intError = db.Massage().indexOf("Error");
        if ( intError == -1 ){
            textView_PrintLog1.setText(R.string.PrintLog2);
        }else{
            textView_PrintLog1.setText(R.string.PrintLog1Error);
        }
        //戻るボタン
        Button returnButton = findViewById(R.id.return_button26);
        returnButton.setOnClickListener(v -> {
            db.BufClear();
            setScreenSub25();
        });
        //clear
        Button clearButton = findViewById(R.id.clear_button26);
        clearButton.setOnClickListener(v -> {
            db.BufClear();
            S04設計条件読出Form設定();
            int intError2 = db.Massage().indexOf("Error");
            if ( intError2 == -1 ){
                textView_PrintLog1.setText(R.string.PrintLog2);
            }else{
                textView_PrintLog1.setText(R.string.PrintLog1Error);
            }
            textView_PrintLog.setText(db.Massage());
        });
    }//Print Log
}// Main Activity
