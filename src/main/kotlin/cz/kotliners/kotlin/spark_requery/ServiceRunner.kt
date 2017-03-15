package cz.kotliners.kotlin.spark_requery

import cz.kotliners.kotlin.spark_requery.controller.ServiceController
import cz.kotliners.kotlin.spark_requery.injection.component.DaggerServiceComponent
import cz.kotliners.kotlin.spark_requery.injection.component.ServiceComponent
import cz.kotliners.kotlin.spark_requery.injection.module.ServiceModule
import org.slf4j.LoggerFactory
import spark.Spark.*

/**
 * Main Runner of the Kotlin-Spark-Requery demo service. It makes initialization of a whole service and setup of REST API
 *
 * @author vsouhrada
 */
class ServiceRunner {

    companion object {
        private val logger = LoggerFactory.getLogger(ServiceRunner::class.java)

        //platformStatic allow access it from java code
        @JvmStatic lateinit var serviceComponent: ServiceComponent
    }

    init {
        serviceComponent = DaggerServiceComponent.builder().serviceModule(ServiceModule()).build()
    }

    fun run() {
        initControllers()
    }

    private fun initControllers() {
        ServiceController()
    }

}