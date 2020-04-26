package com.davidlares.txtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText enterMessage;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.button);
        enterMessage = (EditText) findViewById(R.id.editText2);
        resultText = (TextView) findViewById(R.id.textView3);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // logic goes here
                if(!enterMessage.getText().toString().equals("")) {
                    String message = enterMessage.getText().toString();
                    writeToFile(message);
                } else {
                    // nothing
                }

            }
        });

        try {
            if(readFromFile() != null) {
                enterMessage.setText(readFromFile());
                // resultText.setText(readFromFile());

            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    // write to file -> OutputStreamWriter -> data comes in as bits
    private void writeToFile(String message) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todolist.txt", Context.MODE_PRIVATE)); // non-shared
            outputStreamWriter.write(message);
            outputStreamWriter.close(); // after writing, close
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile() throws IOException {
        String result = "";
        FileInputStream inputStream = openFileInput("todolist.txt");
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString = "";
            StringBuilder stringBuilder = new StringBuilder();
            while((tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }

            inputStream.close();
            result = stringBuilder.toString();
        }

        return result;
    }
}
