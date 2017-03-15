package cz.kotliners.kotlin.spark_requery.models

data class BasicUserInfoDO(val login: String, val url: String, val repos_url: String, val name: String)

data class GitHubRepositoryDO(val name: String, val html_url: String, val description: String?)

data class GitHubFollowerInfoDO(val login: String, val html_url: String)

