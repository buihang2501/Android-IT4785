package hangbt.hust.caculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewResult;
    String expression = "";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        findViewById(R.id.buttonCE).setOnClickListener(this);
        findViewById(R.id.buttonC).setOnClickListener(this);
        findViewById(R.id.buttonBS).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonSub).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonEqual).setOnClickListener(this);
        findViewById(R.id.buttonDot).setOnClickListener(this);
        findViewById(R.id.buttonConvert).setOnClickListener(this);
        findViewById(R.id.buttonOne).setOnClickListener(this);
        findViewById(R.id.buttonTwo).setOnClickListener(this);
        findViewById(R.id.buttonThree).setOnClickListener(this);
        findViewById(R.id.buttonFour).setOnClickListener(this);
        findViewById(R.id.buttonFive).setOnClickListener(this);
        findViewById(R.id.buttonSix).setOnClickListener(this);
        findViewById(R.id.buttonSeven).setOnClickListener(this);
        findViewById(R.id.buttonEight).setOnClickListener(this);
        findViewById(R.id.buttonNine).setOnClickListener(this);
        findViewById(R.id.buttonZero).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonCE:
                expression = "";
                textViewResult.setText("0");
                break;
            case R.id.buttonC:
                break;
            case R.id.buttonBS:
                expression = expression.substring(0, expression.length() - 1);
                textViewResult.setText(expression);
                break;
            case R.id.buttonAdd:
                Log.d(TAG, "onClick: "+expression.length());;
                if (expression.charAt(expression.length() - 1) == '+' ||
                        expression.charAt(expression.length() - 1) == '-' ||
                        expression.charAt(expression.length() - 1) == 'x' ||
                        expression.charAt(expression.length() - 1) == ':') {
                    Toast.makeText(this, "phép toán không phù hợp!", Toast.LENGTH_SHORT).show();
                } else {
                    expression += "+";
                    textViewResult.setText(expression);
                }
                break;
            case R.id.buttonDivide:
                if (expression.charAt(expression.length() - 1) == '+' ||
                        expression.charAt(expression.length() - 1) == '-' ||
                        expression.charAt(expression.length() - 1) == 'x' ||
                        expression.charAt(expression.length() - 1) == ':') {
                    Toast.makeText(this, "phép toán không phù hợp!", Toast.LENGTH_SHORT).show();
                } else {
                    expression += ":";
                    textViewResult.setText(expression);
                }
                break;
            case R.id.buttonSub:
                if (expression.charAt(expression.length() - 1) == '+' ||
                        expression.charAt(expression.length() - 1) == '-' ||
                        expression.charAt(expression.length() - 1) == 'x' ||
                        expression.charAt(expression.length() - 1) == ':') {
                    Toast.makeText(this, "phép toán không phù hợp!", Toast.LENGTH_SHORT).show();
                } else {
                    expression += "-";
                    textViewResult.setText(expression);
                }
                break;
            case R.id.buttonMultiply:
                if (expression.charAt(expression.length() - 1) == '+' ||
                        expression.charAt(expression.length() - 1) == '-' ||
                        expression.charAt(expression.length() - 1) == 'x' ||
                        expression.charAt(expression.length() - 1) == ':') {
                    Toast.makeText(this, "phép toán không phù hợp!", Toast.LENGTH_SHORT).show();
                } else {
                    expression += "x";
                    textViewResult.setText(expression);
                }
                break;
            case R.id.buttonDot:
                break;
            case R.id.buttonConvert:
                break;
            case R.id.buttonEqual:
                //Todo: xử lý biểu thức expression
                String result = String.valueOf(doCalculator(expression));
                textViewResult.setText(expression+"="+result);
                expression = result;
                break;
            case R.id.buttonOne:
                expression += "1";
                textViewResult.setText(expression);
                break;
            case R.id.buttonTwo:
                expression += "2";
                textViewResult.setText(expression);
                break;
            case R.id.buttonThree:
                expression += "3";
                textViewResult.setText(expression);
                break;
            case R.id.buttonFour:
                expression += "4";
                textViewResult.setText(expression);
                break;
            case R.id.buttonFive:
                expression += "5";
                textViewResult.setText(expression);
                break;
            case R.id.buttonSix:
                expression += "6";
                textViewResult.setText(expression);
                break;
            case R.id.buttonSeven:
                expression += "7";
                textViewResult.setText(expression);
                break;
            case R.id.buttonEight:
                expression += "8";
                textViewResult.setText(expression);
                break;
            case R.id.buttonNine:
                expression += "9";
                textViewResult.setText(expression);
                break;
            case R.id.buttonZero:
                expression += "0";
                textViewResult.setText(expression);
                break;
        }
    }

    private int doCalculator(String expression) {
        Log.d(TAG, "doCalculator: " + expression);
        //chuyển đổi từ expresssion sang dạng biểu thức hậu tố
        List<String> hauto = new ArrayList<>();
        Stack<String> st = new Stack<>();
        int mark1 = 0; //đánh dấu để tách toán hạng với phép tính
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                if (mark1 < i) {
                    hauto.add(expression.substring(mark1, i));
                }
                Log.d(TAG, "doCalculator: " + st);
                if (!st.empty()) {
                    Log.d(TAG, "doCalculator: " + st.peek());
                    while (!st.empty() && (st.peek().equals("+") || st.peek().equals("-") || st.peek().equals("x") || st.peek().equals(":"))) {
                        hauto.add(st.peek());
                        st.pop();
                    }
                }
                st.push("+");
                mark1 = i + 1;
            }
            if (expression.charAt(i) == '-') {
                if (mark1 < i) {
                    hauto.add(expression.substring(mark1, i));
                }
                if (!st.empty()) {
                    while (!st.empty() && (st.peek() == "+" || st.peek() == "-" || st.peek() == "x" || st.peek() == ":")) {
                        hauto.add((String) st.pop());
                    }
                }
                st.push("-");
                mark1 = i + 1;
            }
            if (expression.charAt(i) == 'x') {
                if (mark1 < i) {
                    hauto.add(expression.substring(mark1, i));
                }
                if (!st.empty()) {
                    while (!st.empty() && (st.peek() == "x" || st.peek() == ":")) {
                        hauto.add((String) st.pop());
                    }
                }
                st.push("x");
                mark1 = i + 1;
            }
            if (expression.charAt(i) == ':') {
                if (mark1 < i) {
                    hauto.add(expression.substring(mark1, i));
                }
                if (!st.empty()) {
                    while (!st.empty() && (st.peek() == "x" || st.peek() == ":")) {
                        hauto.add((String) st.pop());
                    }
                }
                st.push(":");
                mark1 = i + 1;
            }
        }

        hauto.add(expression.substring(mark1, expression.length()));//lấy toán hạng cuối cùng của biểu thức
        //đưa hết các phần tử trong stack vào hậu tố
        while (!st.empty()) {
            hauto.add((String) st.pop());
        }

        //thực hiện phép toán với hậu tố
        Log.d(TAG, "doCalculator: " + hauto);
        Stack<Integer> stack = new Stack<>();
        Integer number1, number2;
        for (int i = 0; i < hauto.size(); i++) {
            switch (hauto.get(i)) {
                case "+":
                    number1 = stack.pop();
                    number2 = stack.pop();
                    stack.push(number1 + number2);
                    break;
                case "-":
                    number1 = stack.pop();
                    number2 = stack.pop();
                    stack.push(number2 - number1);
                    break;
                case "x":
                    number1 = stack.pop();
                    number2 = stack.pop();
                    stack.push(number1 * number2);
                    break;
                case ":":
                    number1 = stack.pop();
                    number2 = stack.pop();
                    stack.push(number2 / number1);
                    break;
                default:
                    stack.push(Integer.valueOf(hauto.get(i)));
            }
        }
        int result = stack.pop();
        return result;
    }
}
