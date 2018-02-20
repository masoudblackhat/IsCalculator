package com.example.masoud.iscalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

  TextView txt_zero, txt_0ne, txt_two, txt_three, txt_four, txt_five, txt_six, txt_siven, txt_eight, txt_nine, txt_plus, txt_minus, txt_multiplier, txt_devide, txt_delete, txt_equal;
  TextView txt_result, txt_double_zero, txt_clear, txt_ceremony, txt_ce, txt_dot, txt_step, txt_power, txt_remainder;


  int nr1, nr2;
  String old , New;

  boolean plus, minus, multi, div;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txt_result = (TextView) findViewById(R.id.textView26);
    txt_step = (TextView) findViewById(R.id.textView25);

    txt_clear = (TextView) findViewById(R.id.txt_clear);
    txt_plus = (TextView) findViewById(R.id.txt_plus);
    txt_equal = (TextView) findViewById(R.id.txt_equal);



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
        txt_result.setText(oldValue + "+");
      }
    });

    txt_equal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String oldValue = txt_result.getText().toString();
        int findPlus = oldValue.indexOf("+");
        if(findPlus != -1)
        {
          old = oldValue.substring(0,findPlus);
          New = oldValue.substring(findPlus+1 , oldValue.length());
          int num1 = Integer.parseInt(old);
          int num2 = Integer.parseInt(New);

          txt_step.setText(""+(num1+num2));


        }


      }
    });

  }

  public void onClick(View view)
  {
    int length = txt_result.length();
    if(length <= 14)
    {

      int getTagNum = Integer.parseInt(view.getTag().toString());
      old = view.getTag().toString();
      appendNumerToTextView(getTagNum);

    }
    else
    {
      return;
    }
  }

  private void appendNumerToTextView(int getTagNum) {

    String oldValue = txt_result.getText().toString();
    txt_result.setText(oldValue + getTagNum);
  }

}
