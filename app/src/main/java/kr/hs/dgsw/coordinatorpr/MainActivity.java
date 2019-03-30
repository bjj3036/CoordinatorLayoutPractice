package kr.hs.dgsw.coordinatorpr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MemoListAdapter memoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        memoListAdapter = new MemoListAdapter(this, R.layout.row_item, new ArrayList<MemoItem>());
        recyclerView.setAdapter(memoListAdapter);

        memoListAdapter.addItemList(getMemoDummyList());
        memoListAdapter.addItemList(getMemoDummyList());
        memoListAdapter.addItemList(getMemoDummyList());
        memoListAdapter.addItemList(getMemoDummyList());
        memoListAdapter.addItemList(getMemoDummyList());
        memoListAdapter.addItemList(getMemoDummyList());
        memoListAdapter.addItemList(getMemoDummyList());
    }

    private ArrayList<MemoItem> getMemoDummyList() {
        ArrayList<MemoItem> list = new ArrayList<>();
        MemoItem item1 = new MemoItem("일상", "오늘 점심메뉴는 짜장면!");
        MemoItem item2 = new MemoItem("학교", "모프 과제 기한은 화요일까지");
        list.add(item1);
        list.add(item2);
        return list;
    }
}
