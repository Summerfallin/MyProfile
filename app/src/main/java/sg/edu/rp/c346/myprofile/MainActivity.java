package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onPause() {
        super.onPause();
        String strName= etName.getText().toString();
        String strGPA= etGPA.getText().toString();
        Integer gender = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.putString("GPA",strGPA);
        prefEdit.putInt("Gender",gender);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("name","");
        String GPA= prefs.getString("GPA","");
        Integer gender = prefs.getInt("Gender",0);
        etName.setText(name);
        etGPA.setText(GPA);
        rgGender.check(gender);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);
        rgGender=findViewById(R.id.RadioGroupGender);

    }

}
