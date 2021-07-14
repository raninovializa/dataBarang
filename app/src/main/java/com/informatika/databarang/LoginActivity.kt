package com.informatika.databarang

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.informatika.databarang.model.ResponseUsers
import com.informatika.databarang.network.koneksi
import com.informatika.databarang.service.SessionPreferences
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionPreferences: SessionPreferences

    override fun onCreate(SavedInstanceState: Bundle?) {
        super.onCreate(SavedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_login)
        btn_submit.setOnClickListener{
            val userName = et_username.text.toString()
            val password = et_password.text.toString()

            if(userName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Form tidak boleh kosong!", Toast.LENGTH_LONG).show()
            }else{
                actionData(userName, password)
            }
        }
        btn_clean.setOnClickListener{
            formClear()
        }
        tv_disini.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    fun actionData(username : String, password : String){
        koneksi.service.LogIn(username, password).enqueue (object : Callback<ResponseUsers> {
            override fun onFailure(call: Call<ResponseUsers>, t: Throwable) {
                Log.d("pesan1", t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseUsers>, response: Response<ResponseUsers>) {
                if (response.isSuccessful) {
                    val resbody = response.body()
                    val resStatus = resbody?.status
                    val resUserName = resbody?.data?.get(0)?.username
                    Log.d("pesan", resUserName.toString())
                    if (resStatus == true) {
                        sessionPreferences = SessionPreferences(this@LoginActivity)
                        sessionPreferences.actionLogin(resUserName.toString())
                        val i = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    } else if (resStatus == false) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Username atau Password Anda Salah!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        })
    }
                    fun formClear(){
                        et_username.text.clear()
                        et_password.text.clear()
                    }}
