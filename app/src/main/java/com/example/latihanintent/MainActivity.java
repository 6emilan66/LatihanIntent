package com.example.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveWithObject = (Button)findViewById(R.id.btn_movewobject);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber = (Button)findViewById(R.id.btn_movedial);
        btnDialNumber.setOnClickListener(this);
        btnResult = (Button)findViewById(R.id.btn_move4result);
        btnResult.setOnClickListener(this);
        tvResult = findViewById(R.id.result);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_movewobject:
                Person mPerson = new Person();
                mPerson.setName("Gilang Restu Ramadhan");
                mPerson.setAge(17);
                mPerson.setEmail("6emilan66@gmail.com");
                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent =  new Intent(MainActivity.this,
                        MoveWObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWObjectActivity.EXTRA_PERSON, mPerson);
                    startActivity(moveWithObjectIntent);
                break;

            case R.id.btn_movedial:
                String phoneNumber = "089671188733";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move4result:
                Intent moveForResultIntent = new Intent(MainActivity.this,
                        Move4ResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == Move4ResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(Move4ResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
