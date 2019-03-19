package com.alpheaus.androidlists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    ListView myList;
    BaseAdapter adapter;
    ArrayList<Account> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.myList);
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = getLayoutInflater().inflate(R.layout.list_item,null,true);
                TextView txtNames = v.findViewById(R.id.textviewNames);
                TextView txtAccNumber = v.findViewById(R.id.textviewAccNumber);
                TextView txtBalance = v.findViewById(R.id.textviewBalance);

                Account x = arrayList.get(position);
                txtNames.setText(x.getName() );
                txtAccNumber.setText(x.getAccNumber() );

                Locale locale = new Locale("en", "KE");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                String balance=currencyFormatter.format(x.getBalance());

                txtBalance.setText("KES"+x.getBalance() );
                return v;
            }
        };
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account k = arrayList.get(position);
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, k.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Account ac1 = new Account("Jim", "AC001", 12000);
        Account ac2 = new Account("Mary", "AC002", 15000);
        Account ac3 = new Account("Lucy", "AC003", 20000);
        Account ac4 = new Account("Andrew", "AC004", 36000);
        Account ac5 = new Account("Lewis", "AC005", 75400);
        Account ac6 = new Account("Seeyian", "AC006", 86000);
        Account ac7 = new Account("Claire", "AC007", 9500);
        Account ac8 = new Account("Purity", "AC008", 45600);
        Account ac9 = new Account("Maureen", "AC009", 45000);
        Account ac10 = new Account("Noam", "AC0010", 87562);

        arrayList.add(ac1);
        arrayList.add(ac2);
        arrayList.add(ac3);
        arrayList.add(ac4);
        arrayList.add(ac5);
        arrayList.add(ac6);
        arrayList.add(ac7);
        arrayList.add(ac8);
        arrayList.add(ac9);
        arrayList.add(ac10);

        //REFRESH
        adapter.notifyDataSetChanged();



    }
}
