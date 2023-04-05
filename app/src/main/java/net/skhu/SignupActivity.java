package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xml.sax.ErrorHandler;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button button = findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inner class 는 아우터 클래스의 this도 사용가능
                // outer.this
                // findViewById -> SignupActivity.this. 의 메소든
                EditText editText_loginId = findViewById(R.id.editText_loginId);
                String loginId = editText_loginId.getText().toString();
                if (isEmptyOrWhiteSpace(loginId))
                    // 문자열을 하드코딩하면 언어 설정 변경에 좋지 않다.
                    // 문자열 리소스를 사용하는 것이 바람직하다.
                    editText_loginId.setError(getString(R.string.input_loginId));

                EditText editText_password = findViewById(R.id.editText_Password);
                String password = editText_password.getText().toString();
                if (isEmptyOrWhiteSpace(password))
                    editText_password.setError(getString(R.string.input_password));

                EditText editText_password2 = findViewById(R.id.editText_password2);
                String password2 = editText_password2.getText().toString();
                if (isEmptyOrWhiteSpace(password2))
                    editText_password.setError(getString(R.string.passwordsNotEqual));

                EditText editText_email = findViewById(R.id.editText_email);
                String email = editText_email.getText().toString();

                // 회원 가입 데이터 를 서버에 전송 하는 코드를 구현 해야 함.
                String msg = "회원가입 성공: " + loginId + " " + email;

                // 그러면 Toast는 왜 넣을까?
                Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, MemoActivity.class);
                startActivity(intent);
            }
        };
        button.setOnClickListener(listener);
    }

    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}