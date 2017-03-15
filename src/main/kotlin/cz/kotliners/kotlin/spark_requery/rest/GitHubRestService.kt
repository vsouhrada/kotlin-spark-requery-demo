package cz.kotliners.kotlin.spark_requery.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author vsouhrada
 */
interface GitHubRestService {

    @GET("users/{user}")
    fun getBasicUserInfo(@Path("user") user: String): Call<GitHubUserWrapper>

    @GET("users/{user}/repos")
    fun getUserRepositories(@Path("user") user: String): Call<List<GitHubRepositoryInfo>>

    @GET("users/{user}/followers")
    fun getUserFollowers(@Path("user") user: String): Call<List<GitHubFollowerInfo>>

}