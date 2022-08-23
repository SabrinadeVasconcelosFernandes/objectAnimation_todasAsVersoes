package com.sabsrocambole.objectanimation2;
//essa versão é igual a primeira, que já funciona normalmente, mas aqui vamos add
//as propriedades do listener na API, como exemplo(da pra fzr no XML tbm)
//com o listener podemos "ouvir", ver em que estado está o efeito que colocamos
//se ele iniciou, se ele terminou, etc
//para que? podemos aplicar propriedades dependendo do que o efeito está fzd
//naquele momento. Por ex: ahh quando a animação terminar, joga ele pra uma
//activity de login


import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //API --> OBJECT ANIMATOR
    public void efeitoAPI(View view){

        ImageView img = (ImageView) findViewById(R.id.img);

        ObjectAnimator anim = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f);
        anim.setDuration(2000);

        //essas duas linhas de código fazem com que a imagem tenha o efeito duas vezes em repetição
        anim.setRepeatCount(2);
        anim.setRepeatMode(ValueAnimator.RESTART);


        //LISTENER
        anim.addListener(new AnimatorListenerAdapter() {
            //temos 3 métodos que podemos sobescrever:

            // 1) fim da animação
            @Override
            public void onAnimationEnd(Animator animation){
                Log.i("Script","onAnimationEnd()");

            }

            // 2) começo da animação
            @Override
            public void onAnimationStart(Animator animation){
                Log.i("Script","onAnimationStart()");
            }

            // 3) repetição da animação
            @Override
            public void onAnimationRepeat(Animator animation){
                Log.i("Script","onAnimationRepeat()");
            }
        });

        if (flag){
            anim.start();
        }
        else{
            anim.reverse();
        }
        flag = !flag;

    }


    //XML --> ANIMATOR INFLATER
    public void efeitoXML(View view){

        ImageView img = (ImageView) findViewById(R.id.img);

        ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.animacao);
        anim.setTarget(img);

        if (flag){
            anim.start();
        }
        else{
            anim.reverse();
        }
        flag = !flag;

    }

}
