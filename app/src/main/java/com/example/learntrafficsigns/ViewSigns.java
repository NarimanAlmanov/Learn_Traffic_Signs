package com.example.learntrafficsigns;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.text.LineBreaker;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.RelativeLayout;
import android.view.ViewGroup;
public class ViewSigns extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_signs);

        ScrollView scrollView = findViewById(R.id.scrollView);
        LinearLayout mainLayout;
        mainLayout = findViewById(R.id.mainLinearLayout);

        // Создаем несколько пользовательских элементов
        for (int i = 1; i <= 49; i++) {
            int imageResource = getResources().getIdentifier("sign" + i, "drawable", getPackageName());
            LinearLayout element = createCustomElement(imageResource, "Warning signs " + i);
            mainLayout.addView(element);
        }
    }

    // Метод для создания элемента с изображением и текстом
    private LinearLayout createCustomElement(int imageResource, String text) {
        // Создаем новый LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                300)); // Устанавливаем высоту в 170dp
        linearLayout.setPadding(10, 10, 10, 10); // Устанавливаем отступы

        // Создаем CardView
        androidx.cardview.widget.CardView cardView = new androidx.cardview.widget.CardView(this);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        cardView.setPadding(10, 10, 10, 10);
        cardView.setRadius(10); // Устанавливаем скругленные углы


        // Создаем RelativeLayout внутри CardView
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(relativeParams);

        // Создаем ImageView
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(
                300,
                RelativeLayout.LayoutParams.MATCH_PARENT));
        imageView.setPadding(10, 10, 10, 10); // Устанавливаем отступы
        imageView.setImageResource(imageResource);
        relativeLayout.addView(imageView);

        // Создаем TextView
        TextView textView = new TextView(this);
        relativeLayout.addView(textView);
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                500,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, imageView.getId());
        textView.setLayoutParams(textParams);
        textView.setText(text);
        textView.setTextColor(0xFF000FFF); // Устанавливаем цвет текста
        textView.setTextSize(20); // Устанавливаем размер текста
        textView.setBreakStrategy(LineBreaker.BREAK_STRATEGY_BALANCED);
        textView.setTypeface(null, Typeface.BOLD); // Устанавливаем жирный стиль текста


        // Добавляем RelativeLayout в CardView
        cardView.addView(relativeLayout);

        // Добавляем CardView в LinearLayout
        linearLayout.addView(cardView);

        return linearLayout;
    }
}