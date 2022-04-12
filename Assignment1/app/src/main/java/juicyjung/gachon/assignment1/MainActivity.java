package juicyjung.gachon.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtUserName = findViewById(R.id.userName);
        EditText txtUserDepartment = findViewById(R.id.userDepartment);
        EditText txtUserStudentId = findViewById(R.id.userStudentId);
        EditText txtUrl = findViewById(R.id.url);
        EditText txtPhoneNumber = findViewById(R.id.phoneNumber);

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
        });
    }

//    @Override
//    protected void onActivityResult(int …) {
//        //… use Bundle
//    }
}