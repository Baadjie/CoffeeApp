package com.example.baadjie.coffeeapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.view.Gravity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{




    private CheckBox chck1;
    private CheckBox chck2;
    private CheckBox chck3;
   // private TextView tvTotal;
    private Button btnOrder;
    final double HOT=30;
    final double CHOC=35;
    final  double CHINA=50;
    static int count=0;
    private TextView tvTotal;
    int number=0;

    private double change=0;

    private double cash=0;

     private static double total=0;
     private static  double amount=0;
    int qauntity=0;

    private TextView tvCashs ;
    private   TextView tvChange;
    private EditText qauntity1,qauntity2,qauntity3,edtCash;

    public  static  final String CHANGE="change";
    public  static  final String CASH="cash";
    public  static  final String TOTAL="total";
    public  static  final String NUMBER="number";
    public  static final String COUNT="counts";

    public static String answerChange;
    public static String answerCash;
    public static String answerTotal;
    public static String answerNumber;
    public static String answerCount;

    public static  String NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chck1= (CheckBox) findViewById(R.id.checkBox);
        chck2= (CheckBox) findViewById(R.id.checkBox2);
        chck3= (CheckBox) findViewById(R.id.checkBox3);
        btnOrder= (Button) findViewById(R.id.button);
        tvTotal= (TextView) findViewById(R.id.txtTotal);
        qauntity1= (EditText) findViewById(R.id.editText2);
       // qauntity1= (EditText) findViewById(R.id.editText2);
        qauntity2= (EditText) findViewById(R.id.editText4);
        qauntity3=(EditText) findViewById(R.id.editText5);
        edtCash= (EditText) findViewById(R.id.txtCash);
        number=number+1;
        tvCashs= (TextView) findViewById(R.id.textView12);
         tvChange= (TextView) findViewById(R.id.textView13);

        total=0;

        Calendar c=Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String formatedDate=df.format(c.getTime());

        TextView txtText= (TextView) findViewById(R.id.Time);
        //TextView txtText=new TextView(this);
        txtText.setText("      " + formatedDate);
        //txtText.setGravity(Gravity.BOTTOM);
       // setContentView(txtText);


    }

    public void hot(View view){


       if(chck1.isChecked()){






            qauntity=Integer.parseInt(qauntity1.getText().toString());

            amount=amount+HOT ;
            amount=amount*qauntity;

            //count=count+1;
            count=count+qauntity;
           Toast.makeText(MainActivity.this, ""+amount +"R", Toast.LENGTH_SHORT).show();

        }
        else  if(chck1.isChecked()==false){

            amount=amount-amount;
            count=count-1;
            Toast.makeText(MainActivity.this, " "+ "R " +amount, Toast.LENGTH_SHORT).show();

        }




    }

    public void cap(View view){


        if(chck2.isChecked()){

            qauntity=Integer.parseInt(qauntity2.getText().toString());
           // count=count+1;
            count=count+qauntity;
            amount=amount+CHOC;
            amount=amount* qauntity;
            Toast.makeText(MainActivity.this, "R "+amount +"", Toast.LENGTH_SHORT).show();
        }
        else if(chck2.isChecked()==false){

            count=count-1;
            amount=amount-amount;
            Toast.makeText(MainActivity.this, " R "+amount +" ", Toast.LENGTH_SHORT).show();


        }




    }

    public void china(View view){


        if(chck3.isChecked()){

            qauntity=Integer.parseInt(qauntity3.getText().toString());
           // count=count+1;
            count=count+qauntity;
            amount=amount+CHINA;
            amount=amount*qauntity;
            Toast.makeText(MainActivity.this, " R "+amount +"", Toast.LENGTH_SHORT).show();
        }
        else if (chck3.isChecked()==false){


            count=count-1;
            amount=amount-amount;
            Toast.makeText(MainActivity.this, "R "+amount +" ", Toast.LENGTH_SHORT).show();

        }




    }






    public void order(View view){



        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Confirm order");
        dialog.setMessage("Are you sure you want to Order");
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                TextView tvNumber= (TextView) findViewById(R.id.textView6);
                // total=amount;

                number=number-1;
                total=0;
                count=0;

              //  tvTotal.setText("R "+total + "  of " + count +"  items" );

               // tvNumber.setText("Order number is      " +" ##0000" + number);

                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("Order", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                total=0;
                total=amount;
                //total=total-total;
                // number=number+1;


                cash=Integer.parseInt(edtCash.getText().toString());

                change=cash-total;
                EditText editName= (EditText) findViewById(R.id.edtName);

                NAME=editName.getText().toString();

                number=number+1;


                answerCash=String.valueOf(cash);
                answerChange=String.valueOf(change);
                answerTotal=String.valueOf(total);
                answerNumber=String.valueOf(number);
                answerCount=String.valueOf(count);

                Intent intent=new Intent(MainActivity.this,Summary.class);
                intent.putExtra(CHANGE,answerChange);
                intent.putExtra(CASH,answerCash);
                intent.putExtra(TOTAL,answerTotal);
                intent.putExtra(NUMBER,answerNumber);
                intent.putExtra(COUNT,answerCount);
                startActivity(intent);

                total=0;
                Toast.makeText(MainActivity.this, " Thank you for purchasing on our store ", Toast.LENGTH_SHORT).show();
                chck1.setChecked(false);
                chck2.setChecked(false);
                chck3.setChecked(false);
                cash=0;
                change=0;
                count=0;

            }
        });
        dialog.show();


    }
    public void next(View view){

        //TextView tvNumber= (TextView) findViewById(R.id.textView6);
        // total=amount;

        number=number+1;
        total=0;
        count=0;
        cash=0;
        change=0;
        //int tot=0;
       amount-=amount;
       // change=change-change;
       // cash=cash-cash;

      //  tvTotal.setText("R "+total + "  of " + count +"  items" + cash + change );

        //tvCashs.setText("R  "+cash);
       // tvChange.setText("R  "+change);
       // tvTotal.setText("R "+total + "  of " + count +"  items" );
     //   tvNumber.setText("Order number is      " +" ##0000" + number);

        chck1.setChecked(false);
        chck2.setChecked(false);
        chck3.setChecked(false);

    }
    public void back(View view){

       // TextView tvNumber= (TextView) findViewById(R.id.textView6);
        // total=amount;

        number=number-1;
        total=0;
        count=0;

        //tvTotal.setText("R "+total + "  of " + count +"  items" );

       // tvNumber.setText("Order number is      " +" ##0000" + number);



    }

    @Override
    public void onClick(View v) {

    }
}
