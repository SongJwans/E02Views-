package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners);
        // 데이터 목록
        String[] stringArray = {"집주소", "직장주소", "기타"};

        // 데이터를 화면에 보여주기 위한 뷰를 만들어주는 일을 adapter가 한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner
        Spinner spinner = findViewById(R.id.spinner_addressType);
        spinner.setAdapter(adapter);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner1 = findViewById(R.id.spinner_phoneType);
                int index1 = spinner1.getSelectedItemPosition();
                String text1 = spinner1.getSelectedItem().toString();

                Spinner spinner2 = findViewById(R.id.spinner_addressType);
                int index2 = spinner2.getSelectedItemPosition();
                String text2 = spinner2.getSelectedItem().toString();

                String s = String.format("전화:%s(%d) 주소:%s(%d)", text1, index1, text2, index2);
                Toast.makeText(SpinnersActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        };

        AdapterView.OnItemSelectedListener listener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                String s = stringArray[i];
                // Context 가 Activity 의 부모 클래스
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        spinner.setOnItemSelectedListener(listener2);

        Button button = (Button) findViewById(R.id.btnSave);
        button.setOnClickListener(listener1);

    }
}