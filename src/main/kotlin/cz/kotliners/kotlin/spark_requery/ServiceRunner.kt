package cz.kotliners.kotlin.spark_requery

import cz.kotliners.kotlin.spark_requery.controller.ServiceController
import spark.Spark.*

/**
 * Main Runner of the Kotlin-Spark-Requery demo service. It makes initialization of a whole service and setup of REST API
 *
 * @author vsouhrada
 */
class ServiceRunner {

    fun run() {
        initControllers()
    }

    private fun initControllers() {
        ServiceController()
    }

}