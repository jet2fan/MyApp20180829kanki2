package com.example.yo.myapp20180829kanki2;

public class A04速度Class{
	//'変数定義
	private double GD設計速度;			// As Double
	private double GD可能交通容量_乗用車;	// As Double
	private double GD設計交通量_乗用車;	// As Double
	//クラスの定義
	DebugPrint db = new DebugPrint();
	public void A00変数設定(
		double D可能交通量_乗用車,
		double D設計交通量_乗用車,
		double D設計速度 )
		{
		//'変数チェック
		if(D可能交通量_乗用車 < 0.0){
			db.debugError("error:A04速度Class:速度；変数設定；可能交通量=" + D可能交通量_乗用車);
		}else 
		if(D可能交通量_乗用車 <= 4400.0){
			db.debugPrint("A04速度Class:A00変数設定:D可能交通量_乗用車=" + D可能交通量_乗用車 );
		}else{
			db.debugError("error:A04速度Class:速度；変数設定；可能交通量=" + D可能交通量_乗用車 );
		}
		if(D設計交通量_乗用車 < 0.0){
			db.debugError("error:A04速度Class:速度；変数設定；D設計交通量_乗用車=" + D設計交通量_乗用車 );
		}else
		if(D設計交通量_乗用車 <=4400.0 ){
			db.debugPrint("A04速度Class:A00変数設定:D設計交通量_乗用車=" + D設計交通量_乗用車 );
		}else{
			db.debugError("error:A04速度Class:速度；変数設定；D設計交通量_乗用車=" + D設計交通量_乗用車 );
		}
		if(D設計速度 < 0.0){
			db.debugError("error:A04速度Class:速度；変数設定；D設計速度=" + D設計速度 );
		}else
		if(D設計速度 <=120.0){
			db.debugPrint("A04速度Class:A00変数設定:D設計速度=" + D設計速度 );
		}else{
			db.debugError("error:A04速度Class:速度；変数設定；D設計速度=" + D設計速度 );
		}
		//'変数設定
		GD設計速度 = D設計速度;
		GD可能交通容量_乗用車 = D可能交通量_乗用車;
		GD設計交通量_乗用車 = D設計交通量_乗用車;
		//'Debug
		db.debugPrint( "A04速度Class:＜速度：変数設定＞");
		db.debugPrint( "A04速度Class:1.設計速度="+ GD設計速度 );
		db.debugPrint( "A04速度Class:2.可能交通量="+ GD可能交通容量_乗用車 );
		db.debugPrint( "A04速度Class:3.設計交通量="+ GD設計交通量_乗用車 );
		/*A00変数設定'---------------------
		'目的 設計変数設定
		'日付 030507
		'---------------------
		Public Sub A00変数設定( _
		  D可能交通量_乗用車 As Double, _
		  D設計交通量_乗用車 As Double, _
		  D設計速度 As Double)
		'変数チェック
		  Select Case D可能交通量_乗用車
		    Case Is < 0
		      MsgBox "速度；変数設定；可能交通量=" & _
		        D可能交通量_乗用車
		    Case Is <= 4400
		    Case Else
		      MsgBox "速度；変数設定；可能交通量=" & _
		        D可能交通量_乗用車
		  End Select
		  Select Case D設計交通量_乗用車
		    Case Is < 0
		      MsgBox "速度；変数設定；設計交通量=" & _
		        D設計交通量_乗用車
		    Case Is < 4400
		    Case Else
		      MsgBox "速度；変数設定；設計交通量=" & _
		        D設計交通量_乗用車
		  End Select
		  Select Case D設計速度
		    Case Is < 0
		      MsgBox "速度；設計設定；設計速度=" & _
		        D設計速度
		    Case Is <= 120
		    Case Else
		      MsgBox "速度；設計設定；設計速度=" & _
		        D設計速度
		  End Select
		'変数設定
		  GD設計速度 = D設計速度
		  GD可能交通容量_乗用車 = D可能交通量_乗用車
		  GD設計交通量_乗用車 = D設計交通量_乗用車
		'Debug
		'  Debug.Print "＜速度：変数設定＞"
		'  Debug.Print "1.設計速度="; GD設計速度
		'  Debug.Print "2.可能交通量="; GD可能交通容量_乗用車
		'  Debug.Print "3.設計交通量="; GD設計交通量_乗用車
		End Sub */
	}//A00変数設定
	public double F01走行速度(){
		if(GD設計速度 < 0.0){
			db.debugError("error:A04速度Class:速度；F01走行速度；GD設計速度=" + GD設計速度);
		}else
		if(GD設計速度 <=60.0){
			return Math.round(F02走行速度_60( GD設計交通量_乗用車));
		}
		if(GD設計速度 <=120.0){
			return Math.round(F02走行速度_80( GD設計交通量_乗用車));
		}else{	
			db.debugError("error:A04速度Class:速度；F01走行速度；GD設計速度=" + GD設計速度);
		} 
		return 0.0;
		/*F01走行速度
		 '---------------------
		'目的 走行速度
		'日付 030507
		'---------------------
		Public Function F01走行速度() As Double
		  Select Case GD設計速度
		    Case Is < 0
		      MsgBox "速度；走行速度；設計速度=" & _
		        GD設計速度
		    Case Is <= 60
		      F01走行速度 = Round(F02走行速度_60( GD設計交通量_乗用車), 1)
		    Case Is <= 120
		      F01走行速度 = Round(F02走行速度_80( GD設計交通量_乗用車), 1)
		    Case Else
		      MsgBox "速度；走行速度；設計速度=" & _
		        GD設計速度
		  End Select
		End Function*/
	}//F01走行速度()
	private double F02走行速度_60(double D交通量){
		double D交通量比;// As Double
		double D速度低減率;// As Double
		//'計算開始
		D交通量比 = D交通量 / GD可能交通容量_乗用車;
		if(D交通量比 <0.0 ){
			db.debugError("error:A04速度Class:速度；F02走行速度_60；D交通量比=" + D交通量比);
			D速度低減率 = 5.0;
		}else
		if(D交通量比 <1){
		      D速度低減率
				= 0.99994323 
				- 0.37924201 	* Math.pow(D交通量比,1) 
				+ 0.7140742 	* Math.pow(D交通量比,2) 
				- 0.73572551 	* Math.pow(D交通量比,3);
		}else
		if(D交通量比 <3){
			db.debugError("error:A04速度Class:速度；F02走行速度_60；D交通量比=" + D交通量比);
			db.debugPrint("A04速度Class:交通量比を1.0として計算を続けます。");		
		    D速度低減率 = 0.6;
		    //D交通量比 = 1.0;
		}else{
			db.debugError("error:A04速度Class:速度；F02走行速度_60；D交通量比=" + D交通量比);
			D速度低減率 = 5.0;	
		}
		return GD設計速度 * D速度低減率 ;
		/*F02走行速度_60'---------------------
		'目的 走行速度(60)
		'日付 030507
		'---------------------
		Private Function F02走行速度_60( _
		  D交通量 As Double) As Double
		  Dim D交通量比 As Double
		  Dim D速度低減率 As Double
		  '計算開始
		  D交通量比 = D交通量 / GD可能交通容量_乗用車
		  Select Case D交通量比
		    Case Is < 0
		      MsgBox "速度；走行速度60；交通量比=" & D交通量比
		    Case Is < 1
		      D速度低減率 = _
		       0.99994323 _
		       - 0.37924201 * D交通量比 ^ 1 _
		       + 0.7140742 * D交通量比 ^ 2 _
		       - 0.73572551 * D交通量比 ^ 3
		    Case Is < 3
		      MsgBox "速度；走行速度60；交通量比=" & D交通量比
		      MsgBox "交通量比を1.0として計算を続けます。"
		      D速度低減率 = 0.6
		    Case Else
		      MsgBox "速度；走行速度60；交通量比=" & D交通量比
		  End Select
		  F02走行速度_60 = GD設計速度 * D速度低減率
		End Function*/
	}//F02走行速度_60
	private double F02走行速度_80(double D交通量){
		double D交通量比; 	//As Double
		double D速度低減率; //As Double
		//'計算開始
		D交通量比 = D交通量 / GD可能交通容量_乗用車;
		if(D交通量比 <0.0 ){
			db.debugError("error:A04速度Class:速度；F02走行速度_80；D交通量比=" + D交通量比);
			db.debugError("error:A04速度Class:速度；F02走行速度_80；D交通量=" + D交通量);
			D速度低減率 = 5.0;
		}else
		if(D交通量比 <1.0){
		      D速度低減率
				= 1.000062
				- 0.4151829 	* Math.pow(D交通量比,1)
				+ 0.8381227 	* Math.pow(D交通量比,2)
				- 0.8820062 	* Math.pow(D交通量比,3);
		}else
		if(D交通量比 <3.0){
			db.debugError("error:A04速度Class:速度；F02走行速度_80；D交通量比=" + D交通量比);
			db.debugPrint("A04速度Class:交通量比を1.0として計算を続けます。");		
		    D速度低減率 = 0.55;
			db.debugPrint("A04速度Class:D速度低減率を0.55として計算を続けます。");				    
		}else{
			db.debugError("error:A04速度Class:速度；F02走行速度_60；D交通量比=" + D交通量比);
			D速度低減率 = 5.0;	
		}
		return GD設計速度 * D速度低減率 ;
		/*F02走行速度_80
		'---------------------
		'目的 走行速度(80)
		'日付 030507
		'---------------------
		Private Function F02走行速度_80( _
		  D交通量 As Double) As Double
		  Dim D交通量比 As Double
		  Dim D速度低減率 As Double
		  '計算開始
		  D交通量比 = D交通量 / GD可能交通容量_乗用車
		  Select Case D交通量比
		    Case Is < 0
		      MsgBox "速度；走行速度80；交通量比=" & D交通量比
		    Case Is < 1
		      D速度低減率 = _
		       1.000062 _
		       - 0.4151829 * D交通量比 ^ 1 _
		       + 0.8381227 * D交通量比 ^ 2 _
		       - 0.8820062 * D交通量比 ^ 3
		    Case Is < 3
		      MsgBox "速度；走行速度80；交通量比=" & D交通量比
		      MsgBox "計画交通量が大きいため、" & _
		        "設計時間交通量が可能交通容量以上です。" & _
		      "交通量比を1.0として計算を続けます。"
		      D速度低減率 = 0.55
		    Case Else
		      MsgBox "速度；走行速度80；交通量比=" & D交通量比
		  End Select
		  F02走行速度_80 = GD設計速度 * D速度低減率
		End Function*/			
	}//F02走行速度_80
}//A04速度Class
/*VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "A04速度Class"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit
*/
