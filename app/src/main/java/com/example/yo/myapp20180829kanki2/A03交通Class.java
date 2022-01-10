package com.example.yo.myapp20180829kanki2;
public class A03交通Class{
	//'定数
	final double C対面通行 = 2500;//Const  'pcu/h 基本交通量(対面通行)
	final double C一方通行 = 2200;//Const  'pcu/h 基本交通量(一方通行)
	final double dD = 60;		//Const  '重方向交通量
	//入力変数
	private double T;			// As Double '%大型車混入率
	private String S交通方式;	// As String
	private String S区分;		// As String '道路区分(第1種)
	private String S地域;		// As String '道路の存する地域(地方部・都市部)
	private String S地形;		// As String '道路の存する地域の地形(山地部・平地部)
	private String S沿道;		// As String '沿道状況
	private double D幅員;		// As Double 'm 道路幅員
	private double D余裕;		// As Double 'm 側方余裕
	private double D勾配;		// As Double '道路勾配
	private double D計画交通量;// As Double '台/日
	//クラスの定義
	DebugPrint db = new DebugPrint();
	//メソッド
	public static void main(String[] args){  //9//0
	}//main()
	public void  S00変数設定(//変数設定
	/*'コメント---------------------
	'目的 変数の設定
	'日付 030501
	'---------------------*/
		String kS交通方式,		// As String, _
		String kS区分,			// As String, _
		String kS地域,			// As String, _
		String kS地形,			// As String, _
		String kS沿道,			// As String, _
		double kD幅員,			// As Double, _
		double kD余裕,			// As Double, _
		double kD勾配,			// As Double, _
		double kD大型車混入率,	// As Double, _
		double kD計画交通量)
		{ 	// 実行 As Double
		//'S変数チェック
		if( !(kS交通方式.equals("対面通行")) && !(kS交通方式.equals("一方通行")) ){// Then	
			db.debugError("error:A03交通class;変数設定；交通方式に入力されている値が適切でない"); //MsgBox
		}//End If
		if(	!(kS区分.equals("第1種")) && !(kS区分.equals("第2種")) && !(kS区分.equals("第3種")) && !(kS区分.equals("第4種")) ){// Then
			db.debugError("error:A03交通量Class;変数設定で道路区分の設定が解釈出来ません");//MsgBox
		}//End If
		if(	!(kS地域.equals("地方部")) && !(kS地域.equals("都市部"))	){// Then
			db.debugError("error:A03交通量Class;地域変数設定の解釈ができません");//MsgBox
		}//End If
		if(	!(kS地形.equals("平地部")) && !(kS地形.equals("山地部")) && !(kS地形.equals("都市部")) ){// Then
			db.debugError("error:A03交通量Class;地形変数設定が解釈不能");//MsgBox
		}//End If
		if(	!(kS沿道.equals("市街化していない地域")) && !(kS沿道.equals("幾分市街化している地域")) && !(kS沿道.equals("市街化している地域")) ){// Then
			db.debugError("error:A03交通量class;沿道状況の変数設定に問題あり");//MsgBox
		}//End If
		if((kD幅員 < 0.0) || (kD幅員 > 5.0)){// Then
			db.debugError("error:A03交通量class;道路幅の設定がおかしい");//MsgBox
		}//End If
		if((kD余裕 < 0) || (kD余裕 > 2)){// Then
			db.debugError("error:A03交通量class；側方余裕の値に問題あり");//MsgBox
		}//End If
		if((kD勾配 < 0) || (kD勾配 > 3)){// Then
			db.debugError("error:A03交通量class；勾配補正係数の値が規定値の範囲外です。");//MsgBox
		}//End If
		if((kD大型車混入率 < 0) || (kD大型車混入率 > 1)){// Then
			db.debugError("error:A03交通量class:大型車混入率の値が範囲外です");//MsgBox
		}//End If
		if(kD計画交通量 < 0){// Then
			db.debugError("error:A03交通量class:計画交通量がマイナスです");//MsgBox
		}//End If
		//'変数代入
		S交通方式 = kS交通方式;
		S区分 = kS区分;
		S地域 = kS地域;
		S地形 = kS地形;
		S沿道 = kS沿道;
		D幅員 = kD幅員;
		D余裕 = kD余裕;
		D勾配 = kD勾配;
		T = kD大型車混入率 * 100;
		D計画交通量 = kD計画交通量;
		//''変数表示
		db.debugPrint("A03交通量class:S00変数設定:＜交通：変数設定＞");		//'  Debug.Print 
		db.debugPrint("A03交通量class:S00変数設定:1.区分= "+ S区分);		//'  Debug.Print  '1
		db.debugPrint("A03交通量class:S00変数設定:2.地域= "+ S地域);		//'  Debug.Print  '2
		db.debugPrint("A03交通量class:S00変数設定:3.地形= "+ S地形);		//'  Debug.Print  '3
		db.debugPrint("A03交通量class:S00変数設定:5.幅員= "+ D幅員);		//'  Debug.Print  '5
		db.debugPrint("A03交通量class:S00変数設定:6.余裕= "+ D余裕);		//'  Debug.Print  '6
		db.debugPrint("A03交通量class:S00変数設定:7.勾配= "+ D勾配);		//'  Debug.Print  '7
		db.debugPrint("A03交通量class:S00変数設定:8.大型車混入率= "+ T);
		db.debugPrint("A03交通量class:S00変数設定:9.計画交通量= "+ D計画交通量);
	}//End Sub S00変数設定
	public  double A01可能交通容量_乗用車(){//Public Function A01可能交通容量_乗用車() As Double
		//'計算開始
		 switch(S交通方式){ // Select Case 
		    case "対面通行":
		      //A01可能交通容量_乗用車 = 
		        return Math.round(F01可能交通容量_乗用車(C対面通行, 1));
		    case "一方通行":
		      //A01可能交通容量_乗用車 = 
		        return Math.round(F01可能交通容量_乗用車(C一方通行, 2));
		    default:
		      db.debugError("error:A03交通量class:A01可能交通容量_乗用車;交通方式= "+ S交通方式);
		 }//End Select
		 return 0;
	}//End Function A01可能交通容量_乗用車
	private double F01可能交通容量_乗用車( double Cb ,double nD ){ //As Double
	/*'---------------------
	'目的 可能交通容量計算
	'日付 030501
	'---------------------*/
		//'変数定義
		//'Cb 基本交通量
		//'nD 車線数
		double γL; //Dim As Double '車線幅員による補正率
		double γC; //Dim As Double '側方余裕による補正率
		double γI; //Dim As Double '沿道状況による補正率
		double N; //Dim  As Double '車線数
		γL = F02車線幅員補正率();
		db.debugPrint("A03交通量class:F02車線幅員補正率γL:"+ γL);
		γC = F03側方余裕補正率();
		db.debugPrint("A03交通量class:F03側方余裕補正率γC:"+ γC);
		γI = F04沿道状況補正率();
		db.debugPrint("A03交通量class:F04沿道状況補正率γI:"+ γI);
		db.debugPrint("A03交通量class:F01可能交通容量_乗用車,車線数nD:"+ nD);
		return Cb * γL * γC * γI * nD;
	/*'計算開始
	'バグ
	'  Debug.Print "Cb="; Cb
	'  Debug.Print "γL="; γL
	'  Debug.Print "γC="; γC
	'  Debug.Print "γI="; γI
	End Function*/
	}//End Function F01可能交通容量_乗用車
	private double F02車線幅員補正率(){
		db.debugPrint( "A03交通量class:F02車線幅員補正率().D幅員:"+D幅員 );
		if(D幅員 < 2.5){
			db.debugPrint("A03交通量class;車線幅員補正率決定時に幅員が小さすぎる");
		}else if(D幅員 <2.75){
			return 0.82;
		}else if(D幅員 <3.00){
			return 0.88;
		}else if(D幅員 <3.25){
			return 0.94;
		}else if(D幅員 <5.00){
			return 1.00;
		}else{
			db.debugPrint("A03交通class,f02車線補正率で幅員の値が大きすぎる");
		} 
		return 0.0;	
	/*'---------------------
	'目的 車線幅員補正率の計算
	'日付 030501
	'---------------------
	Private Function F02車線幅員補正率() As Double
	  Debug.Print "○幅員="; D幅員
	  Select Case D幅員 
	    case IS < 2.5
	      db.debugPrint("交通量class;車線幅員補正率決定時に幅員が小さすぎる");// MsgBox
	    Case Is < 2.75
	      F02車線幅員補正率 = 0.82
	    Case Is < 3
	      F02車線幅員補正率 = 0.88
	    Case Is < 3.25
	      F02車線幅員補正率 = 0.94
	    Case Is < 5
	       F02車線幅員補正率 = 1
	    Case Else
	     MsgBox "交通class,f02車線補正率で幅員の値が大きすぎる"
	  End Select
	End Function */
	}//F02車線幅員補正率()
	private double F03側方余裕補正率(){
		db.debugPrint( "A03交通量class:F03側方余裕補正率：D余裕:" + D余裕);
		if(D余裕<0.0){
			db.debugError("error:A03交通量class:F03側方余裕補正率:側方余裕がマイナスである");
		}else if(D余裕<0.25){
			return 0.93;
		}else if(D余裕<0.5){
			return 0.95;
		}else if(D余裕<0.75){
			return 0.98;
		}else if(D余裕<2){
			return 1.0;
		}else{
			db.debugError("error:A03交通量class:F03側方余裕補正率:側方余裕が2.0m以上である");
		}
		return 0.0;
	/*'---------------------
	'目的 側方余裕による補正率の計算
	'日付 030501
	'---------------------
	Private Function F03側方余裕補正率() As Double
	  Select Case D余裕
	    Case Is < 0
	      MsgBox "交通量class;側方余裕補正率を決定する余裕の値がマイナスである"
	    Case Is < 0.25
	      F03側方余裕補正率 = 0.93
	    Case Is < 0.5
	      F03側方余裕補正率 = 0.95
	    Case Is < 0.75
	      F03側方余裕補正率 = 0.98
	    Case Is < 2
	      F03側方余裕補正率 = 1
	    Case Else
	      MsgBox "交通量class;f03側方余裕の値が2m以上である"
	  End Select
	End Function*/
	}//F03側方余裕補正率()
	private double F04沿道状況補正率(){
		db.debugPrint("A03交通量class:F04沿道状況補正率:S沿道=" + S沿道);
		switch(S沿道){
			case "市街化していない地域":
				return 1.0;
			case "幾分市街化している地域":
				return 0.95;
			case "市街化している地域":
				return 0.90;
			default:
				db.debugError("error:A03交通量class:F04沿道状況補正率:S沿道に問題:S沿道："+ S沿道);
		}//switch
		return 0.0;
	/*'---------------------
	'目的 沿道状況補正率
	'日付 030501
	'---------------------
	Private Function F04沿道状況補正率() As Double
	'  Debug.Print S沿道
	  Select Case S沿道
	    Case "市街化していない地域"
	      F04沿道状況補正率 = 1
	    Case "幾分市街化している地域"
	      F04沿道状況補正率 = 0.95
	    Case "市街化している地域"
	      F04沿道状況補正率 = 0.9
	    Case Else
	      MsgBox "交通量class;沿道状況の値に問題がある。"
	  End Select
	End Function*/
	}//F04沿道状況補正率
	public  double F05設計交通容量_乗用車(){
		//'変数定義
		double N可能交通容量=0; 	//As Double '乗用車換算
		double γT; 			//As Double '大型車混入による補正
		double d低減率; 		//As Double '計画水準による補正
		//'計算開始
		db.debugPrint("A03交通量class:F05設計交通容量_乗用車:S交通方式=" + S交通方式);
		switch(S交通方式){
			case "対面通行":
				N可能交通容量 = F01可能交通容量_乗用車(C対面通行, 1);
				break;
			case "一方通行":
				N可能交通容量 = F01可能交通容量_乗用車(C一方通行, 2);
				break;
			default:
				db.debugError("error:A03交通量class:F05設計交通容量_乗用車:"+ S交通方式 );
		}//switch()
		d低減率 = F07計画水準低減();
		db.debugPrint("A03交通量class:F05設計交通容量_乗用車:d低減率="+ d低減率);
		return N可能交通容量 * d低減率;
	/*'F05設計交通容量_乗用車---------------------
	'目的 設計交通容量（乗用車）
	'日付 030507
	'---------------------
	Public Function F05設計交通容量_乗用車() As Double
	'変数定義
	  Dim N可能交通容量 As Double '乗用車換算
	  Dim γT As Double '大型車混入による補正
	  Dim d低減率 As Double '計画水準による補正
	'計算開始
	  Select Case S交通方式
	    Case "対面通行"
	      N可能交通容量 = _
	        F01可能交通容量_乗用車(C対面通行, 1)
	    Case "一方通行"
	      N可能交通容量 = _
	        F01可能交通容量_乗用車(C一方通行, 2)
	    Case Else
	      MsgBox "交通量class;設計交通容量;交通方式=" & _
	        S交通方式
	  End Select
	  d低減率 = F07計画水準低減()
	  F05設計交通容量_乗用車 = _
	    Round(N可能交通容量 * d低減率, 0)
	''デバグ
	'  Debug.Print "設計交通容量="; _
	'    F05設計交通容量
	'  Debug.Print "可能交通容量="; N可能交通容量
	'  Debug.Print "低減率="; d低減率
	'  Debug.Print "大型車混入率補正="; F06大型車混入率補正
	End Function*/
	}//F05設計交通容量_乗用車()
	private double F07計画水準低減(){
		db.debugPrint("A03交通量class:F07計画水準低減:S区分="+ S区分);
		switch(S区分){
			case "第1種":
				return 0.75;
			case "第2種":
				return 0.9;
			case "第3種":
				return 0.85;
			case "第4種":
				return 0.9;
			default:
				db.debugError("error:A03交通量class:F07計画水準低減:S区分に問題あり:"+S区分);
		}//switch
		return 0.0;
	/*' F07計画水準低減()---------------------
	'目的 計画水準低減率
	'日付 030506
	'---------------------
	Private Function F07計画水準低減()
	  Select Case S区分
	    Case "第1種"
	      F07計画水準低減 = 0.75
	    Case "第2種"
	      F07計画水準低減 = 0.9
	    Case "第3種"
	      F07計画水準低減 = 0.85
	    Case "第4種"
	      F07計画水準低減 = 0.9
	    Case Else
	      MsgBox "交通量Class；計画水準低減で間違え."
	  End Select
	End Function*/
	}//F07計画水準低減
	public  double F08設計時間交通量_乗用車(){
		double dK;//Dim  As Double 'K値
		double γT;//Dim As Double '大型車補正率補正
		//'計算
		dK = F09K値();
		db.debugPrint("A03交通量class:F08設計時間交通量_乗用車():dK:"+ dK);
		γT = F06大型車混入率補正();
		db.debugPrint("A03交通量class:F08設計時間交通量_乗用車():γT:"+ γT);
		db.debugPrint("A03交通量class:F08設計時間交通量_乗用車():S交通方式="+ S交通方式);
		switch(S交通方式){//  Select Case 
		    case "対面通行":
				return D計画交通量 * dK / 100.0 / γT;
		    case "一方通行":
				return D計画交通量 * dK / 100.0 * dD / 100.0 / γT;
		    default:
				db.debugError("error:A03交通量class:設計時間交通量;交通方式が定義されていません:S交通方式=" + S交通方式);
		}//switch  End Select
		return 0 ;
		/*F08設計時間交通量_乗用車()'---------------------
		'目的 設計時間交通量（乗用車）
		'日付 030507
		'---------------------
		Public Function F08設計時間交通量_乗用車() As Double
		  Dim dK As Double 'K値
		  Dim γT As Double '大型車補正率補正
		'計算
		  dK = F09K値()
		  γT = F06大型車混入率補正
		  Select Case S交通方式
		    Case "対面通行"
		      F08設計時間交通量_乗用車 = _
		        D計画交通量 * dK / 100 / γT
		    Case "一方通行"
		      F08設計時間交通量_乗用車 = _
		        D計画交通量 * dK / 100 * dD / 100 / γT
		    Case Else
		        MsgBox _
		        "交通量Class;設計時間交通量;交通方式が定義されていません" & _
		        S交通方式
		  End Select
		End Function	
		*/
	}//F08設計時間交通量_乗用車
	private double F09K値(){
		db.debugPrint("A03交通量class:F09K値().S地域:" + S地域 );
		db.debugPrint("A03交通量class:F09K値().S地形:" + S地形 );
		switch(S地域){
			case "都市部":
				return 9.0;
			case "地方部":
				switch(S地形){
					case "平地部":
						return 11.0;
					case "山地部":
						return 14.0;
					default:
						db.debugError("error:A03交通量class:F09K値():地形に問題:S地形:"+ S地形);
				}//switch(S地形)
                break;
			default:
				db.debugError("error:A03交通量class:F09K値():地域に問題:S地域:" + S地域);
		}//switch(S地域)
		return 0.0 ;
		/*F09K値()---------------------
		'目的 Ｋ値の算出
		'日付 030507
		'---------------------
		Private Function F09K値() As Double
		  Select Case S地域
		    Case "都市部"
		      F09K値 = 9
		    Case "地方部"
		      Select Case S地形
		        Case "平地部"
		          F09K値 = 11
		        Case "山地部"
		          F09K値 = 14
		        Case Else
		          MsgBox "交通量class;Ｋ値;地形=" & S地形
		      End Select
		    Case Else
		      MsgBox "交通量class;K値;地域=" & S地域
		  End Select
		End Function*/
	}//F09K値()
	private double F06大型車混入率補正(){
		double Et=10000000;//As Double '大型車の乗用車換算係数
		//'変数チェック
		db.debugPrint("A03交通量class:F06大型車混入率補正():D勾配="+ D勾配);
		if(D勾配 > 3){//Then
			db.debugPrint("A03交通量class:勾配が3%以上だ");//MsgBox
		}else if(D勾配 < 0){ 
			db.debugPrint("A03交通量class:勾配が0未満だ");//MsgBox 
		}//End If
		//'計算
		db.debugPrint("A03交通量class:F06大型車混入率補正():S交通方式="+ S交通方式);
		db.debugPrint("A03交通量class:F06大型車混入率補正():T="+ T);
		switch(S交通方式){ // Select Case 
		  case "対面通行":
		    Et = -0.005 * T + 2.15;
		    break;
		  case "一方通行":
		    if(T < 0){
				db.debugError("error:A03交通量class:交通量class:大型車混入率=" + T);
		    }else if(T < 10){
				Et = 1.8;
			}else if(T <= 30){
		        Et = (1.7 - 1.8) / (30.0 - 10.0) * (T - 10.0) + 1.8;
		    }else if(T < 100.0){
		        Et = 1.7;
		    }else{
				db.debugError("error:A03交通量class:交通量class:大型車混入率=" + T);//MsgBox
		    }//End Select
			break;
		  default:
		    db.debugError("error:A03交通量class:交通量class;交通方式:大型車混入率(ここか？)=" + S交通方式);//MsgBox
		}//switch End Select
		return 100.0 / ((100.0 - T) + Et * T);
		/*F06大型車混入率補正()---------------------
		'目的 大型車混入率補正係数
		'日付 030506
		'---------------------
		Private Function F06大型車混入率補正()
		  Dim Et As Double '大型車の乗用車換算係数
		'変数チェック
		  If D勾配 > 3 Then
		    MsgBox "勾配が3%以上だ"
		  ElseIf D勾配 < 0 Then
		    MsgBox "勾配が0未満だ"
		  End If
		'計算
		 Select Case S交通方式
		  Case "対面通行"
		    Et = -0.005 * T + 2.15
		  Case "一方通行"
		    Select Case T
		      Case Is < 0
		        MsgBox "交通量class;大型車補正率;大型車混入率=" & T
		      Case Is < 10
		        Et = 1.8
		      Case Is <= 30
		        Et = _
		          (1.7 - 1.8) / (30 - 10) * (T - 10) + 1.8
		      Case Is < 100
		        Et = 1.7
		      Case Else
		        MsgBox "交通量class;大型車補正率；大型車混入率=" & T
		    End Select
		  Case Else
		    MsgBox "交通量class;大型車補正率;交通方式=" & S交通方式
		 End Select
		    F06大型車混入率補正 = _
		      100 / ((100 - T) + Et * T)
		'  Debug.Print "-------"
		'  Debug.Print "交通方式="; S交通方式
		'  Debug.Print "大型車混入率="; T
		'  Debug.Print "大型車換算係数Et="; Et
		'  Debug.Print "γT="; F06大型車混入率補正
		End Function*/
	}//F06大型車混入率補正()		
	public  double F05設計交通容量(){
		//'変数定義
		double N可能交通容量=0;	//Dim As Double '乗用車換算
		double γT;				//Dim As Double '大型車混入による補正
		double d低減率;		//Dim As Double '計画水準による補正
		//'計算開始
		switch(S交通方式){ //Select Case N可能交通容量の決定
		    case "対面通行":
				N可能交通容量 = F01可能交通容量_乗用車(C対面通行, 1);
				break;
		    case "一方通行":
				N可能交通容量 = F01可能交通容量_乗用車(C一方通行, 2);
				break;
		    default:
				db.debugError("error:A03交通量class:設計交通容量;交通方式=" + S交通方式);//MsgBox
		}//switch()
		γT = F06大型車混入率補正();
		d低減率 = F07計画水準低減();
		return Math.round(N可能交通容量 * γT * d低減率);
		/*F05設計交通容量()---------------------
		'目的 設計交通容量（実台数）
		'日付 030506
		'---------------------
		Public Function F05設計交通容量() As Double
		'変数定義
		  Dim N可能交通容量 As Double '乗用車換算
		  Dim γT As Double '大型車混入による補正
		  Dim d低減率 As Double '計画水準による補正
		'計算開始
		  Select Case S交通方式
		    Case "対面通行"
		      N可能交通容量 = _
		        F01可能交通容量_乗用車(C対面通行, 1)
		    Case "一方通行"
		      N可能交通容量 = _
		        F01可能交通容量_乗用車(C一方通行, 2)
		    Case Else
		      MsgBox "交通量class;設計交通容量;交通方式=" & _
		        S交通方式
		  End Select
		  γT = F06大型車混入率補正()
		  d低減率 = F07計画水準低減()
		  F05設計交通容量 = _
		    Round(N可能交通容量 * γT * d低減率, 0)
		'デバグ
		'  Debug.Print "設計交通容量="; _
		'    F05設計交通容量
		'  Debug.Print "可能交通容量="; N可能交通容量
		'  Debug.Print "低減率="; d低減率
		'  Debug.Print "大型車混入率補正="; F06大型車混入率補正
		End Function*/
	}//F05設計交通容量()
	public  double F08設計時間交通量(){
		double dK; //Dim As Double 'K値
		//'計算
		dK = F09K値();
		db.debugPrint("A03交通量class:F08設計時間交通量():dK="+ dK);
		db.debugPrint("A03交通量class:F08設計時間交通量():S交通方式="+ S交通方式);
		switch(S交通方式){ //Select Case
		    case "対面通行":
		        return Math.round(D計画交通量 * dK / 100.0);
		    case "一方通行":
		        return Math.round(D計画交通量 * dK / 100.0 * dD / 100.0);
		    default:
				db.debugError("error:A03交通量class:F08設計時間交通量();交通方式が未定義:S交通方式=" + S交通方式);
		}//switch End Select
		return 0.0;
		/*F08設計時間交通量()---------------------
		'目的 設計時間交通量（実台数）
		'日付 030507
		'---------------------
		Public Function F08設計時間交通量() As Double
		  Dim dK As Double 'K値
		'計算
		  dK = F09K値()
		  Select Case S交通方式
		    Case "対面通行"
		      F08設計時間交通量 = _
		        Round(D計画交通量 * dK / 100, 0)
		    Case "一方通行"
		      F08設計時間交通量 = _
		        Round(D計画交通量 * dK / 100 * dD / 100, 0)
		    Case Else
		        MsgBox _
		        "交通量Class;設計時間交通量;交通方式が定義されていません" & _
		        S交通方式
		  End Select
		End Function*/
	}//F08設計時間交通量()
}//End A03交通Class
/*VBプログラム--------------------------------------------------
VBクラス頭書き VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "A03交通Class"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit*/
