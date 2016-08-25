package com.example.kevin.leccion;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends AppCompatActivity {

    public Handler mHandler, mHandler2;
    ImageView n1, n2, n3;
    public  String jugador;
    TextView txtjugador, puntaje;
    public int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Intent getInfo= getIntent();
        jugador = getInfo.getStringExtra("nombre");
        txtjugador=(TextView)findViewById(R.id.textView3);
        puntaje=(TextView)findViewById(R.id.textView5);
        txtjugador.setText(jugador);
        n1=(ImageView)findViewById(R.id.imageView);
        n2=(ImageView)findViewById(R.id.imageView2);
        n3=(ImageView)findViewById(R.id.imageView3);

        for(int i=0; i<10;i++) {
            LooperThread looperThread = new LooperThread();
            looperThread.start();
            asyTask myTask = new asyTask();
            myTask.execute();
        }

        n1.setVisibility(View.VISIBLE);
        mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 1.0f);
        mAnimation.setDuration(10000);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        mScanner.setAnimation(mAnimation);

//        ((Button) findViewById( R.id.button2 )).setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ImageView img = (ImageView) findViewById( R.id.imageView );
//                moveViewToScreenCenter( img );
//                img = (ImageView) findViewById( R.id.imageView2 );
//                moveViewToScreenCenter( img );
//                img = (ImageView) findViewById( R.id.imageView3 );
//                moveViewToScreenCenter( img );
//
//            }
//        });



    }

//    private void moveViewToScreenCenter( View view )
//    {
//        RelativeLayout root = (RelativeLayout) findViewById( R.id.rootLayout );
//        DisplayMetrics dm = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics( dm );
//        int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();
//
//        int originalPos[] = new int[2];
//        view.getLocationOnScreen( originalPos );
//
//        int xDest = dm.widthPixels/2;
//        xDest -= (view.getMeasuredWidth()/10);
//        int yDest = dm.heightPixels/2 - (view.getMeasuredHeight()/2) - statusBarOffset;
//
//        TranslateAnimation anim = new TranslateAnimation( 0, xDest - originalPos[0] , 0, yDest - originalPos[1] );
//        anim.setDuration(1000);
//        anim.setFillAfter( true );
//        view.startAnimation(anim);
//    }


    private class asyTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Animation mover;
//            mover= AnimationUtils.loadAnimation(this, R.animator.mover);
//            mover.reset();
//            n1.startAnimation(mover);
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
//            TextView txt = (TextView) findViewById(R.id.output);
//            txt.setText("Executed"); // txt.setText(result);
//            // might want to change "executed" for the returned string passed
//            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

    class LooperThread extends Thread {

        public void run() {
            Looper.prepare();

            mHandler = new Handler() {
                public void handleMessage(Message msg) {

                    Bundle bundle = msg.getData();
                    String mensaje = bundle.getString("mensaje");

                    Toast.makeText(getApplicationContext(), mensaje + "  ", Toast.LENGTH_LONG)
                            .show();
                }
            };
            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("mensaje", "Este mensaje se genero con el handler");
            msg.setData(bundle);
            mHandler.sendMessageDelayed(msg, 1000);

            Looper.loop();
        }
    }
}

