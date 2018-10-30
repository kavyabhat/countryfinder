package com.kvb.countryfinder.view

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.kvb.countryfinder.R
import com.kvb.countryfinder.model.CountryDataBean
import com.kvb.countryfinder.utils.RegionConstants
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnRegionDataFetchedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        val regionList = ArrayList<String>()
        regionList.add(RegionConstants.Africa.toString())
        regionList.add(RegionConstants.Americas.toString())
        regionList.add(RegionConstants.Asia.toString())
        regionList.add(RegionConstants.Europe.toString())
        regionList.add(RegionConstants.Oceania.toString())

        val regionGridAdapter = RegionGridAdapter(this, regionList, this)
        val recyclerView = findViewById<RecyclerView>(R.id.region_rv)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = regionGridAdapter

        //        NetworkLayer networkLayer = new NetworkLayerImpl();
        //        networkLayer.fetchCountrySpecificData("india");
        //        networkLayer.fetchCountriesByRegion(String.valueOf(RegionConstants.Oceania), this);
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun regionDataFetched(countryDataBeanList: List<CountryDataBean>) {
        Log.i(TAG, "regionDataFetched: show country list now. Better open another fragment")
        //        FragmentManager fragmentManager = getSupportFragmentManager();
        //        fragmentManager.beginTransaction().add(new CountryListFragment()).addToBackStack(null).commit();

        val regionHeading = findViewById<TextView>(R.id.region_heading)
        val recyclerView = findViewById<RecyclerView>(R.id.region_rv)
        val noContentView = findViewById<TextView>(R.id.no_content)
        if(countryDataBeanList != null) {
            regionHeading.text = "Select a country"
            val countryListAdapter = CountryListAdapter(this, countryDataBeanList)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = countryListAdapter
            noContentView.visibility = View.GONE
            regionHeading.visibility = View.VISIBLE
            recyclerView.visibility = View.VISIBLE
        }else{
            noContentView.visibility = View.VISIBLE
            regionHeading.visibility = View.GONE
            recyclerView.visibility = View.GONE
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }
}


//TODO add to db via room since list of countries is not something that changes dynamically
//TODO need to convert rv  to proper fragment container