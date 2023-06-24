package com.ppp.pppprinttest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ppp.pppprinttest.R;
import com.ppp.pppprinttest.utils.SunmiPrintHelper;

public class MainActivity extends AppCompatActivity {

    Button mButtonTestPrint;
    TextView mTextViewPrinterStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mButtonTestPrint = findViewById(R.id.btnTestPrint);
        mTextViewPrinterStatus = findViewById(R.id.tvText);
        mButtonTestPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int status_printer  = SunmiPrintHelper.getInstance().sunmiPrinter;
                Log.d("ppp", String.valueOf(status_printer));
                String strPaperSize= SunmiPrintHelper.getInstance().getPrinterPaper();
                mTextViewPrinterStatus.setText("Status : " + String.valueOf(status_printer) + " " + strPaperSize);
                SunmiPrintHelper.getInstance().initPrinter(); //reset to default config
                SunmiPrintHelper.getInstance().printText("Hi! ppp\n", 18, true, false, null);
                SunmiPrintHelper.getInstance().printText("Hi! >.<\n", 20, true, false, null);
                SunmiPrintHelper.getInstance().printDashLine();
                SunmiPrintHelper.getInstance().cutpaper();
                Log.d("ppp", "Hii");
            }
        });
    }
    private void init() {
        SunmiPrintHelper.getInstance().initSunmiPrinterService(this);
    }
}