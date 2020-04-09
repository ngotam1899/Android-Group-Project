package hcmute.edu.vn.calculator_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,btn_add,btn_sub,btn_mul,btn_div,btn_dot,btn_delete,btn_equa;
    TextView txt_Screen;
    boolean Addition, Subtract, Multiplication, Division;
    boolean decimal;

    double input1 = 0, input2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);
        btn_add=(Button) findViewById(R.id.btn_add);
        btn_sub=(Button) findViewById(R.id.btn_sub);
        btn_mul=(Button) findViewById(R.id.btn_mul);
        btn_div=(Button) findViewById(R.id.btn_div);
        btn_dot=(Button) findViewById(R.id.btn_dot);
        btn_equa=(Button) findViewById(R.id.btn_equa);
        btn_delete=(Button) findViewById(R.id.btn_delete);
        txt_Screen=(TextView) findViewById(R.id.txt_Screen);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"1");
                decimal=true;
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText(txt_Screen.getText().toString()+"9");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {
                    //do nothing
                } else {
                    txt_Screen.setText(txt_Screen.getText() + ".");
                    decimal = true;
                }
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_Screen.getText().length()!=0){
                    input1=Float.parseFloat(txt_Screen.getText()+"");
                    Addition=true;
                    decimal=false;
                    txt_Screen.setText(null);
                }
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_Screen.getText().length()!=0){
                    input1=Float.parseFloat(txt_Screen.getText()+"");
                    Subtract=true;
                    decimal=false;
                    txt_Screen.setText(null);
                }
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_Screen.getText().length()!=0){
                    input1=Float.parseFloat(txt_Screen.getText()+"");
                    Multiplication=true;
                    decimal=false;
                    txt_Screen.setText(null);
                }
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_Screen.getText().length()!=0){
                    input1=Float.parseFloat(txt_Screen.getText()+"");
                    Division=true;
                    decimal=false;
                    txt_Screen.setText(null);
                }
            }
        });
        btn_equa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addition || Subtract || Multiplication || Division) {
                    input2 = Float.parseFloat(txt_Screen.getText() + "");
                }

                if (Addition) {

                    txt_Screen.setText(input1 + input2 + "");
                    Addition = false;
                    decimal=false;
                }

                if (Subtract) {

                    txt_Screen.setText(input1 - input2 + "");
                    Subtract = false;
                    decimal=false;
                }

                if (Multiplication) {
                    txt_Screen.setText(input1 * input2 + "");
                    Multiplication = false;
                    decimal=false;
                }

                if (Division) {
                    txt_Screen.setText(input1 / input2 + "");
                    Division = false;
                    decimal=false;
                }

            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Screen.setText("");
                input1 = 0.0;
                input2 = 0.0;
                decimal=false;
            }
        });

    }


}
