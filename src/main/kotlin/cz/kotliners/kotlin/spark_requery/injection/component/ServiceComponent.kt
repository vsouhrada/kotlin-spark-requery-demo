package cz.kotliners.kotlin.spark_requery.injection.component

import com.google.gson.Gson
import cz.kotliners.kotlin.spark_requery.ServiceRunner
import cz.kotliners.kotlin.spark_requery.controller.ServiceController
import cz.kotliners.kotlin.spark_requery.injection.module.ServiceModule
import cz.kotliners.kotlin.spark_requery.internal.InternalServiceImpl
import cz.kotliners.kotlin.spark_requery.rest.GitHubRestService
import dagger.Component
import javax.inject.Singleton

/**
 * @author vsouhrada
 */
@Singleton
@Component(modules = arrayOf(ServiceModule::class))
interface ServiceComponent {

    fun gitHubRestService(): GitHubRestService
    fun gson(): Gson

    // Injects

    fun inject(serviceRunner: InternalServiceImpl)

    fun inject(serviceController: ServiceController)

}