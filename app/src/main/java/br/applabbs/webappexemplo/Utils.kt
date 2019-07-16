package br.applabbs.webappexemplo

import android.util.Patterns



object Utils {

    /**
     * This is used to check the given URL is valid or not.
     * @param url
     * @return true if url is valid, false otherwise.
     */
    fun isValidUrl(url: String): Boolean {
        val p = Patterns.WEB_URL
        val m = p.matcher(url.toLowerCase())
        return m.matches()
    }
}
