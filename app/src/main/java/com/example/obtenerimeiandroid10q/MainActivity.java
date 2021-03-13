package com.example.obtenerimeiandroid10q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    //@RequiresApi(api = Build.VERSION_CODES.O)
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        insertarDatos();

        obtenerDatos();

    }

    private void obtenerDatos() {

        databaseReference.child("datos").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        });

    }

    private void insertarDatos() {

        String androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String serialID = android.os.Build.SERIAL;
        String uuID = UUID.randomUUID().toString();

        Datos datos = new Datos(androidID, serialID, uuID);

        databaseReference.child("datos").push().setValue(datos);

        Log.e("papa: ", androidID + ", " + serialID + ", " + uuID);

    }


}

