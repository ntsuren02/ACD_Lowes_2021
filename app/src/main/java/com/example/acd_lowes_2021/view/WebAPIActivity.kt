package com.example.acd_lowes_2021.view

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.acd_lowes_2021.R
import com.google.gson.JsonObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder
import java.util.logging.Level
import java.util.logging.Logger

class WebAPIActivity : AppCompatActivity(){
    private val API_KEY = "65d00499677e59496ca2f318eb68c049"
    private val WEB_SERVICE_URL = "http://api.openweathermap.org/data/2.5/forecast"

    private fun createUrlLink(location: String): String? {
        return try {
            WEB_SERVICE_URL + "?q=" + URLEncoder.encode(location, "UTF-8") +
                    "&appid=" + API_KEY
        } catch (ex: UnsupportedEncodingException) {
            Logger.getLogger(MainActivity::class.java.getName())
                .log(Level.SEVERE, null, ex)
            null
        }
    }

    private fun convertJsonToWeatherDataList(jsonData: String?) {
        try {
            val JsonObj = JsonObject()
            val main = JsonObj.getAsJsonObject("main")
            val weather = JsonObj.getAsJsonArray("weather").asJsonObject
            val temp = "" + main.getAsLong().toString() + "°F"
            val feels_like = "" + main.getAsLong().toString()  + "°F"

            val weatherID = weather.getAsLong()
            val weatherMain = weather.getAsString()
            val weatherDescription = weather.getAsString()

            /* Populating extracted data into our views */
            val temps = findViewById<TextView>(R.id.temp)
            temps.text = temp

            val feels_likes = findViewById<TextView>(R.id.feels_like)
            feels_likes.text = feels_like

            val weatherMains = findViewById<TextView>(R.id.weatherMain)
            weatherMains.text = weatherMain

            val weatherDescriptions = findViewById<TextView>(R.id.weatherDescription)
            weatherDescriptions.text = weatherDescription
        }
        catch (ex: Exception) {
            Logger.getLogger(MainActivity::class.java.getName())
                .log(Level.SEVERE, null, ex)
        }
    }

    fun retrieveForecast(location: String?) {
        try {
            val urlLink = location?.let { createUrlLink(it) }

            val url = URL(urlLink)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            val responseCode: Int = connection.getResponseCode()
            if (responseCode != HttpURLConnection.HTTP_OK) throw IOException(
                String.format(
                    "Unable to connection to URL: %s",
                    urlLink
                )
            )
            val strBuilder = StringBuilder()
            BufferedReader(InputStreamReader(connection.getInputStream())).use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    strBuilder.append(line)
                }
                convertJsonToWeatherDataList(strBuilder.toString())
            }
        }
        catch (ex: MalformedURLException) {
            Logger.getLogger(MainActivity::class.java.getName())
                .log(Level.SEVERE, null, ex)
        }
        catch (ex: IOException) {
            Logger.getLogger(MainActivity::class.java.getName())
                .log(Level.SEVERE, null, ex)
        }
    }
}