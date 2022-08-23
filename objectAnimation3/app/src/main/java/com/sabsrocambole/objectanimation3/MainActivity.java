package com.sabsrocambole.objectanimation3;
//essa versão é igual a primeira, que já funciona normalmente, mas aqui vamos add
//as propriedades de multiplas animações na mesma imagem
//vamos fazer no do API

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.util.Property;
import android.view.View;
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

        //multiplas animações

        //1) faz a img desaparecer
        PropertyValuesHolder animacao1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);

        //2) modifica o posicionamento do objeto no eixo x
        PropertyValuesHolder animacao2 = PropertyValuesHolder.ofFloat("x", 50f, 70f);

        //3) modifica o posicionamento do objeto no eixo y
        PropertyValuesHolder animacao3 = PropertyValuesHolder.ofFloat("y", 40f, 0f);

        //as três animações vão acontecer ao mesmo tempo

        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(img,animacao1,animacao2,animacao3);
        anim.setDuration(6000);

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
