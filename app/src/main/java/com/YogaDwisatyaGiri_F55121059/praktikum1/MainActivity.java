package com.YogaDwisatyaGiri_F55121059.praktikum1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtwidth;
    private EditText edtheight;
    private EditText edtlength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtwidth = findViewById(R.id.edt_width) ;
        edtheight = findViewById(R.id.edt_height) ;
        edtlength = findViewById(R.id.edt_length) ;
        btnCalculate = findViewById(R.id.btn_calculate) ;
        tvResult = findViewById(R.id.tv_result) ;
        btnCalculate.setOnClickListener(this) ;

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLength = edtlength.getText().toString().trim() ;
            String inputWidth = edtwidth.getText().toString().trim() ;
            String inputHeigth = edtheight.getText().toString().trim() ;

            boolean isEmptyField = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyField = true;
                edtlength.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyField = true;
                edtwidth.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeigth)) {
                isEmptyField = true;
                edtheight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyField) {
                Double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) * Double.parseDouble(inputHeigth);
                tvResult.setText(String.valueOf(volume));

            }

        }
    }
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}


