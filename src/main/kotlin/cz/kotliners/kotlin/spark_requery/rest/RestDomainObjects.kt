package cz.kotliners.kotlin.spark_requery.rest

data class GitHubUserWrapper(val login: String, val url: String, val repos_url: String, val name: String)

data class GitHubRepositoryInfo(val name: String, val html_url: String, val description: String?)

data class GitHubFollowerInfo(val login: String, val html_url: String)