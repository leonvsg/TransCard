package com.leonvsg.transcard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private CaptchaRecognition tesseract;
    private HttpClient httpClient;
    private Parser parser;
    private CardRequestModel model;
    private TextView tesseractTextView;
    private ImageView codeImageView;
    private Button button;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tesseract = new CaptchaRecognition(this);
        httpClient = new HttpClient();
        parser = new Parser();

        codeImageView = findViewById(R.id.codeImage);
        button = findViewById(R.id.button);
        tesseractTextView = findViewById(R.id.result);

        button.setOnClickListener(v -> {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
            tesseractTextView.setText(tesseract.convert(bitmap));
        });

        httpClient.run(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                codeImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.placeholder_error));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                model = parser.parseCardRequestModel(response.body().string());
                setCodeImageAndActivateButton(model.getCheckCodeUri());
            }
        });
    }

    private void setCodeImageAndActivateButton(String imageUri){
        Picasso picasso = Picasso.with(this);
        picasso.setIndicatorsEnabled(true);
        picasso.load(imageUri).placeholder(R.drawable.placeholder).error(R.drawable.placeholder_error).into(codeImageView);
        button.setEnabled(true);
    }
}
