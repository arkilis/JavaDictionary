package android.apeapp.mydictjava.dictionaryjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextInput = this.findViewById(R.id.queryEditText);
        Button searchButton = this.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextInput.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input text cannot be empty", Toast.LENGTH_LONG).show();
                } else {
                    request(editTextInput.getText().toString());
                }
            }
        });
    }

    private void request(String s) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translation.googleapis.com/language/translate/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostRequestInterface postRequestInterface = retrofit.create(PostRequestInterface.class);
        Call<TranslationModel.Data> call = postRequestInterface.getCall(s);

        call.enqueue(new Callback<TranslationModel.Data>() {
            @Override
            public void onResponse(Call<TranslationModel.Data> call, Response<TranslationModel.Data> response) {
                TextView textView = findViewById(R.id.resultsTextView);
                textView.setText(response.body().data.translations.get(0).translatedText);
            }

            @Override
            public void onFailure(Call<TranslationModel.Data> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
