package com.example.yo.myapp20180829kanki2;

public class A06自然一方H20Class{
	//クラスの定義
	DebugPrint db = new DebugPrint();
	// 定数;
	final double Cトンネル入口損失係数 = 0.6d;//Const
	final double Cトンネル壁面摩擦係数 = 0.025d;
	final double C空気密度 = 1.2d;
	final double C自然換気風速 = 2.5d;
	// 入力変数;
	private double GDトンネル延長 ;
	private double GDトンネル断面 ;
	private double GD代表寸法 ;
	private double GD設計交通量 ;
	private double GD大型車混入率 ;
	private double GD走行速度 ;
	// 計算変数;
	private double  GD自動車等価抵抗面積 ;
	private double  GD自動車存在台数 ;
	private double  GD係数α ;
	private double  GD車道内風速 ;
	private double  GD自然換気量 ;
	public void A00変数設定(//変数設定
		double  Dトンネル延長 ,
		double  Dトンネル断面 ,
		double  D代表寸法 ,
		double  D設計交通量 ,
		double  D大型車混入率 ,
		double  D走行速度 )
		{//実行
		int  i ;
		int  ii ;
		// 変数チェック;
		//Select Case Dトンネル延長;
		if( Dトンネル延長 < 20.0){
			db.debugError("error:A06自然一方H20Class:A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "自然；変数入力；トンネル延長" & Dトンネル延長;
		}//if
		else if( Dトンネル延長 < 7000.0){
		}//else if
		else {
			db.debugError("error:A06自然一方H20Class:A00変数設定：Dトンネル延長=" + Dトンネル延長);
			//MsgBox "自然；変数入力；トンネル断面" & Dトンネル延長;
		}//else End Select;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:Dトンネル延長="+ Dトンネル延長);
		//Select Case Dトンネル断面;
		if( Dトンネル断面 < 20.0){
			db.debugError("error:A06自然一方H20Class:A00変数設定：Dトンネル断面=" + Dトンネル断面);
		    //MsgBox "自然；変数入力；トンネル断面" & Dトンネル断面;
		}//if
		else if( Dトンネル断面 < 100.0){
		}//else if
		else{
			db.debugError("error:A06自然一方H20Class:A00変数設定：Dトンネル断面=" + Dトンネル断面);
		    //MsgBox "自然；変数入力；トンネル断面" & Dトンネル断面;
		}//else End Select;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:Dトンネル断面="+ Dトンネル断面);
		//Select Case D代表寸法;
	    if( D代表寸法< 3.0){
			db.debugError("error:A06自然一方H20Class:A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "自然；変数入力；D代表寸法" & D代表寸法;
	    }//if
	    else if( D代表寸法< 15.0){
	    }//
	    else{
			db.debugError("error:A06自然一方H20Class:A00変数設定：D代表寸法=" + D代表寸法);
			//MsgBox "自然；変数入力；トD代表寸法" & D代表寸法;
		}//End Select;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:D代表寸法="+ D代表寸法);
		//Select Case D設計交通量;
	    if( D設計交通量< 0.0){
			db.debugError("error:A06自然一方H20Class:A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "自然；変数入力；設計交通量" & D設計交通量;
	    }
	    else if( D設計交通量< 4400.0){
	    } 
	    else {
			db.debugError("error:A06自然一方H20Class:A00変数設定：D設計交通量=" + D設計交通量);
			//MsgBox "自然；変数入力；設計交通量" & D設計交通量;
		}//End Select;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:D設計交通量="+ D設計交通量);
		//Select Case D大型車混入率;
	    if( D大型車混入率 < 0.0){
			db.debugError("error:A06自然一方H20Class:A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "自然；変数入力；大型車" & "混入率=" & D大型車混入率;
	    }
	    else if( D大型車混入率 <= 1.0){
	    } 
	    else {
			db.debugError("error:A06自然一方H20Class:A00変数設定：D大型車混入率=" + D大型車混入率);
			//MsgBox "自然；変数入力；大型車" & "混入率=" & D大型車混入率;
		}//End Select;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:D大型車混入率="+ D大型車混入率);
		//Select Case D走行速度;
	    if( D走行速度< 0.0){
			db.debugError("error:A06自然一方H20Class:A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "自然；変数入力；走行速度" & D走行速度;
	    }
	    else if( D走行速度< 120.0){
	    }
	    else{
			db.debugError("error:A06自然一方H20Class:A00変数設定：D走行速度=" + D走行速度);
			//MsgBox "自然；変数入力；走行速度" & D走行速度;
		}//End Select;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:D走行速度="+ D走行速度);
		// 変数代入;
	    GDトンネル延長 = Dトンネル延長;
	    GDトンネル断面 = Dトンネル断面;
	    GD代表寸法 = D代表寸法;
	    GD設計交通量 = D設計交通量;
	    GD大型車混入率 = D大型車混入率;
	    GD走行速度 = D走行速度 * 1000.0 / 3600.0;
		db.debugPrint( "A06自然一方H20Class:A00変数設定:GD走行速度="+ GD走行速度);
		// 計算実行;
		S00計算実行();
		/*A00変数設定
	// ----------------------------------------;
	// 目的 変数入力;
	// 日付 080708;
	// ----------------------------------------;
	Public Sub A00変数設定( _;
	  Dトンネル延長 As Double, _;
	  Dトンネル断面 As Double, _;
	  D代表寸法 As Double, _;
	  D設計交通量 As Double, _;
	  D大型車混入率 As Double, _;
	  D走行速度 As Double _;
	  );
	  int  i ;
	  int  ii ;
	// 変数チェック;
	  Select Case Dトンネル延長;
	    Case Is < 20;
	      MsgBox "自然；変数入力；トンネル延長" & _;
	        Dトンネル延長;
	    Case Is < 7000;
	    Case } else {
	      MsgBox "自然；変数入力；トンネル断面" & _;
	        Dトンネル延長;
	  End Select;
	  Select Case Dトンネル断面;
	    Case Is < 20;
	      MsgBox "自然；変数入力；トンネル断面" & _;
	        Dトンネル断面;
	    Case Is < 100;
	    Case } else {
	      MsgBox "自然；変数入力；トンネル断面" & _;
	        Dトンネル断面;
	  End Select;
	  Select Case D代表寸法;
	    Case Is < 3;
	      MsgBox "自然；変数入力；D代表寸法" & _;
	        D代表寸法;
	    Case Is < 15;
	    Case } else {
	      MsgBox "自然；変数入力；トD代表寸法" & _;
	        D代表寸法;
	  End Select;
	  Select Case D設計交通量;
	    Case Is < 0;
	      MsgBox "自然；変数入力；設計交通量" & _;
	        D設計交通量;
	    Case Is < 4400;
	    Case } else {
	      MsgBox "自然；変数入力；設計交通量" & _;
	        D設計交通量;
	  End Select;
	  Select Case D大型車混入率;
	    Case Is < 0;
	      MsgBox "自然；変数入力；大型車" & _;
	        "混入率=" & D大型車混入率;
	    Case Is <= 1;
	    Case } else {
	      MsgBox "自然；変数入力；大型車" & _;
	        "混入率=" & D大型車混入率;
	  End Select;
	  Select Case D走行速度;
	    Case Is < 0;
	      MsgBox "自然；変数入力；走行速度" & _;
	        D走行速度;
	    Case Is < 120;
	    Case } else {
	      MsgBox "自然；変数入力；走行速度" & _;
	        D走行速度;
	  End Select;
	  // 変数代入;
	    GDトンネル延長 = Dトンネル延長;
	    GDトンネル断面 = Dトンネル断面;
	    GD代表寸法 = D代表寸法;
	    GD設計交通量 = D設計交通量;
	    GD大型車混入率 = D大型車混入率;
	    GD走行速度 = D走行速度 * 1000 / 3600;
	// 計算実行;
	 S00計算実行;
	End Sub;*/
	}//A00変数設定
	private void S00計算実行(){
		S01自動車等価抵抗面積();
		S02自動車存在台数();
		S03係数α();
		S04車道内風速();
		S05自然換気量();
		db.debugPrint("A06自然一方H20Class:<<自然換気 一方通行>>");
		db.debugPrint("A06自然一方H20Class:GDトンネル延長"+ GDトンネル延長);
		db.debugPrint("A06自然一方H20Class:GDトンネル断面"+ GDトンネル断面);
		db.debugPrint("A06自然一方H20Class:GD代表寸法"+ GD代表寸法);
		db.debugPrint("A06自然一方H20Class:GD設計交通量"+ GD設計交通量);
		db.debugPrint("A06自然一方H20Class:GD大型車混入率"+ GD大型車混入率);
		db.debugPrint("A06自然一方H20Class:GD走行速度"+ GD走行速度);
		db.debugPrint("A06自然一方H20Class:GD自動車等価抵抗面積"+ GD自動車等価抵抗面積);
		db.debugPrint("A06自然一方H20Class:GD自動車存在台数"+ GD自動車存在台数);
		db.debugPrint("A06自然一方H20Class:GD係数α"+ GD係数α);
		db.debugPrint("A06自然一方H20Class:GD車道内風速"+ GD車道内風速);
		db.debugPrint("A06自然一方H20Class:GD自然換気量"+ GD自然換気量);
		db.debugPrint( " ");
	/*S00計算実行
	// ------------------------------------;
	// 目的 計算実行;
	// 日付 080708;
	// ------------------------------------;
	Private Sub S00計算実行();
	  S01自動車等価抵抗面積;
	  S02自動車存在台数;
	  S03係数α;
	  S04車道内風速;
	  S05自然換気量;
	//   // debug;
	//   // 計算条件;
	//   Debug.Print "<<一方>>";
	//   Debug.Print "GDトンネル延長"; GDトンネル延長;
	//   Debug.Print "GDトンネル断面"; GDトンネル断面;
	//   Debug.Print "GD代表寸法"; GD代表寸法;
	//   Debug.Print "GD設計交通量"; GD設計交通量;
	//   Debug.Print "GD大型車混入率"; GD大型車混入率;
	//   Debug.Print "GD走行速度"; GD走行速度;
	//   // 計算結果;
	//   Debug.Print "GD自動車等価抵抗面積"; GD自動車等価抵抗面積;
	//   Debug.Print "GD自動車存在台数"; GD自動車存在台数;
	//   Debug.Print "GD係数α"; GD係数α;
	//   Debug.Print "GD車道内風速"; GD車道内風速;
	//   Debug.Print "GD自然換気量"; GD自然換気量;
	End Sub;*/
	}//S00計算実行
	private void S01自動車等価抵抗面積(){
		GD自動車等価抵抗面積
		    = 0.78 + 9.1 / GDトンネル断面
		    + (4.21 + 137.0 / GDトンネル断面)
		    * GD大型車混入率;
		//db.debugPrint( "A06自然一方H20Class:S01自動車等価抵抗面積:GD自動車等価抵抗面積="+ GD自動車等価抵抗面積);
	/*S01自動車等価抵抗面積
	// ------------------------------------;
	// 目的 自動車等価抵抗面積;
	// 日付 030512;
	// 変更 080708;
	//    技術基準の変更に伴う修正;
	// ------------------------------------;
	Private Sub S01自動車等価抵抗面積();
	//   GD自動車等価抵抗面積 _;
	//     = 0.8 + 41.9 / GDトンネル断面 _;
	//     + (1.68 + 355 / GDトンネル断面) _;
	//     * GD大型車混入率;
	  GD自動車等価抵抗面積 _;
	    = 0.78 + 9.1 / GDトンネル断面 _;
	    + (4.21 + 137 / GDトンネル断面) _;
	    * GD大型車混入率;
	End Sub;*/
	}//S01自動車等価抵抗面積
	private void S02自動車存在台数(){
		GD自動車存在台数
		    = GD設計交通量
		    * GDトンネル延長 / 3600.0
		    / GD走行速度;
		//db.debugPrint( "A06自然一方H20Class:S02自動車存在台数:GD自動車存在台数="+ GD自動車存在台数);
	/*S02自動車存在台数
	// ------------------------------------;
	// 目的 自動車等存在台数;
	// 日付 030512;
	// ------------------------------------;
	Private Sub S02自動車存在台数();
	  GD自動車存在台数 _;
	    = GD設計交通量 _;
	    * GDトンネル延長 _;
	    / 3600 _;
	    / GD走行速度;
	End Sub;*/
	}//S02自動車存在台数
	private void S03係数α(){
		GD係数α
		    = (GD自動車等価抵抗面積 / GDトンネル断面) 
		    * GD自動車存在台数
		    / (1.0 + Cトンネル入口損失係数
		    + Cトンネル壁面摩擦係数
		    * GDトンネル延長
		    / GD代表寸法);	
		//db.debugPrint( "A06自然一方H20Class:S03係数α:GD係数α="+ GD係数α);
	/*S03係数α
	// ----------------------------------------;
	// 目的 自然換気力計算 c;
	// 日付 080708;
	// ----------------------------------------;
	Private Sub S03係数α();
	  GD係数α _;
	    = (GD自動車等価抵抗面積 / GDトンネル断面) _;
	    * GD自動車存在台数 _;
	    / (1 + Cトンネル入口損失係数 _;
	    + Cトンネル壁面摩擦係数 _;
	    * GDトンネル延長 _;
	    / GD代表寸法);
	End Sub;*/
	}//S03係数α
	private void S04車道内風速(){
		GD車道内風速
			= 1.0 / (1.0 - GD係数α)
			* (Math.sqrt(GD係数α - (1.0 - GD係数α) * Math.pow((C自然換気風速 / GD走行速度),2.0)) - GD係数α)
			* GD走行速度;
		//db.debugPrint( "A06自然一方H20Class:S04車道内風速:GD車道内風速="+ GD車道内風速);
	/*S04車道内風速()
	// ------------------------------------;
	// 目的 車道内風速;
	// 日付 080709;
	// ------------------------------------;
	Private Sub S04車道内風速();
	  GD車道内風速 _;
	    = 1 / (1 - GD係数α) _;
	    * (Sqr(GD係数α _;
	    - (1 - GD係数α) _;
	    * (C自然換気風速 / GD走行速度) ^ 2) _;
	    - GD係数α) _;
	    * GD走行速度;
	End Sub;*/
	}//S04車道内風速
	private void S05自然換気量(){
		GD自然換気量
			= GDトンネル断面
			* GD車道内風速;
		//db.debugPrint( "A06自然一方H20Class:S05自然換気量:GD自然換気量="+ GD自然換気量);
	/*S05自然換気量
	// ------------------------------------;
	// 目的 自然換気量;
	// 日付 080708;
	// ------------------------------------;
	Private Sub S05自然換気量();
	  GD自然換気量 _;
	    = GDトンネル断面 _;
	    * GD車道内風速;
	End Sub;*/

	}//S05自然換気量
	public double A01自然換気量() {
		double dx;
		dx = Math.round(GD自然換気量 * 10.0);
		dx = dx / 10.0;
		return dx;
	/*/ ----------------------------------------;
	// 目的 計算結果出力;
	// 日付 080708;
	// ----------------------------------------;
	Public Function A01自然換気量() As Double;
	A01自然換気量 = Round(GD自然換気量, 1);
	End Function;*/
	}//A01自然換気量
/*A06自然一方H20Class
	// 定数;
	Const Cトンネル入口損失係数 = 0.6;
	Const Cトンネル壁面摩擦係数 = 0.025;
	Const C空気密度 = 1.2;
	Const C自然換気風速 = 2.5;
	// 入力変数;
	Private GDトンネル延長 As Double;
	Private GDトンネル断面 As Double;
	Private GD代表寸法 As Double;
	Private GD設計交通量 As Double;
	Private GD大型車混入率 As Double;
	Private GD走行速度 As Double;
	// 計算変数;
	Private GD自動車等価抵抗面積 As Double;
	Private GD自動車存在台数 As Double;
	Private GD係数α As Double;
	Private GD車道内風速 As Double;
	Private GD自然換気量 As Double;
	// ----------------------------------------;
	// 目的 変数入力;
	// 日付 080708;
	// ----------------------------------------;
	Public Sub A00変数設定( _;
	  Dトンネル延長 As Double, _;
	  Dトンネル断面 As Double, _;
	  D代表寸法 As Double, _;
	  D設計交通量 As Double, _;
	  D大型車混入率 As Double, _;
	  D走行速度 As Double _;
	  );
	  int  i ;
	  int  ii ;
	// 変数チェック;
	  Select Case Dトンネル延長;
	    Case Is < 20;
	      MsgBox "自然；変数入力；トンネル延長" & _;
	        Dトンネル延長;
	    Case Is < 7000;
	    Case } else {
	      MsgBox "自然；変数入力；トンネル断面" & _;
	        Dトンネル延長;
	  End Select;
	  Select Case Dトンネル断面;
	    Case Is < 20;
	      MsgBox "自然；変数入力；トンネル断面" & _;
	        Dトンネル断面;
	    Case Is < 100;
	    Case } else {
	      MsgBox "自然；変数入力；トンネル断面" & _;
	        Dトンネル断面;
	  End Select;
	  Select Case D代表寸法;
	    Case Is < 3;
	      MsgBox "自然；変数入力；D代表寸法" & _;
	        D代表寸法;
	    Case Is < 15;
	    Case } else {
	      MsgBox "自然；変数入力；トD代表寸法" & _;
	        D代表寸法;
	  End Select;
	  Select Case D設計交通量;
	    Case Is < 0;
	      MsgBox "自然；変数入力；設計交通量" & _;
	        D設計交通量;
	    Case Is < 4400;
	    Case } else {
	      MsgBox "自然；変数入力；設計交通量" & _;
	        D設計交通量;
	  End Select;
	  Select Case D大型車混入率;
	    Case Is < 0;
	      MsgBox "自然；変数入力；大型車" & _;
	        "混入率=" & D大型車混入率;
	    Case Is <= 1;
	    Case } else {
	      MsgBox "自然；変数入力；大型車" & _;
	        "混入率=" & D大型車混入率;
	  End Select;
	  Select Case D走行速度;
	    Case Is < 0;
	      MsgBox "自然；変数入力；走行速度" & _;
	        D走行速度;
	    Case Is < 120;
	    Case } else {
	      MsgBox "自然；変数入力；走行速度" & _;
	        D走行速度;
	  End Select;
	  // 変数代入;
	    GDトンネル延長 = Dトンネル延長;
	    GDトンネル断面 = Dトンネル断面;
	    GD代表寸法 = D代表寸法;
	    GD設計交通量 = D設計交通量;
	    GD大型車混入率 = D大型車混入率;
	    GD走行速度 = D走行速度 * 1000 / 3600;
	// 計算実行;
	 S00計算実行;
	End Sub;
	// ----------------------------------------;
	// 目的 計算結果出力;
	// 日付 080708;
	// ----------------------------------------;
	Public Function A01自然換気量() As Double;
	    A01自然換気量 = Round(GD自然換気量, 1);
	End Function;
	// ＜＜＜＜計算開始＞＞＞＞;
	// ------------------------------------;
	// 目的 自動車等価抵抗面積;
	// 日付 030512;
	// 変更 080708;
	//    技術基準の変更に伴う修正;
	// ------------------------------------;
	Private Sub S01自動車等価抵抗面積();
	//   GD自動車等価抵抗面積 _;
	//     = 0.8 + 41.9 / GDトンネル断面 _;
	//     + (1.68 + 355 / GDトンネル断面) _;
	//     * GD大型車混入率;
	  GD自動車等価抵抗面積 _;
	    = 0.78 + 9.1 / GDトンネル断面 _;
	    + (4.21 + 137 / GDトンネル断面) _;
	    * GD大型車混入率;
	End Sub;
	// ------------------------------------;
	// 目的 自動車等存在台数;
	// 日付 030512;
	// ------------------------------------;
	Private Sub S02自動車存在台数();
	  GD自動車存在台数 _;
	    = GD設計交通量 _;
	    * GDトンネル延長 _;
	    / 3600 _;
	    / GD走行速度;
	End Sub;
	// ----------------------------------------;
	// 目的 自然換気力計算 c;
	// 日付 080708;
	// ----------------------------------------;
	Private Sub S03係数α();
	  GD係数α _;
	    = (GD自動車等価抵抗面積 / GDトンネル断面) _;
	    * GD自動車存在台数 _;
	    / (1 + Cトンネル入口損失係数 _;
	    + Cトンネル壁面摩擦係数 _;
	    * GDトンネル延長 _;
	    / GD代表寸法);
	End Sub;
	// ------------------------------------;
	// 目的 車道内風速;
	// 日付 080709;
	// ------------------------------------;
	Private Sub S04車道内風速();
	  GD車道内風速 _;
	    = 1 / (1 - GD係数α) _;
	    * (Sqr(GD係数α _;
	    - (1 - GD係数α) _;
	    * (C自然換気風速 / GD走行速度) ^ 2) _;
	    - GD係数α) _;
	    * GD走行速度;
	End Sub;
	// ------------------------------------;
	// 目的 自然換気量;
	// 日付 080708;
	// ------------------------------------;
	Private Sub S05自然換気量();
	  GD自然換気量 _;
	    = GDトンネル断面 _;
	    * GD車道内風速;
	End Sub;
	// ------------------------------------;
	// 目的 計算実行;
	// 日付 080708;
	// ------------------------------------;
	Private Sub S00計算実行();
	  S01自動車等価抵抗面積;
	  S02自動車存在台数;
	  S03係数α;
	  S04車道内風速;
	  S05自然換気量;
	//   // debug;
	//   // 計算条件;
	//   Debug.Print "<<一方>>";
	//   Debug.Print "GDトンネル延長"; GDトンネル延長;
	//   Debug.Print "GDトンネル断面"; GDトンネル断面;
	//   Debug.Print "GD代表寸法"; GD代表寸法;
	//   Debug.Print "GD設計交通量"; GD設計交通量;
	//   Debug.Print "GD大型車混入率"; GD大型車混入率;
	//   Debug.Print "GD走行速度"; GD走行速度;
	//   // 計算結果;
	//   Debug.Print "GD自動車等価抵抗面積"; GD自動車等価抵抗面積;
	//   Debug.Print "GD自動車存在台数"; GD自動車存在台数;
	//   Debug.Print "GD係数α"; GD係数α;
	//   Debug.Print "GD車道内風速"; GD車道内風速;
	//   Debug.Print "GD自然換気量"; GD自然換気量;
End Sub;
*/
}//A06自然一方H20Class
