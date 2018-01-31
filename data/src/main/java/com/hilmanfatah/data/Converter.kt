package com.hilmanfatah.data

import com.hilmanfatah.data.realm.RealmLogo
import com.hilmanfatah.data.realm.RealmNews
import com.hilmanfatah.data.realm.RealmSource
import com.hilmanfatah.domain.model.NewsItem
import com.hilmanfatah.domain.model.SourcesItem
import com.hilmanfatah.domain.model.UrlToLogos
import java.util.*

/**
 * Created by hilmanfatah on 24/01/18.
 */
fun UrlToLogos.toRealm(): RealmLogo {
    val realmLogo = RealmLogo()
    realmLogo.large = this.large
    realmLogo.medium = this.medium
    realmLogo.small = this.small
    return realmLogo
}

fun RealmLogo.toPojo(): UrlToLogos {
    val urlToLogo = UrlToLogos()
    urlToLogo.large = this.large
    urlToLogo.medium = this.medium
    urlToLogo.small = this.small
    return urlToLogo
}


fun NewsItem.articleToRealm(articleSource: String): RealmNews {
    val realmArticle = RealmNews()
    realmArticle.source = articleSource
    realmArticle.publishedAt = this.publishedAt
    realmArticle.author = this.author
    realmArticle.description = this.description
    realmArticle.title = this.title
    realmArticle.url = this.url
    realmArticle.urlToImage = this.urlToImage
    return realmArticle
}


fun RealmNews.articleToPojo(): NewsItem {
    val article = NewsItem()
    article.publishedAt = this.publishedAt
    article.author = this.author
    article.description = this.description
    article.title = this.title
    article.url = this.url
    article.urlToImage = this.urlToImage
    return article
}

fun List<RealmNews>.articlesToPojos(): ArrayList<NewsItem> {
    val articleList = ArrayList<NewsItem>(this.size)
    this.mapTo(articleList) { it.articleToPojo() }
    return articleList
}

fun List<NewsItem>.articlesToRealm(articleSource: String): ArrayList<RealmNews> {
    val articleList = ArrayList<RealmNews>(this.size)
    this.mapTo(articleList) { it.articleToRealm(articleSource) }
    return articleList
}

fun SourcesItem.sourceToRealm(): RealmSource {
    val realmSource = RealmSource()
    realmSource.category = this.category
    realmSource.description = this.description
    realmSource.id = this.id
    realmSource.name = this.name
    realmSource.url = this.url
    realmSource.urlsToLogos = this.urlsToLogos!!.toRealm()
    return realmSource
}

fun RealmSource.sourceToPojo(): SourcesItem {
    val sources = SourcesItem()
    sources.category = this.category
    sources.description = this.description
    sources.id = this.id
    sources.name = this.name
    sources.url = this.url
    sources.urlsToLogos = this.urlsToLogos!!.toPojo()
    return sources
}

fun List<SourcesItem>.sourcesToRealm(): ArrayList<RealmSource> {
    val sourceList = ArrayList<RealmSource>(this.size)
    this.mapTo(sourceList) { it.sourceToRealm() }
    return sourceList
}

fun List<RealmSource>.sourcesToPojo(): ArrayList<SourcesItem> {
    val sourceList = ArrayList<SourcesItem>(this.size)
    this.mapTo(sourceList) { it.sourceToPojo() }
    return sourceList
}