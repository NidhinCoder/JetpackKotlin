package com.jlrinterview.icim.cleanarchitecture.data.model

/*
    In Home screen, an item will have 3 attributes
    feature name
    feature image id
    feature display State <- No Display, disabled, display (0,1,2)
*/

data class Feature(var featureName:String?=null, var imageId:Int?,var displayState:Int)
