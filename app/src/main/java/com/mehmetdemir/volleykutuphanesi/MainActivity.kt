package com.mehmetdemir.volleykutuphanesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.OkHttpClient
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // kisi_sil()
        //kisi_ekle()
        //kisi_guncelle()
       // tum_kisiler()

    }

    fun kisi_sil(){
        val url="http://kasimadalan.pe.hu/kisiler/delete_kisiler.php"
        val istek=object :StringRequest(Method.POST,url,Response.Listener { cevap->
            Log.e("Silme işlemi cevap",cevap)
        },Response.ErrorListener {error ->
            error.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params["kisi_id"]="11210"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun tum_kisiler(){
        val url="http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"
        val istek=StringRequest(Request.Method.GET,url,Response.Listener { cevap->
            Log.e("Silme işlemi cevap",cevap)
            val jsonObject=JSONObject(cevap)
            val kisilerListesi=jsonObject.getJSONArray("kisiler")
            for(i in 0 until kisilerListesi.length()){
                val k=kisilerListesi.getJSONObject(i)
                val kisi_id=k.getInt("kisi_id")
                val kisi_ad=k.getString("kisi_ad")
                val kisi_tel=k.getString("kisi_tel")

                println("kisi id => $kisi_id")
                println("kisi ad => $kisi_ad")
                println("kisi te => $kisi_tel")
                println("*******************")
            }


        },Response.ErrorListener {error ->
            error.printStackTrace()
        })
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisi_ekle(){
        val url="http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"
        val istek=object :StringRequest(Method.POST,url,Response.Listener { cevap->
            Log.e("ekleme",cevap)
        },Response.ErrorListener {error ->
            error.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params["kisi_ad"]="Mehmet"
                params["kisi_tel"]="123456789"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisi_guncelle(){
        val url="http://kasimadalan.pe.hu/kisiler/update_kisiler.php"
        val istek=object :StringRequest(Method.POST,url,Response.Listener { cevap->
            Log.e("güncelle cevap",cevap)
        },Response.ErrorListener {error ->
            error.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params["kisi_id"]="11227"
                params["kisi_ad"]="Mehmet"
                params["kisi_id"]="123456789"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

}