package com.example.yo.myapp20180829kanki2;

public class A06自然対面H20Class{
	//クラスの定義
	DebugPrint db = new DebugPrint();
	//'定数
	final int C屈曲 = 4;//Const 
	final double Cトンネル入口損失係数 = 0.6d;//Const
	final double Cトンネル壁面摩擦係数 = 0.025d;//Const 
	final double C空気密度 = 1.2d;//Const 
	final double C自然換気風速 = 2.5d;//Const
	//'入力変数
	private double GDトンネル延長;// As Double
	private double GDトンネル断面;// As Double
	private double GD代表寸法;// As Double
	private double GD設計交通量;// As Double
	private double GD大型車混入率;// As Double
	private double GD走行速度;// As Double
	//'計算変数
	private double GD自然換気力c;// As Double
	private double GD通気抵抗a;// As Double
	private double GD自動車等価抵抗面積;// As Double
	private double GD自動車存在台数;// As Double
	private double GD交通換気力b;// As Double
	private double GD車道内風速;// As Double
	private double GD自然換気量;// As Double
	//プログラム開始
	public void A00変数設定(//入力変数
		double Dトンネル延長,// As Double, _
		double Dトンネル断面,// As Double, _
		double D代表寸法,// As Double, _
		double D設計交通量,// As Double, _
		double D大型車混入率,// As Double, _
		double D走行速度// As Double _
		)
		{//実行
		int i;//Dim As Integer
		int ii;//Dim As Integer
		//'変数チェック
		//Select Case Dトンネル延長
		if(Dトンネル延長 < 5.0){//20 -> 5 20200308変更
			db.debugError("error:A06自然対面H20Class:A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "自然；変数入力；トンネル延長" & Dトンネル延長
		}//if
		else if( Dトンネル延長 < 7000.0){//Case Is
		}//else if 
		else{//Case Else
			db.debugError("error:A06自然対面H20Class:A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "自然；変数入力；トンネル断面" & Dトンネル延長
		}//else End Select
		//Select Case Dトンネル断面
		if( Dトンネル断面 < 20.0){//Case Is
			db.debugError("error:A06自然対面H20Class:A00変数設定：Dトンネル断面=" + Dトンネル断面);
			//MsgBox "自然；変数入力；トンネル断面" & Dトンネル断面
		}//if
		else if( Dトンネル断面 < 100.0) {//Case Is
		}//else
		else{//Case Else
			db.debugError("error:A06自然対面H20Class:A00変数設定：Dトンネル断面=" + Dトンネル断面);
			//MsgBox "自然；変数入力；トンネル断面" & Dトンネル断面
		}//else End Select
		//Select Case D代表寸法
		if( D代表寸法 < 0.0){ //Case Is
			db.debugError("error:A06自然対面H20Class:A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "自然；変数入力；D代表寸法" & D代表寸法
		}//if
		else if( D代表寸法 < 20.0){//Case Is
		}//else if
		else{//Case Else
			db.debugError("error:A06自然対面H20Class:A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "自然；変数入力；トD代表寸法" & D代表寸法
		}//else End Select
		//Select Case D設計交通量
		if( D設計交通量< 0.0){//Case Is
			db.debugError("error:A06自然対面H20Class:A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "自然；変数入力；設計交通量" & D設計交通量
		}//if
		else if( D設計交通量< 4400.0){//Case Is
		}//
		else{ //Case Else
			db.debugError("error:A06自然対面H20Class:A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "自然；変数入力；設計交通量" & D設計交通量
		}//else End Select
		//Select Case D大型車混入率
		if( D大型車混入率< 0.0){//Case Is
			db.debugError("error:A06自然対面H20Class:A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "自然；変数入力；大型車" & "混入率=" & D大型車混入率
		}//if 
		else if( D大型車混入率<= 1.0){//Case Is
		}//else if
		else{//Case Else
			db.debugError("error:A06自然対面H20Class:A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "自然；変数入力；大型車" & "混入率=" & D大型車混入率
		}//else End Select
		//Select Case D走行速度
		if( D走行速度 < 0.0){//
			db.debugError("error:A06自然対面H20Class:A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "自然；変数入力；走行速度" & D走行速度
		}//if 
		else if( D走行速度 < 120.0){//Case Is
		}//else if
		else{//Case Else
			db.debugError("error:A06自然対面H20Class:A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "自然；変数入力；走行速度" & D走行速度
		}//else End Select
		//'変数代入
		GDトンネル延長 = Dトンネル延長;
		GDトンネル断面 = Dトンネル断面;
		GD代表寸法 = D代表寸法;
		GD設計交通量 = D設計交通量;
		GD大型車混入率 = D大型車混入率;
		GD走行速度 = D走行速度 * 1000.0 / 3600.0;
		db.debugPrint( "A06自然対面H20Class:A00変数設定：GD走行速度="+ GD走行速度);
		db.debugPrint( "A06自然対面H20Class:A00変数設定：D走行速度="+ D走行速度);
		db.debugPrint( "A06自然対面H20Class:A00変数設定：GDトンネル延長="+ GDトンネル延長);
		//'計算実行
		S00計算実行();
	/*A00変数設定
	'----------------------------------------
	'目的 変数入力
	'日付 080708
	'----------------------------------------
	Public Sub A00変数設定( _
		Dトンネル延長 As Double, _
		Dトンネル断面 As Double, _
		D代表寸法 As Double, _
		D設計交通量 As Double, _
		D大型車混入率 As Double, _
		D走行速度 As Double _
		)
		Dim i As Integer
		Dim ii As Integer
		'変数チェック
		Select Case Dトンネル延長
		Case Is < 20
		MsgBox "自然；変数入力；トンネル延長" & _
		Dトンネル延長
		Case Is < 7000
		Case Else
		MsgBox "自然；変数入力；トンネル断面" & _
		Dトンネル延長
		End Select
		Select Case Dトンネル断面
		Case Is < 20
		MsgBox "自然；変数入力；トンネル断面" & _
		Dトンネル断面
		Case Is < 100
		Case Else
		MsgBox "自然；変数入力；トンネル断面" & _
		Dトンネル断面
		End Select
		Select Case D代表寸法
		Case Is < 3
		MsgBox "自然；変数入力；D代表寸法" & _
		D代表寸法
		Case Is < 15
		Case Else
		MsgBox "自然；変数入力；トD代表寸法" & _
		D代表寸法
		End Select
		Select Case D設計交通量
		Case Is < 0
		MsgBox "自然；変数入力；設計交通量" & _
		D設計交通量
		Case Is < 4400
		Case Else
		MsgBox "自然；変数入力；設計交通量" & _
		D設計交通量
		End Select
		Select Case D大型車混入率
		Case Is < 0
		MsgBox "自然；変数入力；大型車" & _
		"混入率=" & D大型車混入率
		Case Is <= 1
		Case Else
		MsgBox "自然；変数入力；大型車" & _
		"混入率=" & D大型車混入率
		End Select
		Select Case D走行速度
		Case Is < 0
		MsgBox "自然；変数入力；走行速度" & _
		D走行速度
		Case Is < 120
		Case Else
		MsgBox "自然；変数入力；走行速度" & _
		D走行速度
		End Select
		'変数代入
		GDトンネル延長 = Dトンネル延長
		GDトンネル断面 = Dトンネル断面
		GD代表寸法 = D代表寸法
		GD設計交通量 = D設計交通量
		GD大型車混入率 = D大型車混入率
		GD走行速度 = D走行速度 * 1000 / 3600
		'計算実行
		S00計算実行
	End Sub*/
	}//A00変数設定
	private void S00計算実行(){
		S01自然換気力();
		S02通気抵抗();
		S03自動車等価抵抗面積();
		S04自動車存在台数();
		S05交通換気力();
		S06車道内風速();
		S07自然換気量();
	
	/*S00計算実行
	'------------------------------------
	'目的 計算実行
	'日付 080708
	'------------------------------------
	Private Sub S00計算実行()
		S01自然換気力
		S02通気抵抗
		S03自動車等価抵抗面積
		S04自動車存在台数
		S05交通換気力
		S06車道内風速
		S07自然換気量
		' '計算条件
		'  Debug.Print "<<対面>>"
		'  Debug.Print "GDトンネル延長"; GDトンネル延長
		'  Debug.Print "GDトンネル断面"; GDトンネル断面
		'  Debug.Print "GD代表寸法"; GD代表寸法
		'  Debug.Print "GD設計交通量"; GD設計交通量
		'  Debug.Print "GD大型車混入率"; GD大型車混入率
		'  Debug.Print "GD走行速度"; GD走行速度
		'  '計算結果
		'  Debug.Print "GD自動車存在台数"; GD自動車存在台数
	End Sub*/
	}//S00計算実行
	private void S01自然換気力(){
		GD自然換気力c
			= (1.0d 
			+ Cトンネル入口損失係数 
			+ Cトンネル壁面摩擦係数 * GDトンネル延長 / GD代表寸法)
			* C空気密度 / 2.0
			* Math.pow(C自然換気風速,2.0); 
		db.debugPrint("A06自然対面H20Class:S01自然換気力:GD自然換気力c=" + GD自然換気力c);
	/*S01自然換気力
	'----------------------------------------
	'目的 自然換気力計算 c
	'日付 080708
	'----------------------------------------
	Private Sub S01自然換気力()
		GD自然換気力c _
			= (1 + Cトンネル入口損失係数 _
			+ Cトンネル壁面摩擦係数 _
			* GDトンネル延長 / GD代表寸法) _
			* C空気密度 / 2 _
			* C自然換気風速 ^ 2
	End Sub*/
	}//S01自然換気力
	private void S02通気抵抗(){
		GD通気抵抗a
			= (1.0 + Cトンネル入口損失係数
			+ Cトンネル壁面摩擦係数
			* GDトンネル延長 / GD代表寸法)
			* C空気密度 / 2.0;
		db.debugPrint("A06自然対面H20Class:S02通気抵抗:GD通気抵抗a=" + GD通気抵抗a );
	/*S02通気抵抗
	'------------------------------------
	'目的 通気抵抗 a
	'日付 080708
	'------------------------------------
	Private Sub S02通気抵抗()
		GD通気抵抗a _
			= (1 + Cトンネル入口損失係数 _
			+ Cトンネル壁面摩擦係数 _
			* GDトンネル延長 / GD代表寸法) _
			* C空気密度 / 2
	End Sub*/
	}//S02通気抵抗
	private void S03自動車等価抵抗面積(){
		GD自動車等価抵抗面積
			= 0.78 + 9.1 / GDトンネル断面
			+ (4.21 + 137.0 / GDトンネル断面)
			* GD大型車混入率;
		db.debugPrint("A06自然対面H20Class:S02通気抵抗:GD自動車等価抵抗面積=" + GD自動車等価抵抗面積 );
	/*S03自動車等価抵抗面積
	'------------------------------------
	'目的 自動車等価抵抗面積
	'日付 030512
	'変更 080708
	'   技術基準の変更に伴う修正
	'------------------------------------
	Private Sub S03自動車等価抵抗面積()
		'  GD自動車等価抵抗面積 _
		'    = 0.8 + 41.9 / GDトンネル断面 _
		'    + (1.68 + 355 / GDトンネル断面) _
		'    * GD大型車混入率
		GD自動車等価抵抗面積 _
		= 0.78 + 9.1 / GDトンネル断面 _
		+ (4.21 + 137 / GDトンネル断面) _
		* GD大型車混入率
	End Sub*/
	}//S03自動車等価抵抗面積
	private void S04自動車存在台数(){
		GD自動車存在台数
			= GD設計交通量
			* GDトンネル延長
			/ 3600.0
			/ GD走行速度;
		db.debugPrint("A06自然対面H20Class:S02通気抵抗:GD自動車存在台数=" + GD自動車存在台数 );
	/*S04自動車存在台数
	'------------------------------------
	'目的 自動車等存在台数
	'日付 030512
	'------------------------------------
	Private Sub S04自動車存在台数()
		GD自動車存在台数 _
			= GD設計交通量 _
			* GDトンネル延長 _
			/ 3600 _
			/ GD走行速度
	End Sub*/
	}//S04自動車存在台数
	private void S05交通換気力(){
		GD交通換気力b
			= GD自動車等価抵抗面積
			/ GDトンネル断面
			* C空気密度 / 2.0
			* 2.0 * GD自動車存在台数
			* GD走行速度;
		db.debugPrint("A06自然対面H20Class:S02通気抵抗:GD交通換気力b=" + GD交通換気力b );
	/*S05交通換気力
	'------------------------------------
	'目的 交通換気力
	'日付 030512
	'------------------------------------
	Private Sub S05交通換気力()
		GD交通換気力b _
			= GD自動車等価抵抗面積 _
			/ GDトンネル断面 _
			* C空気密度 / 2 _
			* 2 * GD自動車存在台数 _
			* GD走行速度
	End Sub*/
	}//S05交通換気力
	private void S06車道内風速(){
		GD車道内風速
			= (-1.0 * GD交通換気力b
			+ Math.sqrt( Math.pow(GD交通換気力b , 2)
			+ 4.0 * GD通気抵抗a * GD自然換気力c))
			/ (2.0 * GD通気抵抗a);
		db.debugPrint("A06自然対面H20Class:S02通気抵抗:GD車道内風速=" + GD車道内風速 );
	/*S06車道内風速
	'------------------------------------
	'目的 車道内風速
	'日付 080708
	'------------------------------------
	Private Sub S06車道内風速()
		GD車道内風速 _
			= (-1 * GD交通換気力b _
			+ Sqr(GD交通換気力b ^ 2 _
			+ 4 * GD通気抵抗a * GD自然換気力c)) _
			/ (2 * GD通気抵抗a)
	End Sub*/
	}//S06車道内風速
	private void S07自然換気量(){
		GD自然換気量
			= GDトンネル断面
			* GD車道内風速;
		db.debugPrint("A06自然対面H20Class:S02通気抵抗:GD自然換気量=" + GD自然換気量 );
	/*S07自然換気量
	Private Sub S07自然換気量()
		GD自然換気量 _
			= GDトンネル断面 _
			* GD車道内風速
	End Sub*/
	}//S07自然換気量
	public double A01自然換気量(){
		double dx;
		dx = Math.round(GD自然換気量 * 10.0);
		dx = dx / 10.0;
		return dx;
	/*A01自然換気量
	'----------------------------------------
	'目的 計算結果出力
	'日付 080708
	'----------------------------------------
	Public Function A01自然換気量() As Double
		A01自然換気量 = Round(GD自然換気量, 1)
	End Function*/
	}//A01自然換気量
	/*A06自然対面H20Class
	VERSION 1.0 CLASS
	BEGIN
	MultiUse = -1  'True
	Persistable = 0  'NotPersistable
	DataBindingBehavior = 0  'vbNone
	DataSourceBehavior  = 0  'vbNone
	MTSTransactionMode  = 0  'NotAnMTSObject
	END
	Attribute VB_Name = "A06自然対面H20Class"
	Attribute VB_GlobalNameSpace = False
	Attribute VB_Creatable = True
	Attribute VB_PredeclaredId = False
	Attribute VB_Exposed = False
	Option Explicit
	'定数
	Const C屈曲 = 4
	Const Cトンネル入口損失係数 = 0.6
	Const Cトンネル壁面摩擦係数 = 0.025
	Const C空気密度 = 1.2
	Const C自然換気風速 = 2.5
	'入力変数
	Private GDトンネル延長 As Double
	Private GDトンネル断面 As Double
	Private GD代表寸法 As Double
	Private GD設計交通量 As Double
	Private GD大型車混入率 As Double
	Private GD走行速度 As Double
	'入力変数
	Private GDトンネル延長 As Double
	Private GDトンネル断面 As Double
	Private GD代表寸法 As Double
	Private GD設計交通量 As Double
	Private GD大型車混入率 As Double
	Private GD走行速度 As Double
	'計算変数
	Private GD自然換気力c As Double
	Private GD通気抵抗a As Double
	Private GD自動車等価抵抗面積 As Double
	Private GD自動車存在台数 As Double
	Private GD交通換気力b As Double
	Private GD車道内風速 As Double
	Private GD自然換気量 As Double
	'----------------------------------------
	'目的 変数入力
	'日付 080708
	'----------------------------------------
	Public Sub A00変数設定( _
	Dトンネル延長 As Double, _
	Dトンネル断面 As Double, _
	D代表寸法 As Double, _
	D設計交通量 As Double, _
	D大型車混入率 As Double, _
	D走行速度 As Double _
	)
	Dim i As Integer
	Dim ii As Integer
	'変数チェック
	Select Case Dトンネル延長
	Case Is < 20
	MsgBox "自然；変数入力；トンネル延長" & _
	Dトンネル延長
	Case Is < 7000
	Case Else
	MsgBox "自然；変数入力；トンネル断面" & _
	Dトンネル延長
	End Select
	Select Case Dトンネル断面
	Case Is < 20
	MsgBox "自然；変数入力；トンネル断面" & _
	Dトンネル断面
	Case Is < 100
	Case Else
	MsgBox "自然；変数入力；トンネル断面" & _
	Dトンネル断面
	End Select
	Select Case D代表寸法
	Case Is < 3
	MsgBox "自然；変数入力；D代表寸法" & _
	D代表寸法
	Case Is < 15
	Case Else
	MsgBox "自然；変数入力；トD代表寸法" & _
	D代表寸法
	End Select
	Select Case D設計交通量
	Case Is < 0
	MsgBox "自然；変数入力；設計交通量" & _
	D設計交通量
	Case Is < 4400
	Case Else
	MsgBox "自然；変数入力；設計交通量" & _
	D設計交通量
	End Select
	Select Case D大型車混入率
	Case Is < 0
	MsgBox "自然；変数入力；大型車" & _
	"混入率=" & D大型車混入率
	Case Is <= 1
	Case Else
	MsgBox "自然；変数入力；大型車" & _
	"混入率=" & D大型車混入率
	End Select
	Select Case D走行速度
	Case Is < 0
	MsgBox "自然；変数入力；走行速度" & _
	D走行速度
	Case Is < 120
	Case Else
	MsgBox "自然；変数入力；走行速度" & _
	D走行速度
	End Select
	'変数代入
	GDトンネル延長 = Dトンネル延長
	GDトンネル断面 = Dトンネル断面
	GD代表寸法 = D代表寸法
	GD設計交通量 = D設計交通量
	GD大型車混入率 = D大型車混入率
	GD走行速度 = D走行速度 * 1000 / 3600
	'計算実行
	S00計算実行
	End Sub
	'------------------------------------
	'目的 計算実行
	'日付 080708
	'------------------------------------
	Private Sub S00計算実行()
	S01自然換気力
	S02通気抵抗
	S03自動車等価抵抗面積
	S04自動車存在台数
	S05交通換気力
	S06車道内風速
	S07自然換気量
	' '計算条件
	'  Debug.Print "<<対面>>"
	'  Debug.Print "GDトンネル延長"; GDトンネル延長
	'  Debug.Print "GDトンネル断面"; GDトンネル断面
	'  Debug.Print "GD代表寸法"; GD代表寸法
	'  Debug.Print "GD設計交通量"; GD設計交通量
	'  Debug.Print "GD大型車混入率"; GD大型車混入率
	'  Debug.Print "GD走行速度"; GD走行速度
	'  '計算結果
	'  Debug.Print "GD自動車存在台数"; GD自動車存在台数
	End Sub
	'----------------------------------------
	'目的 自然換気力計算 c
	'日付 080708
	'----------------------------------------
	Private Sub S01自然換気力()
	GD自然換気力c _
	= (1 + Cトンネル入口損失係数 _
	+ Cトンネル壁面摩擦係数 _
	* GDトンネル延長 / GD代表寸法) _
	* C空気密度 / 2 _
	* C自然換気風速 ^ 2
	End Sub
	'------------------------------------
	'目的 通気抵抗 a
	'日付 080708
	'------------------------------------
	Private Sub S02通気抵抗()
	GD通気抵抗a _
	= (1 + Cトンネル入口損失係数 _
	+ Cトンネル壁面摩擦係数 _
	* GDトンネル延長 / GD代表寸法) _
	* C空気密度 / 2
	End Sub
	'------------------------------------
	'目的 自動車等価抵抗面積
	'日付 030512
	'変更 080708
	'   技術基準の変更に伴う修正
	'------------------------------------
	Private Sub S03自動車等価抵抗面積()
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
	Private Sub S04自動車存在台数()
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
	Private Sub S05交通換気力()
	GD交通換気力b _
	= GD自動車等価抵抗面積 _
	/ GDトンネル断面 _
	* C空気密度 / 2 _
	* 2 * GD自動車存在台数 _
	* GD走行速度
	End Sub
	'------------------------------------
	'目的 車道内風速
	'日付 080708
	'------------------------------------
	Private Sub S06車道内風速()
	GD車道内風速 _
	= (-1 * GD交通換気力b _
	+ Sqr(GD交通換気力b ^ 2 _
	+ 4 * GD通気抵抗a * GD自然換気力c)) _
	/ (2 * GD通気抵抗a)
	End Sub
	Private Sub S07自然換気量()
	GD自然換気量 _
	= GDトンネル断面 _
	* GD車道内風速
	End Sub
	*/
}//A06自然対面H20Class
