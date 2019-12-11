package com.example.gezegenlerdekackilosun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import 	androidx.appcompat.app.ActionBar
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val Kilo_To_Pound=2.2045
    val MARS = 0.38
    val VENUS = 0.91
    val JUPITER = 2.34
    val Pound_To_Kilo=0.45359237


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbJupiter.setOnClickListener(this)
        cbMars.setOnClickListener(this)
        cbVenus.setOnClickListener(this)




       /* btnHesapla.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
               Log.e("ECE", "Butona Basıldı")
            }
        })*/

          /* btnHesapla.setOnClickListener {
               Log.e("ECE", "Butona Basıldı")
           }*/

     /*   btnHesapla.setOnClickListener {

            var KullaniciKiloPound = kiloToPound(kullaniciKilo.toString().toDouble())
            var marstakiAgirlikPound = KullaniciKiloPound * MARS
            var marstakiAgirlikKilo = PoundToKilo(marstakiAgirlikPound)

            tvSonuc.text = marstakiAgirlikKilo.toString()


        }*/
    }



    fun kiloToPound(kilo : Double) : Double {

        return kilo * Kilo_To_Pound
    }

    fun PoundToKilo (pound : Double ) : Double {

        return pound * Pound_To_Kilo
    }



    override fun onClick(v: View?) {
        var kullaniciKilo =etKilo.text.toString().toDouble()
        var kullaniciPound = kiloToPound(kullaniciKilo)

        v as CheckBox

        var isChecked:Boolean = v .isChecked

        if(!TextUtils.isEmpty(etKilo.text.toString())){
            when (v.id){
                R.id.cbMars -> if(isChecked ){
                    cbVenus.isChecked=false
                    cbJupiter.isChecked=false
                    HesaplaAgirlikPound(kullaniciPound, v)

                }
                R.id.cbVenus -> if(isChecked ){
                    cbJupiter.isChecked=false
                    cbMars.isChecked=false
                    HesaplaAgirlikPound(kullaniciPound, v)

                }

                R.id.cbJupiter -> if(isChecked ){
                    cbMars.isChecked=false
                    cbVenus.isChecked=false
                    HesaplaAgirlikPound(kullaniciPound, v)

                }

            }

        }



    }

    fun HesaplaAgirlikPound( pound: Double, checkBox: CheckBox){
        var sonucKilo : Double =0.0

        when(checkBox.id){

            R.id.cbMars -> sonucKilo = pound * MARS
            R.id.cbVenus -> sonucKilo = pound * VENUS
            R.id.cbJupiter -> sonucKilo = pound * JUPITER
            else -> sonucKilo = 0.0
        }
        var sonucToKilo = PoundToKilo(sonucKilo)
        tvSonuc.text = sonucToKilo.toString()

    }

}
