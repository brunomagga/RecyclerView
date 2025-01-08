package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)

        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvlist.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvlist.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener {contact ->
            val intent = Intent(this, ContactDatailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)

        }
    }
}

val contacts = listOf(
    contact(
        name = "Bruno",
        phone = "(55) 11 9455293451",
        icon = R.drawable.sample10
    ),
    contact(
        name = "Pedro",
        phone = "(55) 11 9455463451",
        icon = R.drawable.sample12
    ),
    contact(
        name = "Giovana",
        phone = "(55) 11 9423463901",
        icon = R.drawable.sample1
    ),
    contact(
        name = "Sara",
        phone = "(55) 11 9455468101",
        icon = R.drawable.sample11
    ),
    contact(
        name = "Maria",
        phone = "(55) 11 9443463455",
        icon = R.drawable.sample16
    ),
    contact(
        name = "Carlos",
        phone = "(55) 11 9455443971",
        icon = R.drawable.sample14
    ),
    contact(
        name = "Gabi",
        phone = "(55) 11 9455422141",
        icon = R.drawable.sample15
    ),
    contact(
        name = "Alex",
        phone = "(55) 11 9422463435",
        icon = R.drawable.sample13
    ),
    contact(
        name = "Vinicius",
        phone = "(55) 11 9455444380",
        icon = R.drawable.sample8
    ),
    contact(
        name = "Lucas",
        phone = "(55) 11 9335463211",
        icon = R.drawable.sample2
    ),contact(
        name = "Larissa",
        phone = "(55) 11 9342463409",
        icon = R.drawable.sample3
    ),contact(
        name = "Beatriz",
        phone = "(55) 11 9155463320",
        icon = R.drawable.sample4
    ),contact(
        name = "Vitoria",
        phone = "(55) 11 9985400451",
        icon = R.drawable.sample5
    ),contact(
        name = "Bianca",
        phone = "(55) 11 9255433211",
        icon = R.drawable.sample6
    ),contact(
        name = "Marcela",
        phone = "(55) 11 9455323071",
        icon = R.drawable.sample7
    ),contact(
        name = "Thiago",
        phone = "(55) 11 9455323981",
        icon = R.drawable.sample9
    ),
)












