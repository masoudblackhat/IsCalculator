package com.example.masoud.iscalculator;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_zero, txt_0ne, txt_two,
            txt_three, txt_four, txt_five,
            txt_six, txt_siven, txt_eight,
            txt_nine, txt_plus, txt_minus,
            txt_multiplier, txt_devide,
            txt_delete, txt_equal;
    TextView txt_result,
            txt_double_zero, txt_clear, txt_ceremony
            , txt_ce, txt_dot, txt_step, txt_power, txt_remainder;


    String num1 , num2 , num3 , num4 , num5;
    String old, New ;

    boolean plus, minus,
            multi, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = (TextView) findViewById(R.id.textView26);
        txt_step = (TextView) findViewById(R.id.textView25);

        txt_clear = (TextView) findViewById(R.id.txt_clear);
        txt_plus = (TextView) findViewById(R.id.txt_plus);
        txt_equal = (TextView) findViewById(R.id.txt_equal);
        txt_minus = (TextView) findViewById(R.id.txt_minus);
        txt_multiplier = (TextView) findViewById(R.id.txt_multiplier);
        txt_devide = (TextView) findViewById(R.id.txt_devide);


        txt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_result.setText("");
            }
        });
        txt_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = txt_result.getText().toString();
                if(oldValue.indexOf("+") != -1)
                {
                    return;
                }
                else
                {
                    txt_result.setText(oldValue + "+");
                }
            }
        });
        txt_devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = txt_result.getText().toString();
                if(oldValue.indexOf("/") != -1)
                {
                    return;
                }
                else
                {
                    txt_result.setText(oldValue + "/");
                }
            }
        });
        txt_multiplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = txt_result.getText().toString();
                if(oldValue.indexOf("*") != -1)
                {
                    return;
                }
                else
                {
                    txt_result.setText(oldValue + "*");
                }
            }
        });
        txt_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = txt_result.getText().toString();
                if(oldValue.indexOf("-") != -1)
                {
                    return;
                }
                else
                {
                    txt_result.setText(oldValue + "-");
                }
            }
        });

        txt_equal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String oldValue = txt_result.getText().toString();
                if (oldValue.contains("+") && oldValue.contains("-")) Fullmethod();
                else if (oldValue.contains("*") && oldValue.contains("/")) Fullmethod();
                else if (oldValue.contains("+") && oldValue.contains("*")) Fullmethod();
                else if (oldValue.contains("-") && oldValue.contains("/")) Fullmethod();
                else if (oldValue.contains("+")) Method_All();
                else if (oldValue.contains("-")) Method_All();
                else if (oldValue.contains("*")) Method_All();
                else if (oldValue.contains("/")) Method_All();
            }
        });

    }
//  this method help to calculate one operator
    private void Method_All()
    {
        String oldValue = txt_result.getText().toString();
        int findPlus = oldValue.indexOf("+");
        if(findPlus != -1) {
            old = oldValue.substring(0, findPlus);
            New = oldValue.substring(findPlus + 1, oldValue.length());
            int num1 = Integer.parseInt(old);
            int num2 = Integer.parseInt(New);
            txt_step.setText("" + (num1 + num2));
        }

        int findMines = oldValue.indexOf("-");
        if(findMines != -1) {
            old = oldValue.substring(0, findMines);
            New = oldValue.substring(findMines + 1, oldValue.length());
            int num1 = Integer.parseInt(old);
            int num2 = Integer.parseInt(New);
            txt_step.setText("" + (num1 - num2));
        }

        int findMultiplay = oldValue.indexOf("*");
        if(findMultiplay != -1) {
            old = oldValue.substring(0, findMultiplay);
            New = oldValue.substring(findMultiplay + 1, oldValue.length());
            int num1 = Integer.parseInt(old);
            int num2 = Integer.parseInt(New);
            txt_step.setText("" + (num1 * num2));
        }

        int findDevided = oldValue.indexOf("/");
        if(findDevided != -1) {
            old = oldValue.substring(0, findDevided);
            New = oldValue.substring(findDevided + 1, oldValue.length());
            int num1 = Integer.parseInt(old);
            int num2 = Integer.parseInt(New);
            txt_step.setText("" + (num1 / num2));
        }

    }
//  this method help to calculate four operators
    private void Fullmethod ()
    {

        String oldValue = txt_result.getText().toString();
        int PF = oldValue.indexOf("+");
        int PM = oldValue.indexOf("-");
        int PMM = oldValue.indexOf("*");
        int PD = oldValue.indexOf("/");
        if(PF != -1 && PM != -1)
        {
            num1 = oldValue.substring(0,PF);
            num2 = oldValue.substring(PF+1 , PM);
            num3 = oldValue.substring(PM+1 , oldValue.length());
            int num_1 = Integer.parseInt(num1);
            int num_2 = Integer.parseInt(num2);
            int num_3 = Integer.parseInt(num3);

            txt_step.setText(""+(num_1+num_2-num_3));
        }
        else if(PMM != -1 && PD != -1)
        {
            num1 = oldValue.substring(0,PMM);
            num2 = oldValue.substring(PMM+1 , PD);
            num3 = oldValue.substring(PD+1 , oldValue.length());
            int num_1 = Integer.parseInt(num1);
            int num_2 = Integer.parseInt(num2);
            int num_3 = Integer.parseInt(num3);

            txt_step.setText(""+(num_1*num_2/num_3));
        }

        else if(PF != -1 && PMM != -1)
        {
            num1 = oldValue.substring(0,PF);
            num2 = oldValue.substring(PF+1 , PMM);
            num3 = oldValue.substring(PMM+1 , oldValue.length());
            int num_1 = Integer.parseInt(num1);
            int num_2 = Integer.parseInt(num2);
            int num_3 = Integer.parseInt(num3);

            txt_step.setText(""+(num_1+num_2*num_3));
        }

        else if(PM != -1 && PD != -1)
        {
            num1 = oldValue.substring(0,PM);
            num2 = oldValue.substring(PM+1 , PD);
            num3 = oldValue.substring(PD+1 , oldValue.length());
            int num_1 = Integer.parseInt(num1);
            int num_2 = Integer.parseInt(num2);
            int num_3 = Integer.parseInt(num3);

            txt_step.setText(""+(num_1-num_2/num_3));
        }

    }

    public void onClick(View view)
    {
            int length = txt_result.length();
            if (length <= 13) {
                int getTagNum = Integer.parseInt(view.getTag().toString());
                appendNumerToTextView(getTagNum);
            } else {
                return;
            }
    }

    private void appendNumerToTextView(int getTagNum) {
        String oldValue = txt_result.getText().toString();
        txt_result.setText(oldValue + getTagNum);
    }

}
