package com.medha.borderedtextinputsample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.medha.borderedtextinputsample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.bordered_edit_text.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        binding.contentLayout.phoneNumberEt.rightCtaTv.setOnClickListener {
            // implement as per your convenience
        }

        binding.contentLayout.phoneNumberEt.etBordered.addTextChangedListener(object:
            TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.e("after",p0.toString()?:"")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("before",p0.toString()?:"")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if((p0?.length?:0)==10){
                    Log.e("on",p0.toString()?:"")
                    binding.contentLayout.phoneNumberEt.setCtaTextColor(R.color.accent_green)
                    binding.contentLayout.phoneNumberEt.setDrawableTextAndCta("Verified",null,
                        ContextCompat.getDrawable(this@MainActivity,R.drawable.phone_verified))
                }else{
                    binding.contentLayout.phoneNumberEt.setError("PLease enter a valid number")
                    val rotated = ContextCompat.getDrawable(this@MainActivity, R.drawable.purple_right_arrow)
                    binding.contentLayout.phoneNumberEt.setCtaTextColor(R.color.colorAccent)
                    binding.contentLayout.phoneNumberEt.setDrawableTextAndCta("Verify Your Number", null, rotated)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}