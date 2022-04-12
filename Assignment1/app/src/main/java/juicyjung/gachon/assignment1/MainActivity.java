package juicyjung.gachon.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtUserName;
    EditText txtUserDepartment;
    EditText txtUserStudentId;
    EditText txtUrl;
    EditText txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = findViewById(R.id.userName);
        txtUserDepartment = findViewById(R.id.userDepartment);
        txtUserStudentId = findViewById(R.id.userStudentId);
        txtUrl = findViewById(R.id.showUrl);
        txtPhoneNumber = findViewById(R.id.showPhoneNumber);

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();
                String userDepartment = txtUserDepartment.getText().toString();
                String userStudentId = txtUserStudentId.getText().toString();

                Bundle loginBundle = new Bundle();
                loginBundle.putString("userName", userName);
                loginBundle.putString("userDepartment", userDepartment);
                loginBundle.putString("userStudentId", userStudentId);

                Intent loginIntent = new Intent(MainActivity.this, NewActivity.class);
                loginIntent.putExtras(loginBundle);

                startActivityForResult(loginIntent, 1122);


            }
        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //…
//            }
//        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //…
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String url = data.getStringExtra("url");
        String phoneNumber = data.getStringExtra("phoneNumber");

        txtUrl.setText(url);
        txtPhoneNumber.setText(phoneNumber);
    }
}