package com.example.yo.myapp20180829kanki2;

import android.content.Context;
import android.widget.Toast;

class DebugPrint{
    private static boolean modeDebug = true;
    private static boolean modeTest = true;
    static StringBuilder buf = new StringBuilder();

    public void BufClear(){
        buf= new StringBuilder();
    }
    public void debugPrint(Object obj) {
        if (modeDebug) System.out.println("Debug:"+obj);
        buf.append("\n");
        buf.append(obj);
    }
    public void debugError(Object obj) {
        if (modeTest) System.out.println("Test:"+obj);
        buf.append("\n");
        buf.append("\n");
        buf.append("\n");
        buf.append("\n");
        buf.append("\n");
        buf.append("\n");
        buf.append("<<<Error:Error:Error:Error:Error:Error>>>:\n");
        buf.append(obj);
        buf.append("\n");
        buf.append("<<<Error:Error:Error:Error:Error:Error>>>:\n");
        buf.append("\n");
        buf.append("\n");
        buf.append("\n");
        buf.append("\n");
    }
    public String Massage(){
        return buf.toString();
    }
}
