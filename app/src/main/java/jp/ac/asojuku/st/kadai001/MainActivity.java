package jp.ac.asojuku.st.kadai001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnLongClickListener {

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button clcikButton = (Button) this.findViewById(R.id.clcikButton);
        clcikButton.setOnClickListener(this);
        clcikButton.setOnLongClickListener(this);
    }

    /**
     * クリックした時の動作
     *
     * @param v クリックされた画面
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, OnClickActivity.class);

        // ラジオグループを操作可能にする
        RadioGroup rGroup = (RadioGroup) this.findViewById(R.id.rGroup);
        // 選択されたラジオボタンIDを知る
        int checkedRgID = rGroup.getCheckedRadioButtonId();
        // ラジオボタンIDからラジオボタンを操作可能にする
        RadioButton checkedRgBtn = (RadioButton) this.findViewById(checkedRgID);
        // ラジオボタンのキャプション（説明文）を取得
        String strCaption = (String) checkedRgBtn.getText();
        // 正解用Keywordを取得
        String usersOption = (String) getResources().getString(R.string.usersOption);
        // 選ばれたラジオボタンのキャプションを正解として次の画面へのインテントに含める
        intent.putExtra(usersOption, strCaption);

        startActivity(intent);
    }

    /**
     * 長押しした時の動作
     *
     * @param v クリックされた画面
     */
    @Override
    public boolean onLongClick(View v) {
        Intent intent = new Intent(MainActivity.this, OnLongClickActivity.class);
        startActivity(intent);
        return true;
    }
}