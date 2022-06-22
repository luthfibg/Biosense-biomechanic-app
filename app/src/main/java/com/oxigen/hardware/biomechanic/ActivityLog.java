package com.oxigen.hardware.biomechanic;

import android.os.Bundle;
import android.widget.TextView;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.Objects;


public class ActivityLog extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        TextView head_logData = findViewById(R.id.dataHead);
        TextView date_logData = findViewById(R.id.dataDate);

        String activity = null;
        String datetime = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            activity = extras.getString("activity[key]");
            datetime = extras.getString("datetime[key]");
        }

        head_logData.setText(activity);
        date_logData.setText(datetime);

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("cvl-m");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    String category = Objects.requireNonNull(snapshot.child("_cat").getValue()).toString();
//                    head_logData.setText(category);
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }
}
