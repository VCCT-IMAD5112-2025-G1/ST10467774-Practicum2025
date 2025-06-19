package za.co.varsitycollege.practicum2025_st10467774
// Caitlyn Engelbrecht - Student Number 10467774
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("RedundantLabeledReturnOnLastExpressionInLambda")
class MainActivity : AppCompatActivity() {

    companion object {
        val songTitles = arrayListOf<String>()
        val songArtists = arrayListOf<String>()
        val songRatings = arrayListOf<Int>()
        val songComments = arrayListOf<String>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val titleInput = findViewById<EditText>(R.id.editSongTitle)
        val artistInput = findViewById<EditText>(R.id.editArtistName)
        val ratingString= findViewById<EditText>(R.id.editRating)
        val commentInput = findViewById<EditText>(R.id.editComment)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val viewPlaylistButton = findViewById<Button>(R.id.viewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        saveButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val artist = artistInput.text.toString().trim()
            val ratingString = ratingString.text.toString().trim()
            val comment = commentInput.text.toString().trim()

            if (title.isEmpty() || artist.isEmpty() || rating.isEmpty() || comment.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
            val ratingInt = rating.toIntOrNull()
            if (ratingInt == null || ratingString < 1 || ratingString > 5) {
                Toast.makeText(this, "Please enter a valid rating between 1 and 5", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            songTitles.add(title)
            songArtists.add(artist)
            songRatings.add(ratingInt)
            songComments.add(comment)

            Toast.makeText(this, "Song added to playlist", Toast.LENGTH_SHORT).show()
            titleInput.text.clear()
            artistInput.text.clear()
            ratingInput.text.clear()
            commentInput.text.clear()
        }
        viewPlaylistButton.setOnClickListener {
            startActivity(Intent(this, PlaylistActivity::class.java))
        }
        exitButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes") { _, _ -> finish()   }
                .setNegativeButton("No", null)
                .show()



        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}