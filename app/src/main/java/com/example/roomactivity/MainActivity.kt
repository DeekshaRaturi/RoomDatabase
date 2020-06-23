package com.example.roomactivity

import android.annotation.SuppressLint
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var dashboardAdapter: DashboardAdapter? = null
    private var arrayList: ArrayList<User>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"UserDatabase").build()

        btn?.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch{
            db.clearAllTables()
            var user = User()

            user.name = edtText?.text.toString()
            arrayList?.add(user)

            db.userDao().saveUser(user)
            db.userDao().getUser().forEach {
                arrayList?.add(it)


            }

            withContext(Dispatchers.Main){
                setRecyclerAdapter(arrayList!!)
            }

        }



        }
    }

    private fun setRecyclerAdapter(arraylist:ArrayList<User>) {
        Log.e("list",""+arraylist?.size)

        dashboardAdapter = DashboardAdapter(arraylist!!)
        recycler?.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = dashboardAdapter
        }
    }
}