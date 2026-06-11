package sg.edu.nus.iss.a2a_listview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    // Mock data: image names
    private val toons = arrayOf(
        "afraid", "full", "hug", "laugh", "no_way",
        "peep", "snore", "stop", "tired", "what"
    )

    // Mock data: image captions
    private val captions = arrayOf(
        "Leave me alone...", "So Full!", "Hug, please!", "So funny!", "No Way!",
        "You there?", "I'm out...", "Stop It!", "I'm beat...", "What?!"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bind adapter to ListView
        val listView = findViewById<ListView>(R.id.listView)
        listView?.adapter = CustomAdapter(this, toons, captions)
        listView?.setOnItemClickListener(this)
    }

    override fun onItemClick(av: AdapterView<*>?, v: View, pos: Int, id: Long) {
        // Set content
        val textView = v.findViewById<TextView>(R.id.textView)
        val caption = textView.text.toString()

        // Show message
        val toast = Toast
            .makeText(this, caption, Toast.LENGTH_SHORT)
        toast.show()
    }

}