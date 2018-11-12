package com.example.zjf.ffmpegcommand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    static {
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avformat-57");
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("swscale-4");
        System.loadLibrary("ffmpeg");
    }

    //JNI
    public native String avformatInfo();
    public native String avCodecInfo();
    public native String avFilterInfo();
    public native String configInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
    }

    public void format(View view) {
        textView.setText(avformatInfo());
    }

    public void filter(View view) {
        textView.setText(avFilterInfo());
    }

    public void config(View view) {
        textView.setText(configInfo());
    }

    public void codec(View view) {
        textView.setText(avCodecInfo());
    }
}
