package com.example.pathfinder.model

data class JsonResult (
    var middle: String?= null,
    var start: String?= null,
    var end: String?= null,
    var result1: Result?= null,
    var result2: Result?= null
)

data class Result(
    var pathList: MutableList<Path>?= null,
    var busCount: Int? = null,
    var searchType: Int? = null,
    var subwayCount: Int? = null,
    var subwayBusCount: Int? = null,
    var pointDistance: Int? = null,
    var outTrafficCheck: Int? = null,
    var startRadius: Int? = null,
    var endRadius: Int? = null
)

data class Path(
    var subPathList: MutableList<SubPath>?= null,
    var pathType: Int? = null,
    var info: Info? = null
)
data class SubPath(
    var sectionTime: Int?= null,
    var distance: Int?= null,
    var trafficType: Int?= null
)

data class Info(
    var totalTime: Int? = null,
    var totalWalkTime: Int?=  null,
    var subwayTransitCount : Int? = null,
    var busStationCount: Int?= null,
    var trafficDistance: Int?= null,
    var firstStartStation: String?= null,
    var mapObj: String?= null,
    var totalStationCount: Int?=null,
    var totalWalk: Int?= null,
    var payment: Int?= null,
    var subwayStationCount: Int?= null,
    var totalDistance: Int?= null,
    var busTransitCount: Int?= null,
    var lastEndStation: String?= null

)