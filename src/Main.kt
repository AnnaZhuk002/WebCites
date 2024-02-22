import java.net.HttpURLConnection
import java.net.URL

// Функция для проверки доступности веб-сайта
fun checkWebsite(url: String): Boolean {
    return try {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "HEAD"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000
        connection.responseCode == HttpURLConnection.HTTP_OK
    } catch (e: Exception) {
        false
    }
}

// Список веб-сайтов для проверки
val websites = listOf(
    "https://www.google.com",
    "https://www.facebook.com",
    "https://www.github.com",
    "https://www.twitter.com",
    "https://www.instagram.com",
    "https://www.youtube.com/",
    "https://www.microsoft.com/",
    "https://www.netflix.com",
    "https://www.reddit.com/",
    "https://www.myspace.com/"
)

// Главная функция
fun main()  {
    // Запускаем проверку веб-сайтов в цикле
    websites.forEachIndexed { index, url ->
        val result = checkWebsite(url)
        val status = if (result) "доступен" else "недоступен"
        println("Сайт ${index + 1}: $url - $status")
    }
}