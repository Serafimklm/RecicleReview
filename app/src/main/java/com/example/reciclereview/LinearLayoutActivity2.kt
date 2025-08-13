package com.example.reciclereview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.reciclereview.databinding.ActivityLinearLayout2Binding

class LinearLayoutActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLinearLayout2Binding

    // definindo o botao e pegando o id de layout
    private lateinit var buttonAct : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLinearLayout2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // associando varialve com o botao
        buttonAct = findViewById(R.id.activity1)
        buttonAct.setOnClickListener {
            // cirar intent para abir uma activity
            val intent = Intent(this, RecicleReniew::class.java)
            startActivity(intent)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_linear_layout2)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


}