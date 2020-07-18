package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Room;
import androidx.room.RoomSQLiteQuery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this); // livedata도 바로 관찰하여 xml에 바인딩 하기 위해 추가

//        final AppDatabase db = Room.databaseBuilder(this,AppDatabase.class,"todo-db")
//                .build();

        //공식문서의 방식으로 viewModel을 가져오면 일반 viewModel은 가능하지만 AndroidViewModel은 생성불가능하다
        model = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);

        binding.setViewModel(model);


        //ui 갱신
//        model.getAll().observe(this, new Observer<List<Todo>>() {
//            @Override
//            public void onChanged(List<Todo> todos) {
////                mResultTextView.setText(todos.toString());
////                binding.result.setText(todos.toString());
//            }
//        });

//        //ui 갱신
//        db.todoDao().getAll().observe(this, new Observer<List<Todo>>() {
//            @Override
//            public void onChanged(List<Todo> todos) {
//
//
//            }
//        });


        //클릭시 db에 insert

//        binding.addBtn.setOnClickListener(new View.OnClickListener() {
//            //findViewById 없이 바로 binding.id로 접근가능
//            @Override
//            public void onClick(View view) {
//               // db.todoDao().insert(new Todo(mEditText.getText().toString()));
//               // mResultTextView.setText(db.todoDao().getAll().toString());
////                new InsertAsyncTask(db.todoDao())
////                        .execute(new Todo((mEditText.getText().toString())));
////                model.inseret(new Todo(binding.input.getText().toString()));
//            }
//        });
    }



}
