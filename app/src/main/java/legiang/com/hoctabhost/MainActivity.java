package legiang.com.hoctabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import static legiang.com.hoctabhost.R.id.btnDangNhap;
import static legiang.com.hoctabhost.R.id.edtPassWord;
import static legiang.com.hoctabhost.R.id.edtUser;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    EditText edtUser,edtPassWord;
    Button btnLogin,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("t1"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab đăng nhập",Toast.LENGTH_LONG).show();

                } else if(s.equals("t2"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab hướng dẫn",Toast.LENGTH_LONG).show();

                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyDangNhap();
            }

            private void xuLyDangNhap() {
                Toast.makeText(MainActivity.this,
                        "User"+edtUser.getText().toString()+"; password: "+edtPassWord.getText().toString(),
                        Toast.LENGTH_LONG).show();

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");//tao doi tuong 1 tab, co id la t1
        tab1.setContent(R.id.tab1); //thiet lap noi dung layout
        //tab1.setIndicator("Đăng nhập");//thiết lập tiêu đề cho tab
        tab1.setIndicator("",getResources().getDrawable(R.drawable.login2));
        tabHost.addTab(tab1);//đưa tab 1 vào tapHost

        TabHost.TabSpec tab2= tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        //tab2.setIndicator("Hướng dẫn");
        tab2.setIndicator("",getResources().getDrawable(R.drawable.huongdan));
        tabHost.addTab(tab2);

        edtUser=findViewById(R.id.edtUser);
        edtPassWord=findViewById(R.id.edtPassWord);
        btnLogin=findViewById(R.id.btnDangNhap);
        btnExit=findViewById(R.id.btnThoat);


    }
}
