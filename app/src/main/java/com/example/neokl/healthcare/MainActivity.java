package com.example.neokl.healthcare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.R.attr.data;
import static com.example.neokl.healthcare.R.id.editText4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Proceed(View view) {
        Intent Intent = new Intent(view.getContext(), Main2Activity.class);
        view.getContext().startActivity(Intent);
    }
    public class SavingFileInternal extends Activity {
        private String filename = "user.txt";
        private String test_string = "This is to be saved to a file on internal storage";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            // save the result
            saveData();
            TextView tv = (TextView)findViewById(R.id.editText4);
            tv.setText("File saved on internal storage!");
            tv.setText("File saved on internal storage!");
            tv.setText("File saved on internal storage!");
            tv.setText("File saved on internal storage!");
        }
              //Store data from the user to text file.
        private void saveData() {
            try {
                File file = new File(getFilesDir(), filename);
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(test_string.getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void loadData() {
            try {
                File file = new File(getFilesDir(), filename);
                InputStream is = new
                        BufferedInputStream(new FileInputStream(file));
                BufferedReader br = new
                        BufferedReader(new InputStreamReader(is));
                String input;
                test_string = "";
                while ((input = br.readLine()) != null)
                    test_string += input;
                br.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPause() {
            super.onPause();
            saveData();
        }

        @Override
        protected void onResume() {
            super.onResume();
            loadData();
        }
    }

}

