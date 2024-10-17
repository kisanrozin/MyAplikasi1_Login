package com.example.myaplikasi1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myaplikasi1.R;


public class MainActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private Button btnReset;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);
        btnReset = findViewById(R.id.btn_reset);
        btnSubmit = findViewById(R.id.btn_submit);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUserName.setText("");
                etPassword.setText("");
                Toast.makeText(MainActivity.this, "Fields cleared", Toast.LENGTH_SHORT).show();
            }
        });

        // Fungsi tombol submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                // Validasi input
                if (!userName.isEmpty() && !password.isEmpty()) {
                    // Menampilkan dialog jika berhasil login
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Login")
                            .setMessage("You have successfully logged in!")
                            .setPositiveButton("Yes", (dialog, which) -> {
                                // Membuka activity baru saat login berhasil
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                startActivity(intent);
                            })
                            .setNegativeButton("No", (dialog, which) ->
                                    Toast.makeText(MainActivity.this, "Login cancelled", Toast.LENGTH_SHORT).show())
                            .show();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
