package com.example.yo.myapp20180829kanki2;

public class A07JFH20Class{
	//クラスの定義
	DebugPrint db = new DebugPrint();
	//'定数
	final double Cトンネル入口損失係数 = 0.6d;//Const 
	final double Cトンネル壁面摩擦係数 = 0.025d;//Const 
	final double C空気密度 = 1.2d;//Const 
	final double C自然換気風速 = 2.5d;//Const 
	final int CJF種類 = 6 +1 ;//Const 20200303配列変数の用意する個数なので、+1 
	private double[] GDJF断面 = new double[CJF種類];// As Double
	private double[] GDJF風速 = new double[CJF種類];// As Double
	//'入力変数
	private double GD設計交通量;// As Double
	private double GD大型車混入率;// As Double
	private double GDトンネル延長;// As Double
	private double GDトンネル断面;// As Double
	private double GD代表寸法;// As Double
	private double GD所要換気量;// As Double
	private double GD走行速度;// As Double
	private String GS交通方式;// As String
	//'計算変数
	private double GD交通量比;// As Double
	private double GD車道内風速;// As Double
	private double GD通気抵抗;// As Double
	private double GD自然換気力;// As Double
	private double GD交通換気力;// As Double
	private double GD自動車等価抵抗面積;// As Double
	private double GD自動車存在台数;// As Double
	private double[] GDJF昇圧力 = new double[CJF種類];// As Double
	private double[] GD断面積比 = new double[CJF種類];// As Double
	private double[] GD風速比 = new double[CJF種類];// As Double
	private double[] GDJF台数 = new double[CJF種類];// As Double
	private void S00GDJF断面設定(){
		//'------------------------------------
		//'目的 初期値
		//'日付 030512
		//'------------------------------------
		//Private Sub Class_Initialize()
		//'ジェットファン断面積定義
		GDJF断面[0] = 0.27d;
		GDJF断面[1] = 0.83d;
		GDJF断面[2] = 1.23d;
		GDJF断面[3] = 1.84d;
		GDJF断面[4] = 0.27d;
		GDJF断面[5] = 0.83d;
		GDJF断面[6] = 1.23d;
		//'ジェットファン風速定義
		GDJF風速[0] = 30d;
		GDJF風速[1] = 30d;
		GDJF風速[2] = 30d;
		GDJF風速[3] = 30d;
		GDJF風速[4] = 35d;
		GDJF風速[5] = 35d;
		GDJF風速[6] = 35d;
		//End Sub
	}//static
	public void A00変数設定(	//初期値入力
		double D設計交通量,// As Double _
		double D大型車混入率,// As Double _
		double Dトンネル延長,// As Double _
		double Dトンネル断面,// As Double _
		double D代表寸法,// As Double _
		double D所要換気量,
		double D走行速度,
		String S交通方式)
		{//A00変数設定 			//実行
		int i;//Dim  As Integer
		S00GDJF断面設定();
		//Select Case D設計交通量
	    if( D設計交通量 <= 0.0){ //Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：D設計交通量=" + D設計交通量);
	      //MsgBox "ＪＦ；変数設定；設計交通量=" & D設計交通量
		}//if
	    else if( D設計交通量 < 4400.0 ){//Case Is
		}//else if
	    else{//Case Else
			db.debugError("error:A07JFH20Class：A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "ＪＦ；変数設定；設計交通量=" & D設計交通量
		}//else End Select
		//Select Case D大型車混入率
	    if( D大型車混入率 < 0.0 ){//Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "ＪＦ；変数設定；大型車混入率=" & D大型車混入率
		}//if
	    else if( D大型車混入率 < 1.0){//Case Is 
		}//else if
	    else{//Case Else
			db.debugError("error:A07JFH20Class：A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "ＪＦ；変数設定；大型車混入率=" & D大型車混入率
		}//else End Select
		//Select Case Dトンネル断面
	    if( Dトンネル断面 < 0.0 ){//Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：Dトンネル断面=" + Dトンネル断面);
			//MsgBox "ＪＦ；変数設定；トンネル断面=" & Dトンネル断面
		}//if
	    else if( Dトンネル断面 < 100.0 ){ //Case Is 
		}//else if 
	    else{ //Case Else
			db.debugError("error:A07JFH20Class：A00変数設定：Dトンネル断面=" + Dトンネル断面);
			//MsgBox "ＪＦ；変数設定；トンネル断面=" & Dトンネル断面
		}//else End Select
		//Select Case Dトンネル延長
	    if(Dトンネル延長 < 5.0){//Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "ＪＦ；変数設定；トンネル延長=" & Dトンネル延長
	    }//if
	    else if(Dトンネル延長 < 50000.0){//Case Is
		}//else if
	    else{//Case Else
			db.debugError("error:A07JFH20Class：A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "ＪＦ；変数設定；トンネル延長=" & Dトンネル延長
		}//else End Select
		//Select Case D代表寸法
	    if(D代表寸法 < 0.0 ){//Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "ＪＦ；変数設定；代表寸法=" & D代表寸法
		}//if
		else if(D代表寸法 < 20.0 ){//Case Is
	    }//else Case Else
		else{
			db.debugError("error:A07JFH20Class：A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "ＪＦ；変数設定；代表寸法=" & D代表寸法
		}//End Select
		//Select Case D所要換気量
	    if(D所要換気量 < 0.0){//Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：D所要換気量=" + D所要換気量);
			//MsgBox "ＪＦ；変数設定；所要換気量=" & D所要換気量
	    }//if
	    else if(D所要換気量 < 800.0){//Case Is
		}//else
	    else{//Case Else
			db.debugError("error:A07JFH20Class：A00変数設定：D所要換気量=" + D所要換気量);
			//MsgBox "ＪＦ；変数設定；所要換気量=" & D所要換気量
		}//else End Select
		//'Debug.Print "走行速度km/s=" & D走行速度
		//Select Case D走行速度
	    if(D走行速度 < 0.0){//Case Is
			db.debugError("error:A07JFH20Class：A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "ＪＦ；変数設定；走行速度=" & D走行速度
	    }//if
	    else if(D走行速度 <= 120.0){//Case Is
	    }//
	    else{//Case Else
			db.debugError("error:A07JFH20Class：A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "ＪＦ；変数設定；走行速度=" & D走行速度
		}//else End Select
		//switch(S交通方式){// Select Case 
		if(	S交通方式.equals("一方通行") ){//case :
				GD交通量比 = 1.0;
		}//if break;
		else if( S交通方式.equals("対面通行") ){// case:
				GD交通量比 = 0.5;
		}//else
		else{//	default:// Case Else
				db.debugError("error:A07JFH20Class：A00変数設定：S交通方式=" + S交通方式);
				//MsgBox "ＪＦ；変数設定；交通方式=" S交通方式
		}//else switchEnd Select
		//'変数代入
		GD走行速度 = D走行速度 * 1000.0 / 60.0 / 60.0;
		GD設計交通量 = D設計交通量;
		GD大型車混入率 = D大型車混入率;
		GDトンネル断面 = Dトンネル断面;
		GDトンネル延長 = Dトンネル延長;
		GD代表寸法 = D代表寸法;
		GD所要換気量 = D所要換気量;
		GS交通方式 = S交通方式;
		//'計算実行
		S10JF台数();
		//''debug
		//*結果出力
		db.debugPrint( "<<<<< JF計算開始 >>>>>");
		db.debugPrint( "A07JFH20Class:入力変数");
		db.debugPrint( "A07JFH20Class:設計交通量  ="+ GD設計交通量);
		db.debugPrint( "A07JFH20Class:大型車混入率="+ GD大型車混入率);
		db.debugPrint( "A07JFH20Class:トンネル延長="+ GDトンネル延長);
		db.debugPrint( "A07JFH20Class:トンネル断面="+ GDトンネル断面);
		db.debugPrint( "A07JFH20Class:代表寸法    ="+ GD代表寸法);
		db.debugPrint( "A07JFH20Class:所要換気量  ="+ GD所要換気量);
		db.debugPrint( "A07JFH20Class:走行速度    ="+ GD走行速度);
		db.debugPrint( "A07JFH20Class:交通方式    ="+ GS交通方式);
		for( i = 0 ; i < CJF種類 ; i++){//For i = 0 To CJF種類
			db.debugPrint( "A07JFH20Class: GDJF断面[i:" + i +"]=" + GDJF断面[i]);
		}//for Next
		for( i = 0 ; i < CJF種類 ; i++){//For i = 0 To CJF種類
			db.debugPrint( "A07JFH20Class: GDJF風速[i:" + i +"]=" + GDJF風速[i]);
		}//for Next
		//計算変数
		db.debugPrint( "A07JFH20Class:計算結果");
		db.debugPrint( "A07JFH20Class:交通量比    ="+ GD交通量比);
		db.debugPrint( "A07JFH20Class:車道内風速  ="+ GD車道内風速);
		db.debugPrint( "A07JFH20Class:通気抵抗    ="+ GD通気抵抗);
		db.debugPrint( "A07JFH20Class:自然換気力  ="+ GD自然換気力);
		db.debugPrint( "A07JFH20Class:交通換気力  ="+ GD交通換気力);
		db.debugPrint( "A07JFH20Class:自動車等価抵抗面積="+ GD自動車等価抵抗面積);
		db.debugPrint( "A07JFH20Class:自動車存在台数="+ GD自動車存在台数);
		for( i = 0 ; i < CJF種類 ; i++){//For i = 0 To CJF種類
			db.debugPrint( "A07JFH20Class:: GDJF昇圧力[i:" + i +"]=" + GDJF昇圧力[i]);
		}//for Next
		for( i = 0 ; i < CJF種類 ; i++){//For i = 0 To CJF種類
			db.debugPrint( "A07JFH20Class:: GD断面積比[i:" + i +"]=" + GD断面積比[i]);
		}//for Next
		for( i = 0 ; i < CJF種類 ; i++){//For i = 0 To CJF種類
			db.debugPrint( "A07JFH20Class:: GD風速比[i:" + i +"]=" + GD風速比[i]);
		}//for Next
		for( i = 0 ; i < CJF種類 ; i++){//For i = 0 To CJF種類
			db.debugPrint( "A07JFH20Class:: GDJF台数[i:" + i +"]=" + GDJF台数[i]);
		}//for Next
	//End Sub*/

	/*A00変数設定	
	'------------------------------------
	'目的 変数設定
	'日付 030512
	'------------------------------------
	Public Sub A00変数設定( _
	  D設計交通量 As Double, _
	  D大型車混入率 As Double, _
	  Dトンネル延長 As Double, _
	  Dトンネル断面 As Double, _
	  D代表寸法 As Double, _
	  D所要換気量, _
	  D走行速度, _
	  S交通方式)
	  Dim i As Integer
	  Select Case D設計交通量
	    Case Is <= 0
	      MsgBox "ＪＦ；変数設定；設計交通量=" & _
	        D設計交通量
	    Case Is < 4400
	    Case Else
	      MsgBox "ＪＦ；変数設定；設計交通量=" & _
	        D設計交通量
	  End Select
	  Select Case D大型車混入率
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；大型車混入率=" & _
	        D大型車混入率
	    Case Is < 1
	    Case Else
	      MsgBox "ＪＦ；変数設定；大型車混入率=" & _
	        D大型車混入率
	  End Select
	  Select Case Dトンネル断面
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；トンネル断面=" & _
	        Dトンネル断面
	    Case Is < 100
	    Case Else
	      MsgBox "ＪＦ；変数設定；トンネル断面=" & _
	        Dトンネル断面
	  End Select
	  Select Case Dトンネル延長
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；トンネル延長=" & _
	        Dトンネル延長
	    Case Is < 50000
	    Case Else
	      MsgBox "ＪＦ；変数設定；トンネル延長=" & _
	        Dトンネル延長
	  End Select
	  Select Case D代表寸法
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；代表寸法=" & _
	        D代表寸法
	    Case Is < 20
	    Case Else
	      MsgBox "ＪＦ；変数設定；代表寸法=" & _
	        D代表寸法
	  End Select
	  Select Case D所要換気量
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；所要換気量=" & _
	        D所要換気量
	    Case Is < 800
	    Case Else
	      MsgBox "ＪＦ；変数設定；所要換気量=" & _
	        D所要換気量
	  End Select
	'  Debug.Print "走行速度km/s=" & D走行速度
	  Select Case D走行速度
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；走行速度=" & _
	        D走行速度
	    Case Is <= 120
	    Case Else
	      MsgBox "ＪＦ；変数設定；走行速度=" & _
	        D走行速度
	  End Select
	  Select Case S交通方式
	    Case "一方通行"
	      GD交通量比 = 1
	    Case "対面通行"
	      GD交通量比 = 0.5
	    Case Else
	      MsgBox "ＪＦ；変数設定；交通方式=" & _
	        S交通方式
	  End Select
	'変数代入
	  GD走行速度 = D走行速度 * 1000 / 60 / 60
	  GD設計交通量 = D設計交通量
	  GD大型車混入率 = D大型車混入率
	  GDトンネル断面 = Dトンネル断面
	  GDトンネル延長 = Dトンネル延長
	  GD代表寸法 = D代表寸法
	  GD所要換気量 = D所要換気量
	  GS交通方式 = S交通方式
	'計算実行
	  S10JF台数
	''debug
	''入力変数
	'  Debug.Print "設計交通量  ="; GD設計交通量
	'  Debug.Print "大型車混入率="; GD大型車混入率
	'  Debug.Print "トンネル延長="; GDトンネル延長
	'  Debug.Print "トンネル断面="; GDトンネル断面
	'  Debug.Print "代表寸法    ="; GD代表寸法
	'  Debug.Print "所要換気量  ="; GD所要換気量
	'  Debug.Print "走行速度    ="; GD走行速度
	'  Debug.Print "交通方式    ="; GS交通方式
	''計算変数
	'  Debug.Print "交通量比    ="; GD交通量比
	'  Debug.Print "車道内風速  ="; GD車道内風速
	'  Debug.Print "通気抵抗    ="; GD通気抵抗
	'  Debug.Print "自然換気力  ="; GD自然換気力
	'  Debug.Print "交通換気力  ="; GD交通換気力
	'  Debug.Print "自動車等価抵抗面積="; GD自動車等価抵抗面積
	'  Debug.Print "自動車存在台数="; GD自動車存在台数
	'  For i = 0 To CJF種類
	'    Debug.Print i; "ＪＦ昇圧力="; GDJF昇圧力(i)
	'  Next
	'  For i = 0 To CJF種類
	'    Debug.Print i; "断面積比  ="; GD断面積比(i)
	'  Next
	'  For i = 0 To CJF種類
	'    Debug.Print i; "風速比    ="; GD風速比(i)
	'  Next
	'  For i = 0 To CJF種類
	'    Debug.Print i; "ＪＦ台数  ="; _
	'      Round(GDJF台数(i), 1)
	'  Next
	End Sub*/
	}//A00変数設定
	private void S10JF台数(){ 
		int i;//Dim  As Integer
		S01車道内風速();
		S02通気抵抗();
		S03自然換気力();
		S04自動車等価抵抗面積();
		S05自動車存在台数();
		S06交通換気力();
		S07断面積比();
		S08風速比();
		S09JF昇圧力();
		for( i = 0 ; i < CJF種類 ; i++){
			GDJF台数[i]
				= (GD通気抵抗 
				+ GD自然換気力 
				- GD交通換気力) 
				/ GDJF昇圧力[i];
		}//for Next
		//End Sub
	/*S10JF台数()
	'------------------------------------
	'目的 ジェットファン台数
	'日付 030512
	'------------------------------------
	Private Sub S10JF台数()
	  Dim i As Integer
	  S01車道内風速
	  S02通気抵抗
	  S03自然換気力
	  S04自動車等価抵抗面積
	  S05自動車存在台数
	  S06交通換気力
	  S07断面積比
	  S08風速比
	  S09JF昇圧力
	  For i = 0 To CJF種類
	    GDJF台数(i) _
	      = (GD通気抵抗 _
	      + GD自然換気力 _
	      - GD交通換気力) _
	      / GDJF昇圧力(i)
	  Next
	End Sub*/
	}//S10JF台数
	private void S01車道内風速(){
	  GD車道内風速 
	    = GD所要換気量 
	    / GDトンネル断面;
	/*S01車道内風速()
	'------------------------------------
	'目的 車道内風速
	'日付 030512
	'------------------------------------
	Private Sub S01車道内風速()
	  GD車道内風速 _
	    = GD所要換気量 _
	    / GDトンネル断面
	End Sub */
	}//S01車道内風速
	private void S02通気抵抗(){
		GD通気抵抗 
			= (1.0 + Cトンネル入口損失係数
			+ Cトンネル壁面摩擦係数
			* GDトンネル延長 / GD代表寸法)
			* C空気密度 / 2.0
			* Math.pow(GD車道内風速,2.0) ;
	//End Sub*/
	/*S02通気抵抗()
	'------------------------------------
	'目的 通気抵抗
	'日付 030512
	'------------------------------------
	Private Sub S02通気抵抗()
	  GD通気抵抗 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * GD車道内風速 ^ 2
	End Sub*/
	}//S02通気抵抗
	private void S03自然換気力(){
		GD自然換気力 
			= (1.0 + Cトンネル入口損失係数
			+ Cトンネル壁面摩擦係数
			* GDトンネル延長 / GD代表寸法)
			* C空気密度 / 2.0 
			* Math.pow(C自然換気風速,2.0);
	/*S03自然換気力()
	'------------------------------------
	'目的 自然換気力
	'日付 030512
	'------------------------------------
	Private Sub S03自然換気力()
	  GD自然換気力 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * C自然換気風速 ^ 2
	End Sub*/
	}//S03自然換気力
	private void S04自動車等価抵抗面積(){
		GD自動車等価抵抗面積
			= 0.78 + 9.1 / GDトンネル断面
			+ (4.21 + 137.0 / GDトンネル断面)
			* GD大型車混入率;
		//End Sub*/
	/*S04自動車等価抵抗面積()
	'------------------------------------
	'目的 自動車等価抵抗面積
	'日付 030512
	'変更 080708
	'   技術基準の変更に伴う修正
	'------------------------------------
	Private Sub S04自動車等価抵抗面積()
	'  GD自動車等価抵抗面積 _
	'    = 0.8 + 41.9 / GDトンネル断面 _
	'    + (1.68 + 355 / GDトンネル断面) _
	'    * GD大型車混入率
	  GD自動車等価抵抗面積 _
	    = 0.78 + 9.1 / GDトンネル断面 _
	    + (4.21 + 137 / GDトンネル断面) _
	    * GD大型車混入率
	End Sub*/
	}//S04自動車等価抵抗面積
	private void S05自動車存在台数(){
		GD自動車存在台数
			= GD設計交通量
			* GDトンネル延長
			/ 3600.0
			/ GD走行速度;
		//End Sub
	/*S05自動車存在台数()
	'------------------------------------
	'目的 自動車等存在台数
	'日付 030512
	'------------------------------------
	Private Sub S05自動車存在台数()
	  GD自動車存在台数 _
	    = GD設計交通量 _
	    * GDトンネル延長 _
	    / 3600 _
	    / GD走行速度
	End Sub*/
	}//S05自動車存在台数
	private void S06交通換気力(){
		GD交通換気力
			= GD自動車等価抵抗面積
			/ GDトンネル断面
			* C空気密度 / 2.0
			* GD自動車存在台数
			* GD交通量比
			* Math.pow((GD走行速度 - GD車道内風速),2)
			- GD自動車等価抵抗面積
			/ GDトンネル断面
			* C空気密度 / 2.0
			* GD自動車存在台数
			* (1.0- GD交通量比)
			* Math.pow((GD走行速度 + GD車道内風速),2);
	/*S06交通換気力()
	'------------------------------------
	'目的 交通換気力
	'日付 030512
	'------------------------------------
	Private Sub S06交通換気力()
	  GD交通換気力 _
	    = GD自動車等価抵抗面積 _
	    / GDトンネル断面 _
	    * C空気密度 / 2 _
	    * GD自動車存在台数 _
	    * GD交通量比 _
	    * (GD走行速度 - GD車道内風速) ^ 2 _
	    - GD自動車等価抵抗面積 _
	    / GDトンネル断面 _
	    * C空気密度 / 2 _
	    * GD自動車存在台数 _
	    * (1 - GD交通量比) _
	    * (GD走行速度 + GD車道内風速) ^ 2
	End Sub*/
	}//S06交通換気力
	private void S07断面積比(){
		int IJF種類;//Dim As Integer
		for( IJF種類 = 0 ;IJF種類 < CJF種類 ; IJF種類++ ){//To 
			GD断面積比[IJF種類]
				= GDJF断面[IJF種類]
				/ GDトンネル断面;
		}//for Next
		//End Sub
	/*S07断面積比()
	'------------------------------------
	'目的 断面積比
	'日付 030512
	'------------------------------------
	Private Sub S07断面積比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD断面積比(IJF種類) _
	    = GDJF断面(IJF種類) _
	    / GDトンネル断面
	  Next
	End Sub*/
	}//S07断面積比
	private void S08風速比(){
		int IJF種類;//Dim As Integer
		for( IJF種類 = 0 ;IJF種類 < CJF種類 ; IJF種類++ ){
			GD風速比[IJF種類]
				= GD車道内風速 / GDJF風速[IJF種類];
		}//for Next
		//End Sub
	/*S08風速比
	'------------------------------------
	'目的 風速比
	'日付 030512
	'------------------------------------
	Private Sub S08風速比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD風速比(IJF種類) _
	      = GD車道内風速 / GDJF風速(IJF種類)
	  Next
	End Sub*/
	}//S08風速比
	private void S09JF昇圧力(){
		int i;//Dim  As Integer
		for( i = 0 ;i < CJF種類; i++){
			GDJF昇圧力[i]
				= 0.5 * C空気密度
				* Math.pow(GDJF風速[i], 2.0) 
				* 2.0 * GD断面積比[i] 
				* (1.0 - GD風速比[i]);
			db.debugPrint(":A07JFH20Class:GDJF昇圧力[i:"+ i +"]="+ GDJF昇圧力[i]);
		}//for Next
	/*S09JF昇圧力()
	'------------------------------------
	'目的 ジェットファン昇圧力
	'日付 030512
	'------------------------------------
	Private Sub S09JF昇圧力()
	  Dim i As Integer
	  For i = 0 To CJF種類
	'    GDJF昇圧力(i) _
	'      = 1 / 2 * C空気密度 _
	'      * GDJF風速(i) ^ 2 _
	'      * GD断面積比(i) _
	'      * (1 - GD風速比(i)) _
	'      / (1 - GD断面積比(i)) ^ 2 _
	'      * (2 - 3 * GD断面積比(i) _
	'      + GD風速比(i) * GD断面積比(i))
	    GDJF昇圧力(i) _
	      = 1 / 2 * C空気密度 _
	      * GDJF風速(i) ^ 2 _
	      * 2 * GD断面積比(i) _
	      * (1 - GD風速比(i))
	  Next
	End Sub*/
	}//S09JF昇圧力
	public void A01JF台数( double[] JF台数){
		int i;//Dim  As Integer
		for( i = 0; i < CJF種類 ; i++){
			JF台数[i] = GDJF台数[i];
		};//for Next
	/*Public Sub A01JF台数( _
	  ByRef JF台数() As Double)
	  Dim i As Integer
	  For i = 0 To CJF種類
	    JF台数(i) = Round(GDJF台数(i), 1)
	  Next
	End Sub*/
	}
	public void A02JF台数( double[] JF台数){
		int i;//Dim  As Integer
		for( i = 0; i < CJF種類 ; i++){
			JF台数[i] = Math.round(GDJF台数[i]*10.0)/10.0;
		};
	}
	public int A03intJF種類(){
	    return CJF種類;
	}//A01JF台数
	//public void A02JF台数ceil( double[] JF台数){
	//	int i;//Dim  As Integer
	//	for( i = 0; i < CJF種類 ; i++){
	//		JF台数[i] = Math.ceil(GDJF台数[i]);
	//	};
	//}
    /*A07JFH20Class
	VERSION 1.0 CLASS
	BEGIN
	  MultiUse = -1  'True
	  Persistable = 0  'NotPersistable
	  DataBindingBehavior = 0  'vbNone
	  DataSourceBehavior  = 0  'vbNone
	  MTSTransactionMode  = 0  'NotAnMTSObject
	END
	Attribute VB_Name = "A07JFH20Class"
	Attribute VB_GlobalNameSpace = False
	Attribute VB_Creatable = True
	Attribute VB_PredeclaredId = False
	Attribute VB_Exposed = False
	Option Explicit
	'定数
	Const Cトンネル入口損失係数 = 0.6
	Const Cトンネル壁面摩擦係数 = 0.025
	Const C空気密度 = 1.2
	Const C自然換気風速 = 2.5
	Const CJF種類 = 6
	Private GDJF断面(CJF種類) As Double
	Private GDJF風速(CJF種類) As Double
	'計算変数
	Private GD交通量比 As Double
	Private GD車道内風速 As Double
	Private GD通気抵抗 As Double
	Private GD自然換気力 As Double
	Private GD交通換気力 As Double
	Private GD自動車等価抵抗面積 As Double
	Private GD自動車存在台数 As Double
	Private GDJF昇圧力(CJF種類) As Double
	Private GD断面積比(CJF種類) As Double
	Private GD風速比(CJF種類) As Double
	Private GDJF台数(CJF種類) As Double
	'------------------------------------
	'目的 初期値
	'日付 030512
	'------------------------------------
	Private Sub Class_Initialize()
	'ジェットファン断面積定義
	  GDJF断面(0) = 0.27
	  GDJF断面(1) = 0.83
	  GDJF断面(2) = 1.23
	  GDJF断面(3) = 1.84
	  GDJF断面(4) = 0.83
	  GDJF断面(5) = 1.23
	  GDJF断面(6) = 0.27
	'ジェットファン風速定義
	  GDJF風速(0) = 30
	  GDJF風速(1) = 30
	  GDJF風速(2) = 30
	  GDJF風速(3) = 30
	  GDJF風速(4) = 35
	  GDJF風速(5) = 35
	  GDJF風速(6) = 35
	End Sub
	'------------------------------------
	'目的 変数設定
	'日付 030512
	'------------------------------------
	Public Sub A00変数設定( _
	  D設計交通量 As Double, _
	  D大型車混入率 As Double, _
	  Dトンネル延長 As Double, _
	  Dトンネル断面 As Double, _
	  D代表寸法 As Double, _
	  D所要換気量, _
	  D走行速度, _
	  S交通方式)
	  Dim i As Integer
	  Select Case D設計交通量
	    Case Is <= 0
	      MsgBox "ＪＦ；変数設定；設計交通量=" & _
	        D設計交通量
	    Case Is < 4400
	    Case Else
	      MsgBox "ＪＦ；変数設定；設計交通量=" & _
	        D設計交通量
	  End Select
	  Select Case D大型車混入率
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；大型車混入率=" & _
	        D大型車混入率
	    Case Is < 1
	    Case Else
	      MsgBox "ＪＦ；変数設定；大型車混入率=" & _
	        D大型車混入率
	  End Select
	  Select Case Dトンネル断面
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；トンネル断面=" & _
	        Dトンネル断面
	    Case Is < 100
	    Case Else
	      MsgBox "ＪＦ；変数設定；トンネル断面=" & _
	        Dトンネル断面
	  End Select
	  Select Case Dトンネル延長
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；トンネル延長=" & _
	        Dトンネル延長
	    Case Is < 50000
	    Case Else
	      MsgBox "ＪＦ；変数設定；トンネル延長=" & _
	        Dトンネル延長
	  End Select
	  Select Case D代表寸法
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；代表寸法=" & _
	        D代表寸法
	    Case Is < 20
	    Case Else
	      MsgBox "ＪＦ；変数設定；代表寸法=" & _
	        D代表寸法
	  End Select
	  Select Case D所要換気量
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；所要換気量=" & _
	        D所要換気量
	    Case Is < 800
	    Case Else
	      MsgBox "ＪＦ；変数設定；所要換気量=" & _
	        D所要換気量
	  End Select
	'  Debug.Print "走行速度km/s=" & D走行速度
	  Select Case D走行速度
	    Case Is < 0
	      MsgBox "ＪＦ；変数設定；走行速度=" & _
	        D走行速度
	    Case Is <= 120
	    Case Else
	      MsgBox "ＪＦ；変数設定；走行速度=" & _
	        D走行速度
	  End Select
	  Select Case S交通方式
	    Case "一方通行"
	      GD交通量比 = 1
	    Case "対面通行"
	      GD交通量比 = 0.5
	    Case Else
	      MsgBox "ＪＦ；変数設定；交通方式=" & _
	        S交通方式
	  End Select
	'変数代入
	  GD走行速度 = D走行速度 * 1000 / 60 / 60
	  GD設計交通量 = D設計交通量
	  GD大型車混入率 = D大型車混入率
	  GDトンネル断面 = Dトンネル断面
	  GDトンネル延長 = Dトンネル延長
	  GD代表寸法 = D代表寸法
	  GD所要換気量 = D所要換気量
	  GS交通方式 = S交通方式
	'計算実行
	  S10JF台数
	''debug
	''入力変数
	'  Debug.Print "設計交通量  ="; GD設計交通量
	'  Debug.Print "大型車混入率="; GD大型車混入率
	'  Debug.Print "トンネル延長="; GDトンネル延長
	'  Debug.Print "トンネル断面="; GDトンネル断面
	'  Debug.Print "代表寸法    ="; GD代表寸法
	'  Debug.Print "所要換気量  ="; GD所要換気量
	'  Debug.Print "走行速度    ="; GD走行速度
	'  Debug.Print "交通方式    ="; GS交通方式
	''計算変数
	'  Debug.Print "交通量比    ="; GD交通量比
	'  Debug.Print "車道内風速  ="; GD車道内風速
	'  Debug.Print "通気抵抗    ="; GD通気抵抗
	'  Debug.Print "自然換気力  ="; GD自然換気力
	'  Debug.Print "交通換気力  ="; GD交通換気力
	'  Debug.Print "自動車等価抵抗面積="; GD自動車等価抵抗面積
	'  Debug.Print "自動車存在台数="; GD自動車存在台数
	'  For i = 0 To CJF種類
	'    Debug.Print i; "ＪＦ昇圧力="; GDJF昇圧力(i)
	'  Next
	'  For i = 0 To CJF種類
	'    Debug.Print i; "断面積比  ="; GD断面積比(i)
	'  Next
	'  For i = 0 To CJF種類
	'    Debug.Print i; "風速比    ="; GD風速比(i)
	'  Next
	'  For i = 0 To CJF種類
	'    Debug.Print i; "ＪＦ台数  ="; _
	'      Round(GDJF台数(i), 1)
	'  Next
	End Sub
	'------------------------------------
	'目的 ジェットファン台数
	'日付 030512
	'------------------------------------
	Private Sub S10JF台数()
	  Dim i As Integer
	  S01車道内風速
	  S02通気抵抗
	  S03自然換気力
	  S04自動車等価抵抗面積
	  S05自動車存在台数
	  S06交通換気力
	  S07断面積比
	  S08風速比
	  S09JF昇圧力
	  For i = 0 To CJF種類
	    GDJF台数(i) _
	      = (GD通気抵抗 _
	      + GD自然換気力 _
	      - GD交通換気力) _
	      / GDJF昇圧力(i)
	  Next
	End Sub
	'------------------------------------
	'目的 車道内風速
	'日付 030512
	'------------------------------------
	Private Sub S01車道内風速()
	  GD車道内風速 _
	    = GD所要換気量 _
	    / GDトンネル断面
	End Sub
	'------------------------------------
	'目的 通気抵抗
	'日付 030512
	'------------------------------------
	Private Sub S02通気抵抗()
	  GD通気抵抗 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * GD車道内風速 ^ 2
	End Sub
	'------------------------------------
	'目的 自然換気力
	'日付 030512
	'------------------------------------
	Private Sub S03自然換気力()
	  GD自然換気力 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * C自然換気風速 ^ 2
	End Sub
	'------------------------------------
	'目的 自動車等価抵抗面積
	'日付 030512
	'変更 080708
	'   技術基準の変更に伴う修正
	'------------------------------------
	Private Sub S04自動車等価抵抗面積()
	'  GD自動車等価抵抗面積 _
	'    = 0.8 + 41.9 / GDトンネル断面 _
	'    + (1.68 + 355 / GDトンネル断面) _
	'    * GD大型車混入率
	  GD自動車等価抵抗面積 _
	    = 0.78 + 9.1 / GDトンネル断面 _
	    + (4.21 + 137 / GDトンネル断面) _
	    * GD大型車混入率
	End Sub
	'------------------------------------
	'目的 自動車等存在台数
	'日付 030512
	'------------------------------------
	Private Sub S05自動車存在台数()
	  GD自動車存在台数 _
	    = GD設計交通量 _
	    * GDトンネル延長 _
	    / 3600 _
	    / GD走行速度
	End Sub
	'------------------------------------
	'目的 交通換気力
	'日付 030512
	'------------------------------------
	Private Sub S06交通換気力()
	  GD交通換気力 _
	    = GD自動車等価抵抗面積 _
	    / GDトンネル断面 _
	    * C空気密度 / 2 _
	    * GD自動車存在台数 _
	    * GD交通量比 _
	    * (GD走行速度 - GD車道内風速) ^ 2 _
	    - GD自動車等価抵抗面積 _
	    / GDトンネル断面 _
	    * C空気密度 / 2 _
	    * GD自動車存在台数 _
	    * (1 - GD交通量比) _
	    * (GD走行速度 + GD車道内風速) ^ 2
	End Sub
	'------------------------------------
	'目的 断面積比
	'日付 030512
	'------------------------------------
	Private Sub S07断面積比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD断面積比(IJF種類) _
	    = GDJF断面(IJF種類) _
	    / GDトンネル断面
	  Next
	End Sub
	'------------------------------------
	'目的 風速比
	'日付 030512
	'------------------------------------
	Private Sub S08風速比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD風速比(IJF種類) _
	      = GD車道内風速 / GDJF風速(IJF種類)
	  Next
	End Sub
	'------------------------------------
	'目的 ジェットファン昇圧力
	'日付 030512
	'------------------------------------
	Private Sub S09JF昇圧力()
	  Dim i As Integer
	  For i = 0 To CJF種類
	'    GDJF昇圧力(i) _
	'      = 1 / 2 * C空気密度 _
	'      * GDJF風速(i) ^ 2 _
	'      * GD断面積比(i) _
	'      * (1 - GD風速比(i)) _
	'      / (1 - GD断面積比(i)) ^ 2 _
	'      * (2 - 3 * GD断面積比(i) _
	'      + GD風速比(i) * GD断面積比(i))
	    GDJF昇圧力(i) _
	      = 1 / 2 * C空気密度 _
	      * GDJF風速(i) ^ 2 _
	      * 2 * GD断面積比(i) _
	      * (1 - GD風速比(i))
	  Next
	End Sub
	*/
}//A07JFH20Class
