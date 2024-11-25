package com.example.chatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.R.id;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private LinearLayout chatPlaceholderLayout;

    // Placeholder for chat users
    private ArrayList<String> chatUsernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_item);

        // Initialize views
        usernameTextView = findViewById(R.id.usernameTextView);
        chatPlaceholderLayout = findViewById(R.id.chatPlaceholderLayout);

        // Example signed-in user
        usernameTextView.setText("Signed-in User");

        // Initialize chat placeholders
        chatUsernames = new ArrayList<>();
        chatUsernames.add("Placeholder Chat 1");
        chatUsernames.add("Placeholder Chat 2");
        chatUsernames.add("Placeholder Chat 3");

        updateChatPlaceholders();

        // Simulate user sign-up
        simulateSignUp("New User 1");
    }

    private void updateChatPlaceholders() {
        chatPlaceholderLayout.removeAllViews();

        for (String username : chatUsernames) {
            View chatView = getLayoutInflater().inflate(R.layout.chat_item, null);

            ImageView chatImageView = chatView.findViewById(R.id.profileImageView);
            TextView chatUsernameTextView = chatView.findViewById(R.id.usernameTextView);

            chatImageView.setImageResource(R.drawable.camera);
            chatUsernameTextView.setText(username);

            chatPlaceholderLayout.addView(chatView);
        }
    }

    private void simulateSignUp(String newUser) {
        if (chatUsernames.size() < 3) {
            chatUsernames.add(newUser);
            updateChatPlaceholders();
        } else {
            Toast.makeText(this, "No space for more chats!", Toast.LENGTH_SHORT).show();
        }
    }
}
