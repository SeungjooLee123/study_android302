package com.example.project02_cloneapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView nav_btm;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Fragment1 fragment1 = new Fragment1();
        changeFrag(new ListViewFragment2());
       // getSupportFragmentManager().beginTransaction()
        //        .replace(R.id.container ,  new ListViewFragment() ).commit();

        TestClass testClass = new TestClass();
        testClass.toastShow(MainActivity.this , "TestClass호출 메인액티비티");





        nav_btm = findViewById(R.id.bottom_nav);
        nav_btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.getItemId() // ? Resoureces 에 등록되어있는 인트로 되어있는 id를 확인가능
                //item.getTitle() // ?  Resources 에 등록되어있는 텍스트( tittle글씨)를 확인가능
                if(item.getItemId() == R.id.tab1){
                    Toast.makeText(MainActivity.this, "tab1 선택 됨", Toast.LENGTH_SHORT).show();
                    fragment = new ListViewFragment2();
                }else if (item.getItemId() == R.id.tab2){
                    Toast.makeText(MainActivity.this, "tab2 선택 됨", Toast.LENGTH_SHORT).show();
                    fragment = new Fragment2();
                }else if (item.getItemId() == R.id.tab3){
                    Toast.makeText(MainActivity.this, "tab3 선택 됨", Toast.LENGTH_SHORT).show();
                    fragment = new Fragment3();
                }else if (item.getItemId() == R.id.tab4){
                    Toast.makeText(MainActivity.this, "tab4 선택 됨", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId() == R.id.tab5){
                    Toast.makeText(MainActivity.this, "tab5 선택 됨", Toast.LENGTH_SHORT).show();
                }
                // id를 부여하면 자동으로 int로 id를 채번해서 R에서 사용할수있게 됨.
                //문제 ) 1.몇번 메뉴가 선택되었는지 Toast창으로 띄우기
                //       2.log로찍어보기
                //       3.로그와 Toast가 둘다 됐다면 디버깅모드로도 확인해보기.
                changeFrag(fragment);
                return true;
            }
        });
    }//onCreate

    public void changeFrag(Fragment fragment){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , fragment).commit();
    }

}