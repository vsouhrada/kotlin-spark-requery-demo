package cz.kotliners.kotlin.spark_requery.internal

import cz.kotliners.kotlin.spark_requery.ServiceRunner
import cz.kotliners.kotlin.spark_requery.models.BasicUserInfoDO
import cz.kotliners.kotlin.spark_requery.models.GitHubFollowerInfoDO
import cz.kotliners.kotlin.spark_requery.models.GitHubRepositoryDO
import cz.kotliners.kotlin.spark_requery.rest.GitHubRestService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author vsouhrada
 * @see[InternalServices]
 */
@Singleton
class InternalServiceImpl : InternalService {

    @Inject lateinit var gitHubService: GitHubRestService

    init {
        ServiceRunner.serviceComponent.inject(this)
    }

    override fun getBasicUserInfo(user: String): BasicUserInfoDO {
        val call = gitHubService.getBasicUserInfo(user).execute()
        val body = call.body()

        return BasicUserInfoDO(
                login = body.login,
                name = body.name,
                repos_url = body.repos_url,
                url = body.url)
    }

    override fun getUserRepositories(user: String): List<GitHubRepositoryDO> {
        val result = ArrayList<GitHubRepositoryDO>()

        val call = gitHubService.getUserRepositories(user).execute()
        if (call.isSuccessful) {
            val body = call.body()
            body.forEach {
                result.add(GitHubRepositoryDO(name = it.name, html_url = it.html_url, description = it.description))
            }
        }

        return result
    }

    override fun getUserFollowers(user: String): List<GitHubFollowerInfoDO> {
        val result = ArrayList<GitHubFollowerInfoDO>()

        val call = gitHubService.getUserFollowers(user).execute()
        if (call.isSuccessful) {
            val body = call.body()
            body.forEach {
                result.add(GitHubFollowerInfoDO(login = it.login, html_url = it.html_url))
            }
        }

        return result
    }
}