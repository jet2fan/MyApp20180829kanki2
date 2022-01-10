package com.example.yo.myapp20180829kanki2;

public class A08火災H20Class{
	//クラスの定義
	DebugPrint db = new DebugPrint();
	//'定数
	final double Cトンネル入口損失係数 = 0.6d;
	final double Cトンネル壁面摩擦係数 = 0.025d;
	final double C空気密度 = 1.2d;
	final double C自然換気風速 = 2.5d;
	final double C車道内風速 = 2d; //煙を逆流させないために必要な風速
	final int CJF種類 = 6+1;//JF種類なので、配列変数の用意すべき個数なので+1とする
	final double C火災発生後走行速度 = 0d;
	private double[] GDJF断面 = new double[CJF種類];// As Double
	private double[] GDJF風速 = new double[CJF種類];// As Double
	//'入力変数
	private double GD設計交通量;// As Double
	private double GD大型車混入率;// As Double
	private double GDトンネル延長;// As Double
	private double GDトンネル断面;// As Double
	private double GD代表寸法;// As Double
	private double GD走行速度;// As Double
	private String GS交通方式;// As String
	//'計算変数
	private double GD交通量比;// As Double
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
	/*'------------------------------------
	//'目的 初期値
	//'日付 030512
	//'------------------------------------
	//Private Sub Class_Initialize()
	//'ジェットファン断面積定義*/
	  GDJF断面[0] = 0.27;
	  GDJF断面[1] = 0.83;
	  GDJF断面[2] = 1.23;
	  GDJF断面[3] = 1.84;
	  GDJF断面[4] = 0.27;
	  GDJF断面[5] = 0.83;
	  GDJF断面[6] = 1.23;
	//'ジェットファン風速定義
	  GDJF風速[0] = 30.0;
	  GDJF風速[1] = 30.0;
	  GDJF風速[2] = 30.0;
	  GDJF風速[3] = 30.0;
	  GDJF風速[4] = 35.0;
	  GDJF風速[5] = 35.0;
	  GDJF風速[6] = 35.0;
	//End Sub
	}//S00GDJF断面設定
	public void A00変数設定(//入力
		double D設計交通量,
		double D大型車混入率,
		double Dトンネル延長,
		double Dトンネル断面,
		double D代表寸法,
		double D走行速度, 
		String S交通方式)
		{//実行 
		int i;//Dim  As Integer
		S00GDJF断面設定();
		//Select Case D設計交通量
		if( D設計交通量<= 0.0){
			db.debugError("error:A08火災H20Class：A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "ＪＦ；変数設定；設計交通量=" & D設計交通量
		}//if
		else if( D設計交通量< 4400.0){
		}//else if
		else{//Case Else
			db.debugError("error:A08火災H20Class：A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "ＪＦ；変数設定；設計交通量=" & D設計交通量
		}//else End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:D設計交通量  ="+ D設計交通量);
		//Select Case D大型車混入率
	    if( D大型車混入率< 0.0){
			db.debugError("error:A08火災H20Class：A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "ＪＦ；変数設定；大型車混入率=" & D大型車混入率
	    }//if 
	    else if(D大型車混入率 < 1.0){
	    }//else if
	    else{ //Case Else
			db.debugError("error:A08火災H20Class：A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "ＪＦ；変数設定；大型車混入率=" D大型車混入率
		}//End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:D大型車混入率  ="+ D大型車混入率);
		//Select Case Dトンネル断面
	    if( Dトンネル断面< 0.0){
			db.debugError("error:A08火災H20Class：A00変数設定：Dトンネル断面=" + Dトンネル断面);
			//MsgBox "ＪＦ；変数設定；トンネル断面=" Dトンネル断面
	    }//if
	    else if( Dトンネル断面< 100.0){
	    }//else if
	    else{//Case Else
			db.debugError("error:A08火災H20Class：A00変数設定：Dトンネル断面=" + Dトンネル断面);
			//MsgBox "ＪＦ；変数設定；トンネル断面=" Dトンネル断面
		}//End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:Dトンネル断面  ="+ Dトンネル断面);
		//Select Case Dトンネル延長
	    if( Dトンネル延長< 0.0){
			db.debugError("error:A08火災H20Class：A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "ＪＦ；変数設定；トンネル延長=" Dトンネル延長
	    }//if
	    else if( Dトンネル延長< 50000.0){
	    }//else if
	    else{//Case Else
			db.debugError("error:A08火災H20Class：A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "ＪＦ；変数設定；トンネル延長=" Dトンネル延長
		}//else End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:Dトンネル延長  ="+ Dトンネル延長);
		//Select Case D代表寸法
	    if( D代表寸法< 0.0){
			db.debugError("error:A08火災H20Class：A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "ＪＦ；変数設定；代表寸法=" D代表寸法
	    }//if
	    else if( D代表寸法< 20.0){
	    }//
	    else{ //Case Else
			db.debugError("error:A08火災H20Class：A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "ＪＦ；変数設定；代表寸法=" D代表寸法
		}//else End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:D代表寸法  ="+ D代表寸法);
		//Select Case D走行速度
	    if( D走行速度 < 0.0){//Case Is
			db.debugError("error:A08火災H20Class：A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "ＪＦ；変数設定；走行速度=" D走行速度
	    }//if
	    else if( D走行速度<= 120.0){//Case Is
	    }//if
	    else{//Case Else
			db.debugError("error:A08火災H20Class：A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "ＪＦ；変数設定；走行速度=" D走行速度
		}//else End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:D走行速度  ="+ D走行速度);
		//Select Case S交通方式
	    switch(S交通方式){
		    case "一方通行":
				GD交通量比 = 1.0;
				break;
		    case "対面通行":
				GD交通量比 = 0.5;
				break;
			default: //Case Else
				//MsgBox "ＪＦ；変数設定；交通方式=" S交通方式
				db.debugError("error:A08火災H20Class：A00変数設定：S交通方式=" + S交通方式);
		}//switch End Select
		db.debugPrint( "A08火災H20Class：A00変数設定:S交通方式  ="+ S交通方式);
		//'変数代入
		GD走行速度 = D走行速度 * 1000.0 / 60.0 / 60.0;
		db.debugPrint( "A08火災H20Class：A00変数設定:GD走行速度  ="+ GD走行速度);
		GD設計交通量 = D設計交通量;
		GD大型車混入率 = D大型車混入率;
		GDトンネル断面 = Dトンネル断面;
		GDトンネル延長 = Dトンネル延長;
		GD代表寸法 = D代表寸法;
		GS交通方式 = S交通方式;
		//'計算実行
		S00計算実行();
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
	  GS交通方式 = S交通方式
	'計算実行
	  S00計算実行
	End Sub
	*/	
	}//A00変数設定
	private void S00計算実行(){
		int i;//Dim  As Integer
		S01自動車存在台数();
		S02自動車等価抵抗面積();
		S03交通換気力();
		S04通気抵抗();
		S05自然換気力();
		S06断面積比();
		S07風速比();
		S08JF昇圧力();
		for( i = 0 ;i < CJF種類;i++){
		    GDJF台数[i]
				= (GD通気抵抗 
				+ GD自然換気力 
				- GD交通換気力) 
				/ GDJF昇圧力[i];
			db.debugPrint( "A08火災H20Class：A01JF台数:GDJF台数[i:"+ i +"]="+ GDJF台数[i] );
		}//for Next
	/*S00計算実行
	'------------------------------------
	'目的 ジェットファン台数
	'日付 030512
	'------------------------------------
	Private Sub S00計算実行()
	  Dim i As Integer
	  S01自動車存在台数
	  S02自動車等価抵抗面積
	  S03交通換気力
	  S04通気抵抗
	  S05自然換気力
	  S06断面積比
	  S07風速比
	  S08JF昇圧力
	  For i = 0 To CJF種類
	    GDJF台数(i) _
	      = (GD通気抵抗 _
	      + GD自然換気力 _
	      - GD交通換気力) _
	      / GDJF昇圧力(i)
	  Next
	'debug
	Debug.Print "GD交通量比"; GD交通量比
	Debug.Print "GD通気抵抗"; GD通気抵抗
	Debug.Print "GD自然換気力"; GD自然換気力
	Debug.Print "GD交通換気力"; GD交通換気力
	Debug.Print "GD自動車等価抵抗面積"; _
	                GD自動車等価抵抗面積
	Debug.Print "GD自動車存在台数"; GD自動車存在台数
	End Sub*/
	}//S00計算実行
	private void S01自動車存在台数(){ 
		double  D交通方式による車線数;//Dim As Double
		if(GS交通方式.equals("対面通行") ){// Then
			D交通方式による車線数 = 2.0;
		}//if
		else if( GS交通方式.equals("一方通行") ){// Then
			D交通方式による車線数 = 1.0;
		}//else if
		else{//Else
			db.debugError("error:A08火災H20Class：S01自動車存在台数：GS交通方式=" + GS交通方式);
			//MsgBox "排煙；自動車存在台数；交通方式=" & GS交通方式
			D交通方式による車線数 = 0.0;
		}//else End If
		db.debugPrint( "A08火災H20Class：S01自動車存在台数:D交通方式による車線数=" + D交通方式による車線数);
		GD自動車存在台数
			= GD設計交通量
		    * GDトンネル延長
		    / 3600.0
		    / GD走行速度
		    / D交通方式による車線数;
		db.debugPrint( "A08火災H20Class：S01自動車存在台数:GD自動車存在台数  ="+ GD自動車存在台数);
	/*S01自動車存在台数
	'------------------------------------
	'目的 自動車等存在台数
	'日付 030512
	'------------------------------------
	Private Sub S01自動車存在台数()
	  Dim D交通方式による車線数 As Double
	  If GS交通方式 = "対面通行" Then
	    D交通方式による車線数 = 2
	  ElseIf GS交通方式 = "一方通行" Then
	    D交通方式による車線数 = 1
	  Else
	    MsgBox "排煙；自動車存在台数；交通方式=" & GS交通方式
	  End If
	  GD自動車存在台数 _
	    = GD設計交通量 _
	    * GDトンネル延長 _
	    / 3600 _
	    / GD走行速度 _
	    / D交通方式による車線数
	End Sub*/
	}//S01自動車存在台数
	private void S02自動車等価抵抗面積(){
		GD自動車等価抵抗面積
		    = 0.78 + 9.1 / GDトンネル断面 
		    + (4.21 + 137.0 / GDトンネル断面) 
		    * GD大型車混入率;
		db.debugPrint( "A08火災H20Class：S02自動車等価抵抗面積:GD自動車等価抵抗面積  ="+ GD自動車等価抵抗面積);
	/*S02自動車等価抵抗面積
	'------------------------------------
	'目的 自動車等価抵抗面積
	'日付 030512
	'変更 080708
	'   技術基準の変更に伴う修正
	'------------------------------------
	Private Sub S02自動車等価抵抗面積()
	'  GD自動車等価抵抗面積 _
	'    = 0.8 + 41.9 / GDトンネル断面 _
	'    + (1.68 + 355 / GDトンネル断面) _
	'    * GD大型車混入率
	  GD自動車等価抵抗面積 _
	    = 0.78 + 9.1 / GDトンネル断面 _
	    + (4.21 + 137 / GDトンネル断面) _
	    * GD大型車混入率
	End Sub */
	}//S02自動車等価抵抗面積
	private void S03交通換気力(){
		GD交通換気力 
		    = -1.0 * GD自動車等価抵抗面積
		    / GDトンネル断面
		    * C空気密度 / 2.0
		    * GD自動車存在台数
		    * 1.0
		    * Math.pow((C火災発生後走行速度 + C車道内風速) , 2);
		db.debugPrint( "A08火災H20Class：S03交通換気力:GD交通換気力  ="+ GD交通換気力);
	/*S03交通換気力
	'------------------------------------
	'目的 交通換気力
	'日付 030512
	'------------------------------------
	Private Sub S03交通換気力()
	  GD交通換気力 _
	    = -1 * GD自動車等価抵抗面積 _
	    / GDトンネル断面 _
	    * C空気密度 / 2 _
	    * GD自動車存在台数 _
	    * 1 _
	    * (C火災発生後走行速度 + C車道内風速) ^ 2
	End Sub*/
	}//S03交通換気力
	private void S04通気抵抗(){
		GD通気抵抗
		    = (1.0 + Cトンネル入口損失係数
		    + Cトンネル壁面摩擦係数
		    * GDトンネル延長 / GD代表寸法)
		    * C空気密度 / 2.0
		    * Math.pow(C車道内風速,2.0);
		db.debugPrint( "A08火災H20Class：S04通気抵抗:GD通気抵抗  ="+ GD通気抵抗);
	/*S04通気抵抗
	'------------------------------------
	'目的 トンネル壁面摩擦抵抗
	'日付 030512
	'------------------------------------
	Private Sub S04通気抵抗()
	  GD通気抵抗 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * C車道内風速 ^ 2
	End Sub*/
	}//S04通気抵抗
	private void S05自然換気力(){
		GD自然換気力
		    = (1.0 + Cトンネル入口損失係数
		    + Cトンネル壁面摩擦係数
		    * GDトンネル延長 / GD代表寸法)
		    * C空気密度 / 2.0
		    * Math.pow(C自然換気風速, 2.0);
		db.debugPrint( "A08火災H20Class：S05自然換気力:GD自然換気力  ="+ GD自然換気力);
	/*S05自然換気力
	'------------------------------------
	'目的 自然換気力
	'日付 030512
	'変更 080709
	'------------------------------------
	Private Sub S05自然換気力()
	  GD自然換気力 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * C自然換気風速 ^ 2
	End Sub*/
	}//S05自然換気力
	private void S06断面積比(){
		int IJF種類;//Dim  As Integer
		for( IJF種類 = 0 ;IJF種類 < CJF種類; IJF種類++){
		    GD断面積比[IJF種類]
			    = GDJF断面[IJF種類]
			    / GDトンネル断面;
			db.debugPrint( "A08火災H20Class：S06断面積比:GDJF断面[IJF種類:"+ IJF種類 + "="+ GDJF断面[IJF種類] );
			db.debugPrint( "A08火災H20Class：S06断面積比:GD断面積比[IJF種類:"+ IJF種類 + "]="+ GD断面積比[IJF種類]);
		}//for Next
	/*S06断面積比
	'------------------------------------
	'目的 断面積比
	'日付 030512
	'------------------------------------
	Private Sub S06断面積比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD断面積比(IJF種類) _
	    = GDJF断面(IJF種類) _
	    / GDトンネル断面
	  Next
	End Sub*/
	}//S06断面積比
	private void S07風速比(){
		int IJF種類;// As Integer
		for( IJF種類 = 0 ;IJF種類 < CJF種類 ; IJF種類++){
		    GD風速比[IJF種類]
		      = C車道内風速 / GDJF風速[IJF種類];
			db.debugPrint( "A08火災H20Class：S07風速比:GD風速比[IJF種類:"+ IJF種類 + "]=" + GD風速比[IJF種類] );
	  }//for Next
	/*S07風速比
	'------------------------------------
	'目的 風速比
	'日付 030512
	'------------------------------------
	Private Sub S07風速比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD風速比(IJF種類) _
	      = C車道内風速 / GDJF風速(IJF種類)
	  Next
	End Sub */
	}//S07風速比
	private void S08JF昇圧力(){
		int i;// As Integer
		db.debugPrint( "A08火災H20Class：S08JF昇圧力:C空気密度="+ C空気密度);
		for( i = 0 ;i< CJF種類; i++){
			GDJF昇圧力[i]
				= 1d / 2d * C空気密度
				* Math.pow( GDJF風速[i], 2.0)
				* 2d * GD断面積比[i]
				* (1d - GD風速比[i]);
			db.debugPrint( "A08火災H20Class：S08JF昇圧力:GDJF風速[i:" + i + "]="+ GDJF風速[i] );
			db.debugPrint( "A08火災H20Class：S08JF昇圧力:GD断面積比[i:" + i + "]="+ GD断面積比[i]);
			db.debugPrint( "A08火災H20Class：S08JF昇圧力:GD風速比[i:" + i + "]="+ GD風速比[i]);
			db.debugPrint( "A08火災H20Class：S08JF昇圧力:GDJF昇圧力[i:" + i + "]="+ GDJF昇圧力[i]);
		}//Next
	
	/*S08JF昇圧力
	'------------------------------------
	'目的 ジェットファン昇圧力
	'日付 030512
	'------------------------------------
	Private Sub S08JF昇圧力()
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
	}//S08JF昇圧力
	public void A01JF台数( double[] jf台数 ){
		int i;// As Integer
		for( i = 0 ; i < CJF種類 ; i++){
			jf台数[i] = Math.round(GDJF台数[i]*10.0)/10.0;
		}//for Next
	/*A01JF台数
	'------------------------------------
	'目的 計算結果
	'日付 080709
	'------------------------------------
	Public Sub A01JF台数( _
	  ByRef JF台数() As Double)
	  Dim i As Integer
	  For i = 0 To CJF種類
	    JF台数(i) = Round(GDJF台数(i), 1)
	  Next
	End Sub*/
	}//A01JF台数
	public int A02intJF種類(){
	    return CJF種類;
	}//A02JF台数

	/*{A08火災H20Class
	Option Explicit
	'定数
	Const Cトンネル入口損失係数 = 0.6
	Const Cトンネル壁面摩擦係数 = 0.025
	Const C空気密度 = 1.2
	Const C自然換気風速 = 2.5
	Const C車道内風速 = 2 '煙を逆流させないために必要な風速
	Const CJF種類 = 6
	Const C火災発生後走行速度 = 0
	Private GDJF断面(CJF種類) As Double
	Private GDJF風速(CJF種類) As Double
	'入力変数
	Private GD設計交通量 As Double
	Private GD大型車混入率 As Double
	Private GDトンネル延長 As Double
	Private GDトンネル断面 As Double
	Private GD代表寸法 As Double
	Private GD走行速度 As Double
	Private GS交通方式 As String
	'計算変数
	Private GD交通量比 As Double
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
	  GS交通方式 = S交通方式
	'計算実行
	  S00計算実行
	End Sub
	'------------------------------------
	'目的 ジェットファン台数
	'日付 030512
	'------------------------------------
	Private Sub S00計算実行()
	  Dim i As Integer
	  S01自動車存在台数
	  S02自動車等価抵抗面積
	  S03交通換気力
	  S04通気抵抗
	  S05自然換気力
	  S06断面積比
	  S07風速比
	  S08JF昇圧力
	  For i = 0 To CJF種類
	    GDJF台数(i) _
	      = (GD通気抵抗 _
	      + GD自然換気力 _
	      - GD交通換気力) _
	      / GDJF昇圧力(i)
	  Next
	'debug
	Debug.Print "GD交通量比"; GD交通量比
	Debug.Print "GD通気抵抗"; GD通気抵抗
	Debug.Print "GD自然換気力"; GD自然換気力
	Debug.Print "GD交通換気力"; GD交通換気力
	Debug.Print "GD自動車等価抵抗面積"; _
	                GD自動車等価抵抗面積
	Debug.Print "GD自動車存在台数"; GD自動車存在台数
	End Sub
	'------------------------------------
	'目的 自動車等存在台数
	'日付 030512
	'------------------------------------
	Private Sub S01自動車存在台数()
	  Dim D交通方式による車線数 As Double
	  If GS交通方式 = "対面通行" Then
	    D交通方式による車線数 = 2
	  ElseIf GS交通方式 = "一方通行" Then
	    D交通方式による車線数 = 1
	  Else
	    MsgBox "排煙；自動車存在台数；交通方式=" & GS交通方式
	  End If
	  GD自動車存在台数 _
	    = GD設計交通量 _
	    * GDトンネル延長 _
	    / 3600 _
	    / GD走行速度 _
	    / D交通方式による車線数
	End Sub
	'------------------------------------
	'目的 自動車等価抵抗面積
	'日付 030512
	'変更 080708
	'   技術基準の変更に伴う修正
	'------------------------------------
	Private Sub S02自動車等価抵抗面積()
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
	'目的 交通換気力
	'日付 030512
	'------------------------------------
	Private Sub S03交通換気力()
	  GD交通換気力 _
	    = -1 * GD自動車等価抵抗面積 _
	    / GDトンネル断面 _
	    * C空気密度 / 2 _
	    * GD自動車存在台数 _
	    * 1 _
	    * (C火災発生後走行速度 + C車道内風速) ^ 2
	End Sub
	'------------------------------------
	'目的 トンネル壁面摩擦抵抗
	'日付 030512
	'------------------------------------
	Private Sub S04通気抵抗()
	  GD通気抵抗 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * C車道内風速 ^ 2
	End Sub
	'------------------------------------
	'目的 自然換気力
	'日付 030512
	'変更 080709
	'------------------------------------
	Private Sub S05自然換気力()
	  GD自然換気力 _
	    = (1 + Cトンネル入口損失係数 _
	    + Cトンネル壁面摩擦係数 _
	    * GDトンネル延長 / GD代表寸法) _
	    * C空気密度 / 2 _
	    * C自然換気風速 ^ 2
	End Sub
	'------------------------------------
	'目的 断面積比
	'日付 030512
	'------------------------------------
	Private Sub S06断面積比()
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
	Private Sub S07風速比()
	  Dim IJF種類 As Integer
	  For IJF種類 = 0 To CJF種類
	    GD風速比(IJF種類) _
	      = C車道内風速 / GDJF風速(IJF種類)
	  Next
	End Sub
	'------------------------------------
	'目的 ジェットファン昇圧力
	'日付 030512
	'------------------------------------
	Private Sub S08JF昇圧力()
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
}
*/
}//A08火災H20Class
