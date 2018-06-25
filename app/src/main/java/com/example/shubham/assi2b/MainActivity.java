package com.example.shubham.assi2b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btna,btns,btnm,btnd,btne,btnde,btnc,btnb;
TextView tv1,tv2;
double a,b;
char op=' ';
        int e1=0;
int d=0,e=0,f=0,negative=0,result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btna=findViewById(R.id.btna);
        btns=findViewById(R.id.btns);
        btnm=findViewById(R.id.btnm);
        btnd=findViewById(R.id.btnd);
        btne=findViewById(R.id.btne);
        btnde=findViewById(R.id.btnde);
        btnc=findViewById(R.id.btnc);
        btnb=findViewById(R.id.btnb);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        hintSet();
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=0;
                if(negative==1){
                    b=-b;
                    negative=0;}
                if(op=='+')
                {
                  a=a+b;
                }
                else if (op=='-')
                {
                    a=a-b;
                }
                else if(op=='*')
                {
                    a=a*b;
                }
                else if(op=='/')
                {
                    a=a/b;
                }
                b=0;
                op=' ';
                tv1.setText(""+a);
                tv2.setText(""+a);
            }
        });
        btnde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e==0) {
                    tv1.setText(tv1.getText().toString() + '.');
                    e++;
                }
                else {
                    Toast.makeText(MainActivity.this,"More than two decimal points not allowed",Toast.LENGTH_LONG).show();
                }
            }
        });
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f++;
                e1=e;
                btne.callOnClick();
                op='+';
                d++;
                tv1.setText(tv1.getText().toString()+op);
                e=0;
            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f++;
                e1=e;
               if(op!=' '&&result==0) {
                   negative = 1;
                   tv1.setText(tv1.getText().toString()+"-");
               }
                else{
                btne.callOnClick();
                op='-';
                   tv1.setText(tv1.getText().toString()+op);}
                d++;

                e=0;

            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f++;
                e1=e;

                btne.callOnClick();
                d++;
                op='*';
                tv1.setText(tv1.getText().toString()+op);
                e=0;

            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f++;
                e1=e;

                btne.callOnClick();
                d++;
                op='/';

                tv1.setText(tv1.getText().toString()+op);
                e=0;

            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("");
                tv2.setText("");
                tv2.setHint("");
                a=0;b=0;d=0;e=0;
                op=' ';
            }
        });
        btnb.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btnc.callOnClick();
                return true;
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String s=tv1.getText().toString();
                if(d==0)
                {
                    if(e==0)
                    {
                        a=(a-(a%10))/10;
                    }
                    else
                    {
                        if(s.charAt(s.length()-1)!='.')
                        {
                           e--;
                            a=a*Math.pow(10,e);
                            a=a-(a%10);
                            a=a/Math.pow(10,e);
                        }
                        else
                        {
                            a=a*Math.pow(10,e);
                            a=a/Math.pow(10,e);
                            e=0;
                        }
                    }
                }
                else
                {
                    if(e==0) {
                        if(s.charAt(s.length()-1)!='+'&&s.charAt(s.length()-1)!='-'&&s.charAt(s.length()-1)!='*'&&s.charAt(s.length()-1)!='/')
                        {
                        b = (b - (b % 10)) / 10;
                    }
                    else
                        {
                          if(s.charAt(s.length()-1)!='-'||negative==0){
                            op=' ';
                          d--;
                          e=e1;}
                          else{
                              negative=0;
                        }
                        }

                    }
                    else
                    {
                        if(s.charAt(s.length()-1)!='.')
                        {
                            e--;
                            b=b*Math.pow(10,e);
                            b=b-(b%10);
                            b=b/Math.pow(10,e);
                        }
                        else
                        {
                            b=b*Math.pow(10,e);
                            b=b/Math.pow(10,e);
                            e=0;
                        }
                    }
                }
            if(!s.isEmpty()) {
                s = s.substring(0, s.length() - 1);
                tv1.setText(s);
                hintSet();
            }
            else {
                    btnc.callOnClick();
            }
           
            }
        });

    }
    public void onClick(View v)
    {
        Button btn=findViewById(v.getId());
        Double y=Double.parseDouble(btn.getText().toString());
        tv1.setText(tv1.getText().toString()+btn.getText());

        if(e==0)
        {
            if (d == 0)
                a = 10 * a + y;
            else {
                b = 10 * b + y;
                result = 1;
            }
        }
        else
        {
            if(d==0)
            {
                a=a+y/Math.pow(10,e);

            }
            else
            {
                b=b+y/Math.pow(10,e);
                result=1;
            }

            e++;

        }
        hintSet();
    }
    public void hintSet()
    {
        double c=a;
        if(negative==1)
            b=-b;
        if(op=='+')
        {
           c = a+b;
        }
        else if (op=='-')
        {
            c=a-b;
        }
        else if(op=='*')
        {
            c=a*b;
        }
        else if(op=='/')
        {
            c=a/b;
        }
        if(negative==1)
            b=-b;
        tv2.setText(""+c);
    }

}
