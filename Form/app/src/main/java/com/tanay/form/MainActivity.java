package com.tanay.form;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (isValidEmail(email))
                {
                    // Valid email, proceed to registration
                    // Implement your registration logic here
                    // For example, save user data to a database
                    // ...

                    // Navigate to the "Successfully Registered" page
                    navigateToSuccessfullyRegisteredPage();
                } else
                {
                    editTextEmail.setError("Invalid email address");
                }
            }
        });
    }

    private boolean isValidEmail(String email)
    {
        // Implement your email validation logic here
        // (Regex, length check, etc.)
        return true; // Placeholder; replace with actual validation
    }

    private void navigateToSuccessfullyRegisteredPage()
    {
        // Implement your navigation logic here
        // For example, start a new activity or fragment
        // ...

        // Placeholder: Show a toast message for demonstration
        Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show();
    }
}
