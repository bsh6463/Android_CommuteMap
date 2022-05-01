package com.example.pathfinder.model.json

data class Path(
    val busStationCount: Int? = null,
    val busTransitCount: Int? = null,
    val firstStartStation: String?  = null,
    val lastEndStation: String?  = null,
    val mapObj: String?  = null,
    val pathType: Int?  = null,
    val payment: Int? = null,
    val subPathList: List<SubPath>?  = null,
    val subwayStationCount: Int?  = null,
    val subwayTransitCount: Int?  = null,
    val totalDistance: Int?  = null,
    val totalStationCount: Int? = null,
    val totalTime: Int?  = null,
    val totalWalk: Int?  = null,
    val totalWalkTime: Int?  = null,
    val trafficDistance: Int?  = null
)