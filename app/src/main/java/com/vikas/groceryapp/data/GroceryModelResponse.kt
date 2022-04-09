package com.vikas.groceryapp.data

data class GroceryModelResponse(
    val active: String,
    val catalog_uuid: String,
    val count: Int,
    val created: Int,
    val created_date: String,
    val desc: String,
    val external_ws: Int,
    val external_ws_url: String,
    val `field`: List<Field>,
    val index_name: String,
    val limit: String,
    val message: String,
    val offset: String,
    val org: List<String>,
    val org_type: String,
    val records: List<Record>,
    val sector: List<String>,
    val source: String,
    val status: String,
    val target_bucket: TargetBucket,
    val title: String,
    val total: Int,
    val updated: Int,
    val updated_date: String,
    val version: String,
    val visualizable: String
)