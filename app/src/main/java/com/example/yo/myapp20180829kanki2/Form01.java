package com.example.yo.myapp20180829kanki2;
public class Form01{
    //クラスの定義
    DebugPrint db = new DebugPrint();
    //定数設定20181102
    final int C設計交通容量 	=0;
    final int C設計時間交通量 	=1;
    final int C交通量種類 =1+1; //1;+1配列の添字→交通量種類の数
    final int CJF種類 = 6+1;//6;+1配列の添字/
    final int C屈曲 =4+1; //4;+1配列の添字//屈曲点最大値
    final int C上下線 = 1+1;//error20200214 配列の添字なので＋１
    final int C対面 = 1;
    //【不要】int I情報ID =0;
    //クラス定義20181102
    //【不要】	A01縦断Class A縦断			= new A01縦断Class();
    A01縦断H20Class A縦断H20 			= new A01縦断H20Class();
    A03交通Class A交通 				= new A03交通Class();
    A04速度Class A速度 				= new A04速度Class();
    //【不要】	A05換気Class A換気			= new A05換気Class();
    A05換気量H20Class A換気H20 		= new A05換気量H20Class();
    A06自然対面H20Class A自然対面H20	= new A06自然対面H20Class();
    A06自然一方H20Class A自然一方H20 	= new A06自然一方H20Class();
    //【不要】	A07JFClass   AJF  		= new A07JFClass();
    A07JFH20Class AJFH20 			= new A07JFH20Class();
    A08火災H20Class A排煙H20 			= new A08火災H20Class();
    //交通量算出変数20181102
    private String S交通方式;// As String '対面通行・一方通行
    private String S道路区分;// As String '第1種～第4種
    private String S道路地域;// As String '地方部・都市部
    private String S道路地形;// As String '平地部・山地部
    private String S沿道状況;// As String '市街化していない地域 幾分市街化している地域 市街化している地域
    private double D車線幅員;// As Double 'm
    private double D側方余裕;// As Double 'm
    private double D道路勾配;// As Double '% 3%以下
    private double D大型車混入率;// As Double '%
    private double D計画交通量;// As Double '台/日
    //走行速度算出変数
    private double D設計速度;// As Double 'km/h
    private double D可能交通容量_乗用車;// As Double 'pcu/h
    private double[] D設計交通量_乗用車= new double[C交通量種類];//(C交通量種類) As Double   'pcu/h
    private double[] D設計交通量 		= new double[C交通量種類];//(C交通量種類) As Double
    private double[] D走行速度		= new double[C交通量種類];//(C交通量種類) As Double '0…C設計交通容量、1…C設計時間交通量
    //縦断勾配算出
    private int I区間屈曲数;// As Integer
    private double[] D区間延長 		= new double[C屈曲];//(C屈曲) As Double
    private double[] D区間勾配 		= new double[C屈曲];//(C屈曲) As Double
    //旧基準なので利用しないprivate double[] D勾配補正係数 	= new double[C交通量種類];//(C交通量種類) As Double
    //'0…C設計交通容量、1…C設計時間交通量
    private double Dトンネル標高;// As Double
    private double Dトンネル断面;// As Double
    private double Dトンネル延長;// As Double
    private double D代表寸法;// As Double
    //旧基準なので利用しない20210821 private double[] D煤煙換気量 		= new double[C交通量種類];//(C交通量種類) As Double
    private double[] D煤煙換気量H20 	= new double[C交通量種類];//(C交通量種類) As Double
    //旧基準なので利用しないprivate double[] DCO換気量 		= new double[C交通量種類];//(C交通量種類) As Double
    //旧基準なので利用しないprivate double[] DJF台数 			= new double[CJF種類];//(CJF種類) As Double
    private double[] DJF台数H20		= new double[CJF種類];//(CJF種類) As Double
    private double[] DJF排煙台数H20	= new double[CJF種類];//(CJF種類) As Double
    private String S選定交通量;// As String 設計時間交通量or設計交通容量
    //変数
    private int I供用年度;// As Integer
    private double[] D自然換気量 = new double[C対面+1];//(C対面) As Double
    //プログラム開始
    public void S01換気量計算条件設定_入力(
        String LS交通方式,//  "対面通行";	//List1.Text    '"対面通行"
        String LS道路区分,//= "第3種";		//List2.Text    '"第3種"f
        String LS道路地域,//= "地方部";	//List3.Text    '"地方部"
        String LS道路地形,//= "平地部";	//List4.Text    '"平地部"
        String LS沿道状況,//= "市街化していない地域";//List5.Text    '"市街化していない地域"
        String LD車線幅員,// 3.5;			//Text1.Text    '3.5
        String LD側方余裕,//= 0.75;		//Text2.Text    '0.75
        String LD道路勾配,//= 2.078;		//Text3.Text    '2.078
        String LD大型車混入率,//=0.12;		//Text4.Text    '0.12
        String LD計画交通量,//= 23191;		//Text5.Text  '23191
        String LS選定交通量, //="設計交通容"
        String LD設計速度,//= 70;			//Combo1.Text   '70
        String LI区間屈曲数,//=4;		//Combo2.Text
        String LD区間延長0,//=100; 	//Text6.Text
        String LD区間延長1,//=100; 	//Text6.Text
        String LD区間延長2,//=100; 	//Text6.Text
        String LD区間延長3,//=100; 	//Text6.Text
        String LD区間延長4,//=100; 	//Text6.Text
        String LD区間勾配0,//=1.0; 	//Text7.Text
        String LD区間勾配1,//=1.0; 	//Text7.Text
        String LD区間勾配2,//=1.0; 	//Text7.Text
        String LD区間勾配3,//=1.0; 	//Text7.Text
        String LD区間勾配4,//=1.0; 	//Text7.Text
        String LDトンネル標高,//= 200;//Text22.Text
        String LDトンネル断面,//= 57;	//Text21.Text
        String LD代表寸法,//=7.2; 	//Text23.Text
        String LI供用年度//Combo3.Text   '20
        ){
        /*目的 変数設定
          '日付 030513
          '追加 080706 H20基準反映 供用年度
         * java20181102
         Form01の画面のテキストボックスのデータを変数にセット
         ＜＜現状移植不要→必要＞＞計算を行うためには、初期値が必要となる。
        java20210203:初期値入力に作成
        ・入力値はすべて、テキストとする。
        ・このメソッドを公開することで、全ての計算を行う。
        '---------------------*/
        //変数定義 本来ならば、変数チェックを行うべき→計算クラスで行っている。
        S交通方式 =LS交通方式;//  "対面通行";	//List1.Text    '"対面通行"
        S道路区分 =LS道路区分;//"第3種";		//List2.Text    '"第3種"f
        S道路地域 =LS道路地域;//"地方部";	//List3.Text    '"地方部"
        S道路地形 =LS道路地形;//"平地部";	//List4.Text    '"平地部"
        S沿道状況 =LS沿道状況;//"市街化していない地域";//List5.Text    '"市街化していない地域"
        D車線幅員 =Double.parseDouble(LD車線幅員);//3.5;			//Text1.Text    '3.5
        D側方余裕 =Double.parseDouble(LD側方余裕);//0.75;		//Text2.Text    '0.75
        D道路勾配 =Double.parseDouble(LD道路勾配);//2.078;		//Text3.Text    '2.078
        D大型車混入率 =Double.parseDouble(LD大型車混入率);//0.12;		//Text4.Text    '0.12
        D計画交通量 =Double.parseDouble(LD計画交通量); //23191;		//Text5.Text  '23191
        S選定交通量 =LS選定交通量; //20210820追記
        D設計速度 =Double.parseDouble(LD設計速度); //70;			//Combo1.Text   '70
        //'勾配補正H
        I区間屈曲数 =Integer.parseInt(LI区間屈曲数);//4;		//Combo2.Text
        D区間延長[0] = Double.parseDouble(LD区間延長0);//100; 	//Text6.Text
        D区間延長[1] = Double.parseDouble(LD区間延長1);//200; 	//Text8.Text
        D区間延長[2] = Double.parseDouble(LD区間延長2);//300; 	//Text10.Text
        D区間延長[3] = Double.parseDouble(LD区間延長3);//400; 	//Text12.Text
        D区間延長[4] = Double.parseDouble(LD区間延長4);//500; 	//Text14.Text
        D区間勾配[0] = Double.parseDouble(LD区間勾配0);//1.0; 	//Text7.Text
        D区間勾配[1] = Double.parseDouble(LD区間勾配1);//1.1; 	//Text9.Text
        D区間勾配[2] = Double.parseDouble(LD区間勾配2);//1.2; 	//Text11.Text
        D区間勾配[3] = Double.parseDouble(LD区間勾配3);//1.3; 	//Text13.Text
        D区間勾配[4] = Double.parseDouble(LD区間勾配4);//1.4; 	//Text15.Text
        Dトンネル延長 =0;
        int i;
        for( i = 0 ; i <= I区間屈曲数 ;i++){//Dトンネル延長
            Dトンネル延長 = Dトンネル延長 + D区間延長[i];
        }//for
        //'煤煙換気量
        Dトンネル標高 =Double.parseDouble(LDトンネル標高);//200;//Text22.Text
        Dトンネル断面 =Double.parseDouble(LDトンネル断面);//57;	//Text21.Text
        //'JF台数
        D代表寸法 =Double.parseDouble(LD代表寸法);//7.2; 	//Text23.Text
        //'供用年度:080706追加
        I供用年度 =Integer.parseInt(LI供用年度);//20; 		//Combo3.Text   '20
        S02計算実行();
    }//End Sub S01換気量計算条件設定_入力()
    public void S01換気量計算条件設定_入力_交通量(
        String LS交通方式,//  "対面通行";	//List1.Text    '"対面通行"
        String LS道路区分,//= "第3種";		//List2.Text    '"第3種"f
        String LS道路地域,//= "地方部";	//List3.Text    '"地方部"
        String LS道路地形,//= "平地部";	//List4.Text    '"平地部"
        String LS沿道状況,//= "市街化していない地域";//List5.Text    '"市街化していない地域"
        String LD車線幅員,// 3.5;			//Text1.Text    '3.5
        String LD側方余裕,//= 0.75;		//Text2.Text    '0.75
        String LD道路勾配,//= 2.078;		//Text3.Text    '2.078
        String LD大型車混入率,//=0.12;		//Text4.Text    '0.12
        String LD計画交通量//= 23191;		//Text5.Text  '23191
        ){
        /*目的 変数設定
          '日付 030513
          '追加 080706 H20基準反映 供用年度
         * java20181102
         Form01の画面のテキストボックスのデータを変数にセット
         ＜＜現状移植不要→必要＞＞計算を行うためには、初期値が必要となる。
        java20210203:初期値入力に作成
        ・入力値はすべて、テキストとする。
        ・このメソッドを公開することで、全ての計算を行う。
        '---------------------*/
        //数定義 本来ならば、変数チェックを行うべき→計算クラスで行っている。
        S交通方式 =LS交通方式;//  "対面通行";	//List1.Text    '"対面通行"
        S道路区分 =LS道路区分;//"第3種";		//List2.Text    '"第3種"f
        S道路地域 =LS道路地域;//"地方部";	//List3.Text    '"地方部"
        S道路地形 =LS道路地形;//"平地部";	//List4.Text    '"平地部"
        S沿道状況 =LS沿道状況;//"市街化していない地域";//List5.Text    '"市街化していない地域"
        D車線幅員 =Double.parseDouble(LD車線幅員);//3.5;			//Text1.Text    '3.5
        D側方余裕 =Double.parseDouble(LD側方余裕);//0.75;		//Text2.Text    '0.75
        D道路勾配 =Double.parseDouble(LD道路勾配);//2.078;		//Text3.Text    '2.078
        D大型車混入率 =Double.parseDouble(LD大型車混入率);//0.12;		//Text4.Text    '0.12
        D計画交通量 =Double.parseDouble(LD計画交通量); //23191;		//Text5.Text  '23191
        S02計算実行_交通量();
    }//End Sub S01換気量計算条件設定_入力_交通量()
    public void S01換気量計算条件設定_入力_トンネル延長(
        String LI区間屈曲数,//=4;		//Combo2.Text
        String LD区間延長0,//=100; 	//Text6.Text
        String LD区間延長1,//=100; 	//Text6.Text
        String LD区間延長2,//=100; 	//Text6.Text
        String LD区間延長3,//=100; 	//Text6.Text
        String LD区間延長4//,//=100; 	//Text6.Text
        ){
        /*目的 変数設定
          '日付 030513
          '追加 080706 H20基準反映 供用年度
         * java20181102
         Form01の画面のテキストボックスのデータを変数にセット
         ＜＜現状移植不要→必要＞＞計算を行うためには、初期値が必要となる。
        java20210203:初期値入力に作成
        ・入力値はすべて、テキストとする。
        ・このメソッドを公開することで、全ての計算を行う。
        '---------------------*/
        I区間屈曲数 =Integer.parseInt(LI区間屈曲数);//4;		//Combo2.Text
        D区間延長[0] = Double.parseDouble(LD区間延長0);//100; 	//Text6.Text
        D区間延長[1] = Double.parseDouble(LD区間延長1);//200; 	//Text8.Text
        D区間延長[2] = Double.parseDouble(LD区間延長2);//300; 	//Text10.Text
        D区間延長[3] = Double.parseDouble(LD区間延長3);//400; 	//Text12.Text
        D区間延長[4] = Double.parseDouble(LD区間延長4);//500; 	//Text14.Text
        Dトンネル延長 =0;
        int i;
        for( i = 0 ; i <= I区間屈曲数 ;i++){//Dトンネル延長
            Dトンネル延長 = Dトンネル延長 + D区間延長[i];
        }//for
    }//End Sub S01換気量計算条件設定_入力_トンネル延長()
    private void S02計算実行(){
        S03交通量計算();
        db.debugPrint("Form01:C設計交通容量="+ C設計交通容量 +"→ 0:設計交通容量 or 1:設計時間交通量");
        //form.S04換気量計算(form.C設計交通容量);この計算は、新基準H20で必要なくなりました。
        S04換気量計算H20(C設計交通容量);
        S04換気量計算H20(C設計時間交通量);
        S05JF変数設定();
        S06JF台数H20();
        S07自然対面換気H20();
        S07自然一方換気H20();
        S08排煙H20();
    }//S02計算実行
    private void S02計算実行_交通量(){
        S03交通量計算();
        db.debugPrint("Form01:C設計交通容量="+ C設計交通容量 +"→ 0:設計交通容量 or 1:設計時間交通量");
    }//S02計算実行_交通量
    private void S03交通量計算(){//Private Sub S03交通量計算()
        A交通.S00変数設定(	
                S交通方式,// _
                S道路区分,// _
                S道路地域,// _
                S道路地形,// _
                S沿道状況,// _
                D車線幅員,// _
                D側方余裕,// _
                D道路勾配,// _
                D大型車混入率,// _
                D計画交通量);
        D可能交通容量_乗用車 = A交通.A01可能交通容量_乗用車();
        db.debugPrint("Form01:S03交通量計算：D可能交通容量_乗用車:" + D可能交通容量_乗用車 );
        D設計交通量_乗用車[C設計交通容量] = A交通.F05設計交通容量_乗用車();
        db.debugPrint("Form01:S03交通量計算：設計交通容量:"+ D設計交通量_乗用車[C設計交通容量]);
        D設計交通量_乗用車[C設計時間交通量] = A交通.F08設計時間交通量_乗用車();
        db.debugPrint("Form01:S03交通量計算：設計時間交通量:"+ D設計交通量_乗用車[C設計時間交通量]);
        D設計交通量[C設計交通容量] = A交通.F05設計交通容量();
        db.debugPrint("Form01:S03交通量計算：設計交通容量:"+ D設計交通量[C設計交通容量]);
        D設計交通量[C設計時間交通量] = A交通.F08設計時間交通量();
        db.debugPrint("Form01:S03交通量計算：設計時間交通量:"+ D設計交通量[C設計時間交通量]);
        /*目的 変数設定
         *'日付 030513 
         * java
         *'---------------------*/
    }//S03交通量計算
    private void S04換気量計算H20(int sI交通量){
        //'変数宣言
        double[][] nD区間勾配補正S = new double[C上下線][C屈曲];// As Double
        double[][] nD区間勾配補正L = new double[C上下線][C屈曲];//(C上下線, C屈曲) As Double
        double nD速度補正係数S;
        double nD速度補正係数L;// As Double
        int i;// As Integer
        int ii;// As Integer
        //'走行速度計算
        A速度.A00変数設定(
                D可能交通容量_乗用車, 
                D設計交通量_乗用車[sI交通量], 
                D設計速度);
        D走行速度[sI交通量] = A速度.F01走行速度();
        //'速度勾配補正計算
        A縦断H20.A00変数設定(
                S交通方式, 
                I区間屈曲数, 
                D区間延長, //[]20200209配列の参照渡しなので、[]がいらない？ 
                D区間勾配, //[]
                D走行速度[sI交通量], 
                I供用年度 );
        //'勾配補正小型車
        A縦断H20.A01勾配補正係数S( nD区間勾配補正S );
        //'勾配補正大型車
        A縦断H20.A01勾配補正係数L( nD区間勾配補正L );
        //'速度補正
        nD速度補正係数S = A縦断H20.A02速度補正係数S();
        nD速度補正係数L = A縦断H20.A02速度補正係数L();
        //計算結果確認
        db.debugPrint("Form01:H20;nD速度補正係数S =" + nD速度補正係数S );
        db.debugPrint("Form01:H20;nD速度補正係数L =" + nD速度補正係数L );
        //'煤煙換気量計算
        A換気H20.A00変数設定(
                D設計交通量[sI交通量],
                D大型車混入率,
                D走行速度[sI交通量],
                Dトンネル断面,
                D区間延長, //配列変数の参照渡しなので()がいらない
                Dトンネル標高,
                I供用年度,
                nD区間勾配補正S,//配列変数の参照渡しなので()がいらない
                nD区間勾配補正L,//配列変数の参照渡しなので()がいらない
                nD速度補正係数S,
                nD速度補正係数L,
                S交通方式
                );//A換気H20.A00変数設定
        D煤煙換気量H20[sI交通量] = A換気H20.A01換気量_煤煙();
        db.debugPrint( "Form01;S04換気量計算H20;D煤煙換気量H20[sI交通量]=" + D煤煙換気量H20[sI交通量] );
        //End Sub*/
        /*目的 S04換気量計算H20'---------------------
          '日付 080706
          '---------------------
          Private Sub S04換気量計算H20( _
          sI交通量 As Integer)
          '変数宣言
          Dim nD区間勾配補正S(C上下線, C屈曲) As Double
          Dim nD区間勾配補正L(C上下線, C屈曲) As Double
          Dim nD速度補正係数S As Double
          Dim nD速度補正係数L As Double
          Dim i As Integer
          Dim ii As Integer
          '走行速度計算
          A速度.A00変数設定 _
          D可能交通容量_乗用車, _
          D設計交通量_乗用車(sI交通量), _
          D設計速度
          D走行速度(sI交通量) = _
          A速度.F01走行速度
          '速度勾配補正計算
          A縦断H20.A00変数設定 _
          S交通方式, _
          I区間屈曲数, _
          D区間延長(), _
          D区間勾配(), _
          D走行速度(sI交通量), _
          I供用年度
          '勾配補正小型車
          A縦断H20.A01勾配補正係数S _
          nD区間勾配補正S()
          '勾配補正大型車
          A縦断H20.A01勾配補正係数L _
          nD区間勾配補正L()
          '速度補正
          nD速度補正係数S = _
          A縦断H20.A02速度補正係数S
          nD速度補正係数L = _
          A縦断H20.A02速度補正係数L
          '煤煙換気量計算
          A換気H20.A00変数設定 _
          D設計交通量(sI交通量), _
          D大型車混入率, _
          D走行速度(sI交通量), _
          Dトンネル断面, _
          D区間延長(), _
          Dトンネル標高, _
          I供用年度, _
          nD区間勾配補正S(), _
          nD区間勾配補正L(), _
          nD速度補正係数S, _
          nD速度補正係数L, _
          S交通方式
          D煤煙換気量H20(sI交通量) _
          = A換気H20.A01換気量_煤煙
          End Sub*/
    }//S04換気量計算H20
    private void S05JF変数設定(){
        //D代表寸法 = Text23.Text
        db.debugPrint( "Form01;S05JF変数設定;D代表寸法=" + D代表寸法 );
        //D設計交通量(C設計交通容量) = Text16.Text
        db.debugPrint( "Form01;S05JF変数設定;D設計交通量[C設計交通容量]=" + D設計交通量[C設計交通容量]);
        //D設計交通量(C設計時間交通量) = Text17.Text
        db.debugPrint( "Form01;S05JF変数設定;D設計交通量[C設計時間交通量]=" + D設計交通量[C設計時間交通量]);
        //D煤煙換気量(C設計交通容量) = Text18.Text
        //	db.debugPrint( "Form01;S05JF変数設定;D煤煙換気量[C設計交通容量]=" + D煤煙換気量[C設計交通容量]);
        //D煤煙換気量(C設計時間交通量) = Text19.Text
        //	db.debugPrint( "Form01;S05JF変数設定;D煤煙換気量[C設計時間交通量]=" + D煤煙換気量[C設計時間交通量]);
        //'追加
        //D煤煙換気量H20(C設計交通容量) = Text28.Text
        db.debugPrint( "Form01;S05JF変数設定;D煤煙換気量H20[C設計交通容量]=" + D煤煙換気量H20[C設計交通容量]);
        //D煤煙換気量H20(C設計時間交通量) = Text27.Text
        db.debugPrint( "Form01;S05JF変数設定;D煤煙換気量H20[C設計時間交通量]=" + D煤煙換気量H20[C設計時間交通量]);
        //S選定交通量 = "設計時間交通量";
        db.debugPrint( "Form01;S05JF変数設定;S選定交通量=" + S選定交通量);
        //End Sub*/
        /*S05JF変数設定
          '---------------------
          '目的 JF変数設定
          '日付 030513
          '---------------------
          Private Sub S05JF変数設定()
          D代表寸法 = Text23.Text
          D設計交通量(C設計交通容量) = Text16.Text
          D設計交通量(C設計時間交通量) = Text17.Text
          D煤煙換気量(C設計交通容量) = Text18.Text
          D煤煙換気量(C設計時間交通量) = Text19.Text
          '追加
          D煤煙換気量H20(C設計交通容量) = Text28.Text
          D煤煙換気量H20(C設計時間交通量) = Text27.Text
          End Sub*/
    }//S05JF変数設定
    private void S06JF台数H20(){
        int i;//Dim  As Integer
        //Dim sS選定交通量 As String
        //sS選定交通量 = List6.Text
        //Select Case sS選定交通量
        switch( S選定交通量 ){ 
            case "設計交通容量":
                AJFH20.A00変数設定(
                        D設計交通量[C設計交通容量],
                        D大型車混入率,
                        Dトンネル延長,
                        Dトンネル断面,
                        D代表寸法,
                        D煤煙換気量H20[C設計交通容量],
                        D走行速度[C設計交通容量],
                        S交通方式);
                AJFH20.A01JF台数( DJF台数H20 );
                break;
            case "設計時間交通量":
                AJFH20.A00変数設定(
                        D設計交通量[C設計時間交通量],
                        D大型車混入率,
                        Dトンネル延長,
                        Dトンネル断面,
                        D代表寸法,
                        D煤煙換気量H20[C設計時間交通量],
                        D走行速度[C設計時間交通量],
                        S交通方式);
                AJFH20.A01JF台数( DJF台数H20 );
                break;
                //Case Else
            default:
                db.debugError("error:form1：S06JF台数H20：S選定交通量=" + S選定交通量);
                //MsgBox "選定交通量が不明です"
        }//switch End Select
        /*S06JF台数H20
          '---------------------
          '目的 JF台数H20
          '日付 080708
          '---------------------
          Private Sub S06JF台数H20()
          Dim i As Integer
          Dim sS選定交通量 As String
          sS選定交通量 = List6.Text
          Select Case sS選定交通量
          Case "設計交通容量"
          AJFH20.A00変数設定 _
          D設計交通量(C設計交通容量), _
          D大型車混入率, _
          A縦断.A02トンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          Round(D煤煙換気量H20(C設計交通容量), 0), _
          D走行速度(C設計交通容量), _
          S交通方式
          AJFH20.A01JF台数 _
          DJF台数H20()
          Case "設計時間交通量"
          AJFH20.A00変数設定 _
          D設計交通量(C設計時間交通量), _
          D大型車混入率, _
          A縦断.A02トンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          Round(D煤煙換気量H20(C設計時間交通量), 0), _
          D走行速度(C設計時間交通量), _
          S交通方式
          AJFH20.A01JF台数 _
          DJF台数H20()
          Case Else
          MsgBox "選定交通量が不明です"
          End Select
          For i = 0 To CJF種類
          Text20(i).Text = DJF台数(i)
          Text25(i).Text = DJF台数H20(i)
          '    Debug.Print "jf台数"; DJF台数H20(i)
          Next
          End Sub*/
    }//S06JF台数H20
    private void S07自然対面換気H20(){
        double sD所要換気量;//Dim  As Double
        //Dim sS選定交通量  As String
        //'計算初期値の入力
        //sS選定交通量 = List6.Text
        //Select Case sS選定交通量
        switch( S選定交通量 ){ 
            case "設計交通容量":
                A自然対面H20.A00変数設定(
                        Dトンネル延長,
                        Dトンネル断面,
                        D代表寸法,
                        D設計交通量[C設計交通容量],
                        D大型車混入率,
                        D走行速度[C設計交通容量]);
                break;
            case "設計時間交通量":
                A自然対面H20.A00変数設定(
                        Dトンネル延長,
                        Dトンネル断面,
                        D代表寸法,
                        D設計交通量[C設計時間交通量],
                        D大型車混入率,
                        D走行速度[C設計時間交通量]);
                break;
            default:// Case Else
                db.debugError("error:form1：S07自然対面換気H20：S選定交通量=" + S選定交通量);
                //MsgBox "計算出来ないな"
        }//S07自然対面換気H20 End Select
        //'計算結果の反映
        D自然換気量[C対面] = A自然対面H20.A01自然換気量();
        db.debugPrint("Form01:S07自然対面換気H20:D自然換気量[C対面]=" + D自然換気量[C対面]);
        //'画面の操作
        //Select Case List6.Text
        sD所要換気量 = 0.0;//20200308エラー初期化されていない可能性
        db.debugPrint("form01:S07自然対面換気H20:S選定交通量=" + S選定交通量);
        switch( S選定交通量 ){ 
            case "設計交通容量":
                //Text26.Text = D煤煙換気量H20(C設計交通容量)
                sD所要換気量 = D煤煙換気量H20[C設計交通容量];
                break;
            case "設計時間交通量":
                //Text26.Text = D煤煙換気量H20(C設計時間交通量)
                sD所要換気量 = D煤煙換気量H20[C設計時間交通量];
                break;
            default://Case Else
                db.debugError("error:form1：S07自然対面換気H20:default:S選定交通量=" + S選定交通量);
                //MsgBox "計算出来ないな"
        }//switch End Select
        //Text29.Text = D自然換気量(C対面)
        if(sD所要換気量 < D自然換気量[C対面]){// Then
            db.debugPrint("Form01:自然換気 可能");
            db.debugPrint(" ");
            //Label19.Caption = "自然換気 可能"
        }//if
        else{ //Else
            db.debugPrint("Form01:自然換気 不可能");
            db.debugPrint(" ");
            //Label19.Caption = "自然換気 不可能"
        }//else End If
        //End Sub
        /*S07自然対面換気H20
          '---------------------
          '目的 自然換気計算（対面）
          '日付 080708
          '---------------------
          Private Sub S07自然対面換気H20()
          Dim sS選定交通量 As String
          Dim sD所要換気量 As Double
          '計算初期値の入力
          sS選定交通量 = List6.Text
          Select Case sS選定交通量
          Case "設計交通容量"
          A自然対面H20.A00変数設定 _
          Dトンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          D設計交通量(C設計交通容量), _
          D大型車混入率, _
          D走行速度(C設計交通容量)
          Case "設計時間交通量"
          A自然対面H20.A00変数設定 _
          Dトンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          D設計交通量(C設計時間交通量), _
          D大型車混入率, _
          D走行速度(C設計時間交通量)
          Case Else
          MsgBox "計算出来ないな"
          End Select
          '計算結果の反映
          D自然換気量(C対面) = _
          A自然対面H20.A01自然換気量
          '画面の操作
          Select Case List6.Text
          Case "設計交通容量"
          Text26.Text = D煤煙換気量H20(C設計交通容量)
          sD所要換気量 = D煤煙換気量H20(C設計交通容量)
          Case "設計時間交通量"
          Text26.Text = D煤煙換気量H20(C設計時間交通量)
          sD所要換気量 = D煤煙換気量H20(C設計時間交通量)
          Case Else
          MsgBox "計算出来ないな"
          End Select
          Text29.Text = D自然換気量(C対面)
          If sD所要換気量 < D自然換気量(C対面) Then
          Label19.Caption = "自然換気 可能"
          Else
          Label19.Caption = "自然換気 不可能"
          End If
          End Sub*/
    }//S07自然対面換気H20
    private void S07自然一方換気H20(){
        //String sS選定交通量; As String
        double sD所要換気量;//Dim  As Double
        //'計算初期値の入力
        //sS選定交通量 = List6.Text
        //Select Case sS選定交通量
        switch(S選定交通量){
            case "設計交通容量":
                A自然一方H20.A00変数設定(
                        Dトンネル延長,
                        Dトンネル断面,
                        D代表寸法,
                        D設計交通量[C設計交通容量],
                        D大型車混入率,
                        D走行速度[C設計交通容量]);
                break;
            case "設計時間交通量":
                A自然一方H20.A00変数設定(
                        Dトンネル延長,
                        Dトンネル断面,
                        D代表寸法,
                        D設計交通量[C設計時間交通量], 
                        D大型車混入率, 
                        D走行速度[C設計時間交通量]);
                break;
            default:// Case Else
                db.debugError("error:form1：S07自然一方換気H20：S選定交通量=" + S選定交通量);
                //MsgBox "計算出来ないな"
        }//switch End Select
        /*S07自然一方換気H20
          '---------------------
          '目的 自然換気計算（一方）
          '日付 080709
          '---------------------
          Private Sub S07自然一方換気H20()
          Dim sS選定交通量 As String
          Dim sD所要換気量 As Double
          '計算初期値の入力
          sS選定交通量 = List6.Text
          Select Case sS選定交通量
          Case "設計交通容量"
          A自然一方H20.A00変数設定 _
          Dトンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          D設計交通量(C設計交通容量), _
          D大型車混入率, _
          D走行速度(C設計交通容量)
          Case "設計時間交通量"
          A自然一方H20.A00変数設定 _
          Dトンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          D設計交通量(C設計時間交通量), _
          D大型車混入率, _
          D走行速度(C設計時間交通量)
          Case Else
          MsgBox "計算出来ないな"
          End Select

          '計算結果の反映
          D自然換気量(C一方) = _
          A自然一方H20.A01自然換気量
          '画面の操作
          Select Case List6.Text
          Case "設計交通容量"
          Text31.Text = D煤煙換気量H20(C設計交通容量)
          sD所要換気量 = D煤煙換気量H20(C設計交通容量)
          Case "設計時間交通量"
          Text31.Text = D煤煙換気量H20(C設計時間交通量)
          sD所要換気量 = D煤煙換気量H20(C設計時間交通量)
          Case Else
          MsgBox "計算出来ないな"
          End Select
          Text30.Text = D自然換気量(C一方)
          If sD所要換気量 < D自然換気量(C一方) Then
          Label25.Caption = "自然換気 可能"
          Else
          Label25.Caption = "自然換気 不可能"
          End If
          End Sub
         */
    }//S07自然一方換気H20
    private void S08排煙H20(){ 
        int i;//Dim  As Integer
        //Dim sS選定交通量 As String
        //sS選定交通量 = List6.Text
        switch ( S選定交通量 ){
            case "設計交通容量":
                A排煙H20.A00変数設定(
                        D設計交通量[C設計交通容量],
                        D大型車混入率,
                        Dトンネル延長,
                        Dトンネル断面, 
                        D代表寸法, 
                        D走行速度[C設計交通容量], 
                        S交通方式);
                A排煙H20.A01JF台数(DJF排煙台数H20);
                break;
            case "設計時間交通量":
                A排煙H20.A00変数設定(
                        D設計交通量[C設計時間交通量], 
                        D大型車混入率, 
                        Dトンネル延長, 
                        Dトンネル断面, 
                        D代表寸法, 
                        D走行速度[C設計時間交通量], 
                        S交通方式);
                A排煙H20.A01JF台数(DJF排煙台数H20);
                break;
            default:
                db.debugError("error:form1：S08排煙H20：S選定交通量=" + S選定交通量);
                //MsgBox "選定交通量が不明です"
        }//switch End Select
        for( i = 0 ; i < CJF種類 ; i++ ){
            db.debugPrint("Form01:S08排煙H20:DJF排煙台数H20[i:" + i + "]=" +DJF排煙台数H20[i] );
            //DJF排煙台数H20[i];//Text32(i).Text =
            //Debug.Print "jf台数"; DJF台数H20(i)
        }//for Next
        db.debugPrint("" );
        //end Sub
        /*S08排煙H20
          '---------------------
          '目的 排煙用JF台数
          '日付 080709
          '---------------------
          Private Sub S08排煙H20()
          Dim i As Integer
          Dim sS選定交通量 As String
          sS選定交通量 = List6.Text
          Select Case sS選定交通量
          Case "設計交通容量"
          A排煙H20.A00変数設定 _
          D設計交通量(C設計交通容量), _
          D大型車混入率, _
          A縦断.A02トンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          D走行速度(C設計交通容量), _
          S交通方式
          A排煙H20.A01JF台数 _
          DJF排煙台数H20()
          Case "設計時間交通量"
          A排煙H20.A00変数設定 _
          D設計交通量(C設計時間交通量), _
          D大型車混入率, _
          A縦断.A02トンネル延長, _
          Dトンネル断面, _
          D代表寸法, _
          D走行速度(C設計時間交通量), _
          S交通方式
          A排煙H20.A01JF台数 _
          DJF排煙台数H20()
          Case Else
          MsgBox "選定交通量が不明です"
          End Select
          For i = 0 To CJF種類
          Text32(i).Text = DJF排煙台数H20(i)
          '   Debug.Print "jf台数"; DJF台数H20(i)
          Next
          end Sub */
    }//S08排煙H20
    public String S09str設計交通容量(){
        return String.valueOf((int)D設計交通量[C設計交通容量]);
    }
    public String S10str設計時間交通量(){
        return String.valueOf((int)D設計交通量[C設計時間交通量]);
    }
    public String S11str煤煙換気量_設計交通容量(){
        return String.valueOf(D煤煙換気量H20[C設計交通容量]);
    }
    public String S12str煤煙換気量_設計時間交通量(){
        return String.valueOf(D煤煙換気量H20[C設計時間交通量]);
    }
    public String S13str自然換気量_対面通行(){
        S07自然対面換気H20(); 
        return String.valueOf(A自然対面H20.A01自然換気量());
    }
    public String S14str自然換気量_一方通行(){
        S07自然一方換気H20(); 
        return String.valueOf(A自然一方H20.A01自然換気量());
    }
    public void S15JF台数( String[] strJF台数){
        int i,intJF種類;
        intJF種類 = AJFH20.A03intJF種類();
        double[] JF台数= new double[intJF種類];
        AJFH20.A02JF台数( JF台数 );
        for( i = 0 ; i < intJF種類 ; i++){
            strJF台数[i] = String.valueOf( JF台数[i] );
        }
    }
    public void S15JF台数ceil( String[] strJF台数){
        int i,intJF種類;
        intJF種類 = AJFH20.A03intJF種類();
        double[] JF台数= new double[intJF種類];
        AJFH20.A02JF台数( JF台数 );
        for( i = 0 ; i < intJF種類 ; i++){
            if( JF台数[i] > 0 ){
                strJF台数[i] = String.valueOf( (int) Math.ceil(JF台数[i]) );
            }
            else{
                strJF台数[i] = "0";
            }
        }
    }
    public int S16JF種類(){
        return AJFH20.A03intJF種類();
    }
    public String S17strトンネル延長(){
        return String.valueOf(Dトンネル延長);
    }
    public void S18排煙JF台数( String[] strJF台数){
        int i,intJF種類;
        intJF種類 =  A排煙H20.A02intJF種類();
        double[] JF台数= new double[intJF種類];
        A排煙H20.A01JF台数( JF台数 );
        for( i = 0 ; i < intJF種類 ; i++){
            strJF台数[i] = String.valueOf( JF台数[i] );
        }
    }
    public void S18排煙JF台数ceil( String[] strJF台数){
        int i,intJF種類;
        intJF種類 =  A排煙H20.A02intJF種類();
        double[] JF台数= new double[intJF種類];
        A排煙H20.A01JF台数( JF台数 );
        for( i = 0 ; i < intJF種類 ; i++){
            strJF台数[i] = String.valueOf( (int) Math.ceil(JF台数[i]));
        }
    }
    public int S19排煙JF種類(){
        return A排煙H20.A02intJF種類();
    }
}//Form01 class
