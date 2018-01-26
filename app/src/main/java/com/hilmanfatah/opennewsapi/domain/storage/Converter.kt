package com.hilmanfatah.opennewsapi.domain.storage

import com.hilmanfatah.opennewsapi.domain.model.ArticlesItem
import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.domain.model.UrlToLogos
import elfatahwashere.com.tokopedianews.storage.model.RealmArticle
import elfatahwashere.com.tokopedianews.storage.model.RealmLogo
import elfatahwashere.com.tokopedianews.storage.model.RealmSource
import java.util.*

/**
 * Created by hilmanfatah on 24/01/18.
 */
fun UrlToLogos.toRealm(): RealmLogo {
    val realmLogo = elfatahwashere.com.tokopedianews.storage.model.RealmLogo()
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


fun ArticlesItem.toRealm(articleSource: String): RealmArticle {
    val realmArticle = elfatahwashere.com.tokopedianews.storage.model.RealmArticle()
    realmArticle.source = articleSource
    realmArticle.publishedAt = this.publishedAt
    realmArticle.author = this.author
    realmArticle.description = this.description
    realmArticle.title = this.title
    realmArticle.url = this.url
    realmArticle.urlToImage = this.urlToImage
    return realmArticle
}


fun RealmArticle.toPojo(): ArticlesItem {
    val article = ArticlesItem()
    article.publishedAt = this.publishedAt
    article.author = this.author
    article.description = this.description
    article.title = this.title
    article.url = this.url
    article.urlToImage = this.urlToImage
    return article
}

fun List<RealmArticle>.toPojos(): ArrayList<ArticlesItem> {
    val articleList = ArrayList<ArticlesItem>(this.size)
    this.mapTo(articleList) { it.toPojo() }
    return articleList
}

fun List<ArticlesItem>.toRealm(articleSource: String): ArrayList<RealmArticle> {
    val articleList = ArrayList<RealmArticle>(this.size)
    this.mapTo(articleList) { it.toRealm(articleSource) }
    return articleList
}

fun SourcesItem.toRealm(): RealmSource {
    val realmSource = elfatahwashere.com.tokopedianews.storage.model.RealmSource()
    realmSource.category = this.category
    realmSource.description = this.description
    realmSource.id = this.id
    realmSource.name = this.name
    realmSource.url = this.url
    realmSource.urlsToLogos = this.urlsToLogos!!.toRealm()
    return realmSource
}

fun RealmSource.toPojo(): SourcesItem {
    val sources = SourcesItem()
    sources.category = this.category
    sources.description = this.description
    sources.id = this.id
    sources.name = this.name
    sources.url = this.url
    sources.urlsToLogos = this.urlsToLogos!!.toPojo()
    return sources
}

fun List<SourcesItem>.toRealm(): ArrayList<RealmSource> {
    val sourceList = ArrayList<RealmSource>(this.size)
    this.mapTo(sourceList) { it.toRealm() }
    return sourceList
}

fun List<RealmSource>.toPojo(): ArrayList<SourcesItem> {
    val sourceList = ArrayList<SourcesItem>(this.size)
    this.mapTo(sourceList) { it.toPojo() }
    return sourceList
}