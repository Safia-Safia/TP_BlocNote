package com.safia.tpblocnote;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    private String currentColor = "#000000";
    private int currentStyleStart;
    private int currentStyleEnd;

    private RadioGroup color;
    private  ImageButton smile, joyful, wink;
    private Button bold, italic, underline;
    EditText editer;
    TextView text;
    private SmileyGetter getter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color = findViewById(R.id.colorgroup);
        editer = findViewById(R.id.edit);
        text = findViewById(R.id.previsualisation);

        smile = findViewById(R.id.img_btn_smile);
        joyful = findViewById((R.id.img_btn_joyful));
        wink = findViewById(R.id.img_btn_wink);

        bold = findViewById(R.id.btn_gras);
        italic =findViewById(R.id.btn_itialique);
        underline = findViewById(R.id.btn_souligné);

        getter = new SmileyGetter(this);
        colorChange();
        policeStyle();

        editer.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text.setText(Html.fromHtml("<font color=\"" + currentColor + "\">" + editer.getText().toString() + "</font>", getter, null));

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });    }

    public void policeStyle(){
        currentStyleStart = editer.getSelectionStart();
        currentStyleEnd = editer.getSelectionEnd();

        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vue) {
                editer.getText().insert(currentStyleStart, "<b>");
                editer.getText().insert(currentStyleEnd, "</b>");
                editer.setText(editer.getText().toString());

            }});

        italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vue) {
                editer.getText().insert(currentStyleStart, "<i>");
                editer.getText().insert(currentStyleEnd, "</i>");
                editer.setText(editer.getText().toString());

            }});
        underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vue) {
                editer.getText().insert(currentStyleStart, "<u>");
                editer.getText().insert(currentStyleEnd, "</u>");
                editer.setText(editer.getText().toString());

            }});



    }

            public void colorChange (){
                color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.radio_btn_noir:
                                currentColor = "#000000";
                                break;
                            case R.id.radio_btn_bleu:
                                currentColor = "#0022FF";
                                break;
                            case R.id.radio_btn_rouge:
                                currentColor = "#FF0000";
                        }
                        editer.setText(editer.getText().toString());
                    }
        });


        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectionStart = editer.getSelectionStart();
                editer.getText().insert(selectionStart, "<img src=\"smile\" >");
            }
        });
        joyful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectionStart = editer.getSelectionStart();
                editer.getText().insert(selectionStart, "<img src=\"heureux\" >");
            }
        });

        wink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectionStart = editer.getSelectionStart();
                editer.getText().insert(selectionStart, "<img src=\"clin\" >");
            }
        });
    }


}


