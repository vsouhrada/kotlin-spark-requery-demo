package cz.kotliners.kotlin.spark_requery.injection.module

import com.google.gson.Gson
import cz.kotliners.kotlin.spark_requery.internal.InternalService
import cz.kotliners.kotlin.spark_requery.internal.InternalServiceImpl
import cz.kotliners.kotlin.spark_requery.rest.GH_URL
import cz.kotliners.kotlin.spark_requery.rest.GitHubRestService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author vsouhrada
 */
@Module
class ServiceModule {

    @Provides @Singleton fun provideGitHubRestService(): GitHubRestService {
        return Retrofit.Builder()
                .baseUrl(GH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubRestService::class.java)
    }

    @Provides @Singleton fun provideInternalService(): InternalService {
        return InternalServiceImpl()
    }


    @Provides @Singleton fun provideGson(): Gson {
        return Gson()
    }

}

