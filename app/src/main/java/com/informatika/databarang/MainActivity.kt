package com.informatika.databarang

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.informatika.databarang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
}
    koneksi.service.getUser().enqueue(object : Callback<List<ResponseUsersItem?>>{
        override fun onFailure(call: Call<List<ResponseUsersItem?>>, t: Throwable) {
            Log.d("pesan1", t.localizedMessage)
        }

        override fun onResponse{
            call: Call<List<ResponseUsersItem?>>,
            response: Response<List<ResponseUsersItem?>>
        ) }
            if(response.isSuccessful){
                Log.d("pesan", response.body().toString());
            }
        }
    }}