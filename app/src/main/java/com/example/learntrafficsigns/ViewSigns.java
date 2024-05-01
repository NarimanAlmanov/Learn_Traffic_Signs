package com.example.learntrafficsigns;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
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

        // Создаем ScrollView
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        // Создаем LinearLayout внутри ScrollView
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // Создаем несколько пользовательских элементов
        for (int i = 0; i < 100; i++) {
            LinearLayout element = createCustomElement(R.drawable.sign39, "Warning signs " + i);
            mainLayout.addView(element);
        }

        // Добавляем LinearLayout в ScrollView
        scrollView.addView(mainLayout);

        // Устанавливаем ScrollView в качестве содержимого активности
        setContentView(scrollView);
    }

    // Метод для создания элемента с изображением и текстом
    private LinearLayout createCustomElement(int imageResource, String text) {
        // Тот же код, что и раньше
        // Создаем новый LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                170)); // Устанавливаем высоту в 170dp
        linearLayout.setPadding(10, 10, 10, 10); // Устанавливаем отступы

        // Создаем CardView
        androidx.cardview.widget.CardView cardView = new androidx.cardview.widget.CardView(this);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
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
                RelativeLayout.LayoutParams.MATCH_PARENT,
                100)); // Устанавливаем высоту в 100dp
        imageView.setPadding(10, 10, 10, 10); // Устанавливаем отступы
        imageView.setImageResource(imageResource);
        relativeLayout.addView(imageView);

        // Создаем TextView
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.BELOW, imageView.getId()); // Размещаем текст под изображением
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL); // Центрируем текст по горизонтали
        textView.setLayoutParams(textParams);
        textView.setText(text);
        textView.setTextColor(0xFF000FFF); // Устанавливаем цвет текста
        textView.setTextSize(20); // Устанавливаем размер текста
        textView.setTypeface(null, Typeface.BOLD); // Устанавливаем жирный стиль текста
        relativeLayout.addView(textView);

        // Добавляем RelativeLayout в CardView
        cardView.addView(relativeLayout);

        // Добавляем CardView в LinearLayout
        linearLayout.addView(cardView);

        return linearLayout;
    }
}