package cz.kotliners.kotlin.spark_requery.controller

import spark.Spark.*

/*
* REST API handler for incoming requests and responses. All methods there are part of public API of this service.
* @author vsouhrada
*
*/
class ServiceController {

    init {
        get("/hello", { req, res -> "Hello Spark!!!" })
    }

}