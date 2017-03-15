package cz.kotliners.kotlin.spark_requery.internal

import cz.kotliners.kotlin.spark_requery.models.BasicUserInfoDO
import cz.kotliners.kotlin.spark_requery.models.GitHubFollowerInfoDO
import cz.kotliners.kotlin.spark_requery.models.GitHubRepositoryDO

/**
 * @author vsouhrada
 */
interface InternalService {

    fun getBasicUserInfo(user: String): BasicUserInfoDO

    fun getUserRepositories(user: String): List<GitHubRepositoryDO>

    fun getUserFollowers(user: String): List<GitHubFollowerInfoDO>

}