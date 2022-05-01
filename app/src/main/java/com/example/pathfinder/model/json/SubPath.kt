package com.example.pathfinder.model.json

data class SubPath(
    val arrivalMessage: String? = null,
    val arrivalMin: Int? = null,
    val distance: Int?= null,
    val door: String?= null,
    val endID: Int?= null,
    val endName: String?= null,
    val endX: Double?= null,
    val endY: Double?= null,
    val lane: Lane?= null,
    val laneJson: LaneJson?= null,
    val leftStation: Int? = null,
    val passStopList: PassStopList?= null,
    val sectionTime: Int?= null,
    val seoulSubwayIdMap: Map<Int, String>?= null,
    val startID: Int?= null,
    val startName: String?= null,
    val startX: Double?= null,
    val startY: Double?= null,
    val stationCount: Int?= null,
    val stations: List<Station>?= null,
    val trafficType: Int?= null,
    val updnLine: String?= null,
    val updnLine2ndMap: Map<Int, String>?= null,
    val updnLineMap: Map<Int, String>?= null,
    val way: String?= null,
    val wayCode: Int?= null,

    /*
    val endArsID: String?= null,
    val endExitNo: String?= null,
    val endExitX: Double?= null,
    val endExitY: Double?= null,
    val endLocalStationID: String?= null,
    val endStationCityCode: Int?= null,
    val endStationProviderCode: Int?= null,
    val startArsID: String?= null,
    val startExitNo: String?= null,
    val startExitX: Double?= null,
    val startExitY: Double?= null,
    val startLocalStationID: String?= null,
    val startStationCityCode: Int?= null,
    val startStationProviderCode: Int?= null,*/

)

data class LaneJson(
    val busId: Int?= null,
    val busLocalBIID: String?= null,
    val busNo: String?= null,
    val busCityCode: Int?= null,
    val type: Int?= null,
    val busProviderCode: Int?= null
)


