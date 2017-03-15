package cz.kotliners.kotlin.spark_requery.internal

import com.google.gson.Gson
import spark.ResponseTransformer

/**
 * @author vsouhrada
 */
class JsonResponseTransformer : ResponseTransformer {

    private val gson = Gson()

    override fun render(model: Any?) = gson.toJson(model)

}