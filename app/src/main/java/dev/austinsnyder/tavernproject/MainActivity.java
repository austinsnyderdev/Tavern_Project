package dev.austinsnyder.tavernproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button registerButton = (Button) findViewById(R.id.accountInformationCompleteButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerButtonClick();
            }
        });
    }

    public void registerButtonClick() {
        EditText emailEditText = findViewById(R.id.emailInput);
        EditText passwordEditText = findViewById(R.id.passwordInput);
        EditText displayNameEditText = findViewById(R.id.displayNameInput);

        checkAndSetEditTextError(emailEditText);
        checkAndSetEditTextError(passwordEditText);
        checkAndSetEditTextError(displayNameEditText);

        String emailText = emailEditText.getText().toString();
        String passwordText = passwordEditText.getText().toString();
        String displayNameText = displayNameEditText.getText().toString();

        Log.i("CompletedLog", emailText);
    }
    //Sets empty field error indicator at the end of necessary EditText boxes
    public void checkAndSetEditTextError(EditText editText) {
        String editTextString = editText.getText().toString();
        if (TextUtils.isEmpty(editTextString)) {
            editText.setError("This item cannot be empty.");
        }
        else if (!isValidEmail(editTextString)) {
            editText.setError("Please enter a valid email address.");
        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

//    private void createAccount(String email, String password) {
//        // [START create_user_with_email]
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//        // [END create_user_with_email]
//    }
}