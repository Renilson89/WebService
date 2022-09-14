package com.example.webservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Button botaoRecuperar;
    private TextView textView;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        botaoRecuperar = findViewById(R.id.button);
        String urlCep = "https://viacep.com.br/ws/";
        retrofit = new Retrofit.Builder()
                .baseUrl(urlCep)
                        .addCallAdapterFactory(GsonConverterFactory.create())
                                .build()


        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask task = new MyTask();
                String urlApi = "viacep.com.br/ws/76801059/json/";
                task.execute(urlApi);
            }
        });
    }

      /*  public class MyTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... strings) {
                String stringURL = strings[0];
                InputStream inputStream = null;
                InputStreamReader inputStreamReader = null;
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    URL url = new URL(stringURL);
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    inputStream = conexao.getInputStream();
                    inputStreamReader = new InputStreamReader (inputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String linha = "";
                    while ((linha = reader.readLine()) != null) {
                        stringBuffer.append(linha);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return stringBuffer.toString();
            }
        }*/
    }




