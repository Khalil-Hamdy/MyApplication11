package com.khalil.myapplication11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class navgation : AppCompatActivity() {

    lateinit var gloable: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navgation)
        setCurrentFragment(My_Name())
        //Bottom Navigation

        findViewById<BottomNavigationView>(R.id.bottomNav).setOnItemSelectedListener {
            when(it.itemId){
                R.id.mEmail -> setCurrentFragment(My_Email())
                R.id.mName -> setCurrentFragment(My_Name())
                R.id.mPassword -> setCurrentFragment(My_Password())
            }
            true
        }


        //Navigation Drawer

        gloable = ActionBarDrawerToggle(this, findViewById<DrawerLayout>(R.id.drawerLayoutId), R.string.open, R.string.close)
        findViewById<DrawerLayout>(R.id.drawerLayoutId).addDrawerListener(gloable)
        gloable.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        findViewById<NavigationView>(R.id.navigationHome).setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mName -> Toast.makeText(this, "khalil Hamdy", Toast.LENGTH_SHORT).show()
                R.id.mPassword -> Toast.makeText(this, "**********", Toast.LENGTH_SHORT).show()
                R.id.mEmail -> Toast.makeText(this, "khalilhamdy2001@gmail.com", Toast.LENGTH_SHORT).show()

            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.navFrameLayout, fragment)
            commit()//apply changes
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(gloable.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}