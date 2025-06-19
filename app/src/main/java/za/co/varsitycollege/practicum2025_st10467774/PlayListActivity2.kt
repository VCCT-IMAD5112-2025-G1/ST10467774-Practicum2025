package za.co.varsitycollege.practicum2025_st10467774

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlayListActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_play_list2)

        val textSongList = findViewById<TextView>(R.id.textSongList)
        val textAverageRating = findViewById<TextView>(R.id.textAverageRating)
        val buttonBackToMain = findViewById<Button>(R.id.buttonBackToMain)

        var displayText = ""
        var totalRating = 0

        for (i in MainActivity.songTitle.indices) {
            displayText += "Song ${i + 1}:"

            displayText += "Title: ${MainActivity.songTitles[i]}"
            displayText += "Artist: ${MainActivity.songArtists[i]}"
            displayText += "Rating: ${MainActivity.songRatings[i]}"
            displayText += "Comments: ${MainActivity.songComments[i]}"
            displayText += "\n"
            totalRating += MainActivity.songRatings[i]
        }
        textSongList.text = if (displayText.isNotEmpty()) DisplayText else "No songs to display."

        val averageRating = if (MainActivity.songRatings.isNotEmpty()) {
            TotalRating.toDouble() / MainActivity.songRatings.size
        } else {
            0.0
        }
        textAverageRating.text = "Average Rating: %.2f" .format(averageRating)

        buttonBackToMain.setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}