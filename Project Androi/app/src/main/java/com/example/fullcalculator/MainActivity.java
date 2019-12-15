package com.example.fullcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtInput;
    TextView tvResult;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    Button btn0;
    Button btnResult;
    Button btnPoint;
    Button btnClean;
    Button btnAc;
    Button btnSqrt;
    Button btnPow;
    Button btnSin;
    Button btnCos;
    Button btnTan;
    final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickView();
    }

    public void initWidget() {
        edtInput = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnDiv = (Button) findViewById(R.id.btn_div);
        btnResult = (Button) findViewById(R.id.btn_result);
        btnPoint = (Button) findViewById(R.id.btn_point);
        btnClean = (Button) findViewById(R.id.btn_clean);
        btnAc = (Button) findViewById(R.id.btn_ac);
        btnSin = (Button) findViewById(R.id.btn_sin);
        btnCos  = (Button) findViewById(R.id.btn_cos);
        btnTan = (Button) findViewById(R.id.btn_tan);
        btnPow = (Button) findViewById(R.id.btn_pow);
        btnSqrt = (Button) findViewById(R.id.btn_sqrt);
    }

    public void setEventClickView() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnAc.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClean.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                edtInput.append("0");
                break;
            case R.id.btn_1:
                edtInput.append("1");
                break;
            case R.id.btn_2:
                edtInput.append("2");
                break;
            case R.id.btn_3:
                edtInput.append("3");
                break;
            case R.id.btn_4:
                edtInput.append("4");
                break;
            case R.id.btn_5:
                edtInput.append("5");
                break;
            case R.id.btn_6:
                edtInput.append("6");
                break;
            case R.id.btn_7:
                edtInput.append("7");
                break;
            case R.id.btn_8:
                edtInput.append("8");
                break;
            case R.id.btn_9:
                edtInput.append("9");
                break;
            case R.id.btn_add:
                edtInput.append("+");
                break;
            case R.id.btn_ac:
                edtInput.setText("");
                tvResult.setText("0");
                break;
            case R.id.btn_sub:
                edtInput.append("-");
                break;
            case R.id.btn_mul:
                edtInput.append("*");
                break;
            case R.id.btn_div:
                edtInput.append("/");
                break;
            case R.id.btn_point:
                edtInput.append(".");
                break;
            case R.id.btn_sin:
                edtInput.append("Sin(");
                break;
            case R.id.btn_cos:
                edtInput.append("Cos(");
                break;
            case R.id.btn_tan:
                edtInput.append("Tan(");
                break;
            case R.id.btn_pow:
                edtInput.append("^");
                break;
            case R.id.btn_sqrt:
                edtInput.append("√");
                break;
            case R.id.btn_clean:
                String s =  edtInput.getText().toString();
                if (s.length() != 0)
                {
                String s1 = s.substring(0,s.length()-1);
                edtInput.setText(s1);}
                break;
            case R.id.btn_result:
                addOperation(edtInput.getText().toString());
                addNumber(edtInput.getText().toString());
                DecimalFormat df = new DecimalFormat("###.######");
                double result = 0;
                if (arrayNumber.size() < arrOperation.size()){
                    tvResult.setText("Lỗi Định Dạng");
                } else if (arrayNumber.size() == 1 && arrOperation.size() == 0) {
                        result = arrayNumber.get(0);
                        tvResult.setText(df.format(result)+"");
                    }
                else if (arrayNumber.size() == 1 && arrOperation.size() == 1){
                    switch (arrOperation.get(0))
                    {
                        case "S":
                            result = result + Math.sin(arrayNumber.get(0));
                            break;
                        case "T":
                            result = result + Math.tan(arrayNumber.get(0));
                            break;
                        case "C":
                            result = result + Math.cos(arrayNumber.get(0));
                            break;
                        case "√":
                            result = Math.sqrt(arrayNumber.get(0));
                            break;
                    }
                    tvResult.setText(df.format(result) + "");
                }
                    else {
                        for (int i = 0; i < (arrayNumber.size()-1 ); i++) {
                            switch (arrOperation.get(i)) {
                                case "+":
                                    if (i == 0) {
                                        result = arrayNumber.get(i) + arrayNumber.get(i + 1);
                                    } else {
                                        result = result + arrayNumber.get(i + 1);
                                    }
                                    break;
                                case "^":
                                    result = result + Math.pow(arrayNumber.get(i),arrayNumber.get(i+1));
                                    break;
                                case "-":
                                    if (i == 0) {
                                        result = arrayNumber.get(i) - arrayNumber.get(i + 1);
                                    } else {
                                        result = result - arrayNumber.get(i + 1);
                                    }
                                    break;
                                case "*":
                                    if (i == 0) {
                                        result = arrayNumber.get(i) * arrayNumber.get(i + 1);
                                    } else {
                                        result = result * arrayNumber.get(i + 1);
                                    }
                                    break;
                                case "/":
                                    if (i == 0) {
                                        result = arrayNumber.get(i) / arrayNumber.get(i + 1);
                                    } else {
                                        result = result / arrayNumber.get(i + 1);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        tvResult.setText(df.format(result) + "");
                    }   }
        }



    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrayNumber;

    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'S':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'C':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'T':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '^':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '√':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addNumber(String stringInput) {
        arrayNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrayNumber.add(Double.valueOf(matcher.group(1)));
        }
    }


}
