package eu.xap3y.skullcreator

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

@Serializable
data class MojangResponse(val id: String, val name: String)

@Serializable
data class MojangProfileProperty(val name: String, val value: String)

@Serializable
data class MojangProfile(val id: String, val name: String, val properties: List<MojangProfileProperty>)


internal class HttpUtils {
    companion object {
        fun getProfileUuid(name: String): String? {
            if (name.length > 16) return null
            val client = OkHttpClient()
            val request: Request = Request.Builder()
                .url("https://api.mojang.com/users/profiles/minecraft/$name")
                .build()

            return try{
                client.newCall(request).execute().use { response ->
                    return if (response.isSuccessful) {
                        val responseBody: String = response.body?.string() ?: return@use null
                        Json.decodeFromString<MojangResponse>(responseBody).id
                    } else {
                        null
                    }
                }
            } catch (e: Exception) {
                null
            }
        }

        fun getProfileTexture(uuid: String): String? {
            val client = OkHttpClient()
            val request: Request = Request.Builder()
                .url("https://sessionserver.mojang.com/session/minecraft/profile/$uuid")
                .build()

            return try {
                client.newCall(request).execute().use { response ->
                    return if (response.isSuccessful) {
                        val responseBody: String = response.body?.string() ?: return@use null
                        Json.decodeFromString<MojangProfile>(responseBody).properties.firstOrNull()?.value
                    } else {
                        null
                    }
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}