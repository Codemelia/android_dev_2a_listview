package sg.edu.nus.iss.a2a_listview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(
    private val context: Context,
    protected var toons: Array<String>,
    protected var captions: Array<String>
): ArrayAdapter<Any?>(context, R.layout.row) {

    init {
        addAll(*arrayOfNulls<Any>(toons.size))
    }

    // How this works: ListView calls Adapter getView() method repeatedly
    override fun getView(pos: Int, view: View?, parent: ViewGroup): View {

        // Point to recycled view initially
        var _view = view

        // Null handling: if null, create new row from row.xml
        // Convert XML layouts into View objects
        if (_view == null) {
            val inflater = context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE
            ) as LayoutInflater

            _view = inflater.inflate(R.layout.row, parent, false)
        }

        // Find ImageView in row.xml
        val imageView = _view!!.findViewById<ImageView>(R.id.imageView)

        // Setting image
        val id = context.resources.getIdentifier(
            toons[pos], // Gets name from image names
            "drawable", // Searches res/drawable/<name>
            context.packageName // Define package from context
        )

        // Display image in ImageView
        imageView?.setImageResource(id)

        // Find TextView in row.xml
        val textView = _view.findViewById<TextView>(R.id.textView)

        // Set text in TextView to image caption
        textView.text = captions[pos]

        // Return completed row to ListView
        return _view

    }

}