package com.example.yo.myapp20180829kanki2;

public class A05換気量H20Class{
	//'定数
	final double C一酸化炭素平均排出量 = 0.005;		//Const '080707修正
	final double C通常走行一酸化炭素排出量 = 100.0;	//Const 
	//'080706追加
	final int C対面通行 = 2;	//Const 
	final int C屈曲 = 4;		//Const 配列の添字となっているので、用意すべき数は、4+1 
	final int C上下線 = 1;		//Const 
	//final int C上 = 0;			//Const 
	//final int C下 = 1;			//Const 
	//'入力変数
	private double GD設計交通量;// As Double
	private double GD大型車混入率;// As Double
	private double GD走行速度;// As Double
	private double GDトンネル断面;// As Double
	private double[] GD区間延長 = new double[(C屈曲+1) * C対面通行];// As Double
	private double GDトンネル標高;// As Double
	//'計算過程
	private double GD煤煙透過率;// As Double
	private double GD煤煙濃度;// As Double
	private double[] GDμ1 =new double[(C屈曲 + 1) * C対面通行];// As Double   '大型080707追加
	private double[] GDμ2 =new double[(C屈曲 + 1) * C対面通行];// As Double  '小型080707追加
	private double GDμL;// As Double            '大型080707追加
	private double GDμS;// As Double            '小型080707追加
	private double[] GD煤煙平均排出量 = new double[(C屈曲 + 1) * C対面通行];// As Double
	private double GD標高補正係数;// As Double
	private double[] GDσ1 = new double[(C屈曲 + 1) * C対面通行];// As Double     '大型080707追加
	private double[] GDσ2 = new double[(C屈曲 + 1) * C対面通行];// As Double     '小型080707追加
	private double GDσL;// As Double   '大型080707追加
	private double GDσS;// As Double   '小型080707追加
	private double GD_RL;// As Double  '大型微粒子率
	private double GD_RS;// As Double            '小型微粒子率
	private double[] GD煤煙排出量標準偏差 = new double[(C屈曲 + 1) * C対面通行];// As Double
	private double[] GD単位基準換気量_煤煙 =new double[(C屈曲 + 1) * C対面通行];// As Double
	private double[] GD区間換気量 = new double[(C屈曲 + 1) * C対面通行];// As Double
	private double GD_Kh;// As Double
	private double GD換気量_煤煙;// As Double
	//'計算結果
	//private double GD煤煙換気量;// As Double
	//private double GD一酸化炭素換気量;// As Double
	//'H20追加
	//'排出量定義
	final int C年 = 0;//Const 
	final int C平均S = 1;//Const 
	final int C平均L = 2;//Const 
	final int C偏差S = 3;//Const 
	final int C偏差L = 4;//Const 
	final int C率S = 5;//Const 
	final int C率L = 6;//Const 
	private int GI供用年度;// As Integer
	private double[] GD_KS = new double[(C屈曲 + 1) * C対面通行];// As Double
	private double[] GD_KL = new double[(C屈曲 + 1) * C対面通行];// As Double
	private double GD_KVS;// As Double
	private double GD_KVL;// As Double
	private String GS交通方式;// As String
	//クラスの定義
	DebugPrint db = new DebugPrint();
	//計算実行	
	public void A00変数設定(	//入力変数
		double D設計交通量,// As Double,
		double D大型車混入率,// As Double,
		double D走行速度,// As Double,
		double Dトンネル断面,// As Double,
		double[] D区間延長,//() As Double,
		double Dトンネル標高,// As Double,
		int I供用年度,// As Integer,
		double[][] D勾配補正係数S,//() As Double,
		double[][] D勾配補正係数L,//() As Double,
		double D速度補正係数S,// As Double,
		double D速度補正係数L,// As Double,
		String nS交通方式// As String
		)
		{// A00変数設定 				//実行
		db.debugPrint("A05換気量H20Class:A00変数設定:nS交通方式=" + nS交通方式);
		int i;//Dim  As Integer
		int ii;//Dim  As Integer
		int ch;//Dim  As Integer
		//'変数チェック
		//Select Case Dトンネル断面
		if( Dトンネル断面 < 20.0 ){ //Case Is < 20
			db.debugError("error:A05換気量H20Class：A00変数設定：トンネル断面が20m2以下" + Dトンネル断面); //MsgBox
			//MsgBox "換気；変数入力；トンネル断面" Dトンネル断面
		}//if
		else if( Dトンネル断面 < 100.0 ){ //Case Is < 100
		}//else if
		else{  //Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：トンネル断面が100m2以下" + Dトンネル断面); //MsgBox
			//MsgBox "換気；変数入力；トンネル断面" Dトンネル断面
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:Dトンネル断面=" + Dトンネル断面 );
		//Select Case D設計交通量
		if( D設計交通量  < 0.0 ){//Case Is
			db.debugError("error:A05換気H20Class：A00変数設定：D設計交通量が0以下" + D設計交通量); //MsgBox
			//MsgBox "換気；変数入力；設計交通量" D設計交通量
		}//if
		else if( D設計交通量 <= 4400.0 ){//Case Is
			}//else if
		else{ //Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：D設計交通量が4400より大きい" + D設計交通量); //MsgBox
			//MsgBox "換気；変数入力；設計交通量" D設計交通量
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:D設計交通量=" + D設計交通量 );
		//Select Case D大型車混入率
		if(D大型車混入率 < 0 ){//Case Is 
			db.debugError("error:A05換気H20Class：A00変数設定：D大型車混入率が0以下" + D大型車混入率); //MsgBox
			//MsgBox "換気；変数入力；大型車" "混入率=" & D大型車混入率
		}//if
		else if( D大型車混入率 <= 1 ){//Case Is 
		}//else if 
		else{// Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：D大型車混入率が1.00より大きい" + D大型車混入率); //MsgBox
			//MsgBox "換気；変数入力；大型車" "混入率=" & D大型車混入率
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:D大型車混入率=" + D大型車混入率 );
		//Select Case D走行速度
		if( D走行速度 < 0 ){//Case Is
			db.debugError("error:A05換気H20Class：A00変数設定：D走行速度が0以下" + D走行速度); //MsgBox
			//MsgBox "換気；変数入力；走行速度" D走行速度
		}//if
		else if( D走行速度 <= 120.0 ){//Case Is
		}//else if 
		else{//Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：D走行速度が120より大きい" + D走行速度); //MsgBox
			//MsgBox "換気；変数入力；走行速度" D走行速度
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:D走行速度=" + D走行速度 );
		//Select Case D区間延長[i]
		for( i = 0 ; i <= C屈曲 ; i++ ){ //To 
			if( D区間延長[i] < 0.0 ){//Case Is
				db.debugError("error:A05換気H20Class：A00変数設定：D区間延長[i:"+ i +"]が0以下" + D区間延長[i] ); //MsgBox
				//MsgBox "換気；変数入力；トンネル延長" D区間延長(i)
			}//if
			else if( D区間延長[i] < 50000.0 ){ //Case Is
			}//else if
			else{ //Case Else
				db.debugError("error:A05換気H20Class：A00変数設定：D区間延長[i:"+ i +"]が5000以上" + D区間延長[i] ); //MsgBox
				//MsgBox "換気；変数入力；トンネル延長" D区間延長(i)
			}//else End Select
			db.debugPrint("A05換気量H20Class:A00変数設定:D区間延長[i:"+ i +"]=" + D区間延長[i] );
		}//for Next
		//Select Case Dトンネル標高
		if( Dトンネル標高 < -100.0 ){//Case Is
			db.debugError("error:A05換気H20Class：A00変数設定：Dトンネル標高が-100以下" + Dトンネル標高 ); //MsgBox
			//MsgBox "換気；変数入力；トンネル標高" & Dトンネル標高
		}//if
		else if( Dトンネル標高 < 3000.0 ){//Case Is
		}//else if
		else{// Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：Dトンネル標高が3000以上" + Dトンネル標高 ); //MsgBox
			//MsgBox "換気；変数入力；トンネル標高" Dトンネル標高
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:Dトンネル標高=" + Dトンネル標高 );
		//'新基準追加
		//Select Case I供用年度
		if( I供用年度 < 20 ){//Case Is
			db.debugError("error:A05換気H20Class：A00変数設定：I供用年度が平成20年以前" + I供用年度 ); //MsgBox
			//MsgBox "換気；変数入力；供用年度" I供用年度
		}//if
		else if( I供用年度 < 26 ){//Case Is 
		}//else if
		else{ //Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：I供用年度が平成26年以上" + I供用年度 ); //MsgBox
			//MsgBox "換気；変数；供用年度" I供用年度
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:I供用年度=" + I供用年度 );
		//Select Case D速度補正係数S
		if( D速度補正係数S < 0.92 ){ //Case Is
			db.debugError("error:A05換気H20Class：A00変数設定：D速度補正係数Sが0.92より小さい" + D速度補正係数S ); //MsgBox
			//MsgBox "換気H20;変数入力；速度勾配S=" D速度補正係数S
		}//if
		else if( D速度補正係数S < 1.11 ){//Case Is
		}//else if
		else{ //Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：D速度補正係数Sが1.11より大きい" + D速度補正係数S ); //MsgBox
			//MsgBox "換気H20;変数入力；速度勾配S=" D速度補正係数S
		}//else End Select
		db.debugPrint("A05換気量H20Class:A00変数設定:D速度補正係数S=" + D速度補正係数S );
		//Select Case D速度補正係数L
		if( D速度補正係数L < 0.91){ //Case Is
			db.debugError("error:A05換気H20Class：A00変数設定：D速度補正係数Lが0.91より小さい" + D速度補正係数S ); //MsgBox
			//MsgBox "換気H20;変数入力；速度勾配L=" D速度補正係数L
		}//if
		else if( D速度補正係数L < 1.13 ){//Case Is
		}//else if
		else{//Case Else
			db.debugError("error:A05換気H20Class：A00変数設定：D速度補正係数Sが1.11より大きい" + D速度補正係数S ); //MsgBox
			//MsgBox "換気H20;変数入力；速度勾配L=" D速度補正係数L
		}//else End Select
		if( !nS交通方式.equals("対面通行") && !nS交通方式.equals("一方通行")) {//Then  VB<> java!=
			db.debugError("error:A05換気H20Class：A00変数設定：nS交通方式が正しくない。交通方式=kk1" + nS交通方式 ); //MsgBox
			//MsgBox "換気H20；変数設定；交通方式=" & _nS交通方式
		}//if End If
		db.debugPrint("A05換気量H20Class:A00変数設定:D速度補正係数L=" + D速度補正係数L );
		//'変数代入
		GD設計交通量 = D設計交通量;
		GD大型車混入率 = D大型車混入率;
		GD走行速度 = D走行速度;
		GDトンネル断面 = Dトンネル断面;
		//'一方通行の判定
		//'一方通行の場合は、戻りのTN延長を0とする。
		for( i = 0 ; i < (C屈曲 + 1 ) * C対面通行 ; i++){ //To
			GD区間延長[i] = 0;
			db.debugPrint("A05換気量H20Class:A00変数設定:GD区間延長[i:"+ i +"]=" + GD区間延長[i] );
		}//for Next
		if( nS交通方式.equals("対面通行") ){//Then
			ch = C上下線;
		}//if
		else if( nS交通方式.equals("一方通行") ){//Then
			ch = 0;
		}//else
		else{
			db.debugError("error:A05換気H20Class：A00変数設定：nS交通方式が正しくない。" + nS交通方式); //MsgBox
			//MsgBox "換気量H20" & nS交通方式
			ch = -1;
		}//else End If
		db.debugPrint("A05換気量H20Class:A00変数設定:ch=" + ch );
		//'区間延長
		for( ii = 0 ; ii <= ch ; ii++ ){//For To
			db.debugPrint("A05換気量H20Class:A00変数設定:ii=" + ii );
			for( i = 0 ; i <= C屈曲 ; i++ ){//To
				db.debugPrint("A05換気量H20Class:A00変数設定:i=" + i );
				GD区間延長[ii * (C屈曲 +1) + i] = D区間延長[i];
				db.debugPrint("A05換気量H20Class:A00変数設定:GD区間延長[ii *(C屈曲 +1) + i]=" + GD区間延長[ii *(C屈曲 +1) + i] + " (C屈曲 +1) + i=" + (ii *(C屈曲 +1) + i) );
			}//for i Next
		}//for ii Next
		for( ii = 0 ; ii <= C上下線 ; ii++){//To
			for( i = 0 ; i <= C屈曲  ; i++ ){//To 
				GD_KS[ii * (C屈曲 + 1)  + i] = D勾配補正係数S[ii][i];
				db.debugPrint("A05換気量H20Class:A00変数設定:GD_KS[ii * (C屈曲 + 1)  + i]=" + GD_KS[ii * (C屈曲 + 1)  + i] + " (C屈曲 +1) + i=" + (ii *(C屈曲 +1) + i) );
			}//for i Next
		}//for ii Next
		for( ii = 0 ; ii <= C上下線 ; ii++ ){ //To
			for( i = 0 ; i<= C屈曲 ; i++ ){ // To
				GD_KL[ii * (C屈曲 + 1 ) + i] = D勾配補正係数L[ii][i];
				db.debugPrint("A05換気量H20Class:A00変数設定:GD_KL[ii * (C屈曲 + 1 ) + i]=" + GD_KL[ii * (C屈曲 + 1 ) + i] + " (C屈曲 +1) + i=" + (ii *(C屈曲 +1) + i) );
			}//for i Next
		}//for ii Next
		//計算結果の反映
		GI供用年度 = I供用年度;
		GD_KVS = D速度補正係数S;
		GD_KVL = D速度補正係数L;
		GDトンネル標高 = Dトンネル標高;
		GS交通方式 = nS交通方式;
		//'計算実行
		S08換気量_煤煙();
		//'----------------------------------------
		db.debugPrint( "A05換気量H20Class:＜換気；変数設定＞" );
		db.debugPrint( "A05換気量H20Class:設計交通量 =" + GD設計交通量 );
		db.debugPrint( "A05換気量H20Class:大型車混入率=" + GD大型車混入率 );
		db.debugPrint( "A05換気量H20Class:走行速度  =" + GD走行速度 );
		db.debugPrint( "A05換気量H20Class:トンネル断面=" + GDトンネル断面 );
		db.debugPrint( "A05換気量H20Class:トンネル標高=" + GDトンネル標高 );
		for( i = 0 ; i <= C屈曲 ; i++ ){
			db.debugPrint( "A05換気量H20Class:トンネル区間延長[i:"+ i +"]=" + GD区間延長[i]  );
		}//for i
		db.debugPrint( "------------------------------" );
		db.debugPrint( "A05換気量H20Class:標高補正計数   =" + GD_Kh );
		db.debugPrint( "A05換気量H20Class:煤煙透過率    =" + GD煤煙透過率 );
		db.debugPrint( "A05換気量H20Class:煤煙濃度     =" + GD煤煙濃度 );
		db.debugPrint( "A05換気量H20Class:単位基準換気量    =" + GD単位基準換気量_煤煙[0]);
		db.debugPrint( "A05換気量H20Class:煤煙換気量    =" + GD換気量_煤煙 );
		db.debugPrint( "------------------------------" );
		//End Sub
	/*A00変数設定'----------------------------------------
'目的 変数入力
'日付 030509
'追加 080706
'----------------------------------------
Public Sub A00変数設定( _
  D設計交通量 As Double, _
  D大型車混入率 As Double, _
  D走行速度 As Double, _
  Dトンネル断面 As Double, _
  D区間延長() As Double, _
  Dトンネル標高 As Double, _
  I供用年度 As Integer, _
  D勾配補正係数S() As Double, _
  D勾配補正係数L() As Double, _
  D速度補正係数S As Double, _
  D速度補正係数L As Double, _
  nS交通方式 As String)
  Dim i As Integer
  Dim ii As Integer
  Dim ch As Integer
'変数チェック
  Select Case Dトンネル断面
    Case Is < 20
      MsgBox "換気；変数入力；トンネル断面" & _
        Dトンネル断面
    Case Is < 100
    Case Else
      MsgBox "換気；変数入力；トンネル断面" & _
        Dトンネル断面
  End Select
  Select Case D設計交通量
    Case Is < 0
      MsgBox "換気；変数入力；設計交通量" & _
        D設計交通量
    Case Is < 4400
    Case Else
      MsgBox "換気；変数入力；設計交通量" & _
        D設計交通量
  End Select
  Select Case D大型車混入率
    Case Is < 0
      MsgBox "換気；変数入力；大型車" & _
        "混入率=" & D大型車混入率
    Case Is <= 1
    Case Else
      MsgBox "換気；変数入力；大型車" & _
        "混入率=" & D大型車混入率
  End Select
  Select Case D走行速度
    Case Is < 0
      MsgBox "換気；変数入力；走行速度" & _
        D走行速度
    Case Is < 120
    Case Else
      MsgBox "換気；変数入力；走行速度" & _
        D走行速度
  End Select
  For i = 0 To C屈曲
    Select Case D区間延長(i)
      Case Is < 0
        MsgBox "換気；変数入力；トンネル延長" & _
          D区間延長(i)
      Case Is < 50000
      Case Else
        MsgBox "換気；変数入力；トンネル延長" & _
          D区間延長(i)
    End Select
  Next
  Select Case Dトンネル標高
    Case Is < -100
      MsgBox "換気；変数入力；トンネル標高" & _
        Dトンネル標高
    Case Is < 3000
    Case Else
      MsgBox "換気；変数入力；トンネル標高" & _
        Dトンネル標高
  End Select
  '新基準追加
  Select Case I供用年度
    Case Is < 20
        MsgBox "換気；変数入力；供用年度" & _
            I供用年度
    Case Is < 26
    Case Else
        MsgBox "換気；変数；供用年度" & _
            I供用年度
  End Select
  Select Case D速度補正係数S
    Case Is < 0.92
        MsgBox "換気H20;変数入力；速度勾配S=" & _
         D速度補正係数S
    Case Is < 1.11
    Case Else
        MsgBox "換気H20;変数入力；速度勾配S=" & _
         D速度補正係数S
  End Select
  Select Case D速度補正係数L
    Case Is < 0.91
        MsgBox "換気H20;変数入力；速度勾配L=" & _
         D速度補正係数L
    Case Is < 1.13
    Case Else
        MsgBox "換気H20;変数入力；速度勾配L=" & _
         D速度補正係数L
  End Select
  If nS交通方式 <> "対面通行" _
    And nS交通方式 <> "一方通行" Then
    MsgBox "換気H20；変数設定；交通方式=" & _
      nS交通方式
  End If
  '変数代入
  GD設計交通量 = D設計交通量
  GD大型車混入率 = D大型車混入率
  GD走行速度 = D走行速度
  GDトンネル断面 = Dトンネル断面
  '一方通行の判定
  '一方通行の場合は、戻りのTN延長を0とする。
  For i = 0 To C屈曲 * C対面通行
    GD区間延長(i) = 0
  Next
  If nS交通方式 = "対面通行" Then
     ch = C上下線
  ElseIf nS交通方式 = "一方通行" Then
     ch = 0
  Else
     MsgBox "換気量H20" & nS交通方式
  End If
  '
  For ii = 0 To ch
    For i = 0 To C屈曲
          GD区間延長(ii * C屈曲 + i) = D区間延長(i)
    Next
  Next
  For ii = 0 To C上下線
    For i = 0 To C屈曲
      GD_KS(ii * C屈曲 + i) = D勾配補正係数S(ii, i)
    Next
  Next
  For ii = 0 To C上下線
    For i = 0 To C屈曲
      GD_KL(ii * C屈曲 + i) = D勾配補正係数L(ii, i)
    Next
  Next
  GI供用年度 = I供用年度
  GD_KVS = D速度補正係数S
  GD_KVL = D速度補正係数L
  GDトンネル標高 = Dトンネル標高
  GS交通方式 = nS交通方式
'計算実行
  S08換気量_煤煙*/ 
	}// A00変数設定
	private void S08換気量_煤煙(){
		int i;//Dim  As Integer
		double ch;//Dim  As Double
		S07標高補正係数_煤煙();
		S01年度排出量標準偏差定義();
		S03煤煙排出量の補正();
		S01煤煙透過率();
	  S02煤煙濃度();
	  S03煤煙平均排出量();
	  S04煤煙排出量標準偏差();
	  S05単位基準換気量_煤煙();
	  //'一方通行の判定
	  if( GS交通方式.equals("対面通行") ){//Then
	     ch = 2;
		 }//if
	  else if( GS交通方式.equals("一方通行") ){//Then
	     ch = 1;
		 }//else if
	  else{
			db.debugError("error:A05換気量H20Class:S08換気量_煤煙;GS交通方式=" + GS交通方式 );
	    ch=99;
	    //MsgBox "換気量H20" & GS交通方式
	  }//else End If
	  GD換気量_煤煙 = 0.0;
	  for( i = 0 ; i < (C屈曲+1) * 2; i++){
	    GD区間換気量[i] = 
	      GD単位基準換気量_煤煙[i] 
	      * GD区間延長[i] 
	      * GD設計交通量 / ch / 1000.0;
			db.debugPrint( "A05換気量H20Class:換気量：S08換気量_煤煙：GD区間換気量[i:"+ i +"]=" + GD区間換気量[i] );
	    //'Debug.Print "延長"; GD区間延長(i)
	    //'換気量計算
	    GD換気量_煤煙 = GD換気量_煤煙 + GD区間換気量[i];
	  }//for Next
		db.debugPrint( "A05換気量H20Class:換気量：S08換気量_煤煙：GD換気量_煤煙" + GD換気量_煤煙 );
	  //'Debug.Print "換気量"; GD換気量_煤煙
	//End Sub */
	/*S08換気量_煤煙()
	'----------------------------------------
	'目的 煤煙換気量計算
	'日付 030510
	'----------------------------------------
	Private Sub S08換気量_煤煙()
	  Dim i As Integer
	  Dim ch As Double
	  S07標高補正係数_煤煙
	  S01年度排出量標準偏差定義
	  S03煤煙排出量の補正
	  S01煤煙透過率
	  S02煤煙濃度
	  S03煤煙平均排出量
	  S04煤煙排出量標準偏差
	  S05単位基準換気量_煤煙
	  GD換気量_煤煙 = 0
	  '一方通行の判定
	  If GS交通方式 = "対面通行" Then
	     ch = 2
	  ElseIf GS交通方式 = "一方通行" Then
	     ch = 1
	  Else
	     MsgBox "換気量H20" & GS交通方式
	  End If
	  For i = 0 To C屈曲 * 2
	    GD区間換気量(i) = _
	      GD単位基準換気量_煤煙(i) _
	      * GD区間延長(i) _
	      * GD設計交通量 / ch / 1000
	    'Debug.Print "延長"; GD区間延長(i)    
	    '換気量計算
	    GD換気量_煤煙 = _
	      GD換気量_煤煙 + GD区間換気量(i)	    
	  Next
	  'Debug.Print "換気量"; GD換気量_煤煙
	End Sub */
	}//S08換気量_煤煙()
	private void S07標高補正係数_煤煙(){
	//Select Case GDトンネル標高
		if( GDトンネル標高 < -20.0 ){//Case Is
			db.debugError("error:A05換気量H20Class:S07標高補正係数_煤煙:GDトンネル標高が-20mより下：" + GDトンネル標高);
			//MsgBox "換気；標高補正係数；トンネル標高=" & GDトンネル標高
		}//if
		else if( GDトンネル標高 < 400.0 ){//Case Is
			GD_Kh = 1.0;
		}//else if
		else if (GDトンネル標高 < 2200.0 ){//Case Is
			GD_Kh 
				= (1.5 - 1.0) / (2000.0 - 400.0) 
				* (GDトンネル標高 - 400.0) + 1 ;
		}//else if
		else{//Case Else
			db.debugError("error:A05換気量H20Class:S07標高補正係数_煤煙:GDトンネル標高が2200m以上：" + GDトンネル標高);
			//MsgBox "換気；標高補正係数；トンネル標高=" GDトンネル標高
		}//else End Select
		db.debugPrint( "A05換気量H20Class:S07標高補正係数_煤煙:GDトンネル標高=" + GDトンネル標高 );
		db.debugPrint( "A05換気量H20Class:S07標高補正係数_煤煙:GD_Kh=" + GD_Kh );
	/*S07標高補正係数_煤煙()
	'----------------------------------------
	'目的 煤煙標高補正係数
	'入力 GDトンネル標高
	'出力  GD煤煙標高補正係数
	'日付 030510
	'----------------------------------------
	Private Sub S07標高補正係数_煤煙()
	  Select Case GDトンネル標高
	    Case Is < -20
	      MsgBox "換気；標高補正係数；トンネル標高=" _
	        & GDトンネル標高
	    Case Is < 400
	      GD_Kh = 1
	    Case Is < 2200
	      GD_Kh _
	        = (1.5 - 1) / (2000 - 400) _
	        * (GDトンネル標高 - 400) + 1
	    Case Else
	      MsgBox "換気；標高補正係数；トンネル標高=" _
	        & GDトンネル標高
	  End Select
	End Sub*/
	}//S07標高補正係数_煤煙
	private void S01年度排出量標準偏差定義(){
		GDμL = F排出量(C平均L, GI供用年度);
		GDμS = F排出量(C平均S, GI供用年度);
		GDσL = F排出量(C偏差L, GI供用年度);
		GDσS = F排出量(C偏差S, GI供用年度);
		GD_RL = F排出量(C率L, GI供用年度);
		GD_RS = F排出量(C率S, GI供用年度);
		/*S01年度排出量標準偏差定義()
		'----------------------------------------
		'目的 排出量、標準偏差、微粒子率の定義
		'入力 I供用年度
		'出力 上記値
		'日付 080707
		'----------------------------------------
		Private Sub S01年度排出量標準偏差定義()
		  GDμL = F排出量(C平均L, GI供用年度)
		  GDμS = F排出量(C平均S, GI供用年度)
		  GDσL = F排出量(C偏差L, GI供用年度)
		  GDσS = F排出量(C偏差S, GI供用年度)
		  GD_RL = F排出量(C率L, GI供用年度)
		  GD_RS = F排出量(C率S, GI供用年度)
		'  Debug.Print "GDμL="; GDμL
		'  Debug.Print "GDμS="; GDμS
		'  Debug.Print "GDσL="; GDσL
		'  Debug.Print "GDσS="; GDσS
		'  Debug.Print "GD_RL="; GD_RL
		'  Debug.Print "GD_RS="; GD_RS
		End Sub*/
		}//S01年度排出量標準偏差定義()
	private double F排出量(	//入力変数
		int I項目,		// As Integer, _
        int I供用年度 	// As Integer) As Double
        )
        {//F排出量 					//実行
		double D表[][] =new double[6+1][5+1];//Dim  As Double
		double tempA;//Dim As Double
		int tempB;//Dim As Long -> 20202029 doubleからintに変更：自然な形に訂正
		//'入力変数のチェック
		//Select Case I項目
		if( I項目 < 0 ){//Case
			db.debugError("error:A05換気量H20Class:F排出量;I項目=：" + I項目 );
			//MsgBox "換気量H20;F排出量;I項目=" & I項目
		}//if 
		else if( I項目 < 7 ){//Case
		}//if
		else{// Case Else
			db.debugError("error:A05換気量H20Class:F排出量;I項目=：" + I項目 );
			//MsgBox "換気量H20;F排出量;I項目=" & I項目
		}//End Select
		//Select Case I供用年度
		if( I供用年度 < 20 ){//Case Is
			db.debugError("error:A05換気量H20Class:F排出量;I供用年度=：" + I供用年度 );
			//MsgBox "換気量H20;F排出量;I供用年度=" & I供用年度
		}//if
		else if ( I供用年度 < 26 ){//Case Is
		}//else if
		else{//Case Else
			db.debugError("error:A05換気量H20Class:F排出量;I供用年度=：" + I供用年度 );
			//MsgBox "換気量H20;F排出量;I供用年度=" & I供用年度
		}//else End Select
		//'速度定義
		D表[C年][ 0] = 20;
		D表[C年][ 1] = 21;
		D表[C年][ 2] = 22;
		D表[C年][ 3] = 23;
		D表[C年][ 4] = 24;
		D表[C年][ 5] = 25;
	    //'平均排出量定義
		D表[C平均S][ 0] = 0.4;
		D表[C平均S][ 1] = 0.4;
		D表[C平均S][ 2] = 0.4;
		D表[C平均S][ 3] = 0.4;
		D表[C平均S][ 4] = 0.3;
		D表[C平均S][ 5] = 0.3;
		D表[C平均L][ 0] = 2.0;
		D表[C平均L][ 1] = 1.8;
		D表[C平均L][ 2] = 1.7;
		D表[C平均L][ 3] = 1.6;
		D表[C平均L][ 4] = 1.6;
		D表[C平均L][ 5] = 1.5;
		//'標準偏差
		D表[C偏差S][ 0] = 0.4;
		D表[C偏差S][ 1] = 0.4;
		D表[C偏差S][ 2] = 0.4;
		D表[C偏差S][ 3] = 0.4;
		D表[C偏差S][ 4] = 0.3;
		D表[C偏差S][ 5] = 0.3;
		D表[C偏差L][ 0] = 0.7;
		D表[C偏差L][ 1] = 0.6;
		D表[C偏差L][ 2] = 0.6;
		D表[C偏差L][ 3] = 0.6;
		D表[C偏差L][ 4] = 0.6;
		D表[C偏差L][ 5] = 0.5;
	    //'微粒子率
		D表[C率S][ 0] = 0.7;
		D表[C率S][ 1] = 0.65;
		D表[C率S][ 2] = 0.65;
		D表[C率S][ 3] = 0.6;
		D表[C率S][ 4] = 0.6;
		D表[C率S][ 5] = 0.55;
		D表[C率L][ 0] = 0.65;
		D表[C率L][ 1] = 0.6;
		D表[C率L][ 2] = 0.6;
		D表[C率L][ 3] = 0.55;
		D表[C率L][ 4] = 0.55;
		D表[C率L][ 5] = 0.5;
	   //'補正値決定
		tempA = 999;
	    for( tempB = 0 ; tempB <= 5 ; tempB++ ){
	        if( I供用年度 == D表[C年][tempB] ){//Then
	            tempA = D表[I項目][tempB];
	        }//End If
	    }//for Next
	    //'エラー処理--------
	    if( tempA == 999 ){// Then
			db.debugError("error:A05換気量H20Class:F排出量;落ち着いて。エラーですね" );
	        //MsgBox "落ち着いて。エラーですね"
	    }//ifEnd If
	    db.debugPrint("A05換気量H20Class:F排出量=" + tempA);
	    return tempA;
	//End Function*/
 	/*F排出量()
	'テーブル作成
	Private Function F排出量(I項目 As Integer, _
	                          I供用年度 As Integer) As Double
	    Dim D表(6, 5) As Double
	    Dim tempA As Double
	    Dim tempB As Long
	   '入力変数のチェック
	   Select Case I項目
	    Case Is < 0
	        MsgBox "換気量H20;F排出量;I項目=" & I項目
	    Case Is < 7
	    Case Else
	        MsgBox "換気量H20;F排出量;I項目=" & I項目
		End Select
	    Select Case I供用年度
	    Case Is < 20
	        MsgBox "換気量H20;F排出量;I供用年度=" & I供用年度
	    Case Is < 26
	    Case Else
	        MsgBox "換気量H20;F排出量;I供用年度=" & I供用年度
	   End Select
	     '速度定義
	   D表(C年, 0) = 20
	   D表(C年, 1) = 21
	   D表(C年, 2) = 22
	   D表(C年, 3) = 23
	   D表(C年, 4) = 24
	   D表(C年, 5) = 25
	    '平均排出量定義
	   D表(C平均S, 0) = 0.4
	   D表(C平均S, 1) = 0.4
	   D表(C平均S, 2) = 0.4
	   D表(C平均S, 3) = 0.4
	   D表(C平均S, 4) = 0.3
	   D表(C平均S, 5) = 0.3
	   D表(C平均L, 0) = 2
	   D表(C平均L, 1) = 1.8
	   D表(C平均L, 2) = 1.7
	   D表(C平均L, 3) = 1.6
	   D表(C平均L, 4) = 1.6
	   D表(C平均L, 5) = 1.5
	    '標準偏差
	   D表(C偏差S, 0) = 0.4
	   D表(C偏差S, 1) = 0.4
	   D表(C偏差S, 2) = 0.4
	   D表(C偏差S, 3) = 0.4
	   D表(C偏差S, 4) = 0.3
	   D表(C偏差S, 5) = 0.3
	   D表(C偏差L, 0) = 0.7
	   D表(C偏差L, 1) = 0.6
	   D表(C偏差L, 2) = 0.6
	   D表(C偏差L, 3) = 0.6
	   D表(C偏差L, 4) = 0.6
	   D表(C偏差L, 5) = 0.5
	    '微粒子率
	   D表(C率S, 0) = 0.7
	   D表(C率S, 1) = 0.65
	   D表(C率S, 2) = 0.65
	   D表(C率S, 3) = 0.6
	   D表(C率S, 4) = 0.6
	   D表(C率S, 5) = 0.55
	   D表(C率L, 0) = 0.65
	   D表(C率L, 1) = 0.6
	   D表(C率L, 2) = 0.6
	   D表(C率L, 3) = 0.55
	   D表(C率L, 4) = 0.55
	   D表(C率L, 5) = 0.5
	   '補正値決定
	    tempA = 999
	    For tempB = 0 To 5
	        If I供用年度 = D表(C年, tempB) Then
	            tempA = D表(I項目, tempB)
	        End If
	    Next
	    F排出量 = tempA
	    'エラー処理--------
	    If tempA = 999 Then
	        MsgBox "落ち着いて。エラーですね"
	    End If
	End Function*/
	}//F排出量
	private void S03煤煙排出量の補正(){
	    int i;//Dim  As Integer
	    for( i = 0 ; i < ( C屈曲 + 1 ) * 2 ; i++ ){
	        GDμ1[i] = (GDμL * GD_RL * GD_KVL * GD_KL[i] * GD_Kh) + GDμL * (1 - GD_RL);
	        GDμ2[i] = (GDμS * GD_RS * GD_KVS * GD_KS[i] * GD_Kh) + GDμS * (1 - GD_RS);
	        GDσ1[i] = (GDσL * GD_RL * GD_KVL * GD_KL[i] * GD_Kh) + GDσL * (1 - GD_RL);
	        GDσ2[i] = (GDσS * GD_RS * GD_KVS * GD_KS[i] * GD_Kh) + GDσS * (1 - GD_RS);
			//
		    db.debugPrint( "A05換気量H20Class:S03煤煙排出量の補正i=" + i);
		    db.debugPrint( "A05換気量H20Class:GDμ1(i)=" + GDμ1[i]);
		    db.debugPrint( "A05換気量H20Class:GDμ2(i)=" + GDμ2[i]);
		    db.debugPrint( "A05換気量H20Class:GDσ1(i)=" + GDσ1[i]);
		    db.debugPrint( "A05換気量H20Class:GDσ1(i)=" + GDσ1[i]);
	    }//for i Next
	/*S03煤煙排出量の補正
	'----------------------------------------
	'目的 煤煙排出量の補正
	'入力 GD
	'出力  GD煤煙平均排出量
	'日付 030510
	'----------------------------------------
	Private Sub S03煤煙排出量の補正()
	    Dim i As Integer
	    For i = 0 To C屈曲 * 2
	        GDμ1(i) = (GDμL * GD_RL * GD_KVL * GD_KL(i) * GD_Kh) + GDμL * (1 - GD_RL)
	        GDμ2(i) = (GDμS * GD_RS * GD_KVS * GD_KS(i) * GD_Kh) + GDμS * (1 - GD_RS)
	        GDσ1(i) = (GDσL * GD_RL * GD_KVL * GD_KL(i) * GD_Kh) + GDσL * (1 - GD_RL)
	        GDσ2(i) = (GDσS * GD_RS * GD_KVS * GD_KS(i) * GD_Kh) + GDσS * (1 - GD_RS)
	    Next
	'    Debug.Print "GDμ1(0)="; GDμ1(0)
	'    Debug.Print "GDμ2(0)="; GDμ2(0)
	'    Debug.Print "GDσ1(0)="; GDσ1(0)
	'    Debug.Print "GDσ1(0)="; GDσ1(0)
	End Sub*/
	}//S03煤煙排出量の補正
	private void S01煤煙透過率(){
		//Select Case GD走行速度
	    if(GD走行速度 < 0.0 ){//Case Is
			db.debugError("error:A05換気量H20Class:S01煤煙透過率;GD走行速度=" + GD走行速度 );
			//MsgBox "換気；煤煙透過率；走行速度=" & GD走行速度
		}//if 
	    else if( GD走行速度 <= 60.0 ){//Case Is
			GD煤煙透過率 = 40.0;
	    }//else if 
	    else if ( GD走行速度 <= 80.0 ){//Case Is
			GD煤煙透過率 = (50.0 - 40.0) / (80.0 - 60.0) * (GD走行速度 - 60.0) + 40.0;
			GD煤煙透過率 = Math.round(GD煤煙透過率);
		}//else if 
	    else if( GD走行速度 <= 120.0 ){//Case Is
			GD煤煙透過率 = 50.0;
		}//else if
	    else{//Case Else
			db.debugError("error:A05換気量H20Class:S01煤煙透過率;GD走行速度=" + GD走行速度 );
			//MsgBox "換気；煤煙透過率；走行速度=" & GD走行速度
		}//else End Select
		db.debugPrint( "A05換気量H20Class:S01煤煙透過率;GD煤煙透過率=" + GD煤煙透過率 + " GD走行速度=" + GD走行速度);
	//End Sub*/
	/*S01煤煙透過率
	'----------------------------------------
	'目的 煤煙透過率
	'入力 GD走行速度
	'出力  GD煤煙透過率
	'日付 030510
	'----------------------------------------
	Private Sub S01煤煙透過率()
	  Select Case GD走行速度
	    Case Is < 0
	      MsgBox "換気；煤煙透過率；走行速度=" _
	        & GD走行速度
	    Case Is <= 60
	      GD煤煙透過率 = 40
	    Case Is <= 80
	      GD煤煙透過率 _
	        = (50 - 40) / (80 - 60) _
	        * (GD走行速度 - 60) + 40
	      GD煤煙透過率 = _
	      Round(GD煤煙透過率, 0)
	    Case Is <= 120
	      GD煤煙透過率 = 50
	    Case Else
	      MsgBox "換気；煤煙透過率；走行速度=" _
	        & GD走行速度
	  End Select
	End Sub*/
	}//S01煤煙透過率
	private void S02煤煙濃度(){
		double x ;
		x = GD煤煙透過率 / 100.0;
		GD煤煙濃度 =  Math.log( x )*(-1) / 100.0 ;
		db.debugPrint( "A05換気量H20Class:S02煤煙濃度;GD煤煙濃度=" + GD煤煙濃度 );
		//'Debug.Print "煤煙濃度"; GD煤煙濃度
		//End Sub*/
		/*S02煤煙濃度
		'----------------------------------------
		'目的 煤煙濃度
		'入力 GD煤煙透過率
		'出力  GD煤煙濃度
		'日付 030510
		'----------------------------------------
		Private Sub S02煤煙濃度()
		  GD煤煙濃度 _
		    = (-1) / 100 _
		    * Log(GD煤煙透過率 / 100)
		  'Debug.Print "煤煙濃度"; GD煤煙濃度
		End Sub*/
	}//S02煤煙濃度
	private void S03煤煙平均排出量(){
	  int i;//Dim As Integer
	  for( i = 0 ; i < (C屈曲 + 1) * 2 ; i++){
	    GD煤煙平均排出量[i] 
	      = GD大型車混入率 
	      * GDμ1[i] 
	      + (1.0 - GD大型車混入率)
	      * GDμ2[i];
			db.debugPrint( "A05換気量H20Class:S03煤煙平均排出量;GD煤煙平均排出量[i:"+ i +"]=" + GD煤煙平均排出量[i] );
	    //'Debug.Print "μ"; GD煤煙平均排出量(i)
	  }//for Next
		//End Sub*/
	/*S03煤煙平均排出量()
	'----------------------------------------
	'目的 煤煙平均排出量
	'入力 GD
	'出力  GD煤煙平均排出量
	'日付 030510
	'----------------------------------------
	Private Sub S03煤煙平均排出量()
	  Dim i As Integer
	  For i = 0 To C屈曲 * 2
	    GD煤煙平均排出量(i) _
	      = GD大型車混入率 _
	      * GDμ1(i) _
	      + (1 - GD大型車混入率) _
	      * GDμ2(i)
	    'Debug.Print "μ"; GD煤煙平均排出量(i)
	  Next
	End Sub*/
	}//S03煤煙平均排出量()
	private void S04煤煙排出量標準偏差(){
	  int i;//Dim  As Integer
	  for( i = 0 ; i < (C屈曲 + 1)* 2 ; i++){//To
	    GD煤煙排出量標準偏差[i] 
	      = Math.sqrt(
	      GD大型車混入率 
	      * ( Math.pow( GDσ1[i], 2 ) + Math.pow((GDμ1[i] - GD煤煙平均排出量[i]), 2)) 
	      + (1 - GD大型車混入率) 
	      * ( Math.pow( GDσ2[i], 2 ) + Math.pow((GDμ2[i] - GD煤煙平均排出量[i]), 2)));
			db.debugPrint( "A05換気量H20Class:S04煤煙排出量標準偏差;GD煤煙排出量標準偏差[i:"+ i +"]=" + GD煤煙排出量標準偏差[i] );
	  }//for Next
	//End Sub*/
	/*S04煤煙排出量標準偏差
	'----------------------------------------
	'目的 煤煙排出量標準偏差
	'入力 GD
	'出力  GD煤煙排出量標準偏差
	'日付 030510
	'----------------------------------------
	Private Sub S04煤煙排出量標準偏差()
	  Dim i As Integer
	  For i = 0 To C屈曲 * 2
	    GD煤煙排出量標準偏差(i) _
	      = Sqr( GD大型車混入率 
	      * (GDσ1(i) ^ 2 + (GDμ1(i) - GD煤煙平均排出量(i)) ^ 2) _
	      + (1 - GD大型車混入率) _
	      * (GDσ2(i) ^ 2 + (GDμ2(i) - GD煤煙平均排出量(i)) ^ 2))
	  Next
	End Sub*/
	}//S04煤煙排出量標準偏差
	private void S05単位基準換気量_煤煙(){
	  int i;//Dim  As Integer
	  for( i = 0 ; i < (C屈曲 +1 ) * 2 ; i++){
	    GD単位基準換気量_煤煙[i] 
	      = Math.pow(((3.0 * GD煤煙排出量標準偏差[i]
	      + Math.sqrt(9.0 * Math.pow(GD煤煙排出量標準偏差[i], 2 )
	      + 8.0 * GD煤煙平均排出量[i]
	      * GD煤煙濃度 
	      * GDトンネル断面 * 1000)) 
	      / (60.0 * Math.sqrt(8.0 * GDトンネル断面 * 1000.0) * GD煤煙濃度)),2.0);
			db.debugPrint( "A05換気量H20Class:S05単位基準換気量_煤煙;GD単位基準換気量_煤煙[i:"+ i +"]=" + GD単位基準換気量_煤煙[i] );
	    //'Debug.Print "単位基準換気量"; GD単位基準換気量_煤煙(i)
	  }//for Next
	/*S05単位基準換気量_煤煙
	'----------------------------------------
	'目的 単位基準換気量
	'入力 GD
	'出力  GD単位基準換気量
	'日付 030510
	'----------------------------------------
	Private Sub S05単位基準換気量_煤煙()
	  Dim i As Integer
	  For i = 0 To C屈曲 * 2
	    GD単位基準換気量_煤煙(i) _
	      = ((3 * GD煤煙排出量標準偏差(i) _
	      + Sqr(9 * GD煤煙排出量標準偏差(i) ^ 2 _
	      + 8 * GD煤煙平均排出量(i) _
	      * GD煤煙濃度 _
	      * GDトンネル断面 * 1000)) _
	      / (60 * Sqr(8 * GDトンネル断面 * 1000) _
	      * GD煤煙濃度)) ^ 2
	    'Debug.Print "単位基準換気量"; GD単位基準換気量_煤煙(i)
	  Next
	End Sub*/
	}//S05単位基準換気量_煤煙
	public double A01換気量_煤煙(){
		double dx;
		db.debugPrint( "A05換気量H20Class:A01換気量_煤煙=" + GD換気量_煤煙);
		db.debugPrint( "A05換気量H20Class:A01換気量_煤煙=" + GD換気量_煤煙*100.0/100.0);
		db.debugPrint( "A05換気量H20Class:A01換気量_煤煙=" + Math.round(GD換気量_煤煙*10.0) / 10.0 );
	  	dx = Math.round( GD換気量_煤煙 * 10);
	        dx = dx/10;
		db.debugPrint( "A05換気量H20Class:A01換気量_煤煙:GD換気量_煤煙" + GD換気量_煤煙 );
		return dx;
	/*Public Function A01換気量_煤煙() As Double
	  A01換気量_煤煙 _
	    = Round(GD換気量_煤煙, 1)
	End Function*/
	}//A01換気量_煤煙
	public double A02標高補正係数_煤煙(){
		db.debugPrint( "A05換気量H20Class:A02標高補正係数_煤煙=" + GD_Kh);
	  return GD_Kh;//A02標高補正係数_煤煙 = 
	/*Public Function A02標高補正係数_煤煙() As Double
	  A02標高補正係数_煤煙 = GD_Kh
	End Function*/
	}//A02標高補正係数_煤煙()
	/*A05換気量H20Class
	ERSION 1.0 CLASS
	BEGIN
		MultiUse = -1  'True
		Persistable = 0  'NotPersistable
		DataBindingBehavior = 0  'vbNone
		DataSourceBehavior  = 0  'vbNone
		MTSTransactionMode  = 0  'NotAnMTSObject
	END
	Attribute VB_Name = "A05換気量H20Class"
	Attribute VB_GlobalNameSpace = False
	Attribute VB_Creatable = True
	Attribute VB_PredeclaredId = False
	Attribute VB_Exposed = False
	Option Explicit
	'定数
	Const C一酸化炭素平均排出量 = 0.005   '080707修正
	Const C通常走行一酸化炭素排出量 = 100
	'080706追加
	Const C対面通行 = 2
	Const C屈曲 = 4
	Const C上下線 = 1
	Const C上 = 0
	Const C下 = 1
	'入力変数
	Private GD設計交通量 As Double
	Private GD大型車混入率 As Double
	Private GD走行速度 As Double
	Private GDトンネル断面 As Double
	Private GD区間延長(C屈曲 * C対面通行) As Double
	Private GDトンネル標高 As Double
	'計算過程
	Private GD煤煙透過率 As Double
	Private GD煤煙濃度 As Double
	Private GDμ1(C屈曲 * C対面通行) As Double   '大型080707追加
	Private GDμ2(C屈曲 * C対面通行) As Double  '小型080707追加
	Private GDμL As Double            '大型080707追加
	Private GDμS As Double            '小型080707追加
	Private GD煤煙平均排出量(C屈曲 * C対面通行) As Double
	Private GD標高補正係数 As Double
	Private GDσ1(C屈曲 * C対面通行) As Double     '大型080707追加
	Private GDσ2(C屈曲 * C対面通行) As Double     '小型080707追加
	Private GDσL As Double            '大型080707追加
	Private GDσS As Double            '小型080707追加
	Private GD_RL As Double            '大型微粒子率
	Private GD_RS As Double            '小型微粒子率
	Private GD煤煙排出量標準偏差(C屈曲 * C対面通行) As Double
	Private GD単位基準換気量_煤煙(C屈曲 * C対面通行) As Double
	Private GD区間換気量(C屈曲 * C対面通行) As Double
	Private GD_Kh As Double
	Private GD換気量_煤煙 As Double
	'計算結果
	Private GD煤煙換気量 As Double
	Private GD一酸化炭素換気量 As Double
	'H20追加
	'排出量定義
	Const C年 = 0
	Const C平均S = 1
	Const C平均L = 2
	Const C偏差S = 3
	Const C偏差L = 4
	Const C率S = 5
	Const C率L = 6
	Private GI供用年度 As Integer
	Private GD_KS(C屈曲 * C対面通行) As Double
	Private GD_KL(C屈曲 * C対面通行) As Double
	Private GD_KVS As Double
	Private GD_KVL As Double
	Private GS交通方式 As String
	'----------------------------------------
	'目的 変数入力
	'日付 030509
	'追加 080706
	'----------------------------------------
	Public Sub A00変数設定( _
		D設計交通量 As Double, _
		D大型車混入率 As Double, _
		D走行速度 As Double, _
		Dトンネル断面 As Double, _
		D区間延長() As Double, _
		Dトンネル標高 As Double, _
		I供用年度 As Integer, _
		D勾配補正係数S() As Double, _
		D勾配補正係数L() As Double, _
		D速度補正係数S As Double, _
		D速度補正係数L As Double, _
		nS交通方式 As String)
		Dim i As Integer
		Dim ii As Integer
		Dim ch As Integer
	'変数チェック
		Select Case Dトンネル断面
			Case Is < 20
				MsgBox "換気；変数入力；トンネル断面" & _
					Dトンネル断面
			Case Is < 100
			Case Else
				MsgBox "換気；変数入力；トンネル断面" & _
					Dトンネル断面
		End Select
		Select Case D設計交通量
			Case Is < 0
				MsgBox "換気；変数入力；設計交通量" & _
					D設計交通量
			Case Is < 4400
			Case Else
				MsgBox "換気；変数入力；設計交通量" & _
					D設計交通量
		End Select
		Select Case D大型車混入率
			Case Is < 0
				MsgBox "換気；変数入力；大型車" & _
					"混入率=" & D大型車混入率
			Case Is <= 1
			Case Else
				MsgBox "換気；変数入力；大型車" & _
					"混入率=" & D大型車混入率
		End Select
		Select Case D走行速度
			Case Is < 0
				MsgBox "換気；変数入力；走行速度" & _
					D走行速度
			Case Is < 120
			Case Else
				MsgBox "換気；変数入力；走行速度" & _
					D走行速度
		End Select
		For i = 0 To C屈曲
			Select Case D区間延長(i)
				Case Is < 0
					MsgBox "換気；変数入力；トンネル延長" & _
						D区間延長(i)
				Case Is < 50000
				Case Else
					MsgBox "換気；変数入力；トンネル延長" & _
						D区間延長(i)
			End Select
		Next
		Select Case Dトンネル標高
			Case Is < -100
				MsgBox "換気；変数入力；トンネル標高" & _
					Dトンネル標高
			Case Is < 3000
			Case Else
				MsgBox "換気；変数入力；トンネル標高" & _
					Dトンネル標高
		End Select
		'新基準追加
		Select Case I供用年度
			Case Is < 20
					MsgBox "換気；変数入力；供用年度" & _
							I供用年度
			Case Is < 26
			Case Else
					MsgBox "換気；変数；供用年度" & _
							I供用年度
		End Select
		Select Case D速度補正係数S
			Case Is < 0.92
					MsgBox "換気H20;変数入力；速度勾配S=" & _
					 D速度補正係数S
			Case Is < 1.11
			Case Else
					MsgBox "換気H20;変数入力；速度勾配S=" & _
					 D速度補正係数S
		End Select
		Select Case D速度補正係数L
			Case Is < 0.91
					MsgBox "換気H20;変数入力；速度勾配L=" & _
					 D速度補正係数L
			Case Is < 1.13
			Case Else
					MsgBox "換気H20;変数入力；速度勾配L=" & _
					 D速度補正係数L
		End Select
		If nS交通方式 <> "対面通行" _
			And nS交通方式 <> "一方通行" Then
			MsgBox "換気H20；変数設定；交通方式=" & _
				nS交通方式
		End If
		'変数代入
		GD設計交通量 = D設計交通量
		GD大型車混入率 = D大型車混入率
		GD走行速度 = D走行速度
		GDトンネル断面 = Dトンネル断面
		'一方通行の判定
		'一方通行の場合は、戻りのTN延長を0とする。
		For i = 0 To C屈曲 * C対面通行
			GD区間延長(i) = 0
		Next
		If nS交通方式 = "対面通行" Then
			 ch = C上下線
		ElseIf nS交通方式 = "一方通行" Then
			 ch = 0
		Else
			 MsgBox "換気量H20" & nS交通方式
		End If
		'
		For ii = 0 To ch
			For i = 0 To C屈曲
						GD区間延長(ii * C屈曲 + i) = D区間延長(i)
			Next
		Next
		For ii = 0 To C上下線
			For i = 0 To C屈曲
				GD_KS(ii * C屈曲 + i) = D勾配補正係数S(ii, i)
			Next
		Next
		For ii = 0 To C上下線
			For i = 0 To C屈曲
				GD_KL(ii * C屈曲 + i) = D勾配補正係数L(ii, i)
			Next
		Next
		GI供用年度 = I供用年度
		GD_KVS = D速度補正係数S
		GD_KVL = D速度補正係数L
		GDトンネル標高 = Dトンネル標高
		GS交通方式 = nS交通方式
	'計算実行
		S08換気量_煤煙
	'----------------------------------------
	'  Debug.Print "＜換気；変数設定＞"
	'  Debug.Print "設計交通量 ="; GD設計交通量
	'  Debug.Print "大型車混入率="; GD大型車混入率
	'  Debug.Print "走行速度  ="; GD走行速度
	'  Debug.Print "トンネル断面="; GDトンネル断面
	'  Debug.Print "トンネル標高="; GDトンネル標高
	'  Debug.Print "トンネル区間延長"; GD区間延長(0)
	'  Debug.Print "------------------------------"
	'  Debug.Print "標高補正計数   ="; GD_Kh
	'  Debug.Print "煤煙透過率    ="; GD煤煙透過率
	'  Debug.Print "煤煙濃度     ="; GD煤煙濃度
	'  Debug.Print "単位基準換気量    ="; GD単位基準換気量_煤煙(0)
	'  Debug.Print "煤煙換気量    ="; GD換気量_煤煙
	'  Debug.Print "------------------------------"
	End Sub
	'----------------------------------------
	'目的 煤煙換気量計算
	'日付 030510
	'----------------------------------------
	Private Sub S08換気量_煤煙()
		Dim i As Integer
		Dim ch As Double
		S07標高補正係数_煤煙
		S01年度排出量標準偏差定義
		S03煤煙排出量の補正
		S01煤煙透過率
		S02煤煙濃度
		S03煤煙平均排出量
		S04煤煙排出量標準偏差
		S05単位基準換気量_煤煙
		GD換気量_煤煙 = 0
		'一方通行の判定
		If GS交通方式 = "対面通行" Then
			 ch = 2
		ElseIf GS交通方式 = "一方通行" Then
			 ch = 1
		Else
			 MsgBox "換気量H20" & GS交通方式
		End If
		For i = 0 To C屈曲 * 2
			GD区間換気量(i) = _
				GD単位基準換気量_煤煙(i) _
				* GD区間延長(i) _
				* GD設計交通量 / ch / 1000
			'Debug.Print "延長"; GD区間延長(i)
			'換気量計算
			GD換気量_煤煙 = _
				GD換気量_煤煙 + GD区間換気量(i)
		Next
		'Debug.Print "換気量"; GD換気量_煤煙
	End Sub
	'----------------------------------------
	'目的 排出量、標準偏差、微粒子率の定義
	'入力 I供用年度
	'出力 上記値
	'日付 080707
	'----------------------------------------
	Private Sub S01年度排出量標準偏差定義()
		GDμL = F排出量(C平均L, GI供用年度)
		GDμS = F排出量(C平均S, GI供用年度)
		GDσL = F排出量(C偏差L, GI供用年度)
		GDσS = F排出量(C偏差S, GI供用年度)
		GD_RL = F排出量(C率L, GI供用年度)
		GD_RS = F排出量(C率S, GI供用年度)
	'  Debug.Print "GDμL="; GDμL
	'  Debug.Print "GDμS="; GDμS
	'  Debug.Print "GDσL="; GDσL
	'  Debug.Print "GDσS="; GDσS
	'  Debug.Print "GD_RL="; GD_RL
	'  Debug.Print "GD_RS="; GD_RS
	End Sub
	'テーブル作成
	Private Function F排出量(I項目 As Integer, _
														I供用年度 As Integer) As Double
			Dim D表(6, 5) As Double
			Dim tempA As Double
			Dim tempB As Long
		 '入力変数のチェック
		 Select Case I項目
			Case Is < 0
					MsgBox "換気量H20;F排出量;I項目=" & I項目
			Case Is < 7
			Case Else
					MsgBox "換気量H20;F排出量;I項目=" & I項目
		 End Select
				Select Case I供用年度
			Case Is < 20
					MsgBox "換気量H20;F排出量;I供用年度=" & I供用年度
			Case Is < 26
			Case Else
					MsgBox "換気量H20;F排出量;I供用年度=" & I供用年度
		 End Select
			'速度定義
		 D表(C年, 0) = 20
		 D表(C年, 1) = 21
		 D表(C年, 2) = 22
		 D表(C年, 3) = 23
		 D表(C年, 4) = 24
		 D表(C年, 5) = 25
			'平均排出量定義
		 D表(C平均S, 0) = 0.4
		 D表(C平均S, 1) = 0.4
		 D表(C平均S, 2) = 0.4
		 D表(C平均S, 3) = 0.4
		 D表(C平均S, 4) = 0.3
		 D表(C平均S, 5) = 0.3
		 D表(C平均L, 0) = 2
		 D表(C平均L, 1) = 1.8
		 D表(C平均L, 2) = 1.7
		 D表(C平均L, 3) = 1.6
		 D表(C平均L, 4) = 1.6
		 D表(C平均L, 5) = 1.5
			'標準偏差
		 D表(C偏差S, 0) = 0.4
		 D表(C偏差S, 1) = 0.4
		 D表(C偏差S, 2) = 0.4
		 D表(C偏差S, 3) = 0.4
		 D表(C偏差S, 4) = 0.3
		 D表(C偏差S, 5) = 0.3
		 D表(C偏差L, 0) = 0.7
		 D表(C偏差L, 1) = 0.6
		 D表(C偏差L, 2) = 0.6
		 D表(C偏差L, 3) = 0.6
		 D表(C偏差L, 4) = 0.6
		 D表(C偏差L, 5) = 0.5
			'微粒子率
		 D表(C率S, 0) = 0.7
		 D表(C率S, 1) = 0.65
		 D表(C率S, 2) = 0.65
		 D表(C率S, 3) = 0.6
		 D表(C率S, 4) = 0.6
		 D表(C率S, 5) = 0.55
		 D表(C率L, 0) = 0.65
		 D表(C率L, 1) = 0.6
		 D表(C率L, 2) = 0.6
		 D表(C率L, 3) = 0.55
		 D表(C率L, 4) = 0.55
		 D表(C率L, 5) = 0.5   '補正値決定
			tempA = 999
			For tempB = 0 To 5
					If I供用年度 = D表(C年, tempB) Then
							tempA = D表(I項目, tempB)
					End If
			Next
			F排出量 = tempA
			'エラー処理--------
			If tempA = 999 Then
					MsgBox "落ち着いて。エラーですね"
			End If
	End Function
	'----------------------------------------
	'目的 煤煙排出量の補正
	'入力 GD
	'出力  GD煤煙平均排出量
	'日付 030510
	'----------------------------------------
	Private Sub S03煤煙排出量の補正()
			Dim i As Integer
			For i = 0 To C屈曲 * 2
					GDμ1(i) = (GDμL * GD_RL * GD_KVL * GD_KL(i) * GD_Kh) + GDμL * (1 - GD_RL)
					GDμ2(i) = (GDμS * GD_RS * GD_KVS * GD_KS(i) * GD_Kh) + GDμS * (1 - GD_RS)
					GDσ1(i) = (GDσL * GD_RL * GD_KVL * GD_KL(i) * GD_Kh) + GDσL * (1 - GD_RL)
					GDσ2(i) = (GDσS * GD_RS * GD_KVS * GD_KS(i) * GD_Kh) + GDσS * (1 - GD_RS)
			Next
	'    Debug.Print "GDμ1(0)="; GDμ1(0)
	'    Debug.Print "GDμ2(0)="; GDμ2(0)
	'    Debug.Print "GDσ1(0)="; GDσ1(0)
	'    Debug.Print "GDσ1(0)="; GDσ1(0)
	End Sub
	'----------------------------------------
	'目的 煤煙透過率
	'入力 GD走行速度
	'出力  GD煤煙透過率
	'日付 030510
	'----------------------------------------
	Private Sub S01煤煙透過率()
		Select Case GD走行速度
			Case Is < 0
				MsgBox "換気；煤煙透過率；走行速度=" _
					& GD走行速度
			Case Is <= 60
				GD煤煙透過率 = 40
			Case Is <= 80
				GD煤煙透過率 _
					= (50 - 40) / (80 - 60) _
					* (GD走行速度 - 60) + 40
				GD煤煙透過率 = _
				Round(GD煤煙透過率, 0)
			Case Is <= 120
				GD煤煙透過率 = 50
			Case Else
				MsgBox "換気；煤煙透過率；走行速度=" _
					& GD走行速度
		End Select
	End Sub
	'----------------------------------------
	'目的 煤煙濃度
	'入力 GD煤煙透過率
	'出力  GD煤煙濃度
	'日付 030510
	'----------------------------------------
	Private Sub S02煤煙濃度()
		GD煤煙濃度 _
			= (-1) / 100 _
			* Log(GD煤煙透過率 / 100)
		'Debug.Print "煤煙濃度"; GD煤煙濃度
	End Sub
	'----------------------------------------
	'目的 煤煙平均排出量
	'入力 GD
	'出力  GD煤煙平均排出量
	'日付 030510
	'----------------------------------------
	Private Sub S03煤煙平均排出量()
		Dim i As Integer
		For i = 0 To C屈曲 * 2
			GD煤煙平均排出量(i) _
				= GD大型車混入率 _
				* GDμ1(i) _
				+ (1 - GD大型車混入率) _
				* GDμ2(i)
			'Debug.Print "μ"; GD煤煙平均排出量(i)
		Next
	End Sub
	'----------------------------------------
	'目的 煤煙排出量標準偏差
	'入力 GD
	'出力  GD煤煙排出量標準偏差
	'日付 030510
	'----------------------------------------
	Private Sub S04煤煙排出量標準偏差()
		Dim i As Integer
		For i = 0 To C屈曲 * 2
			GD煤煙排出量標準偏差(i) _
				= Sqr(GD大型車混入率 _
				* (GDσ1(i) ^ 2 _
				+ (GDμ1(i) _
				- GD煤煙平均排出量(i)) ^ 2) _
				+ (1 - GD大型車混入率) _
				* (GDσ2(i) ^ 2 _
				+ (GDμ2(i) _
				- GD煤煙平均排出量(i)) ^ 2))
		Next
	End Sub
	'----------------------------------------
	'目的 単位基準換気量
	'入力 GD
	'出力  GD単位基準換気量
	'日付 030510
	'----------------------------------------
	Private Sub S05単位基準換気量_煤煙()
		Dim i As Integer
		For i = 0 To C屈曲 * 2
			GD単位基準換気量_煤煙(i) _
				= ((3 * GD煤煙排出量標準偏差(i) _
				+ Sqr(9 * GD煤煙排出量標準偏差(i) ^ 2 _
				+ 8 * GD煤煙平均排出量(i) _
				* GD煤煙濃度 _
				* GDトンネル断面 * 1000)) _
				/ (60 * Sqr(8 * GDトンネル断面 * 1000) _
				* GD煤煙濃度)) ^ 2
			'Debug.Print "単位基準換気量"; GD単位基準換気量_煤煙(i)
		Next
	End Sub
	Public Function A01換気量_煤煙() As Double
		A01換気量_煤煙 _
			= Round(GD換気量_煤煙, 1)
	End Function
	Public Function A02標高補正係数_煤煙() As Double
		A02標高補正係数_煤煙 = GD_Kh
	End Function*/
}//A05換気量H20Class
