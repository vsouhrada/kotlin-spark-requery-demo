package cz.kotliners.kotlin.spark_requery.controller

import com.google.gson.Gson
import cz.kotliners.kotlin.spark_requery.ServiceRunner
import cz.kotliners.kotlin.spark_requery.internal.InternalService
import spark.Spark.get
import javax.inject.Inject

/*
* REST API handler for incoming requests and responses. All methods there are part of public API of this service.
* @author vsouhrada
*
*/
class ServiceController {

    @Inject lateinit var service: InternalService
    @Inject lateinit var gson: Gson

    init {
        ServiceRunner.serviceComponent.inject(this)

        initRoutes()
    }

    private fun initRoutes() {
        get("/user/:name", { req, res ->
            service.getBasicUserInfo(req.params(":name"))
        }, gson::toJson)

        get("/repos/:name", { req, res ->
            service.getUserRepositories(req.params(":name"))
        }, gson::toJson)

        get("/followers/:name", { req, res ->
            service.getUserFollowers(req.params(":name"))
        }, gson::toJson)

        get("/hello", { req, res -> "Hello Spark!!!" })
    }

}