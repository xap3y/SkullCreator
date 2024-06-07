package eu.xap3y.skullcreator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

data class MojangResponse(val id: String, val name: String)
data class MojangProfileProperty(val name: String, val value: String)
data class MojangProfile(val id: String, val name: String, val properties: List<MojangProfileProperty>)

internal class HttpUtils {
    companion object {
        fun getProfileUuid(name: String): String? {
            if (name.length > 16) return null
            val client = OkHttpClient()
            val request: Request = Request.Builder()
                .url("https://api.mojang.com/users/profiles/minecraft/$name")
                .build()

            return client.newCall(request).execute().use { response ->
                return if (response.isSuccessful) {
                    val responseBody: String = response.body?.string() ?: return@use null
                    val mapper: ObjectMapper = jacksonObjectMapper()
                    val mojangResponse: MojangResponse = mapper.readValue(responseBody)
                    mojangResponse.id
                } else {
                    null
                }
            }
        }

        fun getProfileTexture(uuid: String): String? {
            val client = OkHttpClient()
            val request: Request = Request.Builder()
                .url("https://sessionserver.mojang.com/session/minecraft/profile/$uuid")
                .build()

            return client.newCall(request).execute().use { response ->
                return if (response.isSuccessful) {
                    val responseBody: String = response.body?.string() ?: return@use null
                    val mapper: ObjectMapper = jacksonObjectMapper()
                    val profile: MojangProfile = mapper.readValue(responseBody)
                    profile.properties.firstOrNull()?.value
                } else {
                    null
                }
            }
        }
    }
}