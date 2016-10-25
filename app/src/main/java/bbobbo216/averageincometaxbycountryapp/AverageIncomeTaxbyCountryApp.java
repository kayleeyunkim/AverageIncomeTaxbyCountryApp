package bbobbo216.averageincometaxbycountryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class AverageIncomeTaxbyCountryApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final double china_tax = 25;
        final double germany_tax = 32;
        final double sweden_tax = 34;
        final double usa_tax = 18;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_income_taxby_country_app);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText income = (EditText) findViewById(R.id.income);
        final TextView result1 = ((TextView)findViewById(R.id.result1));
        final TextView result2 = ((TextView)findViewById(R.id.result2));
        final TextView result3 = ((TextView)findViewById(R.id.result3));
        final TextView result4 = ((TextView)findViewById(R.id.result4));
//
        RadioGroup rasidence_radiogroup = (RadioGroup)findViewById(R.id.radiogroup);
        rasidence_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                double choosen_tax = 0;
                final double tax;
                RadioButton checkedRadioButton = (RadioButton)findViewById(checkedId);
                final String text = checkedRadioButton.getText().toString();

                if (text.equals("China"))
                    choosen_tax = china_tax;
                else if (text.equals("Sweden"))
                    choosen_tax = sweden_tax;
                else if (text.equals("Germany"))
                    choosen_tax = germany_tax;
                else if (text.equals("USA"))
                    choosen_tax = usa_tax;

                Toast.makeText(getApplicationContext(), text +" has " + choosen_tax + "% tax rate.", Toast.LENGTH_SHORT).show();
                tax = choosen_tax;

                double input_first_income = Double.parseDouble(income.getText().toString());
                final double total = input_first_income;
                final double cal_tax_amount = total * (choosen_tax / 100);
                final double total_after_tax = total - cal_tax_amount;

                Button calculate = (Button) findViewById(R.id.calculate_btn);
                calculate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        result1.setText(text + " has " + tax + "% tax.");
                        result2.setText("Your total income is $" + total);
                        result3.setText("Your tax is $" + cal_tax_amount);
                        result4.setText("Your income after tax is $" + total_after_tax);
                    }
                });


            }
        });








    }

}
