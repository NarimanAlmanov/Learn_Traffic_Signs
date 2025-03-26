package com.example.learntrafficsigns;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Находим RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Указываем, что будет использоваться GridLayoutManager с 2 колонками
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Данные для категорий
        List<SignCategory> categories = Arrays.asList(
                new SignCategory("Warning", R.drawable.sign39),
                new SignCategory("Priority", R.drawable.sign50),
                new SignCategory("Prohibition", R.drawable.sign63),
                new SignCategory("Mandatory", R.drawable.sign99),
                new SignCategory("Information", R.drawable.sign126),
                new SignCategory("Service", R.drawable.sign203),
                new SignCategory("Additional", R.drawable.sign223)
        );

        // Устанавливаем адаптер
        SignCategoryAdapter adapter = new SignCategoryAdapter(this, categories);
        recyclerView.setAdapter(adapter);
    }
}
