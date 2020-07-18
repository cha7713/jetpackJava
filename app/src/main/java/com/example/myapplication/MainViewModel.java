package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AppDatabase db;
    public LiveData<List<Todo>> todos; //원래는 private로 만들고 get set 해야함
    public String newTodo;

    public MainViewModel(@NonNull Application application) {
        super(application);
         db = Room.databaseBuilder(application,AppDatabase.class,"todo-db")
                .build();
         todos = getAll();

    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getAll();
    }
    // ViewModel 객체에는 LiveData 객체와 같은 LifecycleObservers가 포함될 수 있습니다.
    // 그러나 ViewModel 객체는 LiveData 객체와 같이 수명 주기를 인식하는 Observable의 변경사항을 관찰해서는 안 됩니다.


    public void inseret(String todo){
        new InsertAsyncTask(db.todoDao()).execute(new Todo(todo) );
    }

    private static class InsertAsyncTask extends AsyncTask<
                Todo, Void, Void> {//넘겨줄 객체, 중간에 프로세스, 반환할 객체
        private TodoDao mTodoDao;
        public InsertAsyncTask(TodoDao todoDao){
            this.mTodoDao = todoDao;
        }
        @Override
        protected Void doInBackground(Todo... todos) {
            mTodoDao.insert(todos[0]);
            return null;
        }

    }
}
